public class L4T09 {
	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		System.out.println(trouble(s1, s2));
	}
	public static boolean trouble(String number1, String number2) {
		int count1 = 0;
		int count2 = 0;
		String currentChar = "";
		for (int i = 0; i < number1.length() - 1; i++) {
			currentChar = String.valueOf(number1.charAt(i));
			if (currentChar.equals(String.valueOf(number1.charAt(i + 1)))) 
			count1++;
			else count1 = 0;
			if (count1 == 2) {
				count2 = 0;
				for (int j = 0; j < number2.length(); j++) {
					if (currentChar.equals(String.valueOf(number2.charAt(j)))) 
					count2++;
					else count2 = 0;
					if (count2 == 2) return true;
				}
			}
		}
		return false;
	}
}