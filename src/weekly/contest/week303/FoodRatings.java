package weekly.contest.week303;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.*;

public class FoodRatings {
//不会是堆吧。。。不过没有新增食物还好
    //<"korean", {"kimchi","paocai"}>
    Map<String, List<String>> typeToFood;
    //<"kimchi",90>
    Map<String, Integer> foodToScore;
    Map<String, String> foodToType;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToScore = new HashMap<>();
        typeToFood = new HashMap<>();
        foodToType = new HashMap<>();
        for(int i = 0;i< ratings.length;i++){
            foodToType.put(foods[i], cuisines[i]);
            foodToScore.put(foods[i], ratings[i]);
            List<String> food = typeToFood.getOrDefault(cuisines[i], null);
            if(food == null){
                food = new ArrayList<>();
            }
            food.add(foods[i]);
            typeToFood.put(cuisines[i], food);
        }

    }

    public void changeRating(String food, int newRating) {
        foodToScore.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        List<String> list = typeToFood.get(cuisine);
        int max = -1;
        List<String> maxName = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            if(foodToScore.get(list.get(i)) > max){
                max = foodToScore.get(list.get(i));
                maxName.clear();
                maxName.add(list.get(i));
            }else if(foodToScore.get(list.get(i)) == max){
                maxName.add(list.get(i));
            }
        }
        maxName.sort(Comparator.naturalOrder());
        return maxName.get(0);
    }
}
