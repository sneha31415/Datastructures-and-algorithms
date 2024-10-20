package org.example.oops_learn;

public class polynomial {
dynamicArray coefficients=new dynamicArray();
public polynomial(){

}
public void setCoefficient(int deg,int coeff){
    coefficients.set(deg,coeff);
}
public int getCoefficient(int deg){
    return coefficients.get(deg);
}

}
