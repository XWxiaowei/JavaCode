package com.mediator;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ConcreteColleague1.java
//  @ Date : 2016/9/29
//  @ Author : 
//
//




public class ConcreteColleague1 extends Colleague {
	public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void notify(String message) {
        System.out.println("同事1接收到消息"+message);
	}
	
	public void send(String message) {
	    mediator.send(message, this);
	}
}
