import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        getOperatingAndDoStuff();

        SqlGenerator generator = new SqlGenerator();
        generator.roomInitalizer();
        generator.departmentsAndTeacherInitalizer();
        generator.courseInitalizer();
        generator.classesInitializer();
        generator.studentInitalizer();
        generator.rosterInitializer();
        printInserts(generator);
        generator.GradeInitializer();
    }
    private static void getOperatingAndDoStuff() {
        String osName = System.getProperty("os.name");
        if (osName.equals("Linux")) {
            String username = System.getProperty("user.name");
            SqlGenerator.location = "/home/" + username + "/pop/src/";
            System.out.println("USE " + username + "_db;");
            System.out.println(createSchema());
        }
    }
    private static void printInserts(SqlGenerator generator) {
        generator.RoomList.forEach(System.out::println); // for each alot cleaner than 1 billion for loops
        System.out.println(CourseTypes.insertTypes());
        System.out.println(AssignmentType.getType());
        generator.DepartmentList.forEach(System.out::println);
        generator.CourseList.forEach(System.out::println);
        generator.TeacherList.forEach(System.out::println);
        generator.ClassList.forEach(System.out::println);
        generator.RosterList.forEach(System.out::println);
        generator.StudentList.forEach(System.out::println);
    }

    private static String createSchema() {
        return """
            CREATE TABLE Rooms (
                roomID   int PRIMARY KEY AUTO_INCREMENT,
                location varchar(5)
            );

            CREATE TABLE CourseTypes (
                course_typeID int PRIMARY KEY AUTO_INCREMENT,
                course_type   varchar(255)
            );

            CREATE TABLE AssignmentTypes (
                assignment_typeID int PRIMARY KEY AUTO_INCREMENT,
                assignment_type   varchar(255)
            );

            CREATE TABLE Departments (
                departmentID    int PRIMARY KEY AUTO_INCREMENT,
                department_name varchar(255)
            );

            CREATE TABLE Courses (
                courseID      int PRIMARY KEY AUTO_INCREMENT,
                course_name   varchar(255),
                course_typeID int,
                CONSTRAINT fk_course_typeID
                    FOREIGN KEY (course_typeID) REFERENCES CourseTypes(course_typeID)
            );

            CREATE TABLE Teachers (
                teacherID    int PRIMARY KEY AUTO_INCREMENT,
                first_name   varchar(255),
                last_name    varchar(255),
                departmentID int,
                CONSTRAINT fk_departmentID
                    FOREIGN KEY (departmentID) REFERENCES Departments(departmentID)
            );

            CREATE TABLE Classes (
                classID   int PRIMARY KEY AUTO_INCREMENT,
                roomID    int,
                teacherID int,
                courseID  int,
                period    int,
                CONSTRAINT fk_roomID    FOREIGN KEY (roomID)    REFERENCES Rooms(roomID),
                CONSTRAINT fk_teacherID FOREIGN KEY (teacherID) REFERENCES Teachers(teacherID),
                CONSTRAINT fk_courseID  FOREIGN KEY (courseID)  REFERENCES Courses(courseID)
            );

            CREATE TABLE Rosters (
                rosterID        int PRIMARY KEY AUTO_INCREMENT,
                period1_ClassID  int,
                period2_ClassID  int,
                period3_ClassID  int,
                period4_ClassID  int,
                period5_ClassID  int,
                period6_ClassID  int,
                period7_ClassID  int,
                period8_ClassID  int,
                period9_ClassID  int,
                period10_ClassID int,
                CONSTRAINT fk_p1  FOREIGN KEY (period1_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p2  FOREIGN KEY (period2_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p3  FOREIGN KEY (period3_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p4  FOREIGN KEY (period4_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p5  FOREIGN KEY (period5_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p6  FOREIGN KEY (period6_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p7  FOREIGN KEY (period7_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p8  FOREIGN KEY (period8_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p9  FOREIGN KEY (period9_ClassID)  REFERENCES Classes(classID),
                CONSTRAINT fk_p10 FOREIGN KEY (period10_ClassID) REFERENCES Classes(classID)
            );

            CREATE TABLE Students (
                studentID  int PRIMARY KEY AUTO_INCREMENT,
                first_name varchar(255),
                last_name  varchar(255),
                rosterID   int,
                CONSTRAINT fk_rosterID
                    FOREIGN KEY (rosterID) REFERENCES Rosters(rosterID)
            );

            CREATE TABLE Assignments (
                assignmentID      int PRIMARY KEY AUTO_INCREMENT,
                assignmentName    varchar(255),
                assignment_typeID int,
                classID           int,
                CONSTRAINT fk_classID
                    FOREIGN KEY (classID) REFERENCES Classes(classID),
                CONSTRAINT fk_assignment_typeID
                    FOREIGN KEY (assignment_typeID) REFERENCES AssignmentTypes(assignment_typeID)
            );

            CREATE TABLE Grades (
                Grade        int,
                studentID    int,
                assignmentID int,
                CONSTRAINT fk_assignmentID
                    FOREIGN KEY (assignmentID) REFERENCES Assignments(assignmentID),
                CONSTRAINT fk_studentID
                    FOREIGN KEY (studentID) REFERENCES Students(studentID)
            );
            """;
    }
}