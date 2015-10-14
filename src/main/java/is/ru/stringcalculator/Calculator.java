package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
			if(text.equals("1")) {
				return 1;
			}
			else if(text.contains(",")){
				String[] parts = splitString(text);
				return sum(toInt(parts[0]) , toInt(parts[1]));
			}
			return 0;
	}

	public static String[] splitString(String wholeString){
		return wholeString.split(",");
	}

	public static int toInt(String str){
		return Integer.parseInt(str);
	}

	public static int sum(Integer number1, Integer number2){
		return number1 + number2;
	}

}
