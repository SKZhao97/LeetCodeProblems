
public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int change = numBottles / numExchange;
        int left = numBottles % numExchange;
        while(numBottles / numExchange != 0) {
            numBottles = change + left;
            res += change;
            left += change;
            change = left / numExchange;
            left = left % numExchange;
        }
        return res;
    }

    public static void main(String[] args) {
        WaterBottles waterBottles = new WaterBottles();
        int numBottles = 2;
        int numExchange = 3;
        System.out.println(waterBottles.numWaterBottles(numBottles, numExchange));
    }
}
