import java.util.*;
public class L3T07 {
	public static void main(String[] args){
		for (int i = 0; i < args.length; i++) {
	        String s = args[i];
	        int a = Integer.parseInt(s);
	        System.out.println("is kaprekar: " + isKaprekar(a));
	    }
	}
	public static boolean isKaprekar(int x) {
		String result = String.valueOf((int)Math.pow(x, 2));
		int num1;
		int num2;
		if (result.length() == 1) num1 = 0;
		else num1 = Integer.parseInt(result.substring(0, (int)(result.length() / 2)));
		num2 = Integer.parseInt(result.substring((int)(result.length() / 2)));
		return (num1 + num2 == x);
	}
}