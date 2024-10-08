DROP DATABASE IF EXISTS carshopdb;
CREATE DATABASE carshopdb;
USE carshopdb;

CREATE TABLE Category (CategoryID INT AUTO_INCREMENT PRIMARY KEY, CategoryName VARCHAR(50) );

CREATE TABLE Make (MakeID INT AUTO_INCREMENT PRIMARY KEY, MakeName VARCHAR(50) );

CREATE TABLE Model (ModelID INT AUTO_INCREMENT PRIMARY KEY, ModelName VARCHAR(50), ModelDescription TEXT, CategoryID INT, MakeID INT, FOREIGN KEY (MakeID) REFERENCES Make(MakeID), FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID));

CREATE TABLE Color ( ColorID INT AUTO_INCREMENT PRIMARY KEY, ColorName VARCHAR(50) );

CREATE TABLE Engine ( EngineID INT AUTO_INCREMENT PRIMARY KEY, EngineType VARCHAR(50) );

CREATE TABLE Transmission ( TransmissionID INT AUTO_INCREMENT PRIMARY KEY, TransmissionType VARCHAR(50) );

CREATE TABLE Accessory (AccessoryID INT AUTO_INCREMENT PRIMARY KEY, AccessoryName VARCHAR(50), description TEXT, Price double(10, 2));

CREATE TABLE accessories (
    accinv_id INT AUTO_INCREMENT PRIMARY KEY,
	AccessoryID INT,
    FOREIGN KEY (AccessoryID) REFERENCES Accessory(AccessoryID),
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(20) NOT NULL,
    FName VARCHAR(50) NOT NULL,
    LName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE CarType (
    CarTypeID INT AUTO_INCREMENT PRIMARY KEY,
    
    ModelID INT, 
    ColorID INT,     
    EngineID INT, 
    TransmissionID INT, 
    Price double(10, 2),
    SpecDescription TEXT,
    
    FOREIGN KEY (ModelID) REFERENCES Model(ModelID), 
    FOREIGN KEY (ColorID) REFERENCES Color(ColorID), 
    FOREIGN KEY (EngineID) REFERENCES Engine(EngineID), 
    FOREIGN KEY (TransmissionID) REFERENCES Transmission(TransmissionID)
);



CREATE TABLE CarInventory (
	CarInventoryID INT AUTO_INCREMENT PRIMARY KEY,
    CarTypeID INT,
    FOREIGN KEY (CarTypeID) REFERENCES CarType(CarTypeID),
	AddedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_cars (
    user_car_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    CarTypeID INT NOT NULL,
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (username) REFERENCES users(username),
    FOREIGN KEY (CarTypeID) REFERENCES CarType(CarTypeID)
);

CREATE TABLE pending_user_cars (
    user_car_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    CarTypeID INT NOT NULL,
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (username) REFERENCES users(username),
    FOREIGN KEY (CarTypeID) REFERENCES CarType(CarTypeID)
);

CREATE TABLE user_car_accessories (
    user_car_accessory_id INT AUTO_INCREMENT PRIMARY KEY,
    user_car_id INT NOT NULL,
    AccessoryID INT NOT NULL,
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_car_id) REFERENCES user_cars(user_car_id),
    FOREIGN KEY (AccessoryID) REFERENCES accessories(AccessoryID)
);

