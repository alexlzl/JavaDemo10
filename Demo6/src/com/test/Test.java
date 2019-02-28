package com.test;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型定义
 * @param <t>
 */
public class Test<t> {
}

 class Test1{
    public void test(){
        //泛型声明
      Test<? extends SslRMIClientSocketFactory> test=new Test<>();
      Test<String> test1=new Test<>();
        List<?extends Object> list=new ArrayList<String>();
    }
}
