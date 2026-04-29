import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Class {
    private String name;
    private int type;
    private ArrayList<Student> Students = new ArrayList<>();
    private ArrayList<Assignment> Assignments = new ArrayList<>();
    private ArrayList<String> randomNames = new ArrayList<>();
    private int id;
    private Room room;

    public Class (int type, String name) throws FileNotFoundException {
        this.name = name;
        this.type = type;
        Scanner scan = new Scanner(new File("src/randomAssign"));

        while (scan.hasNext()){
            randomNames.add(scan.nextLine());
        }

    }

    public void addStudents (Student a){
        Students.add(a);
    }
    public void makeAssignments ()  {
        /// this SHOULD ONLY RUN ONCE

        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            String AssignmentName = randomNames.get(random.nextInt(randomNames.size()-1));
            Assignments.add(new Assignment(0,i,AssignmentName));
        }
        for (int i = 12; i < 15; i++) {
            String AssignmentName = randomNames.get(random.nextInt(randomNames.size()-1));
            Assignments.add(new Assignment(1,i,AssignmentName));
        }
        for (int i = 0; i < Assignments.size(); i++) {
            System.out.println(Assignments.get(i));
        }
    }
    public void giveGrade(){
        for (int i = 0; i < Students.size(); i++) {
            int studentID = Students.get(i).getId();
            for (int j = 0; j < Assignments.size(); j++) {
                int AssignmentID = Assignments.get(j).getId();
                System.out.println("echo \" INSERT INTO Grades(Grade, studentID,assignmentID) VALUES("
                        + (Math.random()* 25 + 75) + ","  + studentID + "," + "" + AssignmentID + ")\"");

            }
        }
    }
    @Override
    public String toString(){
       return ("echo \"INSERT INTO Courses(name, type, id) VALUES(" + name + "," + type + "," + id + "(\"");
    }
}