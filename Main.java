import java.util.*;


public class Main {
	/*
	Основной метод программы, тут мы получаем от пользователя поочередно координаты для каждой точки,
	создаем экземпляры классов с этими точками и выводим получившуюся площадь.
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] points = new double[9];
		for (int i = 0; i < points.length; i++) {
			System.out.printf("Input in %s coordinate of %s point: ", i % 3 + 1, i / 3 + 1);
			points[i] = Double.parseDouble(input.nextLine());
		}
		Point3d first = new Point3d(points[0], points[1], points[2]);
		Point3d second = new Point3d(points[3], points[4], points[5]);
		Point3d third = new Point3d(points[6], points[7], points[8]);
		System.out.printf("Point 1: X: %s, Y: %s, Z: %s\n", first.getX(), first.getY(), first.getZ());
		System.out.printf("Point 2: X: %s, Y: %s, Z: %s\n", second.getX(), second.getY(), second.getZ());
		System.out.printf("Point 3: X: %s, Y: %s, Z: %s\n", third.getX(), third.getY(), third.getZ());
		if (first.equals(second) && second.equals(third)) {
			System.out.println("Your coordinates in all points are the same. I'm quiting..");
			return;
		}
		double result = computeArea(first, second, third);
		System.out.printf("Result: %.2f\n", result);
	}


	/*
	Метод, который принимает в кач-ве аргументов 3 экземпляра класса Point3d
	Если представить, что эти точки образует треугольник ABC, тогда
	функция вычисляет длину сторон AB, AC, BC. Этого достаточно,
	чтобы использовать формулу Герона.
	*/
	public static double computeArea(Point3d first, Point3d second, Point3d third) {
		double ab = first.distanceTo(second);
		double ac = first.distanceTo(third); 
		double bc = second.distanceTo(third);
		double perimeter = (ab + ac + bc) / 2;
		return Math.sqrt(perimeter * (perimeter - ab) * (perimeter - ac) * (perimeter - bc));
	}

}