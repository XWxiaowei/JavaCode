package com.jay.test;

/**
 * Created by xiang.wei on 2017/11/19
 * 汉诺塔的java实现,递归原理的运用
 * 主要是将A柱子上的所有盘子原样的移动到C柱子上，每次只能移动一个盘子
 *
 */
public class Honi {

    public static void main(String[] args) {
        move(3,"A","B","C");
    }

    /**
     *
     * @param n A柱子中盘子的数量
     * @param a A柱子
     * @param buffer B柱子
     * @param c C柱子
     */
    public static void move(int n, String a, String buffer, String c) {
        if (n == 1) {
            System.out.println(a+"----->"+c);
            return;
        }
        //倒数第二个放在buffer上
        move(n-1,a,c,buffer);
        //a上第一个必定放在c上
        move(1,a,buffer,c);
        //buffer上倒数第二个放在c上
        move(n-1,buffer,a,c);
    }
}
