import java.sql.*;
import java.util.Scanner;

public class PlantDAO {

    Scanner sc = new Scanner(System.in);

    public void addPlant() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO plants(name,type,price,quantity) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Name: ");
            ps.setString(1, sc.next());

            System.out.print("Type: ");
            ps.setString(2, sc.next());

            System.out.print("Price: ");
            ps.setDouble(3, sc.nextDouble());

            System.out.print("Quantity: ");
            ps.setInt(4, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Plant Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewPlants() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM plants");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getDouble(4) + " " +
                    rs.getInt(5)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlant() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE plants SET price=?, quantity=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("ID: ");
            ps.setInt(3, sc.nextInt());

            System.out.print("New Price: ");
            ps.setDouble(1, sc.nextDouble());

            System.out.print("New Quantity: ");
            ps.setInt(2, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Plant Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePlant() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM plants WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("ID: ");
            ps.setInt(1, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Plant Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchPlant() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM plants WHERE name=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Name: ");
            ps.setString(1, sc.next());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getDouble(4) + " " +
                    rs.getInt(5)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}