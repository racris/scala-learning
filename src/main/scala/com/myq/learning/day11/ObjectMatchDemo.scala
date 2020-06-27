package com.myq.learning.day11

/**
  * 基本介绍
  * 1.对象匹配，什么才算是匹配呢？，规则如下:
  * 2.case中对象的unapply方法(对象提取器)返回Some集合则为匹配成功,返回none集合则为匹配失败
  */
object ObjectMatchDemo {
  def main(args: Array[String]): Unit = {
    object Square {
      def unapply(z: Double): Option[Double] = Some(math.sqrt(z))

      def apply(z: Double): Double = z * z
    }
    //案例1
    // 模式匹配使用：
    val number: Double = 36.0
    number match {
      case Square(n) => println(n)
      case _ => println("nothing matched")
    }

    /**
      * 应用案例1的小结
      *
      * 1.构建对象时apply会被调用 ，比如 val n1 = Square(5)
      * 2.当将 Square(n) 写在 case 后时[case Square(n) => xxx]，会默认调用unapply 方法(对象提取器)
      * 3.number 会被 传递给def unapply(z: Double) 的 z 形参
      * 4.如果返回的是Some集合，则unapply提取器返回的结果会返回给 n 这个形参
      * 5.case中对象的unapply方法(提取器)返回some集合则为匹配成功
      * 6.返回none集合则为匹配失败
      */

    //案例2
    val namesString = "Alice,Bob,Thomas"
    //说明
    namesString match {
      case Names(first, second, third) => {
        println("the string contains three people's names")
        // 打印字符串
        println(s"$first $second $third")
      }
      case _ => println("nothing matched")
    }

    /**
      * 应用案例2的小结
      *
      * 1.当case 后面的对象提取器方法的参数为多个，则会默认调用def unapplySeq() 方法
      * 2.如果unapplySeq返回是Some，获取其中的值,判断得到的sequence中的元素的个数是否是三个,如果是三个，则把三个元素分别取出，赋值给first，second和third
      * 3.其它的规则不变.
      */
  }

  object Names {
    def unapplySeq(str: String): Option[Seq[String]] = {
      if (str.contains(",")) Some(str.split(","))
      else None
    }
  }

}
