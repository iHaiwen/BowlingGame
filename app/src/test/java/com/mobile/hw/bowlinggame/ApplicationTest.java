package com.mobile.hw.bowlinggame;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class ApplicationTest {

    @Test
    public void testSomething() {
        Father father = new Son();
        Grandfather uncle = new FatherBrother();
        Action action = new LaughAction();
        Assert.assertNotNull(action);
        action.doThings(father);
//        father.doThings();

//        father.doThings(uncle, action);
//        ((Father)father).doThingInFather(son);
    }
}