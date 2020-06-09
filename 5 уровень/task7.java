public class task7{
	public static void main(String[] args){
		System.out.println(numToEng(126));
	}

	private static String numToEng(int a){
		if(!(a >= 0 && a <= 999)) return "Error";
		String s = "";
		String[] digit = {"zero","one","second","three","four","five","six","seven","eight","nine"};
		String[] teen = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
		String[] decimal = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		String[] hundred = {"","one hundred","second hundred","three hundred","four hundred","five hundred",
				"six hundreds","seven hundred","eight hundred","nine hundred"};
		if(a < 10) return digit[a];
		else if(a>= 10 && a <= 20) return teen[a-10];
		else if(a>20 && a<100) {
			String b = Integer.toString(a); 
			int first = Character.getNumericValue(b.charAt(0));
			int second = Character.getNumericValue(b.charAt(1));
			s += decimal[first] + " " + digit[second];
		}
		else if(a % 100 == 0){
			String b = Integer.toString(a);
			int first = Character.getNumericValue(b.charAt(0));
			s += hundred[first];
		}
		else {
			String b = Integer.toString(a);
			int first = Character.getNumericValue(b.charAt(0));
			int second = Character.getNumericValue(b.charAt(1));
			int third = Character.getNumericValue(b.charAt(2));
			s += hundred[first] + " " + decimal[second] + " " + digit[third];
		}
		return s;
	}
}

