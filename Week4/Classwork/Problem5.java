import java.util.*;
public class Problem5 {
    static int[] rotateArray(int[] nums, int k){
        k %= nums.length;
        int[] arr3 = new int[nums.length];
        for(int i =0; i < nums.length; i++){
            arr3[(i+k)%nums.length] = nums[i];
        }
        return arr3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size, k;
        System.out.print("Enter Array Size: ");
        size = sc.nextInt();
        int[] arr1 = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Element[" + i + "]: ");
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter number of Rotations: ");
        k = sc.nextInt();
        int[] arr3 = rotateArray(arr1, k);
        for (int i = 0; i < size; i++){
            System.out.print(arr3[i]+ " ");
        }
        sc.close();
    }
}