package com.myq.learning.day6

import java.util

object AliasDemo {
  //给类取别名，在此范围类有效
  type MyMap = util.HashMap[String,String]
  val p = new MyMap
  p.put("aaa","bbbb")
  p.get("aaa")
}
