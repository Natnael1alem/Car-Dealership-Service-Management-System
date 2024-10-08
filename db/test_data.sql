USE carshopdb;

INSERT INTO Category (CategoryName) VALUES 
("SUV"), ("HATCHBACK"), ("SEDAN"), ("Coupe"), ("Convertible"), ("Minivan"), ("Pickup"), ("Sports Car");

INSERT INTO Make(MakeName) VALUES
("TESLA"), ("FORD"), ("TOYOTA"), ("HONDA"), ("LAMBORGHINI"), ("Mercedes-Benz"), ("BMW"), ("AUDI");

INSERT INTO MODEL(ModelName, MakeID, ModelDescription) VALUES
("Model S", 1, "Electric sedan with long range and high performance."),
("Model 3", 1, "Affordable electric sedan with autopilot capabilities."),
("Model X", 1, "Electric SUV with falcon-wing doors."),
("F-150", 2, "Popular full-size pickup truck with strong towing capacity."),
("Mustang", 2, "Iconic sports car with powerful engine options."),
("Explorer", 2, "Mid-size SUV with three rows of seating."),
("Escape", 2, "Compact SUV with good fuel economy."),
("Camry", 3, "Reliable mid-size sedan with a comfortable ride."),
("Corolla", 3, "Compact sedan known for its durability."),
("RAV4", 3, "Compact SUV with off-road capabilities."),
("Highlander", 3, "Mid-size SUV with seating for up to eight."),
("Civic", 4, "Compact car with sporty handling and good fuel economy."),
("Accord", 4, "Mid-size sedan with a spacious interior."),
("CR-V", 4, "Compact SUV with a roomy cabin and strong reputation."),
("Odyssey", 4, "Minivan with versatile seating and family-friendly features."),
("Aventador", 5, "High-performance supercar with a V12 engine."),
("Huracan", 5, "V10-powered supercar with aggressive styling."),
("Urus", 5, "Luxury SUV with the soul of a supercar."),
("C-Class", 6, "Luxury compact sedan with advanced technology."),
("E-Class", 6, "Mid-size luxury sedan with a smooth ride."),
("S-Class", 6, "Flagship luxury sedan with top-tier features."),
("GLC", 6, "Luxury compact SUV with a premium interior."),
("3 Series", 7, "Sporty compact sedan with a focus on driving dynamics."),
("5 Series", 7, "Mid-size luxury sedan with advanced features."),
("X3", 7, "Compact luxury SUV with agile handling."),
("X5", 7, "Mid-size luxury SUV with a powerful engine lineup."),
("A4", 8, "Compact luxury sedan with a refined interior."),
("A6", 8, "Mid-size luxury sedan with a comfortable ride."),
("Q5", 8, "Compact luxury SUV with a smooth driving experience."),
("Q7", 8, "Three-row luxury SUV with a spacious cabin.");


INSERT INTO Color (ColorName) VALUES 
("Red"), ("Blue"), ("Green"), ("Grey"), ("Silver"), ("Black"), ("White"), ("Yellow"), ("Orange"), ("Purple");

INSERT INTO Engine (EngineType) VALUES 
("Electric"), ("Gas"), ("Hybrid"), ("Diesel");

INSERT INTO Transmission(TransmissionType) VALUES 
("Manual"), ("Automatic"), ("CVT");

-- Insert Car Types
INSERT INTO CarType (ModelID, ColorID, EngineID, TransmissionID, Price) VALUES
(1, 1, 1, 1, 10000.00), (1, 3, 2, 2, 10000.00), (3, 5, 3, 1, 10000.00), (4, 2, 1, 2, 10000.00), (5, 7, 2, 1, 10000.00), (6, 4, 3, 2, 10000.00);

-- Insert Car Inventory
INSERT INTO CarInventory (CarTypeID) VALUES
(1), (1), (2), (2), (3), (3), (4), (4), (5), (5);

-- Insert users
INSERT INTO users (username, FName, LName, password, email) VALUES
('1', 'John', 'Doe', '1234', 'john@example.com'),
('2', 'Jane', 'Smith', '1234', 'jane@example.com'),
('3', 'Bob', 'Johnson', '1234', 'bob@example.com'),
('4', 'Alice', 'Williams', '1234', 'alice@example.com'),
('5', 'Charlie', 'Brown', '1234', 'charlie@example.com');

-- Insert Accessory
INSERT INTO Accessory (AccessoryName, description, Price) VALUES
('Floor Mats', 'All-weather floor mats', 100.00),
('Roof Rack', 'Universal roof rack system', 100.00),
('Dash Cam', 'Front and rear dash camera', 100.00),
('Seat Covers', 'Premium leather seat covers', 100.00),
('Towing Package', 'Heavy-duty towing package', 100.00),
('GPS Navigation', 'Built-in GPS navigation system', 100.00),
('Sound System', 'Premium sound system upgrade', 100.00),
('Backup Camera', 'Rearview backup camera', 100.00);

-- Insert user accessories inverntory
INSERT INTO accessories (AccessoryID) VALUES 
(1), (1), (1), (2), (2), (3), (3), (3), (4), (5), (6), (7), (7), (8), (8), (8);

-- Insert user car purchases
INSERT INTO user_cars (username, CarTypeID) VALUES
('1', 1), ('1', 1), ('1', 3), ('2', 2); 

-- Insert user car accessory purchases
INSERT INTO user_car_accessories (user_car_id, AccessoryID) VALUES
(1, 1), (1, 1), (2, 1), (2, 2), (2, 4), (3, 5);


SELECT * FROM InventoryCarsList;
SELECT * FROM  PurchasedCarsList;
SELECT * FROM InventoryAccessoriesList;
SELECT * FROM PurchasedAccessoriesList;

