package problemdomain;

public class Pyramid extends Shape {
  private double side;

	public Pyramid(double height) {
	super(height);
	
}

	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	@Override
	public double calcVolume() {
		
		return (1.0/3)*(Math.pow(this.side, 2)*getHeight());
	}
	
	@Override
	public double calcBaseArea() {
		
		return Math.pow(this.side, 2);
	}

}
