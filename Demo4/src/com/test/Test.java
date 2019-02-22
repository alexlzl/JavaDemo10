package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 上边界类型通配符可以确定父类型，回顾向上转型与向下的概念：
 *
 * 在获取数据时 [ 返回类型 get(){ return this.t;} ]：
 *
 * 因为可以确定父类型，所以可以将返回类型设置为父类型。
 * 虽然不能确定返回 this.t的是何种类型，但是this.t的类型肯定是返回类型的子类型，可以通过向上转型成功获取。
 *
 * 在写入数据时 [ void set(参数类型 t){ this.t = t;} ]
 *
 * 因为可以确定父类型，所以可以将参数类型设置为父类型。
 * 虽然不能确定 this.t 字段的具体类型，但是肯定是参数类型的子类型，所以此时set方法进行的是向下转型，存在很大风险。Java泛型为了减低类型转换的安全隐患，不允许这种操作。
 * 上边界类型通配符（<? extends 父类型>）：
 * 因为可以确定父类型，所以可以以父类型去获取数据（向上转型）。但是不能写入数据。
 * ---------------------
  */
public class Test {
    public static void main(String[] args) {
        // Wildcards allow covariance:
        //上边界
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:
//         flist.add(new Apple());
//         flist.add(new Fruit());
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