import java.util.ArrayList;

public class SchoolClass {
    private String name;
//    private ArrayList<Student> Students;
    private ArrayList<Assignment> Assignments;
    private int ID;
    private Teacher teacher;
    private Room room;
    private int period;
    private Course CourseParent;

    public SchoolClass(int ID, String name, Teacher teacher, Room room, int period, Course CourseParent){
        this.name = name;
        this.ID = ID;
        this.teacher = teacher;
        this.room = room;
        this.period = period;
        this.CourseParent = CourseParent;
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
                    " (" + Assignments.get(i).getName() + "," +Assignments.get(i).getType() +"," + ID + ")\"");
        }
    }
    public String toString (){
        return "INSERT INTO Classes VALUES(" + ID +"," + room.ID + "," + teacher.getID() + "," + CourseParent.getID() + "," + period + ")";
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