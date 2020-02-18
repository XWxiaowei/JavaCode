package com.jay.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiang.wei
 * @date 2020/2/17 8:57 PM
 */
@FunctionalInterface
public interface Supplier<T> {
    T get();

    class Car{
        /**
         //Supplier是jdk1.8的接口，这里和lambda一起使用了
         * @param supplier
         * @return
         */
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }

        public static void main(String[] args) {
            //构造器引用，它的语法是Class::new，或者更一般的Class<T>::new实例
            final Car car = Car.create(Car::new);
            final List<Car> cars = Arrays.asList(car);
            //静态方法引用：它的语法是Class::static_method,实例如下：
            cars.forEach(Car::collide);
            //特定类的任意对象的方法引用：它的语法是Class::method
            cars.forEach(Car::repair);
            //特定对象的方法引用：它的语法是instance::method
            final Car police = Car.create(Car::new);
            cars.forEach(police::follow);
        }
    }
}
