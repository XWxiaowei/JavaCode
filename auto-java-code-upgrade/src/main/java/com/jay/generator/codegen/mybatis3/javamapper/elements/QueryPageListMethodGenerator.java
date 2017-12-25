package com.jay.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author xiang.wei
 * @create 2017/12/25 10:45
 */
public class QueryPageListMethodGenerator extends AbstractJavaMapperMethodGenerator {
    @Override
    public void addInterfaceElements(Interface interfaze) {
//        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
//        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
//        importedTypes.add(fqjt);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
//        FullyQualifiedJavaType listType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
//        importedTypes.add(listType);
//        returnType.addTypeArgument(listType);
        method.setReturnType(returnType);
        method.setName("queryPageList");
        // 添加额外参数
        FullyQualifiedJavaType currentType = new FullyQualifiedJavaType("Integer");
        method.addParameter(new Parameter(currentType,"current"));
        FullyQualifiedJavaType pageSizeType = new FullyQualifiedJavaType("Integer");
        method.addParameter(new Parameter(pageSizeType,"pageSize"));
        this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
        this.addMapperAnnotations(interfaze, method);
//        if (this.context.getPlugins().clientCountByExampleMethodGenerated(method, interfaze, this.introspectedTable)) {
//            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
//        }
    }
    public void addMapperAnnotations(Interface interfaze, Method method) {
    }
}
