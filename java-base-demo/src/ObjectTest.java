import java.util.Objects;

/**
 * Created by xiang.wei on 2017/9/17
 */
public class ObjectTest {
    static class A {

    }

    static class B {

    }
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        String aStr = "121";
        String bStr = "121";
        System.out.println(Objects.equals(a, b));
        System.out.println(Objects.equals(aStr,bStr));
    }
}
