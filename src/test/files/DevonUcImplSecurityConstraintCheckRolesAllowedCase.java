package com.devonfw.testapplication.testcomponent.logic.impl;

public class TestClassImpl implements TestClass {

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_ENTITY)
    public void ucImplMethod() {

    }

}