package com.jay.xiang.model;

import java.util.Date;

public class ShopOrderBindInvoice {
    /**
     * 
     */
    private String cId;

    /**
     * 订单编号
     */
    private String cDealno;

    /**
     * 发票唯一流水号
     */
    private String cFpqqlsh;

    /**
     * 0,普通发票;1,专用发票;2,电子发票
     */
    private String cInvoicetype;

    /**
     * 抬头名称
     */
    private String cHeadname;

    /**
     * 纳税人识别号
     */
    private String cTaxpayernum;

    /**
     * 企业注册地址
     */
    private String cCompanyaddr;

    /**
     * 
     */
    private String cPhone;

    /**
     * 开户银行
     */
    private String cBankname;

    /**
     * 银行账户
     */
    private String cBankaccount;

    /**
     * 收票人手机
     */
    private String cMobile;

    /**
     * 发票图片路径
     */
    private String cInvoiceimage;

    /**
     * 0,未开;1,开票中;2已开;3开票失败
     */
    private String cState;

    /**
     * 开票日期
     */
    private Date cKprq;

    /**
     * 发票代码
     */
    private String cFpdm;

    /**
     * 发票号码
     */
    private String cFphm;

    /**
     * 不含税金额
     */
    private Double cBhsje;

    /**
     * 税额
     */
    private Double cHjse;

    /**
     * 红票图片路径
     */
    private String cRedinvoiceimage;

    /**
     * 开票类型1,正票;2,红票
     */
    private String cKptype;

    /**
     * 失败信息
     */
    private String cMsg;

    /**
     * 0:未同步,1:同步失败,2:已同步
     */
    private String cCrmsync;

    /**
     * 
     * @return c_id 
     */
    public String getcId() {
        return cId;
    }

    /**
     * 
     * @param cId 
     */
    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    /**
     * 订单编号
     * @return c_dealno 订单编号
     */
    public String getcDealno() {
        return cDealno;
    }

    /**
     * 订单编号
     * @param cDealno 订单编号
     */
    public void setcDealno(String cDealno) {
        this.cDealno = cDealno == null ? null : cDealno.trim();
    }

    /**
     * 发票唯一流水号
     * @return c_fpqqlsh 发票唯一流水号
     */
    public String getcFpqqlsh() {
        return cFpqqlsh;
    }

    /**
     * 发票唯一流水号
     * @param cFpqqlsh 发票唯一流水号
     */
    public void setcFpqqlsh(String cFpqqlsh) {
        this.cFpqqlsh = cFpqqlsh == null ? null : cFpqqlsh.trim();
    }

    /**
     * 0,普通发票;1,专用发票;2,电子发票
     * @return c_invoicetype 0,普通发票;1,专用发票;2,电子发票
     */
    public String getcInvoicetype() {
        return cInvoicetype;
    }

    /**
     * 0,普通发票;1,专用发票;2,电子发票
     * @param cInvoicetype 0,普通发票;1,专用发票;2,电子发票
     */
    public void setcInvoicetype(String cInvoicetype) {
        this.cInvoicetype = cInvoicetype == null ? null : cInvoicetype.trim();
    }

    /**
     * 抬头名称
     * @return c_headname 抬头名称
     */
    public String getcHeadname() {
        return cHeadname;
    }

    /**
     * 抬头名称
     * @param cHeadname 抬头名称
     */
    public void setcHeadname(String cHeadname) {
        this.cHeadname = cHeadname == null ? null : cHeadname.trim();
    }

    /**
     * 纳税人识别号
     * @return c_taxpayernum 纳税人识别号
     */
    public String getcTaxpayernum() {
        return cTaxpayernum;
    }

    /**
     * 纳税人识别号
     * @param cTaxpayernum 纳税人识别号
     */
    public void setcTaxpayernum(String cTaxpayernum) {
        this.cTaxpayernum = cTaxpayernum == null ? null : cTaxpayernum.trim();
    }

    /**
     * 企业注册地址
     * @return c_companyaddr 企业注册地址
     */
    public String getcCompanyaddr() {
        return cCompanyaddr;
    }

    /**
     * 企业注册地址
     * @param cCompanyaddr 企业注册地址
     */
    public void setcCompanyaddr(String cCompanyaddr) {
        this.cCompanyaddr = cCompanyaddr == null ? null : cCompanyaddr.trim();
    }

    /**
     * 
     * @return c_phone 
     */
    public String getcPhone() {
        return cPhone;
    }

    /**
     * 
     * @param cPhone 
     */
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    /**
     * 开户银行
     * @return c_bankname 开户银行
     */
    public String getcBankname() {
        return cBankname;
    }

    /**
     * 开户银行
     * @param cBankname 开户银行
     */
    public void setcBankname(String cBankname) {
        this.cBankname = cBankname == null ? null : cBankname.trim();
    }

