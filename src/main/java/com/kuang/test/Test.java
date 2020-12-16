package com.kuang.test;

/**
 * 测试Java中的值传递和引用传递
 */
public class Test {
    public void changeValue1(int age){
         age=30;
    }
    public void changeValue2(Person person){
         person.setName("笨蛋");
    }
    public void changeValue3(String str){
        str="XXX";
    }
    public static void main(String[] args) {
       Test test=new Test();
       int age=18;
       test.changeValue1(age);
        System.out.println("age--->"+age);

        Person person=new Person(1,"xuzhi");
        test.changeValue2(person);
        System.out.println("personName-->"+person.getName());

        String str="xuzhi";
        test.changeValue3(str);
        System.out.println("str-->"+str);

        
    }
}
