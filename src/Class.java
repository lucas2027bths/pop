import java.util.ArrayList;

public class Class {
    private String name;
    private int type;
//    private ArrayList<Student> Students;
    private ArrayList<Assignment> Assignments;
    private int id;
    private Room room;

    public Class (int type, String name){
        this.name = name;
        this.type = type;
        System.out.println("echo \"INSERT INTO Courses(name, type, id) VALUES(" + name + "," + type + "," + id + "(\"");
    }
//
//    public void addStudents (Student a){
//        Students.add(a);
//    }
    public void makeAssignments (){
        /// this SHOULD ONLY RUN ONCE
        for (int i = 0; i < 12; i++) {
            String AssignmentName = this.name + "work" + i;
            Assignments.add(new Assignment(0,i,AssignmentName));
        }
        for (int i = 12; i < 15; i++) {
            String AssignmentName = this.name + "work" + i;
            Assignments.add(new Assignment(1,i,AssignmentName));
        }
        for (int i = 0; i < Assignments.size(); i++) {
            System.out.println("echo \"INSERT INTO Assignment(Name, Type, ClassID) VALUES" +
                    " (" + Assignments.get(i).getName() + "," +Assignments.get(i).getType() +"," + id + ")\"");
        }
    }
//    public void giveGrade(){
//        for (int i = 0; i < Students.size(); i++) {
//            int studentID = Students.get(i).getId();
//            for (int j = 0; j < Assignments.size(); j++) {
//                int AssignmentID = Assignments.get(j).getId();
//                System.out.println("echo \" INSERT INTO Grades(Grade, studentID,assignmentID) VALUES("
//                        + (Math.random()* 25 + 75) + ","  + studentID + "," + "" + AssignmentID + ")\"");
//
//            }
//        }
//    }
}