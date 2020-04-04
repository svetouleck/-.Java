package ru.yandex.kozina2001.swet;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;
import static java.lang.StrictMath.*;

public class Complex {
    private double a, b, r, fi;
    private static int tc=4;

    //Конструкторы
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
        this.r = sqrt(a*a + b*b);
        this.fi = atan(b/a);

    }
    public Complex(double a){
        this.a = a;
        this.b = 0;
        this.r = a;
        this.fi = 0;
    }

    public Complex(){
        this.a = 0;
        this.b = 0;
        this.r = 0;
        this.fi = 0;
    }
    public Complex(int tc){
        this.a = 0;
        this.b = 0;
        this.r = 0;
        this.fi = 0;
        this.tc = tc;
    }

    //Геттеры
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getR() {
        return r;
    }
    public double getFi() {
        return fi;
    }
    public int getTc() {
        return tc;
    }
    //Сеттеры
    public void setA(double A) {
        this.a = A;
    }
    public void setB(double B) {
        this.b = B;
    }
    public static void setTc(int a) {
        tc = a;
    }


    public String trigonometric() {
        return (String.format(("%."+this.tc+"f"),this.r) + " * [cos(" + String.format(("%."+this.tc+"f"),this.fi) + ") + i*sin(" + String.format(("%."+this.tc+"f"),this.fi) + ")]");
    }
    public String exponential() {
        return (String.format(("%."+this.tc+"f"),this.r) + " * e^(i*"+String.format(("%."+this.tc+"f"),this.fi)+")");
    }

    public String toString() {
        if (b==0.) return String.format(("%."+this.tc+"f"),this.a);
        else if (b>0) return(String.format(("%."+this.tc+"f"),this.a)+" + i*"+String.format(("%."+this.tc+"f"),this.b));
            else return(String.format(("%."+this.tc+"f"),this.a)+" - i*"+String.format(("%."+this.tc+"f"),abs(this.b)));
    }
    public static Complex sum(Complex c1, Complex c2) {
        Complex c3 = new Complex();
        c3.a = c1.a + c2.a;
        c3.b = c1.b + c2.b;
        c3.r = sqrt(c3.a*c3.a + c3.b*c3.b);
        c3.fi = atan(c3.b/c3.a);
        return(c3);
    }
    public static Complex difference(Complex c1, Complex c2) {
        Complex c3 = new Complex();
        c3.a = c1.a - c2.a;
        c3.b = c1.b - c2.b;
        c3.r = sqrt(c3.a*c3.a + c3.b*c3.b);
        c3.fi = atan(c3.b/c3.a);
        return(c3);
    }
    public static Complex mult(Complex c1, Complex c2) {
        Complex c3 = new Complex();
        c3.a = c1.a*c2.a - c1.b*c2.b;
        c3.b = c1.a*c2.b + c1.b*c2.a;
        c3.r = c1.r*c2.r;
        c3.fi = c1.fi + c2.fi;
        return(c3);
    }
    //???????????????
    public static Complex division(Complex c1, Complex c2) throws Exception{
        if (c2.a==0. && c2.b==0.){
            throw new Exception("Error");
            //return (Error"")
        }
        Complex c3 = new Complex();
            c3.a = (c1.a*c2.a + c1.b*c2.b)/(c2.a*c2.a + c2.b*c2.b);
            c3.b = (c1.a*c2.b - c1.b*c2.a)/(c2.a*c2.a + c2.b*c2.b);
            c3.r = c1.r*c2.r;
            c3.fi = c1.fi + c2.fi;
            c3.r = sqrt(c3.a*c3.a + c3.b*c3.b);
            c3.fi = atan(c3.b/c3.a);
        return(c3);
    }
    public static Complex exp(Complex c1, double n) {
        Complex c3 = new Complex();
        c3.r = power(c1.r,n);
        c3.fi = n * c1.fi;
        c3.a = c3.r * cos(c3.fi);
        c3.b = c3.r * sin(c3.fi);
        return(c3);
    }

}
