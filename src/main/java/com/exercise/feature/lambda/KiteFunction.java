package com.exercise.feature.lambda;

@FunctionalInterface
public interface KiteFunction<T, R, S> {

    R run(T t, S s);
}
