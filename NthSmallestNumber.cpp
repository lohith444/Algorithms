// Example program
#include <iostream>
#include <string>

int nthSmallest(int* arr, int start, int end, int n) {
    int size = end - start + 1;
    int new_start = start;
    int new_end = end;
    int* new_arr = new int[size - 1];
    
    for (int i = start + 1; i < end; i++) {
        if (arr[i] < arr[start]) {
            new_arr[new_start++] = arr[i];
        } else {
            new_arr[new_end--] = arr[i];
        }
    }
    
    if (new_start == (n - 1)) {
        return arr[start];
    } else if (new_start > (n - 1)) {
        return nthSmallest(new_arr, start, new_start - 1, n - start);
    } else {
        return nthSmallest(new_arr, new_start + 1, end, n - new_start - 1);
    }
}

int main()
{
  int n;
  std::cout << "Enter n" << std::endl;
  std::cin >> n;
  int arr[] = {2, 1, 4, 5, 12, 6, 8};
  std::cout << "nthSmallest: " << nthSmallest(arr, 0, 6, n);
}
