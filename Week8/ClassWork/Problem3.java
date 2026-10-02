import java.util.*;
class Delivery{
    double weight;
    double distance;
    double fee;
    double calculate(){
        System.out.println("Delivery");
        return fee;
    }
}
class Standard extends Delivery{
    Standard(double weight, double distance){
        this.weight = weight;
        this.distance = distance;
    }
    double calculate(){
        double amount = 0;
        amount = 5+ (0.50*weight) + (0.10*distance);
        System.out.printf("STANDARD: %.2f%n", amount);
        return amount;
    }
}
class Express extends Delivery{
    Express(double weight, double distance){
        this.weight = weight;
        this.distance = distance;
    }
    double calculate(){
        double amount = 0;
        amount = 15 + weight + (0.20*distance);
        System.out.printf("EXPRESS: %.2f%n", amount);
        return amount;
    }
}
class International extends Delivery{
    International(double weight, double distance, double fee){
        this.weight = weight;
        this.distance = distance;
        this.fee = fee;
    }
    double calculate(){
        double amount = 0;
        amount = 25 + (2*weight) + (0.50*distance) + fee;
        System.out.printf("INTERNATIONAL: %.2f%n", amount);
        return amount;
    }
}
public class Problem3{
    public static void main(String[] args) {
    Delivery d1 = new Standard(10,50);
    Delivery d2 = new Express(5,20);
    Delivery d3 = new International(20,100,30);
    double total = 0;
    total += d1.calculate();
    total += d2.calculate();
    total += d3.calculate();
    System.out.printf("Total: %.2f%n", total );
    }
}