/**
 * Test class for calculator class
 *
 * @author Stephen Thung
 * @version 2019-02-13
 */
public class CalculatorTest {

    /**
     * Test correct calculation of two valid tokens (negate):
     */
    public void calculateTwoTokensTestValidNegate() throws AssertException
    {
        try
        {
            int result = Calculator.calculateTwoTokens(new String[] {"negate", "5"});
            Assert.assertEquals(-5, result);
        }
        catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test correct calculation of two valid tokens (halve):
     */
    public void calculateTwoTokensTestValidHalve() throws AssertException
    {
    	try 
    	{
    		int result = Calculator.calculateTwoTokens(new String[] {"halve", "4"});
    		Assert.assertEquals(2, result);
    	}
    	catch (Exception e) 
    	{
    		Assert.fail("Legal expression threw an Exception: " + e.getMessage());
    	}
    }

    /**
     * Test invalid two-token input (number is not an int):
     */
    public void calculateTwoTokensTestInvalidNumber() throws AssertException
    {
        try
        {
            Calculator.calculateTwoTokens(new String[] {"halve", "3.4"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        	Assert.assertTrue(true);
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not NumberFormatException) caught" + e.getMessage());
        }
    }

    /**
     * Test invalid two-token input (command is not negate/halve):
     */
    public void calculateTwoTokensTestInvalidCommand() throws AssertException
    {
    	try 
    	{
    		Calculator.calculateTwoTokens(new String[] {"divide", "4"});
    		Assert.fail("Illegal expression did not throw an Exception");
    	}
        catch (CalculatorException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        	Assert.assertTrue(true);
        }
    	catch (Exception e)
    	{
    		Assert.fail("Unexpected Exception (not NumberFormatException) caught" + e.getMessage());
    	}
    }

    /**
     * Test correct calculation of three valid tokens (+):
     */
    public void calculateThreeTokensTestValidAdd() throws AssertException
    {
    	try 
    	{
    		int result = Calculator.calculateThreeTokens(new String[] {"4", "+", "4"});
    		Assert.assertEquals(8, result);
    	}
    	catch (Exception e) 
    	{
    		Assert.fail("Legal expression threw an Exception: " + e.getMessage());
    	}
    }

    /**
     * Test correct calculation of three valid tokens (-):
     */
    public void calculateThreeTokensTestValidSubtract() throws AssertException
    {
    	try 
    	{
    		int result = Calculator.calculateThreeTokens(new String[] {"2", "-", "4"});
    		Assert.assertEquals(-2, result);
    	}
    	catch (Exception e) 
    	{
    		Assert.fail("Legal expression threw an Exception: " + e.getMessage());
    	}
    }

    /**
     * Test correct calculation of three valid tokens (/):
     */
    public void calculateThreeTokensTestValidDivide() throws AssertException
    {
    	try 
    	{
    		int result = Calculator.calculateThreeTokens(new String[] {"4", "/", "2"});
    		Assert.assertEquals(2, result);
    	}
    	catch (Exception e) 
    	{
    		Assert.fail("Legal expression threw an Exception: " + e.getMessage());
    	}
    }

    /**
     * Test invalid three-token input (either number is not an int):
     */
    public void calculateThreeTokensTestInvalidNumber() throws AssertException
    {
        // Try for first number:
        try
        {
            Calculator.calculateThreeTokens(new String[] {"foo", "+", "5"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not NumberFormatException) caught" + e.getMessage());
        }

        // Try for second number:
        try
        {
            Calculator.calculateThreeTokens(new String[] {"5", "+", "foo"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        	Assert.assertTrue(true);
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not NumberFormatException) caught" + e.getMessage());
        }
    }

    /**
     * Test invalid three-token input (command is not +/-//):
     */
    public void calculateThreeTokensTestInvalidCommand() throws AssertException
    {
    	try 
    	{
    		Calculator.calculateThreeTokens(new String[] {"4", "=", "4"});
    		Assert.fail("Illegal expression did not throw an Exception");
    	}
        catch (CalculatorException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        	Assert.assertTrue(true);
        }
    	catch (Exception e)
    	{
    		Assert.fail("Unexpected Exception (not NumberFormatException) caught" + e.getMessage());
    	}
    }

    /**
     * Test correct execution of command (one token - only can be "quit"):
     */
    public void executeTestValidQuit() throws AssertException
    {
    	try
    	{
    		int result = Calculator.execute(new String[] {"quit"});
    		Assert.assertEquals(Integer.MIN_VALUE, result);
    	}
    	catch (Exception e) 
    	{
    		Assert.fail("Legal expression threw and Exception: " + e.getMessage());
    	}
    }

    /**
     * Test correct execution of command (any valid two-token command):
     */
    public void executeTestValidTwoTokens() throws AssertException
    {
        try
        {
            int result = Calculator.execute(new String[] {"negate", "5"});
            Assert.assertEquals(-5, result);
        }
        catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test correct execution of command (any valid three-token command):
     */
    public void executeTestValidThreeTokens() throws AssertException
    {
    	try
    	{
    		int result = Calculator.execute(new String[] {"4", "+", "9"});
    		Assert.assertEquals(13, result);
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Legal expression threw an Exception: " + e.getMessage());
    	}
    }

    /**
     * Test invalid execute input (single token; not "quit"):
     */
    public void executeTestInvalidCommand() throws AssertException
    {
        try
        {
            Calculator.execute(new String[] {"foo"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (CalculatorException e)
        {
            // We expect the function to throw a CalculatorException.
            // Check to make sure the CalculatorException has the correct message and type:
            Assert.assertEquals("Illegal Command", e.getMessage());
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not CalculatorException) caught");
        }
    }

    /**
     * Test invalid execute input (invalid token lengths):
     */
    public void executeTestInvalidTokenLength() throws AssertException
    {
        // Token length is 0:
        try
        {
            Calculator.execute(new String[] {});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (CalculatorException e)
        {
            // We expect the function to throw a CalculatorException.
            // Check to make sure the CalculatorException has the correct message and type:
            Assert.assertEquals("Illegal Token Length", e.getMessage());
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not CalculatorException) caught" + e.getMessage());
        }

        // Token length is > 3:
        try
        {
            Calculator.execute(new String[] {"foo", "foo", "foo", "foo"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (CalculatorException e)
        {
            // We expect the function to throw a CalculatorException.
            // Check to make sure the CalculatorException has the correct message and type:
            Assert.assertEquals("Illegal Token Length", e.getMessage());
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not CalculatorException) caught" + e.getMessage());
        }
    }

    /**
     * Test correct parseAndExecution of command (input of "quit"):
     */
    public void parseAndExecuteTestValidQuit() throws AssertException
    {
        String result = Calculator.parseAndExecute("quit");
        Assert.assertEquals("quit", result);
    }

    /**
     * Test correct parseAndExecution of command (any valid 2 or 3 token command):
     */
    public void parseAndExecuteTestValidCommand() throws AssertException
    {
        String result = Calculator.parseAndExecute("5 + 6");
        Assert.assertEquals("The result is: 11", result);
    }

    /**
     * Test incorrect parseAndExecution of command (divide by zero):
     */
    public void parseAndExecuteTestDivideByZero() throws AssertException
    {
    	String result = Calculator.parseAndExecute("1 / 0");
    	Assert.assertEquals("Attempted to divide by 0. Please try again.", result);
    }

    /**
     * Test incorrect parseAndExecution of command (2 or 3 token command with invalid number):
     */
    public void parseAndExecuteTestInvalidNumber() throws AssertException
    {
    	String result = Calculator.parseAndExecute("halve foo");
        Assert.assertEquals("Input number cannot be parsed to an int. Please try again.", result);
    }

    /**
     * Test incorrect parseAndExecution of command (invalid command):
     */
    public void parseAndExecuteTestInvalidCommand() throws AssertException
    {
        String result = Calculator.parseAndExecute("foo 6");
    	Assert.assertEquals("Calculator Exception, message is: Illegal Command", result);
    }

    /**
     * Test incorrect parseAndExecution of command (invalid token length):
     */
    public void parseAndExecuteTestInvalidTokenLength() throws AssertException
    {
    	String result = Calculator.parseAndExecute("4 + 3 + 2 + 1");
    	Assert.assertEquals("Calculator Exception, message is: Illegal Token Length", result);
    }
}
