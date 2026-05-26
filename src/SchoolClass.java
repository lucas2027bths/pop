import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class SchoolClass {
    private String name;
    public ArrayList<Student> students;
    private ArrayList<Assignment> classAssignments = new ArrayList<>();
    private int id;
    private Teacher teacher;
    private Room room;
    private int period;
    private Course courseParent; // the course that this school class belongs to

    public SchoolClass(int id, Teacher teacher, Room room, int period, Course courseParent){
        this.name = courseParent.getName() + period;
        this.id = id;
        this.teacher = teacher;
        this.room = room;
        this.period = period;
        this.courseParent = courseParent;
        students = new ArrayList<>();

    }

    public void addStudents (Student a){
       students.add(a);
    }
    public void makeAssignments (){ // adds 12 minor assignments and 3 major assignments
        /// this SHOULD ONLY RUN ONCE
        for (int i = 0; i < 12; i++) {
            String AssignmentName = this.name + "work" + i;
            classAssignments.add(new Assignment(1,i,AssignmentName));

        }
        for (int i = 12; i < 15; i++) {
            String AssignmentName = this.name + "work" + i;
            classAssignments.add(new Assignment(2,i,AssignmentName));
        }
    }
    public ArrayList<Assignment> getAssignments(){
        return classAssignments;
    }

    public int getPeriod() {
        return period;
    }
    public int getId(){
        return id;
    }

    public String toString (){
        return "INSERT INTO Classes VALUES(" + id +"," + room.id + "," + teacher.getID() + "," + courseParent.getId() + "," + period + ");";
    }

    public static ArrayList<SchoolClass> createClasses(ArrayList<Course> courseList, ArrayList<Room> roomList, ArrayList<Teacher> teacherList) throws FileNotFoundException {
        ArrayList<SchoolClass> classList = new ArrayList<>();
        Random ran = new Random();
        int room = 0;
        int teach = 0;
        int period = 1;
        int id = 1;
        for (int x = 0; x < courseList.size(); x++){

            int randomNum = ran.nextInt(1,5);
            for (int y = 0; y < randomNum; y++){

                if (period > 10){
                    period = 1;
                    room++;
                }

                Room currentRoom = roomList.get(room);
                currentRoom.booked[period-1] = true;
                Teacher currentTeacher = null;

                for (int j = 0; j < teacherList.size(); j++){
                    Teacher teacher = teacherList.get(j);
                    if (!teacher.booked[period - 1]){
                        teacher.booked[period-1] = true;
                        currentTeacher = teacher;
                        break;
                    }
                }

                if (currentTeacher == null){
                    System.out.println("something went wrong");
                }
                classList.add(new SchoolClass(id,currentTeacher,currentRoom,period,courseList.get(x)));
                classList.get(classList.size()-1).makeAssignments();
                id++;
                period++;
            }

        }

    return classList;
    }


    public static void createAndPrintGrades(ArrayList<Student> studentList, ArrayList<Assignment> assignmentList){
        for (int i = 1; i < 5001; i++) {
            Student CurrStudent = studentList.get(i-1);
            Roster CurrRosterObj=CurrStudent.getRoster();
            ArrayList<SchoolClass> CurrClassList= CurrRosterObj.getClasses();
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 15; k++) {
                    SchoolClass CurrClass = CurrClassList.get(j);
                    Assignment currAssignmentId =CurrClass.getAssignments().get(k);
                    System.out.println("INSERT INTO Grades(Grade, studentID,assignmentID) VALUES("
                            + (int)(Math.random()* 25 + 75) + ","  + i + ","  +  assignmentList.indexOf(currAssignmentId) + 1 + ");");
                }
            }
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