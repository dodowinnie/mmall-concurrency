package com.branodn.mmall.example.singleton;

import com.branodn.mmall.annotation.Recommend;
import com.branodn.mmall.annotation.ThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 * 饿汉式，如果实例化时需要做很多操作，那么实例化时间会很长，而且如果不用的话会造成资源的浪费
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有化构造函数
    private SingletonExample7(){

    }

  public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
  }

   private enum Singleton{
      INSTANCE;

      private SingletonExample7 instance;

      Singleton(){
          instance = new SingletonExample7();
      }

      public SingletonExample7 getInstance(){
          return instance;
      }
   }

    public static void main(String[] args) {
        SingletonExample7 s1 = SingletonExample7.getInstance();
        SingletonExample7 s2 = SingletonExample7.getInstance();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }


}
