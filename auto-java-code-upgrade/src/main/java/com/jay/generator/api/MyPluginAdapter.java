package com.jay.generator.api;

import com.jay.generator.codegen.mybatis3.service.ServiceGenerator;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by generator.wei on 2017/12/23
 */
public class MyPluginAdapter extends PluginAdapter{
    public MyPluginAdapter() {
    }

    /**
     * 必须要返回true,不然，自定义的方法不执行
     * @param list
     * @return
     */
    public boolean validate(List<String> list) {
        return true;
    }
    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    /**
     * CompilationUnit compilationUnit, String targetProject, String fileEncoding, JavaFormatter javaFormatter
     * @return
     */
    //TODO 后期再处理 生成额外的java类，可以考虑生成service,以及controller
    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles() {
        List<GeneratedJavaFile> generatedJavaFiles = new ArrayList<GeneratedJavaFile>();
//        ServiceGenerator serviceGenerator = new ServiceGenerator();
//        List<CompilationUnit> compilationUnits = serviceGenerator.getCompilationUnits();
//        GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(compilationUnits.get(0),"com.jay.generator.service","UTF-8",new DefaultJavaFormatter());
//        generatedJavaFiles.add(generatedJavaFile);
        return generatedJavaFiles;
    }
}
