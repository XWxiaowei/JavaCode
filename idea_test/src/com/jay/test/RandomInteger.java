package com.jay.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by maerfeifei on 2017/7/22.
 */
public class RandomInteger {
    public static void main(String[] args) throws FileNotFoundException {
        Random randomInteger = new Random();
        List<String> randoms = new ArrayList<String>();
        InputStream input = new FileInputStream("properties.properties");
        Product product = new Product();
        product.setProductId(12);
    }
}
