package is.ru.stringcalculator

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest{

	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.StringCalculatorTest");
	}

		@Test
		public void testEmptyString(){
			assertEquals(0, StringCalculator.add(""));
		}
}