package com.currentbp.designPattern.BuilderPattern;

import com.currentbp.designPattern.baseBean.*;

/**
 * @author baopan
 * @createTime 2020/8/2 13:24
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
