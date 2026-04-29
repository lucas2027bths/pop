public class Assignment {
    private int type;
    private String name;
    private int id;

    public Assignment (int type, int id, String name){
        this.type = type;
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String toString(){
       return "\"INSERT INTO Assignment(Name, Type, ClassID) VALUES" +
                " (" + "'" + name + "'," + type +"," + id + ")\"";
    }
}
