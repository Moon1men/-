public class Point3d extends Point2d {
	

	private double zCoord;

	/*
	Конструктор нашего класса, в кач-ве аругментов принимает 
	числа x, y, z. Координаты x, y передает в такой же конструктор
	родительского класса Point2d и значение прееменной z присваивает 
	переменной zCoord.
	*/
	public Point3d(double x, double y, double z) {
		super(x, y);
		this.zCoord = z;
	}

	/*
	Если конструктор вызывается без аргументов, то вызывается 
	конструктор родительского класса, которые присваивает переменным
	x,y значения 0,0 соотвественно. Переменной zCoord присваивает 0.
	*/
	public Point3d() {
		super();
		this.zCoord = 0;
	}


	public double getZ() {
		return this.zCoord;
	}


	public void setZ(double value) {
		this.zCoord = value;
	}


	/*
	Метод distanceTo класса Point3d принимает в кач-ве 
	аргумента другой экземпляр класса Point3d other.
	Вычислияет и возвращает рассстояние от одной точки до другой по формуле
	*/
	public double distanceTo(Point3d other) {
		return Math.abs(Math.sqrt(Math.pow(getX() - other.getX(), 2) + Math.pow(getY() - other.getY(), 2) + Math.pow(zCoord - other.getZ(), 2)));
	}

	/*
	Метод, который проверяет равенство двух точек.
	Если у точек все одинаковые - возвращает true, иначе false. 
	*/
	public boolean equals(Point3d other) {
		return getX() == other.getX() && getY() == other.getY() && getZ() == other.getZ();
	}
}