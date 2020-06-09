public class task1 {
	public static void main(String[] args) {
		 System.out.println(bell(2));
	}

	private static int bell(int n) {
			int[][] k = new int[n+1][n+1];
			k[0][0] = 1;
			for (int i=1; i<=n; i++)
			{
				k[i][0] = k[i-1][i-1];
				for (int j=1; j<=i; j++)
					k[i][j] = k[i-1][j-1] + k[i][j-1];
			}
			return k[n][0];
		}
}