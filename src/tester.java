import java.io.FileNotFoundException;
import java.util.ArrayList;

public class tester {
    public static void main(String[] args) throws FileNotFoundException {
        SqlGenerator generator = new SqlGenerator();
        generator.RoomInitalizer();
        generator.DepartmentsAndTeacherInitalizer();
        generator.CourseInitalizer();
        generator.ClassesInitializer();
        generator.StudentInitalizer();
        generator.RosterInitializer();
        System.out.println(generator.RosterList);


//        System.out.println(sqlGenerator.RoomList);
//        System.out.println(sqlGenerator.DepartmentList);
//        System.out.println(sqlGenerator.TeacherList);
//        System.out.println(sqlGenerator.CourseList);
//        System.out.println(sqlGenerator.ClassList);


    }
}
