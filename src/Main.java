import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        setLocationAndSchema();
        //initialize all the arrayLists / data
        SqlGenerator generator = new SqlGenerator();
//        generator.roomInitializer();
//        generator.departmentsAndTeacherInitializer();
//        generator.courseInitializer();
//        generator.classesInitializer();
//        generator.studentInitializer();
//        generator.rosterInitializer();
//        printInserts(generator);
//        generator.GradeInitializer();
    }
    private static void setLocationAndSchema() { // adjusts for operating system and username
        String osName = getOperating();
        if (osName.equals("Linux")) {
            String username = System.getProperty("user.name");
            SqlGenerator.location = "/home/" + username + "/pop/src/"; //set the location for files differently if on unix server
            System.out.println(createSchema()); //add the create schema if being ran on the server
        }
    }

    private static String getOperating(){
        return System.getProperty("os.name");
    }

    private static void printInserts(SqlGenerator generator) {
        generator.RoomList.forEach(System.out::println); // for each alot cleaner than 1 billion for loops
        System.out.println(Course.insertTypes());
        System.out.println(Assignment.insertTypes());
        generator.DepartmentList.forEach(System.out::println);
        generator.CourseList.forEach(System.out::println);
        generator.TeacherList.forEach(System.out::println);
        generator.ClassList.forEach(System.out::println);
        generator.RosterList.forEach(System.out::println);
        generator.StudentList.forEach(System.out::println);
    }

    private static String createSchema() {
        file
    }
}