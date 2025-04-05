

package javafxapplication15;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class University extends Application {

   
    private Student[] students = {
            new Student("nada", "2554656", 23, "Sophomore", new String[]{"programming"}),  
           new Student("magad ", "3535676", 20, "junior", new String[]{"web"}), 
           new Student(" rana ", "7864326", 19, "freshman", new String[]{"database"}),
          new Student("ali", "097642", 21, "Sophomore", new String[]{"programming"}),
          new Student("manar", "987634", 22, "Sophomore", new String[]{"database"})  
    };

    
    private StaffMember[] staffMembers = {
           new StaffMember("ahmed", "doctor", new String[]{"programming"}),
            new StaffMember("nagla", "Assistant", new String[]{"database"}),
             new StaffMember("mona", "doctor", new String[]{"web"}),
              new StaffMember("moaz", "assistant", new String[]{"programming"})
    };

  
    private ObservableList<String> courses = FXCollections.observableArrayList(
            "programming", "web", "database");

  
    @Override
    public void start(Stage primaryStage) {

      
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

     
        Label studentIdLabel = new Label("Student's ID :");
        TextField studentIdTextField = new TextField();
        Label staffTitleLabel = new Label("Staff's major :");
        TextField staffTitleTextField = new TextField();

        gridPane.add(studentIdLabel, 0 , 10);
        gridPane.add(studentIdTextField, 0 ,11);
        gridPane.add(staffTitleLabel, 1 , 6);
        gridPane.add(staffTitleTextField, 1 , 7);

        
        Button searchButton = new Button("Search");
        gridPane.add(searchButton, 4, 0);

       
        Label nameLabel = new Label("staff's or student's Name :");
        TextField nameTextField = new TextField();
        Label idLabel = new Label("confirm password :");
        TextField idTextField = new TextField();
        Label ageLabel = new Label("student's Age:");
        TextField ageTextField = new TextField();
        Label levelLabel = new Label("student's Level:");
        TextField levelTextField = new TextField();
        Label coursesLabel = new Label("Courses:");
        ListView<String> coursesListView = new ListView<>();

        gridPane.add(nameLabel, 0 , 6);
        gridPane.add(nameTextField, 0, 7);
        gridPane.add(idLabel, 1 , 10);
        gridPane.add(idTextField, 1 , 11);
        gridPane.add(ageLabel, 2 , 10);
        gridPane.add(ageTextField, 2 , 11);
        gridPane.add(levelLabel, 3 , 10);
        gridPane.add(levelTextField, 3, 11);
        gridPane.add(coursesLabel, 0 , 3);
        gridPane.add(coursesListView, 1, 3, 3, 1);

     
        Label staffCoursesLabel = new Label("");

        gridPane.add(staffCoursesLabel, 0, 4);
        gridPane.add(new Label(), 1, 4);

        
        coursesListView.setItems(courses);

      
        searchButton.setOnAction(event -> {
            String id = studentIdTextField.getText();
            String title = staffTitleTextField.getText();

            for (Student student : students) {                      //calling la class student 34an ya2dar al user yada5al data wa tatkatab fi al textfeild
                
                if (student.getId().equals(id)) {  /// lazam al user yada5al id 34an u2dar yada5al ba2ii al bayanat
                    
                    nameTextField.setText(student.getName());
                    idTextField.setText(student.getId());
                    ageTextField.setText(Integer.toString(student.getAge()));
                    levelTextField.setText(student.getLevel());
                    coursesListView.getItems().setAll(student.getCourses());
                    return;
                }
            }

           
            for (StaffMember staffMember : staffMembers) {           //calling la class staffmember 34an ya2dar al user yada5al data wa tatkatab fi al textfeild
                
                
                
                if (staffMember.getTitle().equals(title)) {         /// lazam al user yada5al title 34an u2dar yada5al ba2ii al bayanat
                    staffCoursesLabel.setText("");
                    coursesListView.getItems().setAll(staffMember.getCourses());
                    return;
                }
            }

             nameTextField.setText("");
            idTextField.setText("");
            ageTextField.setText("");
            levelTextField.setText("");
            coursesListView.getItems().clear();
            staffCoursesLabel.setText("");
        });

                     
        Scene scene = new Scene(gridPane, 900, 700);      // awal wa7da al (3ard)           tani wa7da al (tol)
        primaryStage.setScene(scene);
        primaryStage.setTitle("FUE University");
        primaryStage.show();
    }

 
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