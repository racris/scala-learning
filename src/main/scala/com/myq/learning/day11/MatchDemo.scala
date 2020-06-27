package com.myq.learning.day11

/**
  * 基本介绍
  *
  * Scala中的模式匹配类似于Java中的switch语法，但是更加强大。
  *
  * 模式匹配语法中，采用match关键字声明，每个分支采用case关键字进行声明，当需要匹配时，会从第一个case分支开始，
  * 如果匹配成功，那么执行对应的逻辑代码，如果匹配不成功，继续执行下一个分支进行判断。
  * 如果所有case都不匹配，那么会执行case _ 分支，类似于Java中default语句。
  */
object MatchDemo {
  def main(args: Array[String]): Unit = {
    // 模式匹配，类似于Java的switch语法
    val oper = '#'
    val n1 = 20
    val n2 = 10
    var res = 0
    oper match {
      case '+' => res = n1 + n2
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case _ => println("oper error")
    }
    println("res=" + res)

    /**
      * match的细节和注意事项
      *
      * 1.如果所有case都不匹配，那么会执行case _ 分支，类似于Java中default语句
      * 2.如果所有case都不匹配，又没有写case _ 分支，那么会抛出MatchError
      * 3.每个case中，不用break语句，自动中断case
      * 4.可以在match中使用其它类型，而不仅仅是字符
      * 5. => 等价于 java swtich 的 :
      * 6. => 后面的代码块到下一个 case， 是作为一个整体执行，可以使用{} 扩起来，也可以不扩。
      */
  }
}
