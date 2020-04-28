package com.devonfw.testapplication.testcomponent.logic.impl;

public class TestInterfaceImpl implements TestInterface {

    @Override                                      
    public boolean testBoolMethod() {               // Noncompliant
        return true;
    }

    private String testStringMethod() {     
        return "TEST";
    }

    @Override                                       
    protected boolean overriddenHelperMethod() {    

    }

}