USE carshopdb;


CREATE VIEW InventoryCarsList 
AS SELECT 
	m.ModelName, m.ModelID, 
    mk.MakeName, mk.MakeID,
	c.ColorName, c.ColorID,
    e.EngineType, e.EngineID, 
	t.TransmissionType, t.TransmissionID, 
    ct.CarTypeID, COUNT(*) AS Quantity,
	ct.Price,
    m.ModelDescription
FROM CarInventory ci
JOIN CarType ct ON ci.CarTypeID = ct.CarTypeID
JOIN Model m ON ct.ModelID = m.ModelID 
JOIN Make mk ON m.MakeID = mk.MakeID
JOIN  Color c ON ct.ColorID = c.ColorID
JOIN Engine e ON ct.EngineID = e.EngineID 
JOIN Transmission t ON ct.TransmissionID = t.TransmissionID
GROUP BY ct.CarTypeID;

CREATE VIEW SelectedCar 
AS SELECT 
	m.ModelName, m.ModelID, 
    mk.MakeName, mk.MakeID,
	c.ColorName, c.ColorID,
    e.EngineType, e.EngineID, 
	t.TransmissionType, t.TransmissionID, 
    ct.CarTypeID, ci.CarInventoryID,
	ct.Price,
    m.ModelDescription
FROM CarInventory ci
JOIN CarType ct ON ci.CarTypeID = ct.CarTypeID
JOIN Model m ON ct.ModelID = m.ModelID 
JOIN Make mk ON m.MakeID = mk.MakeID
JOIN  Color c ON ct.ColorID = c.ColorID
JOIN Engine e ON ct.EngineID = e.EngineID 
JOIN Transmission t ON ct.TransmissionID = t.TransmissionID;


CREATE VIEW MenuCarsList 
AS SELECT 
	m.ModelName, m.ModelID, 
    mk.MakeName, mk.MakeID,
--     c.ColorName, c.ColorID,
    m.ModelDescription
FROM CarInventory ci
JOIN CarType ct ON ci.CarTypeID = ct.CarTypeID
JOIN Model m ON ct.ModelID = m.ModelID 
JOIN Make mk ON m.MakeID = mk.MakeID
-- JOIN  Color c ON ct.ColorID = c.ColorID 
GROUP BY m.ModelID;


CREATE VIEW PurchasedCarsList 
AS SELECT 
	uc.username,
    m.ModelName, m.ModelID,
    mk.MakeName, mk.MakeID,
    c.ColorName, c.ColorID,
    e.EngineType, e.EngineID,
    t.TransmissionType, t.TransmissionID,
    m.ModelDescription,
    user_car_id, uc.CarTypeID,
    ct.Price
FROM  user_cars uc 
JOIN  CarType ct ON uc.CarTypeID = ct.CarTypeID 
JOIN  users u ON uc.username = u.username 
JOIN  Model m ON ct.ModelID = m.ModelID
JOIN Make mk ON m.MakeID = mk.MakeID
JOIN  Color c ON ct.ColorID = c.ColorID 
JOIN Engine e ON ct.EngineID = e.EngineID 
JOIN Transmission t ON ct.TransmissionID = t.TransmissionID;

CREATE VIEW PendingCarsList 
AS SELECT 
	puc.username,
    m.ModelName, m.ModelID,
    mk.MakeName, mk.MakeID,
    c.ColorName, c.ColorID,
    e.EngineType, e.EngineID,
    t.TransmissionType, t.TransmissionID,
    user_car_id, puc.CarTypeID,
    ct.Price
FROM  pending_user_cars puc 
JOIN  CarType ct ON puc.CarTypeID = ct.CarTypeID 
JOIN  users u ON puc.username = u.username 
JOIN  Model m ON ct.ModelID = m.ModelID
JOIN Make mk ON m.MakeID = mk.MakeID
JOIN  Color c ON ct.ColorID = c.ColorID 
JOIN Engine e ON ct.EngineID = e.EngineID 
JOIN Transmission t ON ct.TransmissionID = t.TransmissionID;
        
CREATE VIEW InventoryAccessoriesList 
AS SELECT  
	a.AccessoryName,
    a.AccessoryID,
    a.description,
    accinv_id,
    a.Price
FROM accessories accinv
JOIN Accessory a ON accinv.AccessoryID = a.AccessoryID;


CREATE VIEW PurchasedAccessoriesList 
AS SELECT  
	uc.CarTypeID,
    uc.user_car_id, 
    u.FName, u.LName, u.username, 
    m.ModelName, m.ModelID, 
    a.AccessoryName, a.AccessoryID,
    uca.user_car_accessory_id,
    ct.Price AS CarPrice, a.Price as AccessoryPrice
FROM user_car_accessories uca
JOIN user_cars uc ON uc.user_car_id = uca.user_car_id 
JOIN users u ON u.username = uc.username
JOIN CarType ct ON uc.CarTypeID = ct.CarTypeID
JOIN Model m ON ct.ModelID = m.ModelID 
JOIN Accessory a ON uca.AccessoryID = a.AccessoryID