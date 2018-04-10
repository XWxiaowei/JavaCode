package com.adapter.classAdapter;

import com.adapter.HeightElectricImpl;
import com.adapter.LowElectric;

/**
 * @author xiang.wei
 * @create 2018/4/10 14:41
 */
public class Adapter extends HeightElectricImpl implements LowElectric {

    @Override
    public void createLowElectric(int inputElec) {
        int heightElt = createHeightElectric(inputElec);
        int lowElt = heightElt - 100;
        System.out.println("输出电压为="+lowElt);
    }
}
