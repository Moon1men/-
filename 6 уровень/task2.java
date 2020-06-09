import java.util.*;

public class task2{
	public static void main(String[] args){
		System.out.println(translateWord("Apple"));
		System.out.println(translateSentence("Do you think it is going to rain today?"));
	}

	private static String translateWord(String s){
		if(s == "") 
			return "";
		char first_c = Character.toLowerCase(s.charAt(0));
		if(first_c == 'a' || first_c == 'e' || first_c == 'o' || first_c == 'y' || first_c == 'u' || first_c == 'i'){
			s+="yay";
			return s;
		}
		else{
			String s2 = "";
			int i = 0;
			while(!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' ||
					s.charAt(i) == 'y' || s.charAt(i) == 'u' || s.charAt(i) == 'i')){
				s2 += s.charAt(i);
				i++;
			}
			s2 += "ay";
			String s3 = "";
			for(int j = i;j<s.length();j++){
				s3 += s.charAt(j);
			}
			s3+= s2;
		return s3;
		}
	}
	
	private static String translateSentence(String str){
		boolean t = false;
		String str2="";
		if(str.charAt(str.length()-1) == '.') {
			t = true;
			for(int x=0;x<str.length()-1;x++)
				str2+=str.charAt(x);
		}
		else {
			for(int x=0;x<str.length();x++)
				str2+=str.charAt(x);
		}
		int spaces = 0;
		for(int i = 0;i<str2.length();i++){
			if(str2.charAt(i) == ' ') spaces++;
		}
		String[] p = new String[spaces+1];
		Arrays.fill(p,"");
		int j = 0;
		for(int i=0;i<str2.length();i++){
			if(str2.charAt(i) == ' ') j++;
			else p[j] += str2.charAt(i);
		}
		String out = "";
		for(int i=0;i<p.length;i++){
			if(i!=p.length-1) out += translateWord(p[i]) + " ";
			else out += translateWord(p[i]);
		}
		if(t) out+=".";
		return out;
	}
}