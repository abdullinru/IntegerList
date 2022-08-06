package com.example.integerlist;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
@Service
public class SortedService {
    private Integer[] arr1 = generateRandomArray();
    private Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
    private Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

    @PostConstruct
    public void init() {
        System.out.println("timeOfsortBubble() = " + timeOfsortBubble());
        System.out.println("timeOfsortSelection() = " + timeOfsortSelection());
        System.out.println("timeOfsortInsertion() = " + timeOfsortInsertion());
    }

    private Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[50_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public Long timeOfsortBubble() {
        Long start = System.currentTimeMillis();
        Sortirovka.sortBubble(arr1);
        return System.currentTimeMillis() - start;
    }
    public Long timeOfsortSelection() {
        Long start = System.currentTimeMillis();
        Sortirovka.sortSelection(arr2);
        return System.currentTimeMillis() - start;
    }
    public Long timeOfsortInsertion() {
        Long start = System.currentTimeMillis();
        Sortirovka.sortInsertion(arr3);
        return System.currentTimeMillis() - start;
    }

}
