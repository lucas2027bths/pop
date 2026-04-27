import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SqlGenerator {

    public static void CourseTypes(){
        System.out.print("INSERT INTO CourseTypes (course_TYPEID,course_type) VALUES (1,'Regents')");
        System.out.print("INSERT INTO CourseTypes (course_TYPEID,course_type) VALUES (1,'AP')");
        System.out.print("INSERT INTO CourseTypes (course_TYPEID,course_type) VALUES (1,'Elective')");
    }
    public static void Rooms(){

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
                    System.out.print("INSERT INTO Rooms (location) VALUES ('");
                    if (floor == 0){
                        System.out.print("B" + realWing + room +"')");
                    }else{
                        System.out.print(+ floor + realWing + room +"')");
                    }
                    System.out.print(";");
                    System.out.println();

                }

            }

        }

    }
    public static void Departments() throws FileNotFoundException {
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

        for (int x = 0; x < depts.length; x++){
            String dept = depts[x];
            System.out.println("INSERT INTO Departments VALUES ("+x+",'" + dept +"');");

            while(scan.hasNextLine()){
                String name = scan.nextLine();
                if (x+1 < depts.length && name.equals(depts[x+1])){
                    break;
                }
                String[] firstLast = name.split(" ",2);
                System.out.println("INSERT INTO Teachers (first_name,last_name,departmentID) VALUES('"+firstLast[0]+"','"+firstLast[1]+"',"+x+")");

            }


        }

    }
    public static void Courses() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/courses"));
        while(scan.hasNextLine()){
            String name = scan.nextLine();

        }
    }

}