    /**
     * 银行账户
     * @return c_bankaccount 银行账户
     */
    public String getcBankaccount() {
        return cBankaccount;
    }

    /**
     * 银行账户
     * @param cBankaccount 银行账户
     */
    public void setcBankaccount(String cBankaccount) {
        this.cBankaccount = cBankaccount == null ? null : cBankaccount.trim();
    }

    /**
     * 收票人手机
     * @return c_mobile 收票人手机
     */
    public String getcMobile() {
        return cMobile;
    }

    /**
     * 收票人手机
     * @param cMobile 收票人手机
     */
    public void setcMobile(String cMobile) {
        this.cMobile = cMobile == null ? null : cMobile.trim();
    }

    /**
     * 发票图片路径
     * @return c_invoiceImage 发票图片路径
     */
    public String getcInvoiceimage() {
        return cInvoiceimage;
    }

    /**
     * 发票图片路径
     * @param cInvoiceimage 发票图片路径
     */
    public void setcInvoiceimage(String cInvoiceimage) {
        this.cInvoiceimage = cInvoiceimage == null ? null : cInvoiceimage.trim();
    }

    /**
     * 0,未开;1,开票中;2已开;3开票失败
     * @return c_state 0,未开;1,开票中;2已开;3开票失败
     */
    public String getcState() {
        return cState;
    }

    /**
     * 0,未开;1,开票中;2已开;3开票失败
     * @param cState 0,未开;1,开票中;2已开;3开票失败
     */
    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

    /**
     * 开票日期
     * @return c_kprq 开票日期
     */
    public Date getcKprq() {
        return cKprq;
    }

    /**
     * 开票日期
     * @param cKprq 开票日期
     */
    public void setcKprq(Date cKprq) {
        this.cKprq = cKprq;
    }

    /**
     * 发票代码
     * @return c_fpdm 发票代码
     */
    public String getcFpdm() {
        return cFpdm;
    }

    /**
     * 发票代码
     * @param cFpdm 发票代码
     */
    public void setcFpdm(String cFpdm) {
        this.cFpdm = cFpdm == null ? null : cFpdm.trim();
    }

    /**
     * 发票号码
     * @return c_fphm 发票号码
     */
    public String getcFphm() {
        return cFphm;
    }

    /**
     * 发票号码
     * @param cFphm 发票号码
     */
    public void setcFphm(String cFphm) {
        this.cFphm = cFphm == null ? null : cFphm.trim();
    }

    /**
     * 不含税金额
     * @return c_bhsje 不含税金额
     */
    public Double getcBhsje() {
        return cBhsje;
    }

    /**
     * 不含税金额
     * @param cBhsje 不含税金额
     */
    public void setcBhsje(Double cBhsje) {
        this.cBhsje = cBhsje;
    }

    /**
     * 税额
     * @return c_hjse 税额
     */
    public Double getcHjse() {
        return cHjse;
    }

    /**
     * 税额
     * @param cHjse 税额
     */
    public void setcHjse(Double cHjse) {
        this.cHjse = cHjse;
    }

    /**
     * 红票图片路径
     * @return c_redInvoiceImage 红票图片路径
     */
    public String getcRedinvoiceimage() {
        return cRedinvoiceimage;
    }

    /**
     * 红票图片路径
     * @param cRedinvoiceimage 红票图片路径
     */
    public void setcRedinvoiceimage(String cRedinvoiceimage) {
        this.cRedinvoiceimage = cRedinvoiceimage == null ? null : cRedinvoiceimage.trim();
    }

    /**
     * 开票类型1,正票;2,红票
     * @return c_kptype 开票类型1,正票;2,红票
     */
    public String getcKptype() {
        return cKptype;
    }

    /**
     * 开票类型1,正票;2,红票
     * @param cKptype 开票类型1,正票;2,红票
     */
    public void setcKptype(String cKptype) {
        this.cKptype = cKptype == null ? null : cKptype.trim();
    }

    /**
     * 失败信息
     * @return c_msg 失败信息
     */
    public String getcMsg() {
        return cMsg;
    }

    /**
     * 失败信息
     * @param cMsg 失败信息
     */
    public void setcMsg(String cMsg) {
        this.cMsg = cMsg == null ? null : cMsg.trim();
    }

    /**
     * 0:未同步,1:同步失败,2:已同步
     * @return c_crmsync 0:未同步,1:同步失败,2:已同步
     */
    public String getcCrmsync() {
        return cCrmsync;
    }

    /**
     * 0:未同步,1:同步失败,2:已同步
     * @param cCrmsync 0:未同步,1:同步失败,2:已同步
     */
    public void setcCrmsync(String cCrmsync) {
        this.cCrmsync = cCrmsync == null ? null : cCrmsync.trim();
    }
}