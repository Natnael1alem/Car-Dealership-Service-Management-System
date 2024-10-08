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


    public static List<MenuCar> getMenuCars() {
        List<MenuCar> menuCars = new ArrayList<>();
        String sql = "SELECT * FROM MenuCarsList";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                MenuCar menuCar = new MenuCar(
                    rs.getString("ModelName"),
                    rs.getInt("ModelID"),
                    rs.getString("MakeName"),
                    rs.getString("ModelDescription")
                );
                menuCars.add(menuCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuCars;
    }
    
    public static List<OwnedCar> getOwnedCars(User user) {
        List<OwnedCar> ownedCars = new ArrayList<>();
        String sql = "SELECT * FROM PurchasedCarsList WHERE username = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getUsername());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OwnedCar ownedCar = new OwnedCar(
                    rs.getInt("CarTypeID"),
                    rs.getInt("user_car_id"),
                    rs.getString("ModelName"),
                    rs.getString("MakeName"),
                    rs.getString("ColorName"),
                    rs.getString("EngineType"),
                    rs.getString("TransmissionType"),
                    rs.getString("ModelDescription")
                );
                ownedCars.add(ownedCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownedCars;
    }

    public static List<PendingCar> getPendingCars(User user) {
        List<PendingCar> cars = new ArrayList<>();
        String sql = "SELECT * FROM PendingCarsList WHERE username = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getUsername());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PendingCar car = new PendingCar(
                    rs.getInt("CarTypeID"),
                    rs.getInt("user_car_id"),
                    rs.getString("ModelName"),
                    rs.getString("MakeName"),
                    rs.getString("ColorName"),
                    rs.getString("EngineType"),
                    rs.getString("TransmissionType"),
                    rs.getDouble("Price")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static List<FilterCar> getFilteredCars(int modelID, ArrayList<Integer> selCols, ArrayList<Integer> selEngs, ArrayList<Integer> selTrans) {
        List<FilterCar> filCars = new ArrayList<>();
        String sql = "SELECT * FROM InventoryCarsList WHERE ModelID = ? ";

        sql += " AND ( 1 != 1 ";
        for (int colID : selCols) {
            sql += " OR ColorID = " + colID;
        }
        sql += ")";
        
        sql += " AND ( 1 != 1 ";
        for (int colID : selEngs) {
            sql += " OR EngineID = " + colID;
        }
        sql += ")";

        sql += " AND ( 1 != 1 ";
        for (int colID : selTrans) {
            sql += " OR TransmissionID = " + colID;
        }
        sql += ");";


        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setInt(1, modelID); 
             ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                FilterCar selCar = new FilterCar(
                    rs.getInt("CarTypeID"),
                    rs.getString("ModelName"),
                    rs.getString("MakeName"),
                    rs.getString("ColorName"),
                    rs.getString("EngineType"),
                    rs.getString("TransmissionType"),
                    rs.getDouble("Price"),
                    rs.getString("ModelDescription"),
                    rs.getInt("Quantity")
                );
                filCars.add(selCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filCars;
    }
    
    public static SelectedCar getSelectedCar(int carTypeID) {
        SelectedCar selCar = null;
        String sql = "SELECT * FROM SelectedCar WHERE CarTypeID = ? LIMIT 1";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
             pstmt.setInt(1, carTypeID); 
             ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                selCar = new SelectedCar(
                    rs.getInt("CarTypeID"),
                    rs.getInt("CarInventoryID"),
                    rs.getString("ModelName"),
                    rs.getString("MakeName"),
                    rs.getString("ColorName"),
                    rs.getString("EngineType"),
                    rs.getString("TransmissionType"),
                    rs.getDouble("Price"),
                    rs.getString("ModelDescription")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return selCar;
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

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                User user = new User(
                    rs.getString("username"),
                    rs.getString("FName"),
                    rs.getString("LName"),
                    rs.getString("email"),
                    rs.getString("password")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
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


    public static void addUser(String username, String FName, String LName, String email, String password) {
        String sql = "INSERT INTO users (username, FName, LName, email, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, FName);
            pstmt.setString(3, LName);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int checkUsernameAndEmail(String username, String email) {
        String sql = "SELECT username, email FROM users WHERE username = ? OR email = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameters for username and email
            stmt.setString(1, username);
            stmt.setString(2, email);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Check results to see if username or email exists
            while (rs.next()) {
                String dbUsername = rs.getString("username");
                String dbEmail = rs.getString("email");

                // Check if the username is already taken
                if (dbUsername.equals(username)) {
                    return 1; //returns 1 if username is taken
                }

                // Check if the email is already used
                if (dbEmail.equals(email)) {
                    return 2; // returns 2 if email is taken
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0; // Return 0 if both username and email are available
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



    public static void payCar(User user, PendingCar car) {
        String addOwnership = "INSERT INTO user_cars (username, CarTypeID) VALUES (?, ?)";
        String removeInventory = "DELETE FROM pending_user_cars WHERE user_car_id = ?";

        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(addOwnership); 
            PreparedStatement pstmt2 = conn.prepareStatement(removeInventory)){
            
            pstmt.setString(1, user.getUsername());
            pstmt.setInt(2, car.getId());

            pstmt2.setInt(1, car.getItemID());

            pstmt2.executeUpdate();
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void buyCar(User user, SelectedCar car) {
        String addPending = "INSERT INTO pending_user_cars (username, CarTypeID) VALUES (?, ?)";
        String removeInventory = "DELETE FROM CarInventory WHERE CarInventoryID = ?";

        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(addPending);
            PreparedStatement pstmt2 = conn.prepareStatement(removeInventory)) {
            
            pstmt.setString(1, user.getUsername());
            pstmt.setInt(2, car.getId());

            pstmt2.setInt(1, car.getItemID());

            pstmt2.executeUpdate();
            pstmt.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}