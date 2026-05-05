import java.io.FileNotFoundException;

public class tester {
    public static void main(String[] args) throws FileNotFoundException {
        SqlGenerator sqlGenerator = new SqlGenerator();

        sqlGenerator.RoomInitalizer();
        sqlGenerator.DepartmentsAndTeacherInitalizer();
        sqlGenerator.CourseInitalizer();
        sqlGenerator.ClassesInitializer();

        System.out.println(sqlGenerator.RoomList);
        System.out.println(sqlGenerator.DepartmentList);
        System.out.println(sqlGenerator.TeacherList);
        System.out.println(sqlGenerator.CourseList);
        System.out.println(sqlGenerator.ClassList);
    }
}
