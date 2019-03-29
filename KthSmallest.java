import java.util.*;

public class MyClass {
    public final static int INT_MAX = 1000;
    
    public static int kthSmallest(int[] arr, int k) {
        int start = 0;
        if (arr.length == 1) {
            if (0 == (k - 1)) {
                return arr[0];
            }
            return INT_MAX;
        }
        int end = arr.length - 2;
        int[] new_arr = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[0]) {
                new_arr[start++] = arr[i];
            } else {
                new_arr[end--] = arr[i];
            }
        }
        
        if (start == (k - 1)) {
            return arr[0];
        } else if (start > (k - 1)) {
            return kthSmallest(Arrays.copyOfRange(new_arr, 0, start), k);
        } else {
            return kthSmallest(Arrays.copyOfRange(new_arr, start, arr.length - 1), k - start - 1);
        }
    }
    
    public static void main(String args[]) {
        int[] arr = {2, 7, 1, 12, 3, 15, 6};
        System.out.println("kthSmallest: " + kthSmallest(arr, 7));
    }
}
