package problemdomain;

public abstract class Prism extends Shape {
	private double side;
	
	
	public Prism(double height) {
		super(height);
		// TODO Auto-generated constructor stub
	}
	
	
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}


	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
}
