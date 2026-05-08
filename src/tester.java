import java.io.FileNotFoundException;

public class tester {
    public static void main(String[] args) throws FileNotFoundException {

        String osName = System.getProperty("os.name");
        if (osName.equals("Linux")){
            String username = System.getProperty("user.name");
           SqlGenerator.location = "/home/" + username + "/pop/src/";
            System.out.println("USE " + username+"_db;");
//            System.out.println(
//                    "DROP TABLE Grades;\n" +
//                    "\n" +
//                    "DROP TABLE Assignments;\n" +
//                    "\n" +
//                    "DROP TABLE Students;\n" +
//                    "\n" +
//                    "DROP TABLE Rosters;\n" +
//                    "\n" +
//                    "DROP TABLE Classes;\n" +
//                    "\n" +
//                    "DROP TABLE Teachers;\n" +
//                    "\n" +
//                    "DROP TABLE Courses;\n" +
//                    "\n" +
//                    "DROP TABLE Departments;\n" +
//                    "\n" +
//                    "DROP TABLE AssignmentTypes;\n" +
//                    "\n" +
//                    "DROP TABLE CourseTypes;\n" +
//                    "\n" +
//                    "DROP TABLE Rooms;\n");
            System.out.println("CREATE TABLE Rooms (\n" +
                    "        roomID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        location varchar(5)\n" +
                    ");\n" +
                    "CREATE TABLE CourseTypes (\n" +
                    "        course_typeID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        course_type varchar(255)\n" +
                    ");\n" +
                    "CREATE TABLE AssignmentTypes (\n" +
                    "        assignment_typeID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        assignment_type varchar(255)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE Departments (\n" +
                    "        departmentID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        department_name varchar(255)\n" +
                    ");\n" +
                    "CREATE TABLE Courses (\n" +
                    "        courseID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        course_name varchar(255),\n" +
                    "        course_typeID int,\n" +
                    "        CONSTRAINT fk_course_typeID\n" +
                    "        FOREIGN KEY (course_typeID)\n" +
                    "        REFERENCES CourseTypes(course_typeID)\n" +
                    ");\n" +
                    "CREATE TABLE Teachers (\n" +
                    "        teacherID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        first_name varchar(255),\n" +
                    "        last_name varchar(255),\n" +
                    "        departmentID int,\n" +
                    "        CONSTRAINT fk_departmentID\n" +
                    "        FOREIGN KEY (departmentID)\n" +
                    "        REFERENCES Departments(departmentID)\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE Classes(\n" +
                    "        classID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        roomID int,\n" +
                    "        teacherID int,\n" +
                    "        courseID int,\n" +
                    "        period int,\n" +
                    "        CONSTRAINT fk_roomID\n" +
                    "        FOREIGN KEY (roomID)\n" +
                    "        REFERENCES Rooms(roomID),\n" +
                    "        CONSTRAINT fk_teacherID\n" +
                    "        FOREIGN KEY (teacherID)\n" +
                    "        REFERENCES Teachers(teacherID),\n" +
                    "        CONSTRAINT fk_courseID\n" +
                    "        FOREIGN KEY (courseID)\n" +
                    "        REFERENCES Courses(courseID)\n" +
                    "\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE Rosters (\n" +
                    "        rosterID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        period1_ClassID int,\n" +
                    "        period2_ClassID int,\n" +
                    "        period3_ClassID int,\n" +
                    "        period4_ClassID int,\n" +
                    "        period5_ClassID int,\n" +
                    "        period6_ClassID int,\n" +
                    "        period7_ClassID int,\n" +
                    "        period8_ClassID int,\n" +
                    "        period9_ClassID int,\n" +
                    "        period10_ClassID int,\n" +
                    "        CONSTRAINT fk_p1 FOREIGN KEY (period1_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p2 FOREIGN KEY (period2_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p3 FOREIGN KEY (period3_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p4 FOREIGN KEY (period4_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p5 FOREIGN KEY (period5_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p6 FOREIGN KEY (period6_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p7 FOREIGN KEY (period7_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p8 FOREIGN KEY (period8_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p9 FOREIGN KEY (period9_ClassID) REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_p10 FOREIGN KEY (period10_ClassID) REFERENCES Classes(classID)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE Students (\n" +
                    "        studentID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        first_name varchar(255),\n" +
                    "        last_name varchar(255),\n" +
                    "        rosterID int,\n" +
                    "        CONSTRAINT fk_rosterID\n" +
                    "        FOREIGN KEY (rosterID)\n" +
                    "        REFERENCES Rosters(rosterID)\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE Assignments (\n" +
                    "        assignmentID int PRIMARY KEY AUTO_INCREMENT,\n" +
                    "        assignmentName varchar(255),\n" +
                    "        assignment_typeID int,\n" +
                    "        classID int,\n" +
                    "        CONSTRAINT fk_classID\n" +
                    "        FOREIGN KEY (ClassID)\n" +
                    "        REFERENCES Classes(classID),\n" +
                    "        CONSTRAINT fk_assignment_typeID\n" +
                    "        FOREIGN KEY (assignment_typeIqD)\n" +
                    "        REFERENCES AssignmentTypes(assignment_typeID)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE Grades (\n" +
                    "        Grade int,\n" +
                    "        studentID int,\n" +
                    "        assignmentID int,\n" +
                    "        CONSTRAINT fk_assignmentID\n" +
                    "        FOREIGN KEY (assignmentID)\n" +
                    "        REFERENCES Assignments(assignmentID),\n" +
                    "        CONSTRAINT fk_studentID\n" +
                    "        FOREIGN KEY (studentID)\n" +
                    "        REFERENCES Students(studentID)\n" +
                    ");");
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
