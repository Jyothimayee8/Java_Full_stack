package com.jdbc;

public class Test {

	public static void main(String[] args) {
		
		Connection con = null;
        PreparedStatement ps = null;
        Scanner sc = null;

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/amazon",
                "root", "root");

            // 3. Prepare SQL
            String q = "insert into employee (empid, empname, empresume, empdoj, empphoto) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(q);

            sc = new Scanner(System.in);

            // Input details
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter path to resume file : ");
            String resumePath = sc.nextLine();
            FileReader resumeReader = new FileReader(resumePath);

            System.out.print("Enter joining year: ");
            int year = sc.nextInt();
            System.out.print("Enter joining month (1-12): ");
            int month = sc.nextInt();
            System.out.print("Enter joining day: ");
            int day = sc.nextInt();
            Date sdate = Date.valueOf(LocalDate.of(year, month, day));

            sc.nextLine();

            System.out.print("Enter path to photo file (jpg/png): ");
            String photoPath = sc.nextLine();
            FileInputStream photoStream = new FileInputStream(photoPath);

            // Set parameters
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setCharacterStream(3, resumeReader);
            ps.setDate(4, sdate);
            ps.setBinaryStream(5, photoStream);

            // Execute
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee record inserted successfully.");
            } else {
                System.out.println("Insertion failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
             try {
				ps.close();
				con.close();
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
            }

	}

}
