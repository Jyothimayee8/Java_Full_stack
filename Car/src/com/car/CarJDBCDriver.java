package com.car;

import java.sql.*;
import java.util.*;

public class CarJDBCDriver {

    private static final String URL = "jdbc:mysql://localhost:3306/car_db";
    private static final String USER = "root";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            createTables(conn);
            insertSampleFeatures(conn);

            System.out.print("Enter car make: ");
            String make = sc.nextLine();

            System.out.print("Enter car model: ");
            String model = sc.nextLine();

            System.out.print("Enter car year: ");
            int year = sc.nextInt();

            System.out.print("Enter base price: ");
            double basePrice = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.print("Enter color: ");
            String color = sc.nextLine();

            System.out.print("Enter transmission (Automatic/Manual): ");
            String transmission = sc.nextLine();

            // Show available features
            Map<Long, String> featureMap = listFeatures(conn);
            System.out.println("Enter feature IDs separated by commas: ");
            String[] featureInput = sc.nextLine().split(",");
            List<Long> featureIds = new ArrayList<>();
            for (String f : featureInput) {
                try {
                    featureIds.add(Long.parseLong(f.trim()));
                } catch (NumberFormatException ignored) {}
            }

            long carId = insertCar(conn, make, model, year, basePrice, color, transmission, featureIds);

            getAllCars(conn);
            getCarById(conn, carId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        conn.createStatement().execute("""
            CREATE TABLE IF NOT EXISTS feature (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100),
                price DOUBLE
            )
        """);
        conn.createStatement().execute("""
            CREATE TABLE IF NOT EXISTS car (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                make VARCHAR(50),
                model VARCHAR(50),
                year INT,
                base_price DOUBLE,
                color VARCHAR(50),
                transmission VARCHAR(50),
                features_total DOUBLE,
                total_price DOUBLE,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
        """);
        conn.createStatement().execute("""
            CREATE TABLE IF NOT EXISTS car_features (
                car_id BIGINT,
                feature_id BIGINT,
                FOREIGN KEY (car_id) REFERENCES car(id) ON DELETE CASCADE,
                FOREIGN KEY (feature_id) REFERENCES feature(id) ON DELETE CASCADE
            )
        """);
    }

    private static void insertSampleFeatures(Connection conn) throws SQLException {
        if (conn.createStatement().executeQuery("SELECT COUNT(*) FROM feature").next()) return;
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
    }

    private static Map<Long, String> listFeatures(Connection conn) throws SQLException {
        Map<Long, String> map = new HashMap<>();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM feature");
        System.out.println("Available Features:");
        while (rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            System.out.printf("%d: %s ($%.2f)\n", id, name, price);
            map.put(id, name);
        }
        return map;
    }

    private static long insertCar(Connection conn, String make, String model, int year,
                                  double basePrice, String color, String transmission,
                                  List<Long> featureIds) throws SQLException {
        double featuresTotal = 0;
        try (PreparedStatement ps = conn.prepareStatement("SELECT price FROM feature WHERE id = ?")) {
            for (Long fid : featureIds) {
                ps.setLong(1, fid);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    featuresTotal += rs.getDouble("price");
                }
            }
        }

        double totalPrice = basePrice + featuresTotal;
        long carId;
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO car (make, model, year, base_price, color, transmission, features_total, total_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
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

        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO car_features (car_id, feature_id) VALUES (?, ?)")) {
            for (Long fid : featureIds) {
                ps.setLong(1, carId);
                ps.setLong(2, fid);
                ps.executeUpdate();
            }
        }

        System.out.println("Inserted Car ID: " + carId);
        return carId;
    }

    private static void getAllCars(Connection conn) throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM car");
        System.out.println("=== All Cars ===");
        while (rs.next()) {
            System.out.printf("%d: %s %s (%d) - $%.2f\n",
                rs.getLong("id"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getDouble("total_price"));
        }
    }

    private static void getCarById(Connection conn, long id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE id = ?")) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.printf("Car %d: %s %s - $%.2f\n",
                    id,
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getDouble("total_price"));
            }
        }
    }
}
