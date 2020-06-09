public class task7{
	public static void main(String[] args){
		System.out.println(longestNonrepeatingSubstring("abcabcbb"));
	}

	private static boolean someS(String str){
		for(int i=0;i<str.length();i++){
			for(int j=0;j<str.length();j++){
				if(i == j) continue;
				if(str.charAt(i) == str.charAt(j)) return false;
			}
		}
		return true;
	}

	private static String longestNonrepeatingSubstring(String str){
		String out = "";
		String out2 = "";
		for(int j=0;j<str.length();j++) {
			out = "";
			for (int i = j; i < str.length(); i++) {
				if (i == 0) out += str.charAt(i);
				else {
					while (someS(out)) {
						out += str.charAt(i);
						if(i != str.length()-1) i++;
						String r = out;
						r += str.charAt(i);
						if (!someS(r)) break;
					}
					if(out.length() > out2.length()) out2 = out;
					break;
				}
			}
		}
		return out2;
	}
}