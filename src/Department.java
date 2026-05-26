import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    private int ID;
    private String name;

    public Department(int ID, String name){
        this.ID = ID;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "INSERT INTO Departments VALUES ("+ID+",'" + name +"');";
    }

    public static ArrayList<Department> createDepartments() throws FileNotFoundException {

        ArrayList<Department> departmentList = new ArrayList<>();

        Scanner scan = new Scanner(new File(SqlGenerator.directory +"departments"));
        int id = 1;

        while (scan.hasNextLine()) {
            String name = scan.nextLine();
            if (name.isEmpty()){
                continue;
            }
            departmentList.add(new Department(id,name));
            id++;
        }
    return departmentList;

    }

}
