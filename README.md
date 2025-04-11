# Car Dealership Service Management System

## Overview
The **Car Dealership Service Management System** is a comprehensive **JavaFX-based e-commerce application** designed for managing various aspects of a car dealership. This system supports not only **car sales** but also **maintenance, service, and accessory management**. It is equipped with a **user-friendly interface** and a **robust backend** powered by **MySQL**.

### Key Features
- **User and Admin Versions**: 
  - Users can browse cars, purchase vehicles, and avail various services.
  - Admins can manage inventory, process orders, and handle service requests.
- **Car Services & Maintenance**: 
  - Includes car **washing, painting, color changes, and maintenance**.
  - Stock for multiple **spare parts and accessories**.
- **Insurance & Warranty Support**: 
  - Integration for insurance and service warranty claims.
- **Refund & Exchange System**: 
  - Allows customers to **return and exchange cars** by paying an additional amount.
- **Inventory & Order Management**: 
  - Admins can add, update, and remove cars and accessories.
  - Order processing and transaction handling.
- **MySQL Integration**:
  - Manages user data, purchase history, and inventory efficiently.
- **Secure Authentication**:
  - User authentication with role-based access control.

## Technologies Used
- **Java** - The Programming Language for Backend.
- **JavaFX** - For the graphical user interface.
- **MySQL** - For database management.
- **JDBC** - For database connectivity.

## Setup Instructions

### Prerequisites
- Install **JDK 17 or later**.
- Install **MySQL Server & Workbench**.
- Install **JavaFX SDK**.

### Step 1: Clone the Repository
```sh
git clone https://github.com/your-username/car-dealership-system.git
cd car-dealership-system
```

### Step 2: Configure MySQL Database
1. Open **MySQL Workbench**.
2. Execute all scripts under the folder **db**.
3. Set up JDBC and Update the database credentials in the Java project:
   ```java
   String url = "jdbc:mysql://localhost:3306/db_name";
   String user = "root";
   String password = "yourpassword";
   ```

### Step 3: Install JavaFX
Download and set up JavaFX SDK:
1. Download **JavaFX SDK** from [Gluon](https://gluonhq.com/products/javafx/).
2. Extract the SDK and configure environment variables.
3. Update your `VM options` in **IDE settings**:
   ```sh
   --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml
   ```

### Step 4: Run the Application
- **Using IDE** (IntelliJ/VSCode):
  1. Open the project.
  2. Set up **JavaFX dependencies**.
  3. Run `App.java`.

## Contribution
Feel free to fork the repository and submit **pull requests** for improvements.

## License
This project is **MIT Licensed**. See `LICENSE` for details.
