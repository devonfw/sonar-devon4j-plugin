package com.devonfw.testapplication.testcomponent.logic.impl;

public class TestInterfaceImpl implements TestInterface {

    @Override                                   // Noncompliant
    private boolean testBoolMethod() {
        return true;
    }

    private String testStringMethod() {
        return "TEST";
    }

}