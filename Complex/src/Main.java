
import ru.yandex.kozina2001.swet.*;

public class Main {
    public static void main(String[] args) {
	    Complex c1 = new Complex(2, 1);
	    //Complex c2 = new Complex(1, -2);
        Complex c2 = new Complex(0, 0);
        Complex.setTc(3);
	    //System.out.println(c1.getA()+" "+c1.getB());
	    System.out.println("c1 = "+c1);
        System.out.println("Тригонометрическая форма c1: = "+c1.trigonometric());
        System.out.println("Экспоненциальная форма c1: = "+c1.exponential());
	    System.out.println("Модуль с1: "+String.format(("%."+c1.getTc()+"f"),c1.getR())+"\nAргумент с1: "+String.format(("%."+c1.getTc()+"f"),c1.getFi()));
	    System.out.println("c2 = "+c2);
        System.out.println("Модуль с2: "+String.format(("%."+c2.getTc()+"f"),c2.getR())+"\nAргумент с2: "+String.format(("%."+c2.getTc()+"f"),c2.getFi()));

        Complex c3 = new Complex();
        System.out.println("\nc1 + c2 = "+Complex.sum(c1,c2));
        System.out.println("c1 - c2 = "+Complex.difference(c1,c2));
        System.out.println("c1 * c2 = "+Complex.mult(c1,c2));
        System.out.println("c1 ^ 5 = "+Complex.exp(c1,5));
        try {
            System.out.println("c1 / c2 = "+Complex.division(c1,c2));
        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
