package daily.ongoing.finished;

import java.util.*;

public class StockPrice_2034 {

    int maxTimestamp;
    Map<Integer, Integer> prices;
    TreeMap<Integer,Integer> priceTimes;
    public StockPrice_2034() {
        maxTimestamp = Integer.MIN_VALUE;
        prices = new HashMap<>();
        priceTimes = new TreeMap<>();

    }

    public void update(int timestamp, int price) {
        int oldPrice = prices.getOrDefault(timestamp,0);
        prices.put(timestamp, price);
        maxTimestamp = Math.max(timestamp,maxTimestamp);

        if(oldPrice>0) {
            priceTimes.put(price, priceTimes.get(price) - 1);
            if(priceTimes.get(price)==0){
                priceTimes.remove(price);
            }
        }
        priceTimes.put(price,priceTimes.getOrDefault(price,0)+1);


    }

    public int current() {
        return prices.get(maxTimestamp);
    }

    public int maximum() {
        return priceTimes.lastKey();
    }

    public int minimum() {
        return priceTimes.firstKey();

    }
}