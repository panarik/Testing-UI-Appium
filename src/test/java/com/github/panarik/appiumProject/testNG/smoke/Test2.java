package com.github.panarik.appiumProject.testNG.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {

    @Test
    public void test2() {
        System.out.println("Test2");
        Assert.assertTrue(true);
    }

    @Test (groups = {"regression"})
    public void test22() {
        System.out.println("Test2");
        Assert.assertTrue(true);
    }

}