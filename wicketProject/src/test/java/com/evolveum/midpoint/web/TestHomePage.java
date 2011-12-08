package com.evolveum.midpoint.web;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.evolveum.midpoint.MidPointApplication;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new MidPointApplication());
    }

    @Test
    public void homepageRendersSuccessfully() {
//		//start and render the test page
//		tester.startPage(PageUser.class);
//
//		//assert rendered page class
//		tester.assertRenderedPage(PageUser.class);
    }
}
