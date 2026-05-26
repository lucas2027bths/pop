import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    private int id;
    private String name;

    public Department(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "INSERT INTO Departments VALUES ("+ id +",'" + name +"');";
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
