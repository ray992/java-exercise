package com.exercise.algorithm;

/**
 * @ClassName MyHashMap
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/14 9:04 下午
 * @Version 1.0
 **/
public class MyHashMap {

    private Integer[][] arrays = new Integer[1000001][];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        arrays[key] = new Integer[]{value};
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (arrays[key] == null){
            return -1;
        }
        return arrays[key][0];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (arrays[key] != null){
            arrays[key] = null;
        }
    }
}
