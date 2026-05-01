import java.io.FileNotFoundException;

public class tester {
    public static void main(String[] args) throws FileNotFoundException {
        SqlGenerator sqlGenerator = new SqlGenerator();

        sqlGenerator.RoomInitalizer();
        sqlGenerator.DepartmentsAndTeacherInitalizer();
        sqlGenerator.CourseInitalizer();
        sqlGenerator.ClassesInitializer();
        System.out.println(sqlGenerator.CourseList);
        System.out.println(sqlGenerator.ClassList);
    }
}
