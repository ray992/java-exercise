package com.exercise.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class AnimalShelf {

    public Deque<Integer> animalNumberQueue = new LinkedList();
    public Deque<Integer> animalCategoryQueue = new LinkedList();

    public AnimalShelf() {

    }
    
    public void enqueue(int[] animal) {
        int number = animal[0];
        int category = animal[1];
        animalNumberQueue.addLast(number);
        animalCategoryQueue.addLast(category);
    }
    
    public int[] dequeueAny() {
        if(!animalNumberQueue.isEmpty()){
           int number = animalNumberQueue.pollFirst();
           int category = animalCategoryQueue.pollFirst();
           return new int[]{number, category};
        }
        return new int[]{-1, -1};
    }
    
    public int[] dequeueDog() {
        Stack<Integer> tempAnimalNumberStack = new Stack();
        Stack<Integer> tempAnimalCategoryStack = new Stack();
        int[] result = null;
        while(!animalNumberQueue.isEmpty()){
            int number = animalNumberQueue.pollFirst();
            int category = animalCategoryQueue.pollFirst();
            if (category == 1){
                result = new int[]{number, category};
                break;
            }
            tempAnimalNumberStack.push(number);
            tempAnimalCategoryStack.push(category);
        }
        while(!tempAnimalNumberStack.empty()){
            animalNumberQueue.addFirst(tempAnimalNumberStack.pop());
            animalCategoryQueue.addFirst(tempAnimalCategoryStack.pop());
        }
        return (result == null)?new int[]{-1, -1}:result;
    }
    
    public int[] dequeueCat() {
        Stack<Integer> tempAnimalNumberStack = new Stack();
        Stack<Integer> tempAnimalCategoryStack = new Stack();
        int[] result = null;
        while(!animalNumberQueue.isEmpty()){
            int number = animalNumberQueue.pollFirst();
            int category = animalCategoryQueue.pollFirst();
            if (category == 0){
                result = new int[]{number, category};
                break;
            }
            tempAnimalNumberStack.push(number);
            tempAnimalCategoryStack.push(category);
        }
        while(!tempAnimalNumberStack.empty()){
            animalNumberQueue.addFirst(tempAnimalNumberStack.pop());
            animalCategoryQueue.addFirst(tempAnimalCategoryStack.pop());
        }
        return (result == null)?new int[]{-1, -1}:result;
    }
}
