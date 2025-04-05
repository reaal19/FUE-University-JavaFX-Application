🎓 FUE University JavaFX Application
This is a desktop-based JavaFX application that simulates a simple university information system for FUE University. It allows users to view and search for students and staff members, displaying detailed information about their academic status and courses.

📌 Features
Student Information Lookup
Enter a student's ID to access full academic data:

Name, ID, Age, and Academic Level (Freshman, Sophomore, etc.)

List of registered courses

Easily extendable to show passed, failed, or in-progress courses

Staff Information Lookup
Enter a staff title (e.g., "Professor", "Teacher Assistant") to view:

Assigned teaching courses

Title and name of the staff member

Simple & Clean JavaFX UI
The GUI is built using JavaFX components like GridPane, TextField, Label, ListView, and Button for a clean, interactive experience.

🧪 Technologies Used
Java 8+

JavaFX (GUI framework)

Ant-based build system (NetBeans project structure)

🏁 How to Run
Note: Make sure JavaFX is properly set up in your environment.
Option 1: Run from Terminal
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar futureuniversity.jar
Option 2: Run from Source (Recommended)
Open the project in IntelliJ IDEA or NetBeans.

Add JavaFX SDK to your project libraries.

Set futureuniversity.FUEUniversityGUI as your main class.

Run the application.
📖 Example Students and Staff
Students

Ahmed, ID: 10001, Freshman – Courses: Math, English

Mona, ID: 10002, Junior – Courses: Physics, Chemistry

Staff

Dr. Mohamed – Teaches: Math, Statistics

Ms. Amany – Teaches: English, History

📌 Note
This is an educational project intended to demonstrate:

JavaFX GUI design

Basic OOP (Object-Oriented Programming)

Data lookup and UI interactivity

