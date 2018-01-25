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
  
  
