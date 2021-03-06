package com.visitor.visitor;

import java.util.ArrayList;
import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ObjectStructure.java
//  @ Date : 2016/9/27
//  @ Author : 
//
//

public class ObjectStructure {
    private List<Element> elements=new ArrayList<>();
    
    public void attach(Element element){
        elements.add(element);
    }
    public void detach(Element element){
        elements.remove(element);
    }
    public void accept(Visitor visitor){
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
