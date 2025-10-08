package javaapplication4;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductInventoryManager {
    private static final String URL = "jdbc:mysql://localhost:3306/productschema";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection conn;
    public ProductInventoryManager() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static class Product {
        int Prod_ID;
        String Name;
        double Price;
        int Quantity_in_Stock;
        public Product(int productId, String name, float price, int quantityInStock) {
            this.Prod_ID = productId;
            this.Name = name;
            this.Price = price;
            this.Quantity_in_Stock = quantityInStock;
        }
        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + Prod_ID +
                    ", name='" + Name + '\'' +
                    ", price=" + Price +
                    ", quantityInStock=" + Quantity_in_Stock +
                    '}';
        }
    }
    public boolean addProduct(String name, double price, int quantity) {
        String sql = "INSERT INTO Product (name, price, quantity_in_stock) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Add product error: " + e.getMessage());
            return false;
        }
    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getInt("quantity_in_stock")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Get all products error: " + e.getMessage());
        }
        return products;
    }
    public boolean updateProduct(int productId, String newName, double newPrice, int newQuantity) {
        String sql = "UPDATE Product SET name = ?, price = ?, quantity_in_stock = ? WHERE product_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setDouble(2, newPrice);
            ps.setInt(3, newQuantity);
            ps.setInt(4, productId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update product error: " + e.getMessage());
            return false;
        }
    }
    public boolean reduceStock(int productId, int quantityToReduce) {
        String selectSql = "SELECT quantity_in_stock FROM Product WHERE product_id = ?";
        String updateSql = "UPDATE Product SET quantity_in_stock = quantity_in_stock - ? WHERE product_id = ?";
        try (PreparedStatement selectPs = conn.prepareStatement(selectSql)) {
            selectPs.setInt(1, productId);
            try (ResultSet rs = selectPs.executeQuery()) {
                if (rs.next()) {
                    int currentStock = rs.getInt("quantity_in_stock");
                    if (currentStock < quantityToReduce) {
                        System.out.println("Insufficient stock for product ID " + productId);
                        return false;
                    }
                    try (PreparedStatement updatePs = conn.prepareStatement(updateSql)) {
                        updatePs.setInt(1, quantityToReduce);
                        updatePs.setInt(2, productId);
                        return updatePs.executeUpdate() > 0;
                    }
                } else {
                    System.out.println("Product ID " + productId + " not found.");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Reduce stock error: " + e.getMessage());
            return false;
        }
    }
    public boolean deleteProduct(int productId) {
        String sql = "DELETE FROM Product WHERE product_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete product error: " + e.getMessage());
            return false;
        }
    }
    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
    public static void main(String[] args) {
        try {
            ProductInventoryManager manager = new ProductInventoryManager();
            manager.addProduct("Laptop", 1500.00, 10);
            manager.addProduct("Smartphone", 700.00, 25);
            manager.addProduct("Keyboard", 45.50, 50);
            System.out.println("All products:");
            for (Product p : manager.getAllProducts()) {
                System.out.println(p);
            }
            System.out.println("\nUpdating product ID 1...");
            manager.updateProduct(1, "Gaming Laptop", 1800.00, 8);
            System.out.println("\nReducing stock for product ID 2 by 5...");
            boolean reduced = manager.reduceStock(2, 5);
            System.out.println("Stock reduced? " + reduced);
            System.out.println("\nAttempting to reduce stock for product ID 3 by 100 (should fail)...");
            reduced = manager.reduceStock(3, 100);
            System.out.println("Stock reduced? " + reduced);
            System.out.println("\nProducts after updates:");
            for (Product p : manager.getAllProducts()) {
                System.out.println(p);
            }
            System.out.println("\nDeleting product ID 2...");
            boolean deleted = manager.deleteProduct(2);
            System.out.println("Product deleted? " + deleted);
            System.out.println("\nFinal product list:");
            for (Product p : manager.getAllProducts()) {
                System.out.println(p);
            }
            manager.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
