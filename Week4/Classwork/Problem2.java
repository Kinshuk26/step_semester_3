import java.util.*;
public class Problem2 {
    static int maxProfit(int[] prices){
        int lowest = prices[0];
        int lindex = 0;
        int profit = 0;
        int pindex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
            lowest = prices[i];
            lindex = i;
            }
            int currentProfit = prices[i] - lowest;
            if (currentProfit > profit) {
                profit = currentProfit;
                pindex = i;
            }
        }
        if (profit == 0){
            System.out.println("0 (prices only fall ,so no trade is possible)");
        }
        else{
            System.out.println(profit + " (Buy on Day " + (lindex + 1) + " at price " + prices[lindex] + ", sell on day " + (pindex + 1)+ " at price " + prices[pindex] + ")");
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.print("Enter Array Size: ");
        size =sc.nextInt();
        int[] prices = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Element[" + i + "]: ");
            prices[i] = sc.nextInt();
        }
        maxProfit(prices);
        sc.close();
    }
}