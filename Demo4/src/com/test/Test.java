package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Wildcards allow covariance:
        //上边界
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:
//         flist.add(new Apple());
         flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}