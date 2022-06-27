package com.exercise.algorithm.binarySearch;

public class GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int pick = 0;
        while (left <= right){
            int middle = (right - left) / 2 + left;
            int res = guess(middle);
            if (res == -1){
                right = middle - 1;
            }else if (res == 1){
                left = middle +1;
            }else {
                pick = middle;
                break;
            }
        }
        return pick;
    }

    int guess(int num){
        return 6;
    }

    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame();
        System.out.println(guessGame.guess(10));
    }

}
