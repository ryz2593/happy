package com.ryz2593.happy.builder_pattern.step5;

import com.ryz2593.happy.builder_pattern.step1.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryz2593
 * @date 2019/8/12
 * @desc
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
