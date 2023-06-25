package com.exercise.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName BigDecimalDemo
 * @Description 大数运算
 * @Author yeqiang
 * @Date 2021/1/18 9:28 下午
 * @Version 1.0
 **/
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal ("2.4761");
        //2.476190476190476
        System.out.println(bigDecimal.setScale(4, RoundingMode.UP)); //正数向右靠， 负数向左靠
        System.out.println(bigDecimal.setScale(4, RoundingMode.DOWN));//正数向左靠， 负数向右靠
        System.out.println(bigDecimal.setScale(4, RoundingMode.CEILING)); // 全向右靠，向大靠拢
        System.out.println(bigDecimal.setScale(4, RoundingMode.FLOOR)); // 全向左靠，向小靠拢
        System.out.println(bigDecimal.setScale(4, RoundingMode.HALF_UP)); // 舍弃距离相同，向上舍入， 如果舍弃部分大于等于0.5， 则向上，否则向下
        System.out.println(bigDecimal.setScale(4, RoundingMode.HALF_DOWN)); // 舍弃距离相同，向下舍入， 如果舍弃部分大于等于0.5， 则向上，否则向下
        System.out.println(bigDecimal.setScale(4, RoundingMode.HALF_EVEN));
        System.out.println(bigDecimal.setScale(4, RoundingMode.UNNECESSARY));
    }
}
