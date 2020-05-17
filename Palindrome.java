/*
Класс Palindrome принимает входные значения из консоли
Поэтому, запускать ее стоит так:
java Palindrome arg1 arg2 arg3...
Выводит все входные слова, которые являются палиндромами
*/


public class Palindrome {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			boolean result = isPalindrome(s);
			if (result) System.out.printf("String %s is palindrome\n", s);
			else System.out.printf("String %s is not palindrome\n", s);
		}
	}

	/*
	Метод reverseString принимает в кач-ве аргумента строку s
	Через цикл for разворачивает строку и сохраняет резльутат
	в переменную result. Возвращает развертную строку.
	*/
	public static String reverseString(String s) {
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}

	/*
	Метод isPalindrome, принимает в кач-ве аргумента строку s
	Возвращает true, если строка является палиндромом, иначе false.
	*/
	public static boolean isPalindrome(String s) {
		return s.equals(reverseString(s));
	}
}