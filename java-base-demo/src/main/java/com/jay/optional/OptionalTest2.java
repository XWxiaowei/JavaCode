package com.jay.optional;

import java.util.Optional;

/**
 * @author xiang.wei
 * @date 2020/2/18 2:23 PM
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        //正确使用Optional
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Object> optional2 = Optional.ofNullable(null);

        //ifPresent(Consumer consumer):如果option对象保存的值不是null,则调用consumer对象，否则不调用
        //如果不是null，调用Consumer
        optional1.ifPresent(t -> System.out.println("value is" + t));
        //如果是null，调用Consumer
        optional2.ifPresent(t -> System.out.println("value is " + t));

        //orElse 如果optional对象保存的值不是null，则返回原来的值，否则返回value
        System.out.println(optional1.orElse(1000) == 1); //true
        System.out.println((Integer) optional2.orElse(1000) == 1000);//true

        //orElseGet(Supplier supplier):功能与orElse一样，只不过orElseGet参数是一个对象。
        System.out.println(optional1.orElseGet(() -> 1000) == 1); //true
        System.out.println((Integer) optional2.orElseGet(() -> 1000) == 1000); //true

        //orElseThrow(): 值不存在则抛出异常，存在则什么都不做，有点类似Guava的Precoditions

//        optional1.orElseThrow(() -> {
//            throw new IllegalStateException();
//        });
//        try {
//            optional2.orElseThrow(() -> {
//                throw new IllegalStateException();
//            });
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }

         //filter(Predicate) :判断Optional对象中保存的值是否满足Predicate,并返回新的Optional
        Optional<Integer> filter1 = optional1.filter(a -> a == null);
        Optional<Integer> filter2 = optional1.filter((a) -> a == 1);
        Optional<Object> filter3 = optional2.filter(a -> a == null);

        System.out.println(filter1.isPresent()); //false
        System.out.println(filter2.isPresent()); //true
        System.out.println(filter2.get().intValue() == 1); //true
        System.out.println(filter3.isPresent()); //false

        //map(Function):对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
        Optional<String> str1Optional = optional1.map(a -> "key" + a);
        Optional<String> str2Optional = optional2.map(a -> "key" + a);
        System.out.println(str1Optional.get()); //key1
        System.out.println(str2Optional.isPresent()); //false
        //flatMap()：功能与map()相似，差别在返回值不同，flatMap方法的mapping函数返回值可以是任何
        //类型T,而map方法的mapping函数必须是Optional
        Optional<Optional<String>> str11Optional = optional1.map(a -> Optional.of("key" + a));
        Optional<String> str22Optional = optional1.flatMap(a -> Optional.of("key" + a));
        System.out.println(str11Optional.get().get()); //key1
        System.out.println(str22Optional.get()); //key1
    }
}
