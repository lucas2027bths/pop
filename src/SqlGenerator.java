import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqlGenerator {
    public ArrayList<Department> DepartmentList = new ArrayList<>();
    public ArrayList<Teacher> TeacherList = new ArrayList<>();
    public ArrayList<Room> RoomList = new ArrayList<>();
    public ArrayList<Student> StudentList = new ArrayList<>();


    public void RoomInitalizer(){
        int id = 0;
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
    public void DepartmentsAndTeacherInitalizer() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/teachers"));
        String[] depts = {"Biological Sciences",
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
        int id = 0;

        for (int x = 0; x < depts.length; x++){
            String dept = depts[x];
            DepartmentList.add(new Department(x,dept));
            while(scan.hasNextLine()){
                String name = scan.nextLine();
                if (x+1 < depts.length && name.equals(depts[x+1])){
                    break;
                }
                String[] firstLast = name.split(" ",2);
                TeacherList.add(new Teacher(id,firstLast[0],firstLast[1],x));
                id++;

            }


        }

    }
    public void StudentInitalizer() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/students"));
        int count = 0;
        while(scan.hasNextLine()){
                String[] name = scan.nextLine().split(" ");
                StudentList.add(new Student(name[0],name[1],1,count));
                count++;
            }
    }


    public void ClassesInitializer() throws FileNotFoundException {
        Scanner scan = new Scanner (new File("src/courses"));
        while(scan.hasNextLine()){
            String name = scan.nextLine();

        }
    }
}