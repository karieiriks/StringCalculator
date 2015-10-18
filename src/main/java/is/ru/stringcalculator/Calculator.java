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


	private static String[] splitString(String wholeString){
		return wholeString.split("(,)|(\n)");
	}

	private static int toInt(String str){
		return Integer.parseInt(str);
	}

	private static int sum(Integer number1, Integer number2){
		return number1 + number2;
	}

	private static int sumX(String[] text){
		int sum = 0;
		for(int i = 0; i < text.length; i++){
			if(toInt(text[i]) <= 1000){
				sum += toInt(text[i]);
			}
		}
		return sum;
	}	

	private static String[] splitWithDelimeter(String subText, String delimeter){
		return subText.split(delimeter);
	}

	private static String getDelimeter(String oldText){
		if(oldText.contains("[")){
			return oldText.substring(3, (oldText.length() - 1));
		}
		return oldText.substring(2, oldText.length());
	}

	private static String[] getMultipleDelimeters(String oldText){
			oldText = oldText.substring(3, oldText.length());
			oldText = oldText.replace("]", ",");
			oldText = oldText.replace("[", "");
			return oldText.split(",");
	}


	private static void checkNegative(String[] suspiciousText){
		String guilty = "";
		for(int i = 0; i < suspiciousText.length; i++){
			if(toInt(suspiciousText[i]) < 0)
			{
				guilty += suspiciousText[i] + ",";
			}
		}
		if(guilty.isEmpty()){
			return;
		}
		int size = guilty.length();
		guilty = guilty.substring(0, (size - 1));
		throw new IllegalArgumentException("Negatives not allowed: " + guilty);

	}
}
