## lambda表达式
### lambda的语法
### 函数式接口
### 方法引用
有现成的方法可以完成你想要传递到其他代码的某个动作，
1. 例如假设你希望只要出现一个定时器事件就打印这个事件对象，你可以调用
`Timer timer = new Timer(1000, even -> System.out.println(even))`

你也可以直接把println方法传递到Timer构造器，具体的做法是：
`Timer timer1 = new Timer(1000,System.out::println)`

表达式`System.out::println` 是一个方法引用，它等价于lambda表达式`x->System.out.println(x)`
2. 假如你想对字符串排序，而不考虑字母的大小写，可以传递一下方法表达式：
`Arrays.sort(strings,String::compareToIgnore)`

从这些例子可以看出，要用 :: 操作符分隔方法名与对象或类名。主要有3种情况：
  - object::instanceMethod
  - Class::staticMethod
  - Class::instanceMethod
  在前2种情况中，方法引用等价于提供方法参数的lambda表达式。前面已经提到，System.out.println等价于
  x->System.out.println(x)。类似得，Math::pow等价于（x,y）->Math.pow(x,y)
  
  对于第3种情况，第1个参数会成为方法的目标，例如：`String::compareToIgnoreCase`等同于`(x,y)->x.compareToIgnoreCase(y)`
  
### 变量作用域
lambda 表达式有3个部分
 1. 一个代码块；
 2. 参数；
 3. 自由变量的值，这里指非参数而且不在代码中定义的变量。

 **在lambda表达式中，只能引用值不会改变的变量。**
 
 这是因为如果在lambda表达式中改变变量，并发执行多个动作时就会不安全。对于目前为止我们看到的
 动作不会发生这种情况。
 
### 处理lambda 表达式
使用lambda表达式的重点是延迟执行。毕竟，如果想要立即执行代码，完全可以直接执行，而无需把它包装在一个
lambda表达式中。之所以希望以后执行代码，这有很多原因，如：
 - 在一个单独的线程中运行代码：
 - 多次运行代码；
 - 在算法的适当位置运行代码（例如：排序中的比较操作）；
 - 发生某种情况时执行代码（如，点击了一个按钮，数据到达，等等）；
 - 只在必要时才运行代码。

例如：假设你想要执行一个动作n次，将这个动作和重复次数传递到一个 `repeat` 方法：
`repeat(10,()->System.out.println("Hello,world"))`
要接受这个lambda表达式，需要选择一个函数式接口。例如，我们可以使用 `Runnable` 接口：
```
 public static void repeat(int n,Runnable action){
      for(int i=0;i<n;i++){
        action.run();
      }
 }
 
```
如果要告诉动作出现在某次迭代中。
``` 
/**
     * 在某次迭代中执行动作
     * @param n
     * @param action
     */
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

```
### 再谈Comparator
Comparator 接口包含很多方便的静态方法来创建比较器。这些方法可以用于lambda表达式或者方法引用

静态comparing 方法取一个"键提取器"函数，它将类型T映射为一个课比较的类型（如String）。对要比较的对象

应用这个函数，然后对返回的键完成比较。例如，假设有一个Person对象数组，可以如下按名字对这些对象排序：
`Arrays.sort(people,Comparator.comparing(Person::getName))`

我们来看一个完整的例子：
```
public class PersonCompartor {
    public static void main(String[] args) {
        People person = new People();
        person.setId(111);
        person.setName("zhangsan");
        People person1 = new People();
        person1.setId(12);
        person1.setName("zhangsan");
        People person2 = new People();
        person2.setId(31);
        person2.setName("an三");
        People person3 = new People();
        person3.setId(21);
        person3.setName("an一11111111");

        People[] peopleArray = new People[]{person,person1,person2,person3};
        //1、按照人名排序
        Arrays.sort(peopleArray, Comparator.comparing(People::getName));
        System.out.println("第一次排序结果："+JSON.toJSONString(peopleArray));
        //2、人名相同的情况下，按照id排序
        Arrays.sort(peopleArray,Comparator.comparing(People::getName).thenComparing(People::getId));
        System.out.println("第二次排序结果："+JSON.toJSONString(peopleArray));
        //3、根据人名长度完成排序：，提取了的键指定一个比较器
        Arrays.sort(peopleArray, Comparator.comparing(People::getName, (s, t) -> Integer.compare(s.length(), t.length())));
        System.out.println("第三次排序结果："+JSON.toJSONString(peopleArray));
        //4、第三种方法的变体
        Arrays.sort(peopleArray,Comparator.comparing(p->p.getName().length()));
        System.out.println("第四次排序结果（同第三次）："+JSON.toJSONString(peopleArray));
    }
}

```
运行结果是：
```
第一次排序结果：[{"id":21,"name":"an一11111111"},{"id":31,"name":"an三"},{"id":111,"name":"zhangsan"},{"id":12,"name":"zhangsan"}]
第二次排序结果：[{"id":21,"name":"an一11111111"},{"id":31,"name":"an三"},{"id":12,"name":"zhangsan"},{"id":111,"name":"zhangsan"}]
第三次排序结果：[{"id":31,"name":"an三"},{"id":12,"name":"zhangsan"},{"id":111,"name":"zhangsan"},{"id":21,"name":"an一11111111"}]
第四次排序结果（同第三次）：[{"id":31,"name":"an三"},{"id":12,"name":"zhangsan"},{"id":111,"name":"zhangsan"},{"id":21,"name":"an一11111111"}]

```
