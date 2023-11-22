import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //Creating a Boat[] array
        Boat[] boats = {new Boat("Liberty", 13, 5500, 12, true),
                        new Boat("Casablanca", 9, 2000, 6, false),
                        new Boat("Dream", 15, 3700, 8, true) };

        Comparator<Boat> cmpr1 = Comparator.comparing(Boat::getMass);   //Comparator, with a sorting by mass criteria
        Comparator<Boat> cmpr2 = Comparator.comparing(Boat::getLength); //Comparator, with a sorting by length criteria

        System.out.println("==Ascending order, mass==");
        Boat[] arr1 = ArrayUtility.sortAsc(boats, cmpr1);
        ArrayUtility.printArray(arr1);

        System.out.println("==Descending order, length==");
        Boat[] arr2 = ArrayUtility.sortDesc(boats, cmpr2);
        ArrayUtility.printArray(arr2);
    }
}