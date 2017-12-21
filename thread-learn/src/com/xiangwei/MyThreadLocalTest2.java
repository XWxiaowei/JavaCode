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
                ThreadLocalData.getThreadLocalData().setName("����");  
                System.out.println(Thread.currentThread().getName()+"----------------"+A.getName());  
                System.out.println(Thread.currentThread().getName()+"----------------"+B.getName());  
            };  
        }.start();  
        new Thread(){  
            public void run() {  
                ThreadLocalData.getThreadLocalData().setAge(18);  
                ThreadLocalData.getThreadLocalData().setName("����");  
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
    private ThreadLocalData(){  //���ṩpublic�Ĺ��췽����ֻ�ṩһ����̬�����������˷��������뵱ǰ�߳��йصĵ�ǰ���ʵ������  
          
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