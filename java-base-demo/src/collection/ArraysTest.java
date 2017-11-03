package collection;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xiang.wei on 2017/9/17
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[ints.length-i-1] = i;
        }
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        List<int[]> intList = Arrays.asList(ints);
        for (int[] ints1 : intList) {
            for (int i : ints1) {
                System.out.println(i);
            }
        }

        String[] str = {"12", "23", "11"};
        List<String> strings = Arrays.asList(str);
        String[] str2=new String[100];
        String[] strings1 = strings.toArray(str2);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
