package com.home.excel;

import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ExcelFileReaderTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ExcelFileReaderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ExcelFileReaderTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDataCount()
    {
    	URL fileToRead = ExcelFileReader.class.getResource("/sample.xlsx");
        assertEquals(3,ExcelFileReader.readFile(fileToRead.getFile()));
    }
}
