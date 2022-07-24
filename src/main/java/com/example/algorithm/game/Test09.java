package com.example.algorithm.game;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description : TODO
 * @Author : young
 * @Date : 2022-07-24 11:39
 * @Version : 1.0
 **/
public class Test09 {
    private HashMap<String, Integer> nameScoreMap = new HashMap<>();
    private HashMap<String, LinkedList<String>> cuisineNameList = new HashMap<>();

    public Test09(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            nameScoreMap.put(foods[i], ratings[i]);
            LinkedList<String> list;
            if (cuisineNameList.containsKey(cuisines[i])) {
                list = new LinkedList<>();
            } else {
                list = cuisineNameList.get(cuisines[i]);
            }
            list.addFirst(foods[i]);
            cuisineNameList.put(cuisines[i], list);
        }
    }

    public void changeRating(String food, int newRating) {
        nameScoreMap.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        LinkedList<String> linkedList = cuisineNameList.get(cuisine);

        int max = Integer.MIN_VALUE;
        String maxFood = "";
        for (int i = 0; i < linkedList.size(); i++) {
            String foodName = linkedList.get(i);
            int score = nameScoreMap.get(foodName);
            if (score > max) {
                max = score;
                maxFood = foodName;
            }
        }

        return maxFood;
    }
}
