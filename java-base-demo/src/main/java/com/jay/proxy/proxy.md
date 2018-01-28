## 代理
### 创建代理对象
要想创建一个代理对象，需要使用Proxy类的newProxyInstance方法。这个方法有三个参数：
1. 一个类加载器，作为Java安全模型的一部分，对于系统类和从因特网上下载下来的类，可以使用
不同的类加载器。
2. 一个Class对象数组，每个元素都是需要实现的接口
3. 一个调用处理器。

使用代理可能出于很多原因，例如：
1. 路由对远程服务器的方法调用。
2. 在程序运行期间，将用户接口事件与动作关联起来。
3. 为调试，跟踪方法调用。
```
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            TraceHandler traceHandler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, traceHandler);
            elements[i] = proxy;

            Integer key = new Random().nextInt(elements.length) - 1;
            int result = Arrays.binarySearch(elements, key);
            if (result >= 0) {
                System.out.println(elements[result]);
            }
        }
    }
}

class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(target);
        System.out.println("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                if (i < args.length - 1) {
                    System.out.println(",");
                }
            }
            System.out.println(")");
        }
        return method.invoke(target, args);
    }
}


```
### 代理类的特性
代理类是在程序运行过程中创建的。然而，一旦被创建，就变成了常规类，与虚拟机中的任何其他类没有什么区别。

所有的代理类都扩展于Proxy类。一个代理类只有一个实例域-----调用处理器。它定义在Proxy的超类中。
