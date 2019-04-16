package com.jery;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Java8StreamTest {

    public static void printValue(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) {
        /** Java8中有双冒号的方法：把方法当作参数传到Stream内部，使Stream的每个元素都传入到该方法执行 */
        List<String> a1 = Arrays.asList("a", "b", "c", "d", "\n");
        // 1.使用for循环遍历输出
        for (String s : a1) {
            Java8StreamTest.printValue(s);
        }
        // 2.使用foreach+Lambda循环遍历输出
        a1.forEach(x -> Java8StreamTest.printValue(x));
        // 3.使用(Consumer<? super T> action) 循环遍历输出
        Consumer<String> methodParam = Java8StreamTest::printValue;
        a1.forEach(x -> methodParam.accept(x));
        // 4.使用(Consumer<? super T> action) 简写
        a1.forEach(Java8StreamTest::printValue);

        /**
         * Lambda：函数式编程实现函数接口或使用匿名内部类（包含并重写一个方法）并作为参数时，可用Lambda表达式替换
         * 1.干嘛得：1.函数作为参数传递 2.函数接口做参数时，简化代码，只写参数和代码块
         * 2.何时用：执行一个方法method()，其参数为函数接口（是一个只包含一个方法的接口）的实现
         * 3.怎么用：() -> {}
         * ()  参数
         * {}  执行的代码块
         * method(new Interface() {                 ==使用Lambda==>    method((Xxx xxx...)->{
         *   @Override                                     *              do something...
         *   public Xxx innerMethod(Xxx xxx...){           *          });
         *     do something..
         *   }
         * });
         *
         * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html
         *
         *
         */
        // IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        // IntStream.range(1, 3).forEach(System.out::println);
        // IntStream.rangeClosed(1, 3).forEach(System.out::println);
        // Arrays.asList(1, 2, 3, 4).stream().map(n -> n * n).collect(Collectors.toList()).forEach(System.out::println);
        // Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6)).forEach(System.out::println);
        Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6)).flatMap((childList) -> childList.stream()).forEach(System.out::println);
        // Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        // Stream.of(sixNums).filter(n -> n%2==0).forEach(System.out::println);
        // 字符串合并
        // Stream.of("A", "B", "C", "D").forEach(System.out::println);
        // System.out.println(Stream.of("A", "B", "C", "D").reduce("", String::concat));
        // System.out.println(Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min));
        // System.out.println(Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));
        // System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get());
        // System.out.println(Stream.of("a", "B", "c", "D", "e", "F").filter(s -> s.compareTo("Z")<0).reduce("", String::concat));
        // Stream.iterate(0, n -> n + 3).limit(10).forEach(System.out::println);


        //Stream.of().forEach(System.out::println);
        //Stream.of().forEach(System.out::println);
    }
}
