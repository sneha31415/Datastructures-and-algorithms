package org.example.oops_learn;

public class vehicleuse {
    public static void main(String[] args) {
        //in this class we need not inherit vehicle class because we are not creating any class like car
        // we are just creating a vehicle object v
       // vehicle v = new vehicle("black"); //now we cant create a vehicle object buz vehicle is an abstact(incomplete) class

        //v.print();
        //here we are making car obj so constructor of car as well as vehicle will be called buc car is the derived class if vehicle
        car c = new bmw();
        //we will be able to access print funtion and color and maxspeed for object car
        c.color="black"; //color can be accessed here even if its default buz we are in same package
       // c.maxspeed=100;  now this is not valid cuz maxspeed of vehicle is private
        c.numGears=5;

        //print() of car will be called and not vehicle
        c.print(); //called as overriding
       // c.printcar();
        c.setMaxspeed(100);
        System.out.println(c.getMaxspeed());

        //polymorphism
       // vehicle a = new car();

        //a is a vehicle for compiler in the line 'a.isConvertible();' so,isConvertible() will not work as it is a function of car
        //** a.isConvertible();
        //print() of vehicle will be called cuz a is a vehicle for compiler(compiler goes line by linE)
        //a.print();

//        vehicle v = new car();
//        v.print();
    }
}
