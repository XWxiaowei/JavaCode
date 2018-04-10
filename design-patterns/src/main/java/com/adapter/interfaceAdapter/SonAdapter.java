package com.adapter.interfaceAdapter;

import com.adapter.HeightElectric;

/**
 * @author xiang.wei
 * @create 2018/4/10 15:39
 */
public class SonAdapter extends AbstractAdapter {
    private HeightElectric heightElectric;

    public SonAdapter(HeightElectric heightElectric) {
        this.heightElectric = heightElectric;
    }

    @Override
    public void createLowElectric(int inputElec) {
        int heightElt = heightElectric.createHeightElectric(inputElec);
        int lowElt = heightElt - 100;
        System.out.println("输出电压为="+lowElt);
    }
}
