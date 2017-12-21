package com.xiangwei;

public class MyThreadLocalTest2 {  
  
    private final static ThreadLocal<String> myThreadLocal=new ThreadLocal<String>();  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        new Thread(){  
            public void run() {  
                  
                ThreadLocalData.getThreadLocalData().setAge(12);  
                ThreadLocalData.getThreadLocalData().setName("张三");  
                System.out.println(Thread.currentThread().getName()+"----------------"+A.getName());  
                System.out.println(Thread.currentThread().getName()+"----------------"+B.getName());  
            };  
        }.start();  
        new Thread(){  
            public void run() {  
                ThreadLocalData.getThreadLocalData().setAge(18);  
                ThreadLocalData.getThreadLocalData().setName("李四");  
                System.out.println(Thread.currentThread().getName()+"----------------"+A.getName());  
                System.out.println(Thread.currentThread().getName()+"----------------"+B.getName());  
                  
            };  
        }.start();  
  
    }  
    static class A  
    {  
        public static String getName()  
        {  
            return  ThreadLocalData.getThreadLocalData().getName();  
        }  
          
        public static void setName(String name)  
        {  
            myThreadLocal.set(name);  
        }  
    }  
      
    static class B  
    {  
        public static String getName()  
        {  
            return  ThreadLocalData.getThreadLocalData().getName();  
        }  
        public static void setName(String name)  
        {  
            myThreadLocal.set(name);  
        }  
    }  
}  
  
class ThreadLocalData  
{  
    private static ThreadLocal<ThreadLocalData> threadLocal=new ThreadLocal<ThreadLocalData>();  
    private String name;  
    private int age;  
    private ThreadLocalData(){  //不提供public的构造方法，只提供一个静态工厂方法，此方法返回与当前线程有关的当前类的实例对象。  
          
    }  
      
    public static ThreadLocalData getThreadLocalData()  
    {  
        ThreadLocalData threadLocalData=threadLocal.get();  
        if(threadLocalData==null)  
        {  
            threadLocalData=new ThreadLocalData();  
            threadLocal.set(threadLocalData);  
        }  
        return threadLocalData;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
      
}