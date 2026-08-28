import java.util.*;
public class Problem1{
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int num;
        boolean NotPrime = false;
        System.out.print("Enter number: ");
        num = sc.nextInt();
        for (int i = 2; i < num; i++){
            if (num%i == 0){
                NotPrime = true;
                break;
            }
        }
        System.out.println((NotPrime || num<2)?"The Number is a not prime number.":"The number is a prime number");
    }
}