/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futureuniversity;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FUEUniversityGUI extends Application {

    // Create an array of students               // ben3ml create to student 
    private Student[] students = {
            new Student("Ahmed", "10001", 22, "Freshman", new String[]{"Math", "English"}),  // Freshman -> ma3nha talb or talbha 
            new Student("Mona ", "10002", 19, "Junior", new String[]{"Physics", "Chemistry"}), // Junior -> ma3nha mobtd2 
            new Student("David ", "10003", 21, "Freshman", new String[]{"History", "Economics"}),
            new Student("Mina", "10004", 20, "Sophomore", new String[]{"Computer Science", "Statistics"})  //Sophomore-> ma3nha talb fy sana tanya darsya 
    };

    // Create an array of staff members            // a7na hena ben3ml creat l staff 
    private StaffMember[] staffMembers = {
            new StaffMember("Dr.Mohamed", "Professor", new String[]{"Math", "Statistics"}),
            new StaffMember("Ms. Amany", "Teacher Assistant", new String[]{"English", "History"})
    };

    // Create an observable list of courses       // hena create mol7zat fy el course 
    private ObservableList<String> courses = FXCollections.observableArrayList(
            "Math", "English", "Physics", "Chemistry", "History", "Economics", "Computer Science", "Statistics");

    // Create the GUI                          // hena 3amlna el GUI
    @Override
    public void start(Stage primaryStage) {

        // Create a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add labels and text fields for student ID and staff title              // hena taktb text field student and id and staff 
        Label studentIdLabel = new Label("Student ID:");
        TextField studentIdTextField = new TextField();
        Label staffTitleLabel = new Label("Staff Title:");
        TextField staffTitleTextField = new TextField();

        gridPane.add(studentIdLabel, 0, 0);
        gridPane.add(studentIdTextField, 1, 0);
        gridPane.add(staffTitleLabel, 2, 0);
        gridPane.add(staffTitleTextField, 3, 0);

        // Add a button to search for student or staff member                // ba3ml buttom badwr 3ala student or staff 
        Button searchButton = new Button("Search");
        gridPane.add(searchButton, 4, 0);

        // Add labels and text fields for student information              // benktb text fields w information l student 
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();
        Label idLabel = new Label("ID:");
        TextField idTextField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageTextField = new TextField();
        Label levelLabel = new Label("Level:");
        TextField levelTextField = new TextField();
        Label coursesLabel = new Label("Courses:");
        ListView<String> coursesListView = new ListView<>();

        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameTextField, 1, 1);
        gridPane.add(idLabel, 2, 1);
        gridPane.add(idTextField, 3, 1);
        gridPane.add(ageLabel, 0, 2);
        gridPane.add(ageTextField, 1, 2);
        gridPane.add(levelLabel, 2, 2);
        gridPane.add(levelTextField, 3, 2);
        gridPane.add(coursesLabel, 0, 3);
        gridPane.add(coursesListView, 1, 3, 3, 1);

        // Add a label for staff member information                // a7na hena be3ml information l staff
        Label staffCoursesLabel = new Label("Courses:");

        gridPane.add(staffCoursesLabel, 0, 4);
        gridPane.add(new Label(), 1, 4);

        // Set the list of courses for the courses list view        // ben3ml t3en l courses 3a4an tat3rd 
        coursesListView.setItems(courses);

        // Set the search button action                         // ben3ml buttom search
        searchButton.setOnAction(event -> {
            String id = studentIdTextField.getText();
            String title = staffTitleTextField.getText();

            // Check if the ID belongs to a student              // hena ben3ml check information l  student
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    nameTextField.setText(student.getName());
                    idTextField.setText(student.getId());
                    ageTextField.setText(Integer.toString(student.getAge()));
                    levelTextField.setText(student.getLevel());
                    coursesListView.getItems().setAll(student.getCourses());
                    return;
                }
            }

            // Check if the title belongs to a staff member             // hena ben3ml check fy title el staff
            for (StaffMember staffMember : staffMembers) {
                if (staffMember.getTitle().equals(title)) {
                    staffCoursesLabel.setText("Courses:");
                    coursesListView.getItems().setAll(staffMember.getCourses());
                    return;
                }
            }

            // If neither a student nor a staff member was found, clear the fields                // lw mal2ash student or staff e3ml clear the fields
            nameTextField.setText("");
            idTextField.setText("");
            ageTextField.setText("");
            levelTextField.setText("");
            coursesListView.getItems().clear();
            staffCoursesLabel.setText("Courses:");
        });

        // Create the scene and set it to the primary stage                  
        Scene scene = new Scene(gridPane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FUE University");
        primaryStage.show();
    }

    // Define the Student class                  // na7dd no3 el talb 
    private static class Student {
        private String name;
        private String id;
        private int age;
        private String level;
        private String[] courses;

        public Student(String name, String id, int age, String level, String[] courses) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.level = level;
            this.courses = courses;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public String getLevel() {
            return level;
        }

        public String[] getCourses() {
            return courses;
        }
    }

    // Define the StaffMember class                   // ben7dd no3 el staff
    private static class StaffMember {
        private String name;
        private String title;
        private String[] courses;

        public StaffMember(String name, String title, String[] courses) {
            this.name = name;
            this.title = title;
            this.courses = courses;
        }

        public String getName() {
            return name;
        }

        public String getTitle() {
            return title;
        }

        public String[] getCourses() {
            return courses;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}