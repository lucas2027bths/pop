import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Teacher {
    private int ID;
    private String first;
    private String last;
    private int DEPTID;
    public boolean[] booked; // boolean used to check if a teacher is book for a certain period
    public Teacher(int ID, String first, String last, int DEPTID){
        this.ID = ID;
        this.first = first;
        this.last = last;
        this.DEPTID = DEPTID;
        booked = new boolean[10];
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString(){
        return "INSERT INTO Teachers (ID,first_name,last_name,departmentID) VALUES(" + ID + ",'" + first + "','" + last + "'," + DEPTID + ")";
    }


    public static ArrayList<Teacher> createTeachers(ArrayList<Department> departments){
        ArrayList<Teacher> teacherList = new ArrayList<>();
        Scanner scan = new Scanner(new File(location+"teachers"));
        int id = 1;

        for (int currentDeptIndex = 0; currentDeptIndex < departments.size(); currentDeptIndex++){
            String departmentName = departments.get(currentDeptIndex).getName();
            departments.add(new Department(currentDeptIndex+1,departmentName));

            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                if (name.isEmpty()){
                    continue;
                }
                if (currentDeptIndex + 1 < departments.size() && name.equals(departments.get(currentDeptIndex+1).getName())) {
                    break;
                }
                String[] firstLast = name.split(" ", 2);
                teacherList.add(new Teacher(id, firstLast[0], firstLast[1], currentDeptIndex+1));
                id++;
            }


        }
        Collections.shuffle(teacherList); //randomize
        return teacherList;
    }

}
