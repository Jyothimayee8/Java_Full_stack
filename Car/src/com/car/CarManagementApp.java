package com.car;
import java.sql.*;
import java.util.*;

public class CarManagementApp {

    // MySQL DB config
    private static final String URL  = "jdbc:mysql://localhost:3306/amazon";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("✅ Connected to MySQL!");

            createTables(conn);
            insertSampleFeatures(conn);

            List<Long> selectedFeatures = Arrays.asList(1L, 2L); // Sunroof + Leather Seats
            long carId = insertCar(conn, "Toyota", "Camry", 2023, 30000, "Black", "Automatic", selectedFeatures);

            getAllCars(conn);
            getCarById(conn, carId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create all required tables
    private static void createTables(Connection conn) throws SQLException {
        String createFeatureTable = """
            CREATE TABLE IF NOT EXISTS feature (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                price DOUBLE NOT NULL
            );
        """;
        String createCarTable = """
            CREATE TABLE IF NOT EXISTS car (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                make VARCHAR(50) NOT NULL,
                model VARCHAR(50) NOT NULL,
                year INT NOT NULL,
                base_price DOUBLE NOT NULL,
                color VARCHAR(50),
                transmission VARCHAR(50),
                features_total DOUBLE,
                total_price DOUBLE,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            );
        """;
        String createCarFeaturesTable = """
            CREATE TABLE IF NOT EXISTS car_features (
                car_id BIGINT,
                feature_id BIGINT,
                FOREIGN KEY (car_id) REFERENCES car(id) ON DELETE CASCADE,
                FOREIGN KEY (feature_id) REFERENCES feature(id) ON DELETE CASCADE
            );
        """;
        conn.createStatement().execute(createFeatureTable);
        conn.createStatement().execute(createCarTable);
        conn.createStatement().execute(createCarFeaturesTable);
    }

    // Insert some default features
    private static void insertSampleFeatures(Connection conn) throws SQLException {
        String checkSQL = "SELECT COUNT(*) FROM feature";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(checkSQL);
            rs.next();
            if (rs.getInt(1) > 0) return; // Skip if already inserted
        }

        String sql = "INSERT INTO feature (name, price) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            String[][] features = {
                {"Sunroof", "800"},
                {"Leather Seats", "1200"},
                {"ADAS", "2500"},
                {"Premium Audio", "650"}
            };
            for (String[] f : features) {
                ps.setString(1, f[0]);
                ps.setDouble(2, Double.parseDouble(f[1]));
                ps.executeUpdate();
            }
        }
        System.out.println("✅ Sample features inserted.");
    }

    // Insert a new car and its features
    private static long insertCar(Connection conn, String make, String model, int year,
                                  double basePrice, String color, String transmission,
                                  List<Long> featureIds) throws SQLException {
        double featuresTotal = 0;

        String featureQuery = "SELECT price FROM feature WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(featureQuery)) {
            for (Long fid : featureIds) {
                ps.setLong(1, fid);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    featuresTotal += rs.getDouble("price");
                }
            }
        }

        double totalPrice = basePrice + featuresTotal;
        String insertCarSQL = """
            INSERT INTO car (make, model, year, base_price, color, transmission, features_total, total_price)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;
        long carId;
        try (PreparedStatement ps = conn.prepareStatement(insertCarSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, make);
            ps.setString(2, model);
            ps.setInt(3, year);
            ps.setDouble(4, basePrice);
            ps.setString(5, color);
            ps.setString(6, transmission);
            ps.setDouble(7, featuresTotal);
            ps.setDouble(8, totalPrice);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            carId = rs.getLong(1);
        }

        String insertCarFeatureSQL = "INSERT INTO car_features (car_id, feature_id) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertCarFeatureSQL)) {
            for (Long fid : featureIds) {
                ps.setLong(1, carId);
                ps.setLong(2, fid);
                ps.executeUpdate();
            }
        }

        System.out.println("✅ Car inserted with ID: " + carId);
        return carId;
    }

    // Show all cars
    private static void getAllCars(Connection conn) throws SQLException {
        String sql = "SELECT * FROM car";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            System.out.println("\n=== All Cars ===");
            while (rs.next()) {
                System.out.printf("%d: %s %s (%d) - $%.2f\n",
                    rs.getLong("id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getDouble("total_price"));
            }
        }
    }

    // Show one car by ID
    private static void getCarById(Connection conn, long id) throws SQLException {
        String sql = "SELECT * FROM car WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.printf("\nCar %d: %s %s - $%.2f\n",
                    id,
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getDouble("total_price"));
            }
        }

        String featureSQL = """
            SELECT f.name, f.price FROM feature f
            JOIN car_features cf ON f.id = cf.feature_id
            WHERE cf.car_id = ?
        """;
        try (PreparedStatement ps = conn.prepareStatement(featureSQL)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println("Features:");
            while (rs.next()) {
                System.out.printf("- %s ($%.2f)\n", rs.getString("name"), rs.getDouble("price"));
            }
        }
    }
}
