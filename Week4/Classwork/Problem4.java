import java.util.*;
public class Problem4 {
    static int[] mergeSortedArrays(int[] arr1, int[] arr2){
        int i = 0, j = 0, k = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        while ( (i < arr1.length && j < arr2.length)) {
            if (arr1[i] > arr2[j]){
                arr3[k++] = arr2[j++];
            }
            else{
                arr3[k++] = arr1[i++];
            }
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array1 Size: ");
        int size1 = sc.nextInt();
        System.out.print("Enter Array2 Size: ");
        int size2 = sc.nextInt();
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        for(int i = 0; i < size1; i++){
            System.out.print("Element[" + i + "]: ");
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < size2; i++){
            System.out.print("Element[" + i + "]: ");
            arr2[i] = sc.nextInt();
        }
        int[] arr3 = new int[size1 + size2];
        arr3 =mergeSortedArrays(arr1, arr2);
        for (int i = 0; i < size1+size2; i++){
            System.out.print(arr3[i] + " ");
        }
        sc.close();
    }
}
