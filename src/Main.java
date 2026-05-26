import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        System.out.println(Room.header());
        printObjects(generator.getRoomList());

       System.out.println(Course.insertTypes());
       System.out.println(Assignment.insertTypes());

        System.out.println(Department.header());
        printObjects(generator.getDepartmentList());
//
//        System.out.println(Course.header());
//        printObjects(generator.getCourseList());
//
//        System.out.println(Teacher.header());
//        printObjects(generator.getTeacherList());
//
//
//        System.out.println(SchoolClass.header());
//        printObjects(generator.getClassList());
//
//        System.out.println(Roster.header());
//        printObjects(generator.getRosterList());
//
//        System.out.println(Student.header());
//        printObjects(generator.getStudentList());
//
//        System.out.println(Assignment.header());
//        printObjects(generator.getAssignmentList());
//
//       SchoolClass.createAndPrintGrades(generator.getStudentList(),generator.getAssignmentList());
    }


    private static void printObjects(ArrayList<?> objectArrayList){
        int size = objectArrayList.size();
        for (int x = 0 ; x < size-1; x++){
            System.out.println(objectArrayList.get(x).toString());
        }
        String last = objectArrayList.get(size-1).toString();
        System.out.println(last.substring(0,last.length()-1) + ";");
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