
public class Main {

    public static void main(String[] args) {
        Vector v1 = new Vector(1,0,0);
        Vector v2 = new Vector(-1,0,0);
        //System.out.println(v1.getX()+" "+v1.getY()+" "+v1.getZ());
        //v1.setX(7.7); v1.setY(6.1); v1.setZ(3);
        Vector.setTc(3);

        System.out.println("Вектор v1: "+v1);
        System.out.println("Длинна вектора v1: "+ String.format(("%."+v1.getTc()+"f"),v1.length()));
        System.out.println("Вектор v2: "+v2);
        System.out.println("Длинна вектора v2: "+String.format(("%."+v1.getTc()+"f"),v2.length()));

        Vector v3 = new Vector();
        System.out.println("\nУгол между v1 и v2: "+String.format(("%."+v1.getTc()+"f"),v3.angle(v1,v2)));
        System.out.println("v1 + v2 = "+Vector.sum(v1,v2));
        System.out.println("v1 - v2 = "+Vector.difference(v1,v2));
        System.out.println("l*v1 = "+Vector.lambdaMult(5,v1));
        System.out.println("(v1, v2) = "+ String.format(("%."+v1.getTc()+"f"),v3.scalarMult(v1,v2)));
        System.out.println("[v1, v2] = "+Vector.vectorMult(v1,v2));

        v3.setX(1.5); v3.setY(-1); v3.setZ(0.1);
        System.out.println("\nВектор v1: "+v1);
        System.out.println("Вектор v2: "+v2);
        System.out.println("Вектор v3: "+v3);
        Vector v4 = new Vector();
        System.out.println("v1 * v2 * v3 = "+String.format(("%."+v1.getTc()+"f"),v3.mult(v1,v2,v3)));
    }
}
