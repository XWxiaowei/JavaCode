package com.jay.generator.codegen.mybatis3.javamapper;

import com.jay.generator.codegen.mybatis3.javamapper.elements.CountListMethodGenerator;
import com.jay.generator.codegen.mybatis3.javamapper.elements.QueryPageListMethodGenerator;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.mybatis3.javamapper.SimpleJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.internal.util.StringUtility;
import org.mybatis.generator.internal.util.messages.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义生成mapper
 * Created by xiang.wei on 2017/12/23
 */
public class MySimpleJavaClientGenerator extends SimpleJavaClientGenerator {
    public MySimpleJavaClientGenerator() {
        super(true);
    }

    public MySimpleJavaClientGenerator(boolean requiresMatchedXMLGenerator) {
        super(requiresMatchedXMLGenerator);
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        this.progressCallback.startTask(Messages.getString("Progress.17", this.introspectedTable.getFullyQualifiedTable().toString()));
        CommentGenerator commentGenerator = this.context.getCommentGenerator();
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3JavaMapperType());
        Interface interfaze = new Interface(type);
        interfaze.setVisibility(JavaVisibility.PUBLIC);
        //添加添加类注释，这个是添加到类头部，没有多大作用
        commentGenerator.addJavaFileComment(interfaze);
        String rootInterface = this.introspectedTable.getTableConfigurationProperty("rootInterface");
        if (!StringUtility.stringHasValue(rootInterface)) {
            rootInterface = this.context.getJavaClientGeneratorConfiguration().getProperty("rootInterface");
        }
        if (StringUtility.stringHasValue(rootInterface)) {
            FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootInterface);
            interfaze.addSuperInterface(fqjt);
            interfaze.addImportedType(fqjt);
        }
        this.addDeleteByPrimaryKeyMethod(interfaze);
        this.addInsertMethod(interfaze);
        this.addSelectByPrimaryKeyMethod(interfaze);
        this.addSelectAllMethod(interfaze);
        this.addUpdateByPrimaryKeyMethod(interfaze);
        this.addCountListMethod(interfaze);
        this.addQueryPageListMethod(interfaze);
        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (this.context.getPlugins().clientGenerated(interfaze, (TopLevelClass) null, this.introspectedTable)) {
            answer.add(interfaze);
        }

        List<CompilationUnit> extraCompilationUnits = this.getExtraCompilationUnits();
        if (extraCompilationUnits != null) {
            answer.addAll(extraCompilationUnits);
        }

        return answer;
    }

    /**
     * 生成统计数量的方法
     *
     * @param interfaze
     */
    protected void addCountListMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new CountListMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);

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

}
