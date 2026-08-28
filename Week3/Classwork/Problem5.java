import java.util.*;
public class Problem5 {
    public static void main(String[] args) {
        int num, sum = 0, temp, digit;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        num = sc.nextInt();, m
        temp = num;
        while (num > 0){
            digit = num%10;
            sum += (digit*digit*digit);
            num /= 10;
        }
        System.out.println((temp==sum)?"The number is an Armstrong Number": "The number is not an Armstrong Number");
    }
}