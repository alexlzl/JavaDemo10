package com.test;

class Foo<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(Child t) {
        this.t = (T) t;
    }
}

class Parent {

}

class Child extends Parent{

}

public class Test {
    private static Foo<? extends Parent> foo;

    public static void main(String[] args) {
         foo=new Foo<>();
        foo.setT(new Child());
    }
}



