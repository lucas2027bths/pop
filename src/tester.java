import java.io.FileNotFoundException;

public class tester {
    public static void main(String[] args) throws FileNotFoundException {

        String osName = System.getProperty("os.name");
        if (osName.equals("Linux")){
            String username = System.getProperty("user.name");
           SqlGenerator.location = "/home/" + username + "/pop/src/";
        }
        SqlGenerator generator = new SqlGenerator();
        generator.roomInitalizer();
        generator.departmentsAndTeacherInitalizer();
        generator.courseInitalizer();
        generator.classesInitializer();
        generator.studentInitalizer();
        generator.rosterInitializer();

        for (Room each : generator.RoomList){
            System.out.println(each);
        }
        System.out.println(CourseTypes.insertTypes());
        System.out.println(AssignmentType.getType());
        for (Department each : generator.DepartmentList){
            System.out.println(each);
        }
        for (Course each : generator.CourseList){
            System.out.println(each);
        }
        for (Teacher each : generator.TeacherList){
            System.out.println(each);
        }
        for (SchoolClass each : generator.ClassList){
            System.out.println(each);
        }
        for (Roster each : generator.RosterList){
            System.out.println(each);
        }
        for (Student each : generator.StudentList){
            System.out.println(each);
        }
        generator.GradeInitializer();


//        generator.GradeInitializer();
//        System.out.println(sqlGenerator.RoomList);
//        System.out.println(sqlGenerator.DepartmentList);
//        System.out.println(sqlGenerator.TeacherList);
//        System.out.println(sqlGenerator.CourseList);
//        System.out.println(sqlGenerator.ClassList);


    }
}
