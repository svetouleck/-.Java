
import static java.lang.StrictMath.*;

public class Vector{
    private double x,y,z;
    private static int tc=7;
    //конструкторы
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        }
    public Vector() {
        this(0,0,0);
        /*this.x = 0;
        this.y = 0;
        this.z = 0;*/
    }



    //Геттеры
    public int getTc() {
        return tc;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    //Сеттеры
    public void setX(double X) {
        this.x = X;
    }
    public void setY(double Y) {
        this.y = Y;
    }
    public void setZ(double Z) {
        this.z = Z;
    }
    public static void setTc(int a) {
        tc = a;
    }

    public String toString() {
        return("{"+String.format(("%."+this.tc+"f"),this.x)+", "+String.format(("%."+this.tc+"f"),this.y)+", "+String.format(("%."+this.tc+"f"),this.y)+"}");
    }

    public double length() {
        double m = (double)Math.round(sqrt(x*x+y*y+z*z) * pow(10, (double)this.tc)) / pow(10, (double)this.tc);
        return(m);
    }
    public static Vector sum(Vector v1, Vector v2) {
        Vector v3 = new Vector();
        v3.x = v1.x + v2.x;
        v3.y = v1.y + v2.y;
        v3.z = v1.z + v2.z;
        return(v3);
    }
    public static Vector difference(Vector v1, Vector v2) {
        Vector v3 = new Vector();
        v3.x = v1.x - v2.x;
        v3.y = v1.y - v2.y;
        v3.z = v1.z - v2.z;
        return(v3);
    }
    public static  Vector lambdaMult(double l, Vector v1) {
        Vector v3 = new Vector();
        v3.x = v1.x * l;
        v3.y = v1.y * l;
        v3.z = v1.z * l;
        return(v3);
    }
    public double scalarMult(Vector v1, Vector v2) {
        double m = (double)Math.round((v1.x*v2.x + v1.y*v2.y + v1.z*v2.z) * pow(10, (double)this.tc)) / pow(10, (double)this.tc);
        return(m);
    }
    public static  Vector vectorMult(Vector v1, Vector v2) {
        Vector v3 = new Vector();
        v3.x = v1.y*v2.z - v1.z*v2.y;
        v3.y = -(v1.x*v2.z - v1.x*v2.y);
        v3.z = v1.x*v2.y - v1.x*v2.y;
        return(v3);
    }
    public double mult(Vector v1, Vector v2,  Vector v3) {
        double m = (double)Math.round((v1.x*v2.y*v3.z + v1.z*v2.x*v3.y + v1.y*v2.z*v3.x - v1.z*v2.y*v3.z - v1.x*v2.z*v3.y - v1.y*v2.x*v3.z) * pow(10, (double)this.tc)) / pow(10, (double)this.tc);
        return(m);
    }
    public double angle(Vector v1, Vector v2) {
        double Len1 = v1.length();
        double Len2 = v1.length();
        double M = v1.scalarMult(v1,v2);
        //System.out.println(M+" "+Len1+" "+(M/(Len1*Len2)));
        return(acos(M/(Len1*Len2))*(180/PI)%360);
    }

}
