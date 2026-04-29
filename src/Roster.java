import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Roster {
    private static int ID;
    private LinkedHashSet<Class> Classes;
    private Student student;

    public Roster(ArrayList<Class> ClassList) {
        Classes = new LinkedHashSet<>();
        while (Classes.size() < 10) {
            Classes.add(ClassList.get( (int) (Math.random() * ClassList.size()) ));
        }

        ArrayList<Class> ClassArrayList = new ArrayList<>(Classes);

        for (int i = 1; i < Classes.size(); i++) {
            Class temp = ClassArrayList.get(i);
            int j = i;

            while ( j > 0 && temp.getPeriod() < ClassArrayList.get(j - 1).getPeriod() ) {
                ClassArrayList.set(j, ClassArrayList.get(j - 1));
                j--;
            }
            ClassArrayList.set(j, temp);
        }

        Classes = new LinkedHashSet<>(ClassArrayList);

        ID++;

    }


}

