package com.adapter.objectAdapter;

import com.adapter.HeightElectric;
import com.adapter.HeightElectricImpl;
import com.adapter.LowElectric;

/**
 * @author xiang.wei
 * @create 2018/4/10 14:41
 */
public class Adapter implements LowElectric {
    private HeightElectric heightElectric;

    public Adapter(HeightElectric heightElectric) {
        this.heightElectric = heightElectric;
    }

    @Override
    public void createLowElectric(int inputElec) {
        int heightElt = heightElectric.createHeightElectric(inputElec);
        int lowElt = heightElt - 100;
        System.out.println("输出电压为="+lowElt);
    }
}
