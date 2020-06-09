public class task4{
	public static void main(String[] args){
		System.out.println(sumDigProd(1,2,3,4,5,6));
	}

	private static int sumDigProd(int ... v){ 
		int k = 0;
		int u = 1;
		for(int i=0;i<v.length;i++)
			k+=v[i];
		String s = Integer.toString(k);
		for(int j=0;j<s.length();j++)
			u*=Character.getNumericValue(s.charAt(j));
		if(u>9) 
			return sumDigProd(u);
		else 
			return u;
	}
}