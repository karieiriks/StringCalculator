package is.ru.stringcalculator;

import java.util.Arrays;

public class Calculator {

	public static int add(String text){
			if(text.contains("][")){
				String[] newString = splitWithDelimeter(text, "\n");
				String[] delimeters = getMultipleDelimeters(newString[0]);
				String newText = newString[1];
				for(int i = 0; i < delimeters.length; i++){
					newText = newText.replace(delimeters[i], ",");
				}
				String[] finalString = splitString(newText);
				checkNegative(finalString);
				return sumX(finalString);
			}
			else if(text.contains("//")){
				String[] newString = splitWithDelimeter(text, "\n");
				String delimeter = getDelimeter(newString[0]);
				String newText = newString[1];
				newText = newText.replace(delimeter, ",");
				String[] finalString = splitString(newText);
				checkNegative(finalString);
				return sumX(finalString);
			}
			else if(text.contains(",") || text.contains("\n")){
				String[] parts = splitString(text);
				checkNegative(parts);
				return sumX(parts);
			}
			else{
				if(text.length() != 0){
					return toInt(text);
				}
				else{
					return 0;
				}
			}
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
			if(toInt(text[i]) <= 1000){
				sum += toInt(text[i]);
			}
		}
		return sum;
	}	

	public static String[] splitWithDelimeter(String subText, String delimeter){
		return subText.split(delimeter);
	}

	public static String getDelimeter(String oldText){
		if(oldText.contains("[")){
			return oldText.substring(3, (oldText.length() - 1));
		}
		return oldText.substring(2, oldText.length());
	}

	public static String[] getMultipleDelimeters(String oldText){
			oldText = oldText.substring(3, oldText.length());
			oldText = oldText.replace("]", ",");
			oldText = oldText.replace("[", "");
			return oldText.split(",");
	}


	public static void checkNegative(String[] suspiciousText){
		for(int i = 0; i < suspiciousText.length; i++){
			if(toInt(suspiciousText[i]) < 0)
			{
				throw new IllegalArgumentException("Negatives");
			}
		}
	}
}
