package com.devonfw.testapplication.testcomponent.logic.impl;

public class TestInterfaceImpl implements Test1, Test2, Test3, TestInterface {

    private int testInt;
    private String testString;

    private boolean testBoolMethod() {
        return true;
    }

    private String testStringMethod() {
        return "TEST";
    }

}

public interface TestInterface {
    
    private int interfaceMethod();

}