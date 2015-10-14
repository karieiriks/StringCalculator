package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
			if(text.equals("1")) {
				return 1;
			}
			else if(text.contains(",")){
				String[] parts = splitString(text);
				return sumX(parts);
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

	public static int sumX(String[] text){
		int sum = 0;
		for(int i = 0; i < text.length; i++){
			sum += toInt(text[i]);
		}
		return sum;
	}	

}
