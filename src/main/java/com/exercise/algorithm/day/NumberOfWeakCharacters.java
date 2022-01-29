package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName NumberOfWeakCharacters
 * @Description 游戏中弱角色的数量
 * @Author yeqiang
 * @Date 2022/1/28 下午1:49
 * @Version 1.0
 **/
public class NumberOfWeakCharacters {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int weakCount = 0;
        for (int i = 0; i < properties.length; i++){
            int[] curCharacter = properties[i];
            int curAttack = curCharacter[0];
            int curDefence = curCharacter[1];
            for (int j = i + 1; j < properties.length; j++){
                int[] otherCharacter = properties[j];
                int otherAttack = otherCharacter[0];
                int otherDefence = otherCharacter[1];
                if (otherAttack > curAttack && otherDefence > curDefence){
                    weakCount++;
                    break;
                }
            }
        }
        return weakCount;
    }

    public int numberOfWeakCharacters2(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1]:o2[0] - o1[0]; //攻击力降序， 防守力升序
            }
        });
        int maxDef = 0;
        int weakCount = 0;
        for (int[] p: properties){
            if (p[1] < maxDef){
                weakCount++;
            }else {
                maxDef = p[1];
            }
        }
        return weakCount;
    }

    public static void main(String[] args) {
        NumberOfWeakCharacters numberOfWeakCharacters = new NumberOfWeakCharacters();
        System.out.println(numberOfWeakCharacters.numberOfWeakCharacters(new int[][]{{5,5}, {6,3}, {3,6}}));
        System.out.println(numberOfWeakCharacters.numberOfWeakCharacters(new int[][]{{2,2}, {3,3}}));
        System.out.println(numberOfWeakCharacters.numberOfWeakCharacters(new int[][]{{1,5}, {10,4}, {4,3}}));
    }
}
