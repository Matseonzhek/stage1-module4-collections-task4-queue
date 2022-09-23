package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public static void main(String[] args) {
        Queue<Integer> first = new LinkedList<>(List.of(1, 3, 5, 4, 7, 9));
        Queue<Integer> second = new LinkedList<>(List.of(4, 2, 8, 5, 8, 3));
        System.out.println(new ArrayDequeCreator().createArrayDeque(first, second));

    }

    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {

        ArrayDeque<Integer> result = new ArrayDeque<>();
        ArrayDeque<Integer> firstPlayer = new ArrayDeque<>(firstQueue);
        ArrayDeque<Integer> secondPlayer = new ArrayDeque<>(secondQueue);

        result.offer(Objects.requireNonNull(firstPlayer.poll()));
        result.offer(Objects.requireNonNull(firstPlayer.poll()));

        result.offer(Objects.requireNonNull(secondPlayer.poll()));
        result.offer(Objects.requireNonNull(secondPlayer.poll()));

            while (!firstPlayer.isEmpty() ) {

            firstPlayer.offer(Objects.requireNonNull(result.removeLast()));
            result.offer(Objects.requireNonNull(firstPlayer.remove()));
            result.offer(Objects.requireNonNull(firstPlayer.remove()));

            secondPlayer.offer(Objects.requireNonNull(result.removeLast()));
            result.offer(Objects.requireNonNull(secondPlayer.remove()));
            result.offer(Objects.requireNonNull(secondPlayer.remove()));
        }
        return result;
    }
}
