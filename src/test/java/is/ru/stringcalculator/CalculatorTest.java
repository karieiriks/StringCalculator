package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {

      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumberString(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumberString(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testLargeNumbers(){
		assertEquals(2468, Calculator.add("1234,1234"));
	}

	@Test
	public void testThreeNumberString(){
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testManyNumbers(){
		assertEquals(55, Calculator.add("1,2,3,4,5,6,7,8,9,10"));
	}

	@Test
	public void testNewLineChar(){
		assertEquals(3, Calculator.add("1\n2"));
		assertEquals(21, Calculator.add("1,2\n3,4\n5,6"));
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test 
	public void testNewLineAndCommaChar(){
		assertEquals(6, Calculator.add("1,2\n3"));
	}

	@Test
	public void testDelimeter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
		assertEquals(6, Calculator.add("//!\n1,2!3"));
		assertEquals(6, Calculator.add("//&\n1&2,3"));
	}

}