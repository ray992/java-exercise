package com.exercise.interfaces;

public class InterDemo {

    public static void main(String[] args) {
        InterDemo interDemo = new InterDemo();
        Integer res = interDemo.add(3, 4, new InterfaceDemo() {
            @Override
            public int add(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(res);
    }
    public int add(Integer a, Integer b,  InterfaceDemo interfaceDemo){
        return interfaceDemo.add(a, b);
    }


}


interface InterfaceDemo {
    int add(Integer a, Integer b);
}
