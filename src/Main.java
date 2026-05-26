import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        setLocationAndSchema();
        SqlGenerator generator = new SqlGenerator();
        printInserts(generator);
    }

    private static void setLocationAndSchema() throws FileNotFoundException { // adjusts for operating system and username
        String osName = getOperating();
        if (osName.equals("Linux")) {
            String username = System.getProperty("user.name");
            SqlGenerator.directory = "/home/" + username + "/pop/src/"; //set the location for files differently if on unix server
            System.out.println(createSchema()); //add the create schema if being ran on the server
        }
    }

    private static String getOperating(){
        return System.getProperty("os.name");
    }

    private static void printInserts(SqlGenerator generator) {
        generator.getRoomList().forEach(System.out::println);
        System.out.println(Course.insertTypes());
        System.out.println(Assignment.insertTypes());
        generator.getDepartmentList().forEach(System.out::println);
        generator.getCourseList().forEach(System.out::println);
        generator.getTeacherList().forEach(System.out::println);
        generator.getClassList().forEach(System.out::println);
        generator.getRosterList().forEach(System.out::println);
        generator.getStudentList().forEach(System.out::println);
        generator.getAssignmentList().forEach(System.out::println);
        SchoolClass.createAndPrintGrades(generator.getStudentList(),generator.getAssignmentList());
    }

    private static String createSchema() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(SqlGenerator.directory + "createSchema"));
        String schema = "";

        while (scan.hasNextLine()){

            schema += scan.nextLine();

        }

        return schema;

    }
}