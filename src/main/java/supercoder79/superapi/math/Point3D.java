package supercoder79.superapi.math;

public class Point3D extends Point2D {
	public double z = 0;

	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public String toString() {
		return "x = " + this.x + " y = " + this.y + " z = " + this.z;
	}
}
