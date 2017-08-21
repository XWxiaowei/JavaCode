package com.jay.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by maerfeifei on 2017/7/22.
 */
public class RandomInteger {
    public static void main(String[] args) throws FileNotFoundException {
        Random randomInteger = new Random();
        List<String> randoms = new ArrayList<String>();
//        InputStream input = new FileInputStream("properties.properties");
        Product product = new Product();
        product.setProductId(12);

        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        for (String key : map.keySet()) {

        }
        for (String values : map.values()) {

        }

        Set<Map.Entry<String, String>> newSet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = newSet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = null;
            entry = iterator.next();
        }

    }

    //Refactor this
    public void test1() {
        System.out.println("ceshi"); //sout
        //fori
        for (int i = 0; i < 100; i++) {

        }
        User user = new User();
        String userid = user.getUserid();  //user.getUserid().var+Tab
        final ArrayList<User> users = new ArrayList<>();
        //users.for
        for (User user1 : users) {

        }

    }
    //psvm
//    public static void main(String[] args) {
//
//    }

//    command+j  查看所有模板

    //command+shift+return  自动补全
    class User {
        private String userid;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
    }

}
