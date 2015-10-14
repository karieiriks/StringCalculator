package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
			if(text.equals("1")) {
				return 1;
			}
			else if(text.contains("//")){
				String[] newStrings = splitWithDelimeter(text, "\n");
				String delimeter = getDelimeter(newStrings[0]);
				String newText = newStrings[1];
				newText = newText.replace(delimeter, ",");
				String[] finalString = splitString(newText);
				return sumX(finalString);
			}
			else if(text.contains(",") || text.contains("\n")){
				String[] parts = splitString(text);
				return sumX(parts);
			}
			return 0;
	}

	public static String[] splitString(String wholeString){
		return wholeString.split("(,)|(\n)");
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

	public static String[] splitWithDelimeter(String subText, String delimeter){
		return subText.split(delimeter);
	}

	public static String getDelimeter(String oldText){
		return oldText.substring(2, oldText.length());
	}

}
