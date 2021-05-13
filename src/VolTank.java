public class VolTank {
  public static int tankVol(int h, int d, int vt) {
    double r = (double)d /2;
    double length = vt / (Math.PI * Math.pow(r,2));
    double angle = 2 * Math.acos((r-h)/r);
    return (int) (0.5 * Math.pow(r,2) * (angle - Math.sin(angle)) * length);
  }
  public static void main(String[] args) {
    tankVol(5, 7, 3848);
  }
}
