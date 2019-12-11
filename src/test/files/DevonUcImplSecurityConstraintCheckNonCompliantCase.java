package com.devonfw.testapplication.testcomponent.logic.impl;

public class TestInterfaceImpl implements TestInterface {

    @Override                                   // Noncompliant
    public boolean testBoolMethod() {
        return true;
    }

    private String testStringMethod() {
        return "TEST";
    }

    @Override
    protected boolean overriddenHelperMethod() {

    }

}