import java.util.*;

public class task1 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(encrypt("Sunshine")));
		int[] massive={72, 33, -73, 84, -12, -3, 13, -13, -68}; 
		System.out.println(decrypt(massive));
	}

	private static int[] encrypt(String str){
		int[] massive = new int[str.length()];
		massive[0] = str.charAt(0);
		for(int i=1;i<str.length();i++){
			 massive[i] = (str.charAt(i) - str.charAt(i-1));
		}
		return massive;
	}
	
	private static String decrypt(int[] massive){
		String str = "";
		str += (char) massive[0];
		for(int i=1;i<massive.length;i++){
			int a = str.charAt(i-1);
			str += (char) (a + massive[i]);
		}
		return str;
	}
}