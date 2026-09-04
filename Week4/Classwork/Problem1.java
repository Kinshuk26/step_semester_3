import java.util.*;
public class Problem1{
    static int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target, size;
        System.out.print("Enter Size of Array: ");
        size = sc.nextInt();
        System.out.print("Enter Target Value: ");
        target = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < nums.length; i++){
            System.out.print("Elemet[" + i + "]: ");
            nums[i] = sc.nextInt();
        }
        int[] answer = twoSum(nums, target);
        System.out.println("[" + answer[0] + ", "+answer[1]+"] (nums["+answer[0]+"] + nums["+answer[1]+"] = " + nums[answer[0]] + " + " + nums[answer[1]] + " = " + target + ")");
    }
}