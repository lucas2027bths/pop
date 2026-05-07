import java.io.FileNotFoundException;

public class tester {
    public static void main(String[] args) throws FileNotFoundException {
        SqlGenerator generator = new SqlGenerator();
        generator.roomInitalizer();
        generator.departmentsAndTeacherInitalizer();
        generator.courseInitalizer();
        generator.classesInitializer();
        generator.studentInitalizer();
        generator.rosterInitializer();

        System.out.println(generator.RoomList);
        System.out.println(generator.DepartmentList);
        System.out.println(generator.CourseList);
        System.out.println(generator.TeacherList);
        System.out.println(generator.ClassList);
        System.out.println(generator.RosterList);
        System.out.println(generator.StudentList);
        generator.GradeInitializer();


//        generator.GradeInitializer();
//        System.out.println(sqlGenerator.RoomList);
//        System.out.println(sqlGenerator.DepartmentList);
//        System.out.println(sqlGenerator.TeacherList);
//        System.out.println(sqlGenerator.CourseList);
//        System.out.println(sqlGenerator.ClassList);


    }
}
