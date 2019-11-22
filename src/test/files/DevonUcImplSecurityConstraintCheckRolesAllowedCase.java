package com.devonfw.testapplication.testcomponent.logic.impl;

public class TestClassImpl implements TestClass {

    @Override
    @RolesAllowed(ApplicationAccessControlConstants.PERMISSION_TEST)
    public void ucImplMethod() {

    }

}