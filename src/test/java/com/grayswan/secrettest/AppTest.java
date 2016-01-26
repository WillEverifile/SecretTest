package com.grayswan.secrettest;

import static com.grayswan.secrettest.App.testSecret;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assert testSecret(10000, new Secret() {
					public int secret(int value) {
						return value;
					}
				});
        assert !testSecret(10000, new Secret() {
					public int secret(int value) {
						return value % 2;
					}
				});
    }
}
