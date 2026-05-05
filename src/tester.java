import java.io.FileNotFoundException;
import java.util.ArrayList;

public class tester {
    public static void main(String[] args) throws FileNotFoundException {
        SqlGenerator sqlGenerator = new SqlGenerator();
        sqlGenerator.ClassesInitializer();
        ArrayList<Roster> rosters = new ArrayList<>();
        for (Student student : SqlGenerator.StudentList) {
            Roster roster = new Roster(student);
            rosters.add(roster);
        }
        for (Roster roster : rosters) {
            System.out.println(roster);
        }
        /*
        sqlGenerator.RoomInitalizer();
        sqlGenerator.DepartmentsAndTeacherInitalizer();
        sqlGenerator.CourseInitalizer();
        sqlGenerator.ClassesInitializer();

        System.out.println(sqlGenerator.RoomList);
        System.out.println(sqlGenerator.DepartmentList);
        System.out.println(sqlGenerator.TeacherList);
        System.out.println(sqlGenerator.CourseList);
        System.out.println(sqlGenerator.ClassList);

         */
    }
}
