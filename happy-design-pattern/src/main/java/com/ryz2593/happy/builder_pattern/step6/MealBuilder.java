package com.ryz2593.happy.builder_pattern.step6;

import com.ryz2593.happy.builder_pattern.step4.ChickenBurger;
import com.ryz2593.happy.builder_pattern.step4.Coke;
import com.ryz2593.happy.builder_pattern.step4.Pepsi;
import com.ryz2593.happy.builder_pattern.step4.VegBurger;
import com.ryz2593.happy.builder_pattern.step5.Meal;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
