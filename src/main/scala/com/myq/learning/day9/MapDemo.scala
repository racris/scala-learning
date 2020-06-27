package com.myq.learning.day9

import scala.collection.mutable

/**
  * Scala中的Map介绍
  *
  * 1.Scala中的Map 和Java类似，也是一个散列表，它存储的内容也是键值对(key-value)映射，Scala中不可变的Map是有序的，可变的Map是无序的。
  *
  * 2.Scala中，有可变Map (scala.collection.mutable.Map) 和 不可变Map(scala.collection.immutable.Map)
  */
object MapDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 方式1-构造不可变映射
      * 1.从输出的结果看到，输出顺序和声明顺序一致
      * 2.构建Map集合中，集合中的元素其实是Tuple2类型
      * 3.默认情况下（即没有引入其它包的情况下）,Map是不可变map
      * 4.为什么说Map中的元素是Tuple2 类型 [反编译或看对应的apply]
      */
    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map1)

    //方式2-构造可变映射
    //需要指定可变Map的包
    val map2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> 30)
    /*说明
    1.从输出的结果看到，输出顺序和声明顺序不一致*/

    //方式3-创建空的映射
    val map3 = new scala.collection.mutable.HashMap[String, Int]
    println(map3)

    /**
      * 方式4-对偶元组
      *
      * 即创建包含键值对的二元组， 和第一种方式等价，只是形式上不同而已。
      *
      * 对偶元组 就是只含有两个数据的元组。
      */
    val map4 = mutable.Map(("A", 1), ("B", 2), ("C", 3), ("D", 30))
    println("map4=" + map4)
    println(map4("A"))

    //方式1-使用map(key)
    val value1 = map2("Alice")
    println(value1)

    /**
      * 说明:
      * 如果key存在，则返回对应的值
      * 如果key不存在，则抛出异常[java.util.NoSuchElementException]
      * 在Java中,如果key不存在则返回null
      */

    /**
      * 方式2-使用contains方法检查是否存在key
      *
      * // 返回Boolean
      * // 1.如果key存在，则返回true
      * // 2.如果key不存在，则返回false
      */
    //    val map4 = mutable.Map( ("A", 1), ("B", 2), ("C", 3),("D", 30.9) )
    if (map4.contains("B")) {
      println("key存在 值= " + map4("B"))
    } else {
      println("key不存在")
    }
    /**
      * 说明:
      * 使用containts先判断在取值，可以防止异常，并加入相应的处理逻辑
      */

    /*方式3-使用map.get(key).get取值
    通过 映射.get(键) 这样的调用返回一个Option对象，要么是Some，要么是None
    */
    var map5 = mutable.Map(("A", 1), ("B", "北京"), ("C", 3))
    println(map5.get("A")) //Some
    println(map5.get("A").get) //得到Some在取出
    /**
      * 说明和小结:
      * map.get方法会将数据进行包装
      * 如果 map.get(key) key存在返回some,如果key不存在，则返回None
      * 如果 map.get(key).get  key存在，返回key对应的值,否则，抛出异常 java.util.NoSuchElementException: None.get
      */

    /**
      * 方式4-使用map4.getOrElse()取值
      *
      * getOrElse 方法 : def getOrElse[V1 >: V](key: K, default: => V1)
      * 说明：
      * 1.如果key存在，返回key对应的值。
      * 2.如果key不存在，返回默认值。在java中底层有很多类似的操作。
      */
    val map6 = mutable.Map(("A", 1), ("B", "北京"), ("C", 3))
    println(map6.getOrElse("A", "默认"))

    /**
      * 如何选择取值方式建议
      * 1.如果我们确定map有这个key ,则应当使用map(key), 速度快
      * 2.如果我们不能确定map是否有key ,而且有不同的业务逻辑，使用map.contains() 先判断在加入逻辑
      * 3.如果只是简单的希望得到一个值，使用map4.getOrElse("ip","127.0.0.1")
      */

    /**
      * 更新map的元素
      */
    val map7 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
    map7("AA") = 20
    println(map7)
    /**
      * 说明:
      *
      * 1.map 是可变的，才能修改，否则报错
      * 2.如果key存在：则修改对应的值,key不存在,等价于添加一个key-val
      */

    //添加map元素
  // 方式1-增加单个元素
    val map8 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
    map8 += ( "D" -> 4 )
    map8 += ( "B" -> 50 )
    println(map8)
    //方式2-增加多个元素
    val map51 = map8 + ("E"->1, "F"->3)
    map8 += ("EE"->1, "FF"->3)

    //删除map元素
    map8 -= ("A", "B")
    println("map8=" + map8)
    /**
      * 说明
      * 1."A","B" 就是要删除的key, 可以写多个.
      * 2.如果key存在，就删除，如果key不存在，也不会报错
      */

    //映射 Map-对map遍历
    //对map的元素(元组Tuple2对象 )进行遍历的方式很多，具体如下:
    val map9 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
    for ((k, v) <- map9) println(k + " is mapped to " + v)
    for (v <- map9.keys) println(v)
    for (v <- map9.values) println(v)
    for(v <- map9) println(v)//这样的取出类型是Tuple2
  }
}
