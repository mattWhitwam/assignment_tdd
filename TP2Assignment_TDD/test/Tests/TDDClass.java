/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import tp2assignment_tdd.TestableClass;

/**
 *
 * @author Matt
 */
public class TDDClass {
    private static TestableClass testMe;
    public TDDClass() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        testMe = new TestableClass("Matt", 30, 85f, 100f, true);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(timeout=10)
    public void testConstructor() {
        TestableClass other = new TestableClass(testMe);
        TestableClass yetAnother = testMe;
        assertEquals("The TestableClass(TestableClass) constructor does not work as expected.", testMe, other);
        assertNotSame("Constructor has made a mistake", testMe, other);
        assertSame("Create with = works as expected", testMe, yetAnother);    
    }
    
    @Test(timeout=10)
    public void testNumbers() {
        testMe.setAge(testMe.getAge()+1);
        testMe.setWeight(testMe.getWeight()+2);
        testMe.setBalance(testMe.getBalance()+3);
        
        assertEquals("Age improperly calculated", testMe.getAge(), 31);
        assertEquals("Weight improperly calculated", testMe.getWeight(), 87f, 0.001f);
        assertEquals("Balance improperly calculated", testMe.getBalance(), 103f, 0.001f);   
    }
    
    @Test(timeout=10)
    public void testLiving() {
        TestableClass other = new TestableClass();
        assertTrue("testMe should be alive", testMe.isAlive());
        assertFalse("testMe should not be !alive", !testMe.isAlive());
        
        assertTrue("other should be !alive", !other.isAlive());
        assertFalse("other should not be alive", other.isAlive());
    }
    
    @Test(timeout=20)
    public void testNulls() {
        TestableClass other = null;
        
        assertNull("other should be null", other);
        assertNotNull("testMe should not be null", testMe);
    }
    
    @Ignore ("This test fails regardless")
    @Test(timeout = 0)
    public void testFailing() {
        fail("This test pretends to be a nasty lecturer");
    }
    
    @Test (expected=IndexOutOfBoundsException.class)
    public void testArray() throws Exception {
        TestableClass[] testArray1 = new TestableClass[] {testMe, new TestableClass(testMe)};
        TestableClass[] testArray2 = new TestableClass[] {testMe, testMe};
        assertArrayEquals("These arrays should be equal", testArray1, testArray2);
        testArray2[1] = testArray1[2];
    }
}
