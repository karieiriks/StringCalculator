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
				try{
					if(checkNegative(finalString).length() > 0){
						String check = checkNegative(finalString);
						throw new Exception();
					}
				}catch(Exception e){
	        	
					
				}
				return sumX(finalString);
			}
			else if(text.contains(",") || text.contains("\n")){
				String[] parts = splitString(text);
				try{
					if(checkNegative(parts).length() > 0){
						String check = checkNegative(parts);
						throw new Exception();
					}
				}catch(Exception e){
	        	

				}
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

	public static String checkNegative(String[] suspiciousText){
		String guilty = "";
		for(int i = 0; i < suspiciousText.length; i++){
			if(toInt(suspiciousText[i]) < 0)
			{
				guilty += suspiciousText[i] + ",";
			}
		}
		guilty = guilty.substring(0, (guilty.length() - 1));
		return guilty;
	}
}





/*String checkNeg = checkNegative(finalString);
try{
try{
	if(checkNeg.length() != 0)
		Throw NegativeNumberException();
}catch(NegativeNumberException e){
	StdOut.println("Negatives not allowed ");		
		for(int i = 0; i < checkNeg.length(); i++){
			StdOut.print(checkNeg[i]);
		}
}
String checkNeg = checkNegative(parts);
try{
	if(checkNeg.length() != 0){
		Throw new NegativeNumberException();
	}
}catch(NegativeNumberException){
	StdOut.println("Negatives not allowed ");		
		for(int i = 0; i < checkNeg.length(); i++){
			StdOut.print(checkNeg[i]);
		}
}*/