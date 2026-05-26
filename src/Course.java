import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Course {
    private int ID;
    private String name;
    private int course_type_ID;

    public Course(int ID, String name , int course_type_ID){
        this.ID = ID;
        this.name = name;
        this.course_type_ID = course_type_ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public static String insertTypes (){
        return "INSERT INTO CourseTypes VALUES(1,'Regents');" +
                "INSERT INTO CourseTypes VALUES(2,'AP');" +
                "INSERT INTO CourseTypes VALUES(3,'Elective');";
    }
    @Override
    public String toString(){
        return "INSERT INTO Courses VALUES ("+ID+",'" + name +"'," + course_type_ID + ");";
    }

    public static ArrayList<Course> createCourses() throws FileNotFoundException {

        ArrayList<Course> courseList = new ArrayList<>();

        Scanner scan = new Scanner (new File(SqlGenerator.directory +"courses"));
        int x = 1;
        while(scan.hasNextLine()){
            String name = scan.nextLine();
            String[] nameStuff = name.split(" [|] ",2);
            courseList.add(new Course(x,nameStuff[0],Integer.parseInt(nameStuff[1])));
            x++;
        }
        Collections.shuffle(courseList); //randomize
        return courseList;
    }

}
