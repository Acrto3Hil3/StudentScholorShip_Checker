# Student Scholarship Management System

![Student Scholarship Management System]![p1](https://github.com/user-attachments/assets/3214deb4-8157-4e0f-92fe-b0a7030dd4a5)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The **Student Scholarship Management System** is a web application designed to manage student scholarships. It allows administrators to upload student data via CSV files, view and manage student details, and ensure efficient scholarship distribution.

## Features
- User authentication (Admin login)
- Upload student data via CSV
- View student details
- Search and filter students
- Responsive design

## Technologies Used
- **Backend**: Java Servlets, JSP, JDBC
- **Frontend**: HTML, CSS, Bootstrap
- **Database**: Oracle
- **Build Tool**: Apache Maven
- **Server**: Apache Tomcat

## Setup
### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Apache Tomcat
- Oracle Database

### Installation
1. **Clone the repository**
    ```bash
    git clone https://github.com/your-username/student-scholarship-management-system.git
    cd student-scholarship-management-system
    ```

2. **Configure the Database**
    - Create a new database and execute the SQL script provided in the `db` folder.

3. **Configure the Project**
    - Update the database configuration in `src/main/resources/db.properties` file.

4. **Build the Project**
    ```bash
    mvn clean install
    ```

5. **Deploy to Tomcat**
    - Copy the generated WAR file from `target` directory to the Tomcat `webapps` directory.

6. **Run the Server**
    - Start the Tomcat server and access the application at `http://localhost:8080/student-scholarship-management-system`.

## Usage
### Admin Login
- Navigate to the login page and enter your credentials.

### Upload CSV
- Use the upload section to submit student data via CSV.

### View Student Details
- View and manage student details from the dashboard.

## Screenshots
![Dashboard](images/dashboard.png)
*Admin Dashboard*

![Upload CSV](images/upload.png)
*CSV Upload Section*

![Student Details](images/student_details.png)
*Student Details Table*

## Contributing
We welcome contributions! Please follow these steps:
1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -am 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Create a new Pull Request

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

