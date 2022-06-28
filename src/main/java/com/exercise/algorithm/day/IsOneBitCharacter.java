package com.exercise.algorithm.day;

public class IsOneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        int preBit = 0;
        for (int i = 0; i < bits.length; i++){
            int curBit = bits[i];
            if (bits.length - 1 == i){
                if (preBit == 1){
                    return false;
                }
            }
            if (preBit == 0){
                if (curBit == 1){
                    preBit = 1;
                }
            }else {
                preBit = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsOneBitCharacter isOneBitCharacter = new IsOneBitCharacter();
        System.out.println(isOneBitCharacter.isOneBitCharacter(new int[]{1,0,0}));
        System.out.println(isOneBitCharacter.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
