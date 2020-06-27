package com.myq.learning.day11

/**
  * 匹配嵌套结构
  * 基本介绍
  *
  * 操作原理类似于正则表达式
  *
  * 最佳实践案例-商品捆绑打折出售
  *
  * 现在有一些商品，请使用Scala设计相关的样例类，完成商品捆绑打折出售。要求
  * 1.商品捆绑可以是单个商品，也可以是多个商品。
  * 2.打折时按照折扣x元进行设计.
  * 3.能够统计出所有捆绑商品打折后的最终价格
  */
object Demo {
  def main(args: Array[String]): Unit = {
    //  匹配嵌套结构(就是Bundle的对象)
    //给出案例表示有一捆数，单本漫画（40-10） +文学作品(两本书)（80+30-20） = 30 + 90 = 120.0
    val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))
    val result2 = sale match {
      //说明因为没有使用 _* 即明确说明没有多个Bundle,所以返回的rest，就不是WrappedArray了。
      case Bundle(_, _, art @ Book(_, _), rest) => (art, rest)
    }
    println(result2)
    println("art =" + result2._1)
    println("rest=" + result2._2)

    println("res=" + price(sale))
  }

  def price(it: Item): Double = {
    it match {
      case Book(_, p) => p
      //生成一个新的集合,_是将its中每个循环的元素传递到price中it中。递归操作,分析一个简单的流程
      case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
    }
  }

}

abstract class Item // 项

//创建样例类
case class Book(description: String, price: Double) extends Item
//Bundle 捆 ， discount: Double 折扣 ， item: Item* ,
case class Bundle(description: String, discount: Double, item: Item*) extends Item

//知识点1-将descr绑定到第一个Book的描述
/**
  * 如何取出
  * val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))
  * 这个嵌套结构中的 "漫画"
  *
  * val res = sale match  {
  * //如果我们进行对象匹配时，不想接受某些值，则使用_ 忽略即可，_* 表示所有
  * case Bundle(_, _, Book(desc, _), _*) => desc
  * }
  */

//知识点2-通过@表示法将嵌套的值绑定到变量。_*绑定剩余Item到rest
/**
  * 如何将 "漫画" 和
  *
  * val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))
  * 这个嵌套结构中的 "漫画" 和 紫色的部分 绑定到变量，即赋值到变量中.
  * val result2 = sale match {
  * case Bundle(_, _, art @ Book(_, _), rest @ _*) => (art, rest)
  * }
  * println(result2)
  * println("art =" + result2._1)
  * println("rest=" + result2._2)
  */

//知识点3-不使用_*绑定剩余Item到rest
/**
  * 如何将 "漫画" 和 Article
  *
  * val sale = Bundle("书籍", 10,  Article("漫画", 40), Bundle("文学作品", 20, Article("《阳关》", 80), Article("《围城》", 30)))
  * 这个嵌套结构中的 "漫画" 和 Article的部分 绑定到变量，即赋值到变量中.
  * val result2 = sale match {
  * //说明因为没有使用 _* 即明确说明没有多个Bundle,所以返回的rest，就不是WrappedArray了。
  * case Bundle(_, _, art @ Book(_, _), rest) => (art, rest)
  * }
  * println(result2)
  * println("art =" + result2._1)
  * println("rest=" + result2._2)
  */