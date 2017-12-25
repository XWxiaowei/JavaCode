package com.jay.generator.codegen.mybatis3.service;

import com.jay.generator.codegen.mybatis3.javamapper.elements.QueryPageListMethodGenerator;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.internal.util.StringUtility;
import org.mybatis.generator.internal.util.messages.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成service
 * @author xiang.wei
 * @create 2017/12/25 16:35
 */
public class ServiceGenerator extends AbstractJavaGenerator {
   @Override
    public List<CompilationUnit> getCompilationUnits() {
       this.progressCallback.startTask(Messages.getString("Progress.17", this.introspectedTable.getFullyQualifiedTable().toString()));
       CommentGenerator commentGenerator = this.context.getCommentGenerator();
       FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3JavaMapperType());
       Interface interfaze = new Interface(type);
       interfaze.setVisibility(JavaVisibility.PUBLIC);
       String rootInterface = this.introspectedTable.getTableConfigurationProperty("rootInterface");
       if (!StringUtility.stringHasValue(rootInterface)) {
           rootInterface = this.context.getJavaClientGeneratorConfiguration().getProperty("rootInterface");
       }
       if (StringUtility.stringHasValue(rootInterface)) {
           FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootInterface);
           interfaze.addSuperInterface(fqjt);
           interfaze.addImportedType(fqjt);
       }
       this.addQueryPageListMethod(interfaze);
       List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
       if (this.context.getPlugins().clientGenerated(interfaze, (TopLevelClass) null, this.introspectedTable)) {
           answer.add(interfaze);
       }
       return answer;
    }
    /**
     * 生成分页方法
     *
     * @param interfaze
     */
    protected void addQueryPageListMethod(Interface interfaze) {
        //后期添加rules
        AbstractJavaMapperMethodGenerator methodGenerator = new QueryPageListMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);
    }
    protected void initializeAndExecuteGenerator(AbstractJavaMapperMethodGenerator methodGenerator, Interface interfaze) {
        methodGenerator.setContext(this.context);
        methodGenerator.setIntrospectedTable(this.introspectedTable);
        methodGenerator.setProgressCallback(this.progressCallback);
        methodGenerator.setWarnings(this.warnings);
        methodGenerator.addInterfaceElements(interfaze);
    }
}
