import zhevlakov.LinkedList;
import java.util.Arrays;

/**
 * Created by zhevlakov on 12.06.17.
 */
public class Program {
    public static void main(String[] args) {

        LinkedList<Long> list = new LinkedList<Long>();
        list.add(12L);
        list.add(15L);
        list.add(11L);
        list.add(17L);
        list.add(12L);
        System.out.println(Arrays.toString(list.toArray()));
        list.removeTail();
        System.out.println(Arrays.toString(list.toArray()));
        list.removeGreatThan(12L);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
