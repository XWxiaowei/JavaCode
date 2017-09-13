import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xiang.wei on 2017/9/13
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            //获取Class对象，方式1
            Class<?> aClass = Class.forName("java.lang.String");
            Class stringCls = aClass;
            System.out.println("方式1"+stringCls);
//            方式2
            Class<String> stringClass = String.class;
            System.out.println("方式2"+stringClass);
//            方式3
            String string = new String();
            Class<? extends String> aClass1 = string.getClass();
            System.out.println("方式3"+aClass1);


            //Class 对象生成一个实例
            Object newInstance = aClass.newInstance();
            String  stringTest=(String)newInstance;
            stringTest = "项伟";
            System.out.println(stringTest);

            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println("获取所有属性"+field);
            }
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println("获取所有方法"+method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
