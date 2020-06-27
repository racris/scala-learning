package com.myq.learning.day6

import scala.beans.BeanProperty

class PackageImportDemo {

}

class User {
  import scala.beans.BeanProperty
  @BeanProperty var  name : String = ""
  def test(): Unit = {
    //可以使用选择器，选择引入包的内容
    import scala.collection.mutable.{HashMap, HashSet}
    var map = new HashMap()
    var set = new HashSet()
  }

  def test2(): Unit ={
    //将HashMap重命名为JavaHashMap，仅在此范围类有效
    import java.util.{ HashMap=>JavaHashMap, List}
    import scala.collection.mutable._
    var map = new HashMap() // 此时的HashMap指向的是scala中的HashMap
    var map1 = new JavaHashMap(); // 此时使用的java中hashMap的别名

  }

}
class Dog {
  @BeanProperty var  name : String = "" //可以吗?
}


/**
  * Scala引入包的细节和注意事项:
  * 1.在Scala中，import语句可以出现在任何地方，并不仅限于文件顶部，import语句的作用一直延伸到包含该语句的块末尾。
  *   这种语法的好处是：在需要时在引入包，缩小import 包的作用范围，提高效率。
  * 2.Java中如果想要导入包中所有的类，可以通过通配符*，Scala中采用下 _
  * 3.如果不想要某个包中全部的类，而是其中的几个类，可以采用选取
  * def test(): Unit = {
  *   import scala.collection.mutable.{HashMap, HashSet}
  *   var map = new HashMap()
  *   var set = new HashSet()
  * }
  * 4.如果引入的多个包中含有相同的类，那么可以将不需要的类进行重命名进行区分，这个就是重命名。
  *     import java.util.{ HashMap=>JavaHashMap, List}
  *     import scala.collection.mutable._
  *     var map = new HashMap() // 此时的HashMap指向的是scala中的HashMap
  *     var map1 = new JavaHashMap(); // 此时使用的java中hashMap的别名
  * 5.如果某个冲突的类根本就不会用到，那么这个类可以直接隐藏掉。
  *     import java.util.{ HashMap=>_, _} // 含义为 引入java.util包的所有类，但是忽略 HahsMap类.
  *     var map = new HashMap() // 此时的HashMap指向的是scala中的HashMap, 而且idea工具，的提示也不会显示java.util的HashMaple
  */