package com.ryz2593.happy.builder_pattern.step7;

import com.ryz2593.happy.builder_pattern.step5.Meal;
import com.ryz2593.happy.builder_pattern.step6.MealBuilder;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}
