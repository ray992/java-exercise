package com.exercise.jsons;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface JsonOperation<T, V> {

    V toJson(T t) throws JsonProcessingException;

    V toJsonList(List<T> tList);

    T fromJson(V v) throws JsonProcessingException;

    List<T> fromJsonList(V v);
}
