package com.jay.ssh.service;

import com.jay.ssh.pojo.MyInvoice;
import java.util.List;


/**
 * @author  xiang.wei
 */
public interface MyInvoiceService {

    /**
     * 获取用户的发票信息
     * @param buyerId  用户id
     * @return
     */
    List<MyInvoice> getMyInvoice(String buyerId);


    /**
     * 新增发票信息
     * @param myInvoice
     * @return 发票id
     */
    String saveMyInvoice(MyInvoice myInvoice);


}
