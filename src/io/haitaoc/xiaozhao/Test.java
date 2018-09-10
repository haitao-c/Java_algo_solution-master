package io.haitaoc.xiaozhao;


/** 类的初始化顺序:普通类：
 静态变量
 静态代码块
 普通变量
 普通代码块
 构造函数
 继承的子类：
 父类静态变量
 父类静态代码块
 子类静态变量
 子类静态代码块
 父类普通变量
 父类普通代码块
 父类构造函数
 子类普通变量
 子类普通代码块
 子类构造函数
 * **/
public class Test {

    public static Test test = new Test();

    public Test(){
        System.out.println("public");
    }
    {
        System.out.println("code block not static");
    }

    static {
        System.out.println("static code block");
    }

    public static void main(String[] args) {
        Test t = new Test();
    }
}
