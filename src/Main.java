import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr; // int arr[]
        arr = new int[5];
        int[] arr2 = {1, 2, 3, 4};

        Array a0 = new Array(1, -2, -3, -4, 5, -5, 11, 4, 22, -9, 0);
        a0.sortBubble();

        a0.deleteIndex(2);
        System.out.println(a0);
    }
}