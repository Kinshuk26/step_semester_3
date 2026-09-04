import java.util.*;
public class Problem3 {
    static int value;
    static boolean containsDuplicate (int[] nums){
        boolean duplicate = false;
        for (int  i = 0; i < nums.length - 1; i++){
            for (int j = i+1; j< nums.length; j++){
                if (nums[i] == nums[j]){
                    duplicate = true;
                    value = nums[i];
                    return duplicate;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.print("Enter Array Size: ");
        size = sc.nextInt();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Element[" + i + "]: ");
            nums[i] = sc.nextInt();
        }
        boolean answer = containsDuplicate(nums);
        if(answer) System.out.println("True (The value " + value + " appears at two different positions)");
        else System.out.println("False (Every value is Distinct)");
        sc.close();
    }
}