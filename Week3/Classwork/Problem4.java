import java.util.*;
public class Problem4 {
    public static void main(String[] args) {
        int num1, num2, remainder;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number 1: ");
        num1 = sc.nextInt();
        System.out.print("Enter Number 2: ");
        num2 = sc.nextInt();
        while (num2!=0) {
            remainder = num1%num2;
            num1 = num2;
            num2 = remainder;
        }
        System.out.println("GCD of the Numbers: " + num1);
    }
}