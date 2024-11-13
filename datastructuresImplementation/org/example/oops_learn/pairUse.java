package org.example.oops_learn;

public class pairUse {
    public static void main(String[] args) {
        pair <String>p = new pair<>("st","abc");
      //  pair p2= new pair('a','b' ); {raw}
        pair2 <String,Integer>p2 = new pair2<String,Integer>("abc",4);
        pair2 <Integer,Integer> internalPair=new pair2<>(1,2);
        pair2 <pair2<Integer,Integer>,Integer> p3= new pair2<>(internalPair,3);
        System.out.println(p3.getfirst().getfirst());
        System.out.println(p3.getfirst().getSecond());
        System.out.println(p3.getSecond());
    }

}
