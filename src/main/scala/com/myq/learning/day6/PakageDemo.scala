package com.myq.learning.day6{

  /**
    * 包对象
    * 包对象底层实现机制分析：
    * 1.当创建包对象后，在该包下生成 public final class package 和 public final class package$
    * 2.通过 package$ 的一个静态实例完成对包对象中的属性和方法的调用。
    */
  package object demo{
    /**
      * 包可以包含类、对象和特质trait，但不能包含函数/方法或变量的定义。这是Java虚拟机的局限。
      * 为了弥补这一点不足，scala提供了包对象的概念来解决这个问题。
      * 包对象的注意事项:
      * 1.每个包都可以有一个包对象。你需要在父包中定义它。
      * 2.包对象名称需要和包名一致，一般用来对包的功能补充
      */
    val name = "hello"  //属性和方法可以直接在对应的包中直接使用
    def say(): Unit ={
      println("say")
    }
  }

  package demo{
    class TestDemo{

    }
  }
  class PakageDemo {

  }
}

/**
  * 包的创建方式，scala可以用以上方式创建
  * Scala包注意事项和使用细节：
  * 1.scala进行package 打包时，可以有如下形式
  *   1）package com.atguigu.scala
  *   2）package com.atguigu
  *     package scala
  *  3）package com.atguigu{
  *     package scala{
  *     }
  *  }
  * 2.包也可以像嵌套类那样嵌套使用（包中有包）, 这个在前面的第三种打包方式已经讲过了，在使用第三种方式时的好处是：程序员可以在同一个文件中，
  * 将类(class / object)、trait 创建在不同的包中，这样就非常灵活了
  * 3.作用域原则：可以直接向上访问。即: Scala中子包中直接访问父包中的内容, 大括号体现作用域。(提示：Java中子包使用父包的类，需要import)。
  * 在子包和父包 类重名时，默认采用就近原则，如果希望指定使用某个类，则带上包名即可。
  * 4.父包要访问子包的内容时，需要import对应的类等
  * 5.可以在同一个.scala文件中，声明多个并列的package(建议嵌套的pakage不要超过3层)
  * 6.包名可以相对也可以绝对，比如，访问BeanProperty的绝对路径是：_root_. scala.beans.BeanProperty ，
  * 在一般情况下：我们使用相对路径来引入包，只有当包名冲突时，使用绝对路径来处理。
  */



