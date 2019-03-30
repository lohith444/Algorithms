import java.io.*;
import java.util.*;

class Solution {
  public static int kthSmallest(int[] arr, int k) {
    if (arr.length <= 1) {
      return (k == 1) && (arr.length == 1) 
        ? arr[0] : Integer.MAX_VALUE;
    }
    
    int start = 0;
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
    }
    return kthSmallest(Arrays.copyOfRange(new_arr, start, arr.length - 1), k - start - 1);
  }
  
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter k: ");
    int k = myObj.nextInt();
    int[] arr = {2, 12, 3, 7, 1, 15, 19, 11};
    System.out.println(k + "th Smallest number: " + kthSmallest(arr, k));
  }
}
