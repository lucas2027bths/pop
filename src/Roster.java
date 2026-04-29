import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Roster {
    private static int ID;
    private LinkedHashSet<Class> Classes;
    private Student student;

    public Roster(LinkedHashSet<Class> Classes) {
        while (Classes.size() < 10) {
            ArrayList<Class> ClassList = SqlGenerator.getClassList();
            Classes.add(ClassList.getLast( Math.random() * ClassList.size() ))
        }
        ArrayList<Class> ClassArrayList = new ArrayList<>(Classes);
        for (int i = 1; i < Classes.size(); i++) {
            Class temp = ClassArrayList.get(i);
            int j = i;

            while ( int j > 0 && temp.getPeriod() < ClassArrayList.get(j - 1).getPeriod() ) {
                ClassArrayList.set(j, ClassArrayList.get(j - 1));
                j--;
            }
            ClassArrayList.set(j, temp);
        }
        Classes = new LinkedHashSet<>(ClassArrayList);
        ID++;

    }


}

