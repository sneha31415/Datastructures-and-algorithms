package org.example.classtest;

public class Client {
    public static void main(String[] args) {
        Animal a = new Cat();
        //Animal b = new Animal();
        /*abstract classes() are used for==
        1) we cannot create Abstract class object buz it is incomplete(i.e Cat ya koi to object use karo)
        2)array use
        */
        Animal [] animals= new Animal[3];
        animals[0]= new Cat();
        animals[0].makeSound();
        //animals datatype ko pehle Cat datetype mei type caste kiya and then makeSound() function ko call kiya
        //this is to be done when makeSound() is a function of Cat class only ans not animal class
        //((Cat)animals[0]).makeSound();

    }
}
