package com.carshop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/carshopdb";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM InventoryCarsList";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Car car = new Car(
                    rs.getString("ModelName"),
                    rs.getString("ColorName"),
                    rs.getString("EngineType"),
                    rs.getString("TransmissionType")
                );
                car.setId(rs.getInt("car_id"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static List<Model> getAllModels() {
        List<Model> models = new ArrayList<>();
        String sql = "SELECT * FROM Model";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Model model = new Model(
                    rs.getInt("ModelID"),
                    rs.getString("ModelName")
                );
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;
    }

    public static List<Color> getAllColors() {
        List<Color> colors = new ArrayList<>();
        String sql = "SELECT * FROM Color";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Color color = new Color(
                    rs.getInt("ColorID"),
                    rs.getString("ColorName")
                );
                colors.add(color);
                //System.out.println(color.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colors;
    }

    public static List<Engine> getAllEngines() {
        List<Engine> engines = new ArrayList<>();
        String sql = "SELECT * FROM Engine";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Engine engine = new Engine(
                    rs.getInt("EngineID"),
                    rs.getString("EngineType")
                );
                engines.add(engine);
                //System.out.println(color.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engines;
    }

    public static List<Transmission> getAllTransmissions() {
        List<Transmission> transmissions = new ArrayList<>();
        String sql = "SELECT * FROM Transmission";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Transmission transmission = new Transmission(
                    rs.getInt("TransmissionID"),
                    rs.getString("TransmissionType")
                );
                transmissions.add(transmission);
                //System.out.println(color.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transmissions;
    }


    public static void addCar(int modelID, int colorID, int engineID, int transmissionID ) {
        String sql = "INSERT INTO cars (ModelID, ColorID, EngineID, TransmissionID) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, modelID);
            pstmt.setInt(2, colorID);
            pstmt.setInt(3, engineID);
            pstmt.setInt(4, transmissionID);

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Accessory> getAllAccessories() {
        List<Accessory> accessories = new ArrayList<>();
        String sql = "SELECT * FROM InventoryAccessoriesList";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Accessory accessory = new Accessory(
                    rs.getString("AccessoryName"),
                    rs.getString("description")
                );
                accessory.setId(rs.getInt("accinv_id"));
                accessories.add(accessory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessories;
    }

    public static List<AccessoryType> getAllAccessoriesType(){
        List<AccessoryType> accessories = new ArrayList<>();
        String sql = "SELECT * FROM Accessory";
        
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                AccessoryType accessory = new AccessoryType(
                    rs.getString("AccessoryName"),
                    rs.getString("description")
                );
                accessory.setId(rs.getInt("AccessoryID"));
                accessories.add(accessory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessories;    
    }

    public static void addAccessory(int accessoryInt) {
        String sql = "INSERT INTO accessories (AccessoryID) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, accessoryInt);

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewAccessory(String name, String description){
        String sql = "INSERT INTO Accessory (AccessoryName, description) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, description);

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewModel(String name) {
        String sql = "INSERT INTO Model (ModelName) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewColor(String name) {
        String sql = "INSERT INTO Color (ColorName) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewEngine(String name) {
        String sql = "INSERT INTO Engine (EngineType) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewTransmission(String name) {
        String sql = "INSERT INTO Transmission (TransmissionType) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}