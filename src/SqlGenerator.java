import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SqlGenerator {


    //Lists
    public ArrayList<Department> DepartmentList = new ArrayList<>();
    public ArrayList<Teacher> TeacherList = new ArrayList<>();
    public ArrayList<Room> RoomList = new ArrayList<>();
    public ArrayList<Course> CourseList = new ArrayList<>();
    public ArrayList<Student> StudentList = new ArrayList<>();
    public ArrayList<SchoolClass> ClassList = new ArrayList<>();
    public ArrayList<Roster> RosterList = new ArrayList<>();
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
        for (int i = 0; i < 5000; i++) {
            Student CurrStudent = StudentList.get(i);
            Roster CurrRosterObj=CurrStudent.getRoster();
            ArrayList<SchoolClass> CurrClassList= CurrRosterObj.getClasses();
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k < 16; k++) {
                    SchoolClass CurrClass = CurrClassList.get(j);
                    for (Assignment each : CurrClass.getAssignments()){
                        int AssignmentID = CurrClass.getID() * 15 + k - 15;
                        System.out.println("INSERT INTO Grades(Grade, studentID,assignmentID) VALUES("
                                + (int)(Math.random()* 25 + 75) + ","  + i+1 + ","  + AssignmentID + ");");
                    }
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

        Collections.shuffle(CourseList);  //randomize
        Collections.shuffle(TeacherList);

        for (int x = 0; x < CourseList.size(); x++){ //go through all courses and create classes for them

            createClassesOfCourse(ran,period,room,id,x);

        }


    }

    private void createClassesOfCourse(Random ran, int period, int room,int id, int x){
        int amountOfClassesPerCourse = ran.nextInt(1,5);

        for (int y = 0; y < amountOfClassesPerCourse; y++){ //create from 1-5 classes per course

            if (period > 10){ //reset back to period 1 if period 10 is reached
                period = 1;
                room++; //we're doing psuedo random and really just getting a random coures and then giving all rooms 10 periods of a class
            }

            Room currentRoom = RoomList.get(room); //get a room
            currentRoom.booked[period-1] = true; // -1 because index starts at 0
            Teacher currentTeacher = null;

            for (int j = 0; j < TeacherList.size(); j++){
                Teacher teacher = TeacherList.get(j); //very inefficient but just go through all teachers and try to find one that's not booked on that period
                if (!teacher.booked[period - 1]){
                    teacher.booked[period-1] = true;
                    currentTeacher = teacher;
                    break;
                }
            }

            if (currentTeacher == null){ //if a teacher wasn't selected return as something went wrong
                System.out.println("something went wrong");
                return;
            }

            ClassList.add(new SchoolClass(id,currentTeacher,currentRoom,period,CourseList.get(x)));
            ClassList.get(ClassList.size()-1).makeAssignments();
            id++;
            period++;
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