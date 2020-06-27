package com.myq.learning.day9

/**
  * 基本介绍
  *
  * Scala中的List 和Java List 不一样，在Java中List是一个接口，真正存放数据是ArrayList，而Scala的List可以直接存放数据，就是一个object，默认情况下Scala的List是不可变的，List属于序列Seq。
  * val List = scala.collection.immutable.List
  * object List extends SeqFactory[List]
  */
object ListDemo {

  def main(args: Array[String]): Unit = {
    //创建List
    val list01 = List(1, 2, 3) //创建时，直接分配元素
    println(list01)
    val list02 = Nil  //空集合
    println(list02)

    //列表 List-元素的追加
    /**
      * 基本介绍
      * 向列表中增加元素, 会返回新的列表/集合对象。注意：Scala中List元素的追加形式非常独特，和Java不一样。
      */
    //方式1-在列表的最后增加数据
    var list1 = List(1, 2, 3, "abc")
    // :+运算符表示在列表的最后增加数据
    val list2 = list1 :+ 4
    println(list1) //list1没有变化
    println(list2) //新的列表结果是 [1, 2, 3, "abc", 4]

    //方式2-在列表的最前面增加数据
    // :+运算符表示在列表的最后增加数据
    val list3 = 4 +: list1
    println(list1) //list1没有变化
    println(list3)

    //方式3-在列表的最后增加数据
    /**
      * 说明:
      * 1.符号::表示向集合中  新建集合添加元素。
      * 2.运算时，集合对象一定要放置在最右边，
      * 3.运算规则，从右向左。
      * 4.::: 运算符是将集合中的每一个元素加入到空集合中去 --相当于扁平化，注意使用:::两边必须是集合
      */
    val list5 = 4 :: 5 :: 6 :: list1 :: Nil
    println(list5)
    //下面等价 4 :: 5 :: 6 :: list1
    val list7 = 4 :: 5 :: 6 :: list1 ::: Nil
    println(list7)

  }

  /**
    * 创建List的应用案例小结
    *
    * 1.List默认为不可变的集合
    * 2.List 在 scala包对象声明的,因此不需要引入其它包也可以使用
    * 3.val List = scala.collection.immutable.List
    * 4.List 中可以放任何数据类型，比如 arr1的类型为 List[Any]
    * 5.如果希望得到一个空列表，可以使用Nil对象, 在 scala包对象声明的,因此不需要引入其它包也可以使用val Nil = scala.collection.immutable.Nil
    */
}
