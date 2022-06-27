package com.exercise.feature.lambda;

import java.util.Comparator;
import java.util.function.Function;

public class MethodCall {

    public static void main(String[] args) {
        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("1000"));

        Comparator<Integer> compare = Integer::compare;
        System.out.println(compare.compare(100, 29));
    }
}
