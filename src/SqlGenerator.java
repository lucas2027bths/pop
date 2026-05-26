import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SqlGenerator {

    private ArrayList<Department> departmentList = new ArrayList<>();
    private ArrayList<Teacher> teacherList = new ArrayList<>();
    private ArrayList<Room> roomList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<SchoolClass> classList = new ArrayList<>();
    private ArrayList<Roster> rosterList = new ArrayList<>();
    private ArrayList<Assignment> assignmentList = new ArrayList<>();
    public static String directory = "src/";

    public SqlGenerator() throws FileNotFoundException {

        roomList = Room.createRooms();
        departmentList = Department.createDepartments();
        teacherList = Teacher.createTeachers(departmentList);
        courseList = Course.createCourses();
        classList = SchoolClass.createClasses(courseList,roomList,teacherList);
        studentList = Student.createStudents();
        rosterList = Roster.createRosters(studentList,classList);
        assignmentList = Assignment.createAssignmentList(classList);

    }

    public ArrayList<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public ArrayList<Roster> getRosterList() {
        return rosterList;
    }

    public ArrayList<SchoolClass> getClassList() {
        return classList;
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}