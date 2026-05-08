public class CourseTypes {
    public static String insertTypes (){
        return "INSERT INTO CourseTypes VALUES(1,'Regents');\n" +
                "INSERT INTO CourseTypes VALUES(2,'AP');\n" +
                "INSERT INTO CourseTypes VALUES(3,'Elective');";
    }
}
