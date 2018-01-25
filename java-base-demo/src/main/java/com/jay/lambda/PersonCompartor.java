package com.jay.lambda;

import com.alibaba.fastjson.JSON;
import com.jay.lambda.model.People;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiang.wei on 2018/1/25
 *
 * @author xiang.wei
 */
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
