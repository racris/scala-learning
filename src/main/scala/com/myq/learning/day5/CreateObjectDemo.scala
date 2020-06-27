package com.myq.learning.day5

/**
  * 创建对象的流程
  */
object CreateObjectDemo {
  val demo = new Demo
}

/**
  * 流程分析(面试题-写出)
  * 1.加载类的信息(属性信息，方法信息)
  * 2.在内存中(堆)开辟空间
  * 3.使用父类的构造器(主和辅助)进行初始
  * 4.使用主构造器对属性进行初始化 【age:90, naem nul】
  * 5.使用辅助构造器对属性进行初始化 【 age:20, naem 小倩 】
  * 6.将开辟的对象的地址赋给 p这个引用
  */

class Demo{

}
