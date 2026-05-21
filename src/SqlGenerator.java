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







    public void rosterInitializer  () throws FileNotFoundException {  //TODO MIGRATE THIS TO ROSTER CLASS
        int maxStudents = StudentList.size() / ClassList.size();
        int ID = 1;
        for (Student student : StudentList) {
            RosterList.add(new Roster(student,ClassList,ID));
            ID++;
        }
    }
}