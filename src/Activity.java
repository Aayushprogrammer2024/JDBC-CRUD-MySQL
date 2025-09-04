import java.sql.*;
import java.util.Scanner;

public class Activity {
    public void insertData() {
        Scanner input=new Scanner(System.in);


        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/dbfirst",
                    "root",
                    "MySQL123"
            );
            String query = "INSERT INTO record(Name,Password,Contact,Gender) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter your name:");
            String name=input.next();
            input.nextLine();
            System.out.println("Dear "+name+" Enter Your Password");
            String pass=input.next();

            System.out.println("Enter your Contact:");
            String cont=input.next();
            System.out.println("Enter the Gender");
            String gend=input.next();


            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, cont);
            ps.setString(4, gend);
            ps.executeUpdate();

            System.out.println("Data Inserted Successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readData() {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/dbfirst",
                    "root",
                    "MySQL123"
            );
            String query = "SELECT * FROM record";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID=" + rs.getString(1));
                System.out.println("Name=" + rs.getString(2));
                System.out.println("Password=" + rs.getString(3));
                System.out.println("Contact=" + rs.getString(4));
                System.out.println("Gender=" + rs.getString(5));


            }
            ps.execute(query);
            System.out.println("Data Read Successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateData() {
        Scanner input=new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/dbfirst",
                    "root",
                    "MySQL123"
            );
            int id;
            String name;
            System.out.println("Enter the id which u want to update");
            id=input.nextInt();
            String query = "UPDATE record SET Name=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(query);

            System.out.println("Enter the updated name for ID:"+id);
            name=input.next();
            ps.setString(1,name);
            ps.setInt(2,id);
            ps.executeUpdate();

            System.out.println("Names updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
        Scanner input =new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/dbfirst",
                    "root",
                    "MySQL123"
            );
            int id;
            System.out.println("Enter the ID which u want to Delete:");
            id=input.nextInt();
            String query = "DELETE FROM record where ID=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
           ps.executeUpdate();
            System.out.println("Data Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
