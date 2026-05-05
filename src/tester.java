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
        for (Student stud : generator.StudentList){
            System.out.println(stud.getRoster());
        }


//        System.out.println(sqlGenerator.RoomList);
//        System.out.println(sqlGenerator.DepartmentList);
//        System.out.println(sqlGenerator.TeacherList);
//        System.out.println(sqlGenerator.CourseList);
//        System.out.println(sqlGenerator.ClassList);


    }
}
