package supercoder79.superapi.math;

public class DistMath {
    public static int dist2D(int x1, int x2, int y1, int y2) {
        int xsq = Math.abs(x2-x1);
        int ysq = Math.abs(y2-y1);
        int bothadded = xsq + ysq;
        int total = (int)Math.round(Math.sqrt(bothadded));
        return total;
    }
    public static double dist2D(Point2D p1, Point2D p2) {
        double x1 = p1.x;
        double x2 = p2.x;
        double y1 = p1.y;
        double y2 = p2.y;
        double xsq = Math.abs(x2-x1);
        double ysq = Math.abs(y2-y1);
        double bothadded = xsq + ysq;
        double total = Math.round(Math.sqrt(bothadded));
        return total;
    }
    public static double dist2D(double x1, double x2, double y1, double y2) {
        double xsq = Math.abs(x2-x1);
        double ysq = Math.abs(y2-y1);
        double bothadded = xsq + ysq;
        double total = Math.round(Math.sqrt(bothadded));
        return total;
    }

    public static int dist3D(int x1, int x2, int y1, int y2, int z1, int z2) {
        int xsq = Math.abs(x2-x1);
        int ysq = Math.abs(y2-y1);
        int zsq = Math.abs(z2-z1);
        int bothadded = xsq + ysq + zsq;
        int total = (int)Math.round(Math.sqrt(bothadded));
        return total;
    }
    public static double dist3D(Point3D p1, Point3D p2) {
        double x1 = p1.x;
        double x2 = p2.x;
        double y1 = p1.y;
        double y2 = p2.y;
        double z1 = p1.z;
        double z2 = p2.z;
        double xsq = Math.abs(x2-x1);
        double ysq = Math.abs(y2-y1);
        double zsq = Math.abs(z2-z1);
        double bothadded = xsq + ysq + zsq;
        double total = Math.round(Math.sqrt(bothadded));
        return total;
    }
    public static double dist3D(double x1, double x2, double y1, double y2, double z1, double z2) {
        double xsq = Math.abs(x2-x1);
        double ysq = Math.abs(y2-y1);
        double zsq = Math.abs(z2-z1);
        double bothadded = xsq + ysq + zsq;
        double total = Math.round(Math.sqrt(bothadded));
        return total;
    }
}
