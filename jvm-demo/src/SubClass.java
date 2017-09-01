/**
 * Created by xiang.wei on 2017/8/31
 */
public class SubClass extends SuperClass {
    static
    {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass()
    {
        System.out.println("init SubClass");
    }
}
