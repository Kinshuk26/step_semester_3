import java.util.*;
    class Payment{
        double amount;
        double calculate(){
            System.out.println("Payment Completed.");
            return amount;
        }
    }
    class Card extends Payment{
        Card(double amount){
            this.amount = amount;
            }
        double calculate(){
            amount += (amount*0.02);
            System.out.println("CARD: " + amount);
            return amount;
        }
    }
    class Wallet extends Payment{
        Wallet(double amount){
            this.amount = amount;
        }
        double calculate(){
            amount += (amount *0.01);
            System.out.printf("WALLET: %.2f%n",amount);
            return amount;
        }
    }
    class Bank extends Payment{
        Bank(double amount){
            this.amount = amount;
        }
        double calculate(){
            System.out.printf("BANKTRANSFER: %.2f%n",amount);
            return amount;
        }
    }
public class Problem1{
    public static void main(String[] args) {
        Payment w1 = new Wallet(500.00);
        Payment c1 = new Card(1000.00);
        Payment b1 = new Bank(2000.00);
        double total = 0.0;
        total += c1.calculate();
        total += w1.calculate();
        total += b1.calculate();
        System.out.printf("Total: %.2f%n ",total);
    }
}