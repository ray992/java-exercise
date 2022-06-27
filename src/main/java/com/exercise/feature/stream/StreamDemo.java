package com.exercise.feature.stream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        //of
        Stream<String> stringStream = Stream.of("ab","cd","ef");
        //object
        Stream<Object> objectStream = Stream.empty();
        //concat
        Stream<String> stringStream1 = Stream.of("gh", "hi");
        Stream<String> concatStream = Stream.concat(stringStream, stringStream1);
        // max min
        Stream<Integer> integerStream = Stream.of(10, 2, 100, 13, 4);
        System.out.println(integerStream.max(Integer::compareTo).get());
        //System.out.println(integerStream.min(Integer::compareTo).get()); //所有的流对象只能使用一次，会报错
        Stream<Integer> integerStream1 = Stream.of(210, 23, 1300, 133, 42);
        System.out.println(integerStream1.min(Integer::compareTo).get());
        //findFirst
        String firstElement = concatStream.findFirst().get();
        System.out.println(firstElement);
        //peek
        Stream<String> stringStream2 = Stream.of("a","c","e");
        List<String> upperList = stringStream2.peek(s -> {
        }).collect(Collectors.toList());
        System.out.println(upperList);
        //foreach
        Stream<String> stringStream3 = Stream.of("e","f","g");
        stringStream3.forEach(
                e -> System.out.println(e.toUpperCase(Locale.ROOT))
        );
        //foreachOrdered
        Stream<String> stringStream4 = Stream.of("m","n","p");
        stringStream4.forEachOrdered(
                e -> System.out.println(e.toUpperCase(Locale.ROOT))
        );
        //limit
        Stream<String> stringStream5 = Stream.of("m","n","p");
        stringStream5.limit(2).forEachOrdered(System.out::println);
        //skip
        System.out.println("+==========");
        Stream<String> stringStream6 = Stream.of("m","n","p");
        stringStream6.skip(2).forEachOrdered(System.out::println);
        //sorted
        System.out.println("+==========");
        Stream<String> stringStream7 = Stream.of("y","n","p");
        stringStream7.sorted().forEachOrdered(System.out::println);
        //filter
        Stream<Integer> stream = Stream.of(2,3,6,8);
        List<Integer> filterList = stream.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >4;
            }
        }).collect(Collectors.toList());
        System.out.println(filterList);

        Stream<String> stringStream8 = Stream.of("1", "2", "3");
        List<Integer> integerList = stringStream8.map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(integerList);
        //reduce
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        int res = stream1.reduce(2, (x, y) -> x + y);
        System.out.println(res);
    }

    //try - with -resource 语法，自动资源释放
    public void test(){
        try (FileInputStream fileInputStream = new FileInputStream(new File(""));
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) {

        }catch (Exception e){

        }
    }

}
