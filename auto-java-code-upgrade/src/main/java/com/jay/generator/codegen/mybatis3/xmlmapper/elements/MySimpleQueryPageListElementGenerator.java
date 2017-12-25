package com.jay.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * 添加sql语句
 * @author xiang.wei
 * @create 2017/12/25 9:59
 */
public class MySimpleQueryPageListElementGenerator extends AbstractXmlElementGenerator {
    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select");
        answer.addAttribute(new Attribute("id", "queryPageList"));
        answer.addAttribute(new Attribute("parameterType","java.lang.Integer"));
        answer.addAttribute(new Attribute("resultMap", this.introspectedTable.getBaseResultMapId()));
        this.context.getCommentGenerator().addComment(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getBaseColumnListElement());
        sb.setLength(0);
        sb.append("FROM ");
        sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));
        //WHERE
        //LIMIT #{current},#{pageSize}
        sb.setLength(0);
        sb.append("LIMIT  #{current},#{pageSize}");
        answer.addElement(new TextElement(sb.toString()));
        parentElement.addElement(answer);
    }
}
