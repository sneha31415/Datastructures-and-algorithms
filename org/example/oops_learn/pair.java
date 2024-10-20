package org.example.oops_learn;
//generics
public class pair<T> {
    private T first;
    private T second;

    //constructor
    public pair(T first,T second){
        this.first= first;
        this.second= second;
    }
    public void setFirst(T first){
        this.first= first;
    }
    public T getfirst(){
        return first;
    }
    public void setSecond(T second){
        this.second= second;
    }
    public T getSecond(){
        return second;
    }
}

  class pair2<T,V> {
    private T first;
    private V second;

    //constructor
    public pair2(T first,V second){
        this.first= first;
        this.second= second;
    }
    public void setFirst(T first){
        this.first= first;
    }
    public T getfirst(){
        return first;
    }
    public void setSecond(V second){
        this.second= second;
    }
    public V getSecond(){
        return second;
    }
}
