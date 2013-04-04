package com.mycompany;

import org.apache.wicket.util.tester.WicketTester;

import com.evolveum.demo.addressbook.HomePage;
import com.evolveum.demo.addressbook.WicketApplication;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}
}
