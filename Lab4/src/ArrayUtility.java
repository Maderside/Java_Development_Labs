import java.util.Arrays;
import java.util.Comparator;

/**
 * Uitility class that is used to sort an array of Boat class in ascending and descending order and to print the array
 */
public class ArrayUtility {

    /**
     * Sorts a Boat[] array in ascending order
     * @param arr Default array of Boat instances
     * @param cmp Comparator, defines sorting criteria
     * @return
     */
    public static Boat[] sortAsc(Boat[] arr, Comparator<Boat> cmp){
        Arrays.sort(arr, cmp);

        return arr;
    }

    /**
     * Sorts a Boat[] array in descending order
     * @param arr Default array of Boat instances
     * @param cmp Comparator, defines sorting criteria
     * @return
     */
    public static Boat[] sortDesc(Boat[] arr, Comparator<Boat> cmp){
        Arrays.sort(arr, cmp.reversed());

        return arr;
    }

    /**
     * Prints an array in one column
     * @param arr Default array of Boat instances
     */
    public static void printArray(Boat[] arr){
        for (Boat boat : arr) {
            System.out.println(boat.toString());
        }
    }
}
