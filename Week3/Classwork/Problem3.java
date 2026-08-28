import java.util.*;
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int origNum, temp, revnum = 0, digit;
        System.out.print("Enter a Number: ");
        origNum = sc.nextInt();
        temp = origNum;
        while (origNum > 0) {
            digit = origNum%10;
            revnum = (revnum*10)+digit;
            origNum /= 10;
        }
        System.out.println((revnum==temp)?"Number is a Palindrome": "Number is not a palindrome");
    }
}
