package com.jay.generator.codegen.mybatis3;

import com.jay.generator.codegen.mybatis3.javamapper.MySimpleAnnotatedClientGenerator;
import com.jay.generator.codegen.mybatis3.javamapper.MySimpleJavaClientGenerator;
import com.jay.generator.codegen.mybatis3.xmlmapper.MySimpleXMLMapperGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3SimpleImpl;
import org.mybatis.generator.internal.ObjectFactory;

import java.util.List;

/**
 * Created by generator.wei on 2017/12/23
 */
public class MyIntrospectedTableMyBatis3SimpleImpl extends IntrospectedTableMyBatis3SimpleImpl{
    public MyIntrospectedTableMyBatis3SimpleImpl() {
    }

    @Override
    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings, ProgressCallback progressCallback) {
        this.xmlMapperGenerator = new MySimpleXMLMapperGenerator();
        this.initializeAbstractGenerator(this.xmlMapperGenerator, warnings, progressCallback);
    }

    @Override
    protected AbstractJavaClientGenerator createJavaClientGenerator() {
        if (this.context.getJavaClientGeneratorConfiguration() == null) {
            return null;
        } else {
            String type = this.context.getJavaClientGeneratorConfiguration().getConfigurationType();
            Object javaGenerator;
            if ("XMLMAPPER".equalsIgnoreCase(type)) {
                javaGenerator = new MySimpleJavaClientGenerator();
            } else if ("ANNOTATEDMAPPER".equalsIgnoreCase(type)) {
                javaGenerator = new MySimpleAnnotatedClientGenerator();
            } else if ("MAPPER".equalsIgnoreCase(type)) {
                javaGenerator = new MySimpleJavaClientGenerator();
            } else {
                javaGenerator = (AbstractJavaClientGenerator) ObjectFactory.createInternalObject(type);
            }
            return (AbstractJavaClientGenerator)javaGenerator;
        }
    }

    @Override
    protected void calculateJavaModelGenerators(List<String> warnings, ProgressCallback progressCallback) {
        super.calculateJavaModelGenerators(warnings, progressCallback);
    }
//    public String getQueryPageList() {
//        return (String)this.internalAttributes.get(InternalAttribute.ATTR_QUERY_PAGE_LIST);
//    }
//    public void setQueryPageList(String s) {
//        this.internalAttributes.put(MyIntrospectedTableMyBatis3SimpleImpl.InternalAttribute.ATTR_QUERY_PAGE_LIST, s);
//    }

//    @Override
//    protected void calculateXmlAttributes() {
//        super.calculateXmlAttributes();
//        this.setQueryPageList("queryPageList");
//    }
//    protected static enum  InternalAttribute{
//        ATTR_QUERY_PAGE_LIST;
//        private InternalAttribute() {
//        }
//    }
}
