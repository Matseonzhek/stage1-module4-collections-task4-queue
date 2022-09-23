package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public static void main(String[] args) {
        List<Integer> foPrinting = new DishOrderDeterminer().determineDishOrder(11, 4);
        System.out.println(foPrinting);
    }

    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishArray = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
//        List<Integer> result = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < numberOfDishes + 1; i++) {
            queue.offer(i);
        }


        int dishToEatIndex = 1;

        while (!queue.isEmpty()) {
            if (dishToEatIndex % everyDishNumberToEat != 0) {
                queue.offer(queue.poll());
            } else {
                result.add(queue.poll());
            }
            System.out.println(queue);
            dishToEatIndex++;
        }
        return result;
    }
}
