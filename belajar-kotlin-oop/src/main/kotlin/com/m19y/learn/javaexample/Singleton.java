package com.m19y.learn.javaexample;

public class Singleton {

  private static Singleton instance;

  private Singleton(){}

  public static Singleton getInstance(){
    if(instance == null){
      instance = new Singleton();
    }
    return instance;
  }

  public static void main(String[] args) {

    Singleton singleton = Singleton.getInstance();
    Singleton singleton1 = Singleton.getInstance();
    System.out.println(singleton1 == singleton);
  }
}
