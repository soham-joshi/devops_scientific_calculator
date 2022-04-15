package devops_scientific_calc;

import org.junit.Test; 
import org.junit.Assert; 
import org.junit.Before;
import java.lang.Math;

public class AppTest 
{

	private Application calUnderTest; 

	@Before
	public void setUp()
	{
		calUnderTest = new Application();
	}

	// 1. Legal Arguments

	// 1.1 True Test Cases

	@Test
    public void testTrueSquareRoot() 
    { 
        double a = 25; 
        double expectedResult = Math.sqrt(a);
        //Act 
        double result = calUnderTest.sqroot(a);
        //Assert
        Assert.assertEquals(expectedResult, result, 0.0f);
    }

    @Test
    public void testTrueFact() 
    { 
        int a = 5; 
        double expectedResult = 1;

		for(int count = a; count>=1; count-- )
		{
			expectedResult = expectedResult * count;
		}

        //Act 
        double result = calUnderTest.fact(a);
        //Assert
        Assert.assertEquals(expectedResult, result, 0.0f);
    }
    
    @Test
    public void testTrueNatlog() 
    { 
        double a = 5; 

        double expectedResult = Math.log(a);

        //Act 
        double result = calUnderTest.natlog(a);
        //Assert
        Assert.assertEquals(expectedResult, result, 0.02f);
    }
    
    @Test
    public void testTruePowerf() 
    { 
        double b = 5; 
        double e = 3;
        double expectedResult = Math.pow(b, e);
        //Act 
        double result = calUnderTest.powerf(b, e);
        //Assert
        Assert.assertEquals(expectedResult, result, 0.0f);
    }


	// 1.2 False Test Cases

    @Test
    public void testFalseSquareRoot() 
    { 
        double a = 37; 
        double notexpectedResult = 5.0;
        //Act 
        double result = calUnderTest.sqroot(a);
        //Assert
        Assert.assertNotEquals(notexpectedResult, result, 0.0f);
    }

    @Test
    public void testFalseFact() 
    { 
        double a = 11; 
        double notexpectedResult = 360.0;
        //Act 
        double result = calUnderTest.fact(a);
        //Assert
        Assert.assertNotEquals(notexpectedResult, result, 0.0f);
    }
    
    @Test
    public void testFalseNatlog() 
    { 
        double a = 8; 
        double notexpectedResult = 0.30;
        //Act 
        double result = calUnderTest.natlog(a);
        //Assert
        Assert.assertNotEquals(notexpectedResult, result, 0.02f);
    }
    
    @Test
    public void testFalsePowerf() 
    { 
        double b = 11; 
        double e = 6;
        double notexpectedResult = 25.0;
        //Act 
        double result = calUnderTest.powerf(b, e);
        //Assert
        Assert.assertNotEquals(notexpectedResult, result, 0.0f);
    }

	// 2. Illegal Arguments

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeArgumentsSqroot() 
    { 
        double a = -5; 
        calUnderTest.sqroot(a);
    } 

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeArgumentsFact() 
    { 
        double a = -23; 
        calUnderTest.fact(a);
    } 

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeArgumentsNatlog() 
    { 
        double a = -45; 
        calUnderTest.natlog(a);
    } 

    @Test(expected = IllegalArgumentException.class)
    public void testZeroArgumentsNatlog() 
    { 
        double a = 0; 
        calUnderTest.natlog(a);
    } 

    @Test(expected = IllegalArgumentException.class)
    public void testZeroNegativeArgumentsPowerf() 
    { 
        double b = 0;
        double e = -4; 
        calUnderTest.powerf(b, e);
    } 

    @Test(expected = IllegalArgumentException.class)
    public void testZeroZeroArgumentsPower() 
    { 
        double b = 0;
        double e = 0; 
        calUnderTest.powerf(b, e);
    }
	

}
