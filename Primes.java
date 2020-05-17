/*
Класс Primes не использует входных параметров
В цикле i от 2 до 100 вызывает функцию isPrime(i)
И выводит число, если оно является простым  
*/


public class Primes {
	public static void main(String[] args) {
		for (int i = 2; i < 100; i++) {
			boolean result = isPrime(i);
			if (result == true) System.out.printf("Number %d is prime.\n", i);
		}
	}

	/*
	Метод isPrime принимает в кач-ве аргумента число number
	и возвращает true, если оно является простым
	иначе false.
	*/
	public static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) return false;
		}
		return true;
	}
}