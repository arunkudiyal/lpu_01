import java.util.HashMap;
import java.util.Map;
public class MapCollection {
    public static void main(String[] args) {
        // An object that maps keys to values.
        // A map cannot contain duplicate keys; each key can map to at most one value.
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "Four");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(5, "Five");
        map.put(5, "Six");
        map.put(5, "Seven");
        System.out.println(map);

        // functions
        System.out.println(map.size());                     // 5
        System.out.println("Value of 5 " + map.get(5));     // Seven
        System.out.println(map.containsKey(5));             // true

        System.out.println( map.hashCode() );               // 162924316
    }
}
