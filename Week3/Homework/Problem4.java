import java.util.Scanner;
public class Problem4 {
    static void generateFirstValidTable(int[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] < 1) {
                System.out.println("Skipping invalid number: " + candidates[i]);
                continue;
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println(candidates[i] + " x " + j + " = "+ (candidates[i] * j));
            }
            break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        int[] candidates = new int[n];
        System.out.println("Enter candidates:");
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }
        generateFirstValidTable(candidates);
        sc.close();
    }
}