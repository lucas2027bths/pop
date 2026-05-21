import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SqlGenerator {


    //Lists
    public ArrayList<Department> DepartmentList = new ArrayList<>();
    public ArrayList<Teacher> TeacherList = new ArrayList<>();
    public ArrayList<Room> RoomList = new ArrayList<>();
    public ArrayList<Course> CourseList = new ArrayList<>();
    public ArrayList<Student> StudentList = new ArrayList<>();
    public ArrayList<SchoolClass> ClassList = new ArrayList<>();
    public ArrayList<Roster> RosterList = new ArrayList<>();
    public static ArrayList<Assignment> AssignmentList = new ArrayList<>();
    static String location = "src/";

    public void roomInitalizer(){
        int id = 1;
        for (int floor = 0; floor <= 8;floor++){

            for (int wing = 0; wing < 4; wing++){
                String realWing;


                if (wing == 0){
                    realWing = "N";
                }
                else if (wing == 1){
                    realWing = "E";
                }
                else if (wing == 2){
                    realWing = "S";
                }
                else {
                    realWing = "W";
                }


                for (int room = 1; room <= 20; room++){
                    String location;
                    if (floor == 0){
                        location = ("B" + realWing + room);
                    }else{
                        location = (floor + realWing + room );
                    }
                    RoomList.add(new Room(id,location));
                    id++;

                }

            }

        }

    }


    public void departmentsAndTeacherInitalizer() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(location+"teachers"));
        String[] departments = {"Biological Sciences",
                "Chemistry",
                "Computer Science",
                "English",
                "Health & PE",
                "Mathematics",
                "Physics",
                "Social Studies",
                "Special Education",
                "Visual & Performing Arts",
                "World Languages & ENL"
        };
        int id = 1;

        for (int currentDepartment = 0; currentDepartment < departments.length; currentDepartment++){
            String departmentName = departments[currentDepartment];
            DepartmentList.add(new Department(currentDepartment+1,departmentName));

            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                if (name.isEmpty()){
                    continue;
                }
                if (currentDepartment + 1 < departments.length && name.equals(departments[currentDepartment+1])) {
                    break;
                }
                String[] firstLast = name.split(" ", 2);
                TeacherList.add(new Teacher(id, firstLast[0], firstLast[1], currentDepartment+1));
                id++;
            }


        }

    }




    public void studentInitalizer() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(location+"students"));
        int count = 0;
        while(scan.hasNextLine()){
            String[] name = scan.nextLine().split(" ");
            StudentList.add(new Student(name[0],name[1],count));
            count++;
        }
    }

    public void GradeInitializer(){
        for (int i = 1; i < 5001; i++) {
            Student CurrStudent = StudentList.get(i-1);
            Roster CurrRosterObj=CurrStudent.getRoster();
            ArrayList<SchoolClass> CurrClassList= CurrRosterObj.getClasses();
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 15; k++) {
                    SchoolClass CurrClass = CurrClassList.get(j);
                    Assignment currAssignmentId =CurrClass.getAssignments().get(k);
                        System.out.println("INSERT INTO Grades(Grade, studentID,assignmentID) VALUES("
                                + (int)(Math.random()* 25 + 75) + ","  + i + ","  +  AssignmentList.indexOf(currAssignmentId) + 1 + ");");
                }
            }
        }
    }



    public void classesInitializer() throws FileNotFoundException {
        Random ran = new Random();
        int room = 0;
        int teach = 0;
        int period = 1;
        int id = 1;
        for (int x = 0; x < CourseList.size(); x++){

            int randomNum = ran.nextInt(1,5);
            for (int y = 0; y < randomNum; y++){

                if (period > 10){
                    period = 1;
                    room++;
                }

                Room currentRoom = RoomList.get(room);
                currentRoom.booked[period-1] = true;
                Teacher currentTeacher = null;

                for (int j = 0; j < TeacherList.size(); j++){
                    Teacher teacher = TeacherList.get(j);
                    if (!teacher.booked[period - 1]){
                        teacher.booked[period-1] = true;
                        currentTeacher = teacher;
                        break;
                    }
                }

                if (currentTeacher == null){
                    System.out.println("something went wrong");
                    return;
                }
                ClassList.add(new SchoolClass(id,currentTeacher,currentRoom,period,CourseList.get(x)));
                ClassList.get(ClassList.size()-1).makeAssignments();
                id++;
                period++;
            }

        }


    }



    public void courseInitalizer() throws FileNotFoundException {
        Scanner scan = new Scanner (new File(location+"courses"));
        int x = 1;
        while(scan.hasNextLine()){
            String name = scan.nextLine();
            String[] nameStuff = name.split(" [|] ",2);
            CourseList.add(new Course(x,nameStuff[0],Integer.parseInt(nameStuff[1])));
            x++;
        }
    }

    public void rosterInitializer  () throws FileNotFoundException {
        int maxStudents = StudentList.size() / ClassList.size();
        int ID = 1;
        for (Student student : StudentList) {
            RosterList.add(new Roster(student,ClassList,ID));
            ID++;
        }
    }
}