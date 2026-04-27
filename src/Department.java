public class Department {
    private int ID;
    private String name;

    public Department(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString(){
        return "INSERT INTO Departments VALUES ("+ID+",'" + name +"');";
    }

}
