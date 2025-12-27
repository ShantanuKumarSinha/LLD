package introToOops;

import java.util.ArrayList;
import java.util.List;

public class CallByValueProofInJava {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        var newList = new ArrayList<>(list);
        Integer x = Integer.valueOf(5);
        // list only holds the value
        newList.add(x);
        System.out.println(newList);
        newList.add(4);
        //changing of the value won't have any impact in list
        x = 24;
        System.out.println(newList);
    }
}
