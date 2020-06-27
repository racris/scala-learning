package com.myq.learning.day9

import scala.collection.mutable.ArrayBuffer

/**
  * 定长数组与变长数组的转换
  *
  * arr1.toBuffer  //定长数组转可变数组
  * arr2.toArray  //可变数组转定长数组
  *
  * 说明：
  * 1.arr2.toArray 返回结果才是一个定长数组， arr2本身没有变化
  * 2.arr1.toBuffer返回结果才是一个可变数组， arr1本身没有变化
  */
object ArrayBetweenBuffer {
  val arr2 = ArrayBuffer[Int]()
  // 追加值
  arr2.append(1, 2, 3)
  println(arr2)

  val newArr = arr2.toArray
  println(newArr)

  val newArr2 = newArr.toBuffer
  newArr2.append(123)
  println(newArr2)

}
