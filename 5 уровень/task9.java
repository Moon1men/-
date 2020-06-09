public class task9{
	public static void main(String[] args){
		System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
	}

	public static String correctTitle(String str) {
		String[] words = str.split(" ");
		String out = "";
		for (int i = 0; i < words.length; i++) {
			if (i>0) {
				out += " ";
			}
			String[] wordsNoHyphens = words[i].split("-");
			for (int j = 0; j < wordsNoHyphens.length; j++) {
				if(j>0) {
					out += "-";
				}
				if (wordsNoHyphens[j].equalsIgnoreCase("and") 
					|| wordsNoHyphens[j].equalsIgnoreCase("the") 
					|| wordsNoHyphens[j].equalsIgnoreCase("of")
					|| wordsNoHyphens[j].equalsIgnoreCase("in")) {
					out += wordsNoHyphens[j].toLowerCase();
				}
				else {
					out += wordsNoHyphens[j].substring(0,1).toUpperCase();
					out += wordsNoHyphens[j].substring(1).toLowerCase();
				}
			}
		}
		return out;
	}
}