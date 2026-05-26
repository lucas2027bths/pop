import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Course {
    private int id;
    private String name;
    private int courseTypeID;

    public Course(int ID, String name , int course_type_ID){
        this.id = ID;
        this.name = name;
        this.courseTypeID = course_type_ID;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static String insertTypes (){
        return "INSERT INTO CourseTypes VALUES(1,'Regents');" +
                "INSERT INTO CourseTypes VALUES(2,'AP');" +
                "INSERT INTO CourseTypes VALUES(3,'Elective');";
    }
    @Override
    public String toString(){
        return "INSERT INTO Courses VALUES ("+ id +",'" + name +"'," + courseTypeID + ");";
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
