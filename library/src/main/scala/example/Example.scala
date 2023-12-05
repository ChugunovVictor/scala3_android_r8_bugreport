package example

import java.util
import java.util.stream.Collectors

class Clazz(value_ : Int) {
  def value: Int = value_
}

// Works / if use collection of primitives / no actions with collection
//object Example:
//  def info1(): String = {
//    info2(Seq(123))
//    "info1"
//  }
//  def info2(values: Seq[Int]): String = "123"

// Works / if use collection of primitives / some actions with collection
//object Example:
//  def info1(): String = {
//    info2(Seq(123))
//    "info1"
//  }
//  def info2(values: Seq[Int]): String = values.mkString(",")

// Works / if use collection of entities / no actions with collection
//object Example:
//  def info1(): String = {
//    info2(Seq(new Clazz(123)))
//    "info1"
//  }
//  def info2(values: Seq[Clazz]): String = "123"

// Fail / if use collection of entities / some actions with collection
//
//AGPBI: {"kind":"error","text":"com.android.tools.r8.internal.y10: Enforced and erased signatures are inconsistent in CallSite: { Name: apply, Proto: Proto LL scala.Function1 example.Static$, MethodHandle: {INVOKE_STATIC, java.lang.invoke.CallSite java.lang.invoke.LambdaMetafactory.altMetafactory(java.lang.invoke.MethodHandles$Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[])}, Args: Item METHOD_TYPE Proto LL java.lang.Object java.lang.Object, Item METHOD_HANDLE MethodHandle: {INVOKE_DIRECT, int example.Static$.info2$$anonfun$1(example.Clazz)}, Item METHOD_TYPE Proto IL int example.Clazz, Int 5, Int 1, Item METHOD_TYPE Proto IL int example.Clazz}","sources":[{}],"tool":"R8"}
//com.android.tools.r8.internal.y10: Enforced and erased signatures are inconsistent in CallSite: { Name: apply, Proto: Proto LL scala.Function1 example.Static$, MethodHandle: {INVOKE_STATIC, java.lang.invoke.CallSite java.lang.invoke.LambdaMetafactory.altMetafactory(java.lang.invoke.MethodHandles$Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[])}, Args: Item METHOD_TYPE Proto LL java.lang.Object java.lang.Object, Item METHOD_HANDLE MethodHandle: {INVOKE_DIRECT, int example.Static$.info2$$anonfun$1(example.Clazz)}, Item METHOD_TYPE Proto IL int example.Clazz, Int 5, Int 1, Item METHOD_TYPE Proto IL int example.Clazz}
object Example:
  def info1(): String = {
    info2(Seq(new Clazz(123)))
    "info1"
  }
  def info2(values: Seq[Clazz]): String = values.map(_.value).mkString(",")

// Fail / if use collection of entities from non static context / some actions with collection
//class Example:
//  def info1(): String = {
//    info2(Seq(new Clazz(123)))
//    "info1"
//  }
//  def info2(values: Seq[Clazz]): String = values.map(_.value).mkString(",")

// Works / if use java collection of entities / some actions with collection
//object Example:
//  def info1(): String = {
//    val a = new util.ArrayList[Clazz]()
//    a.add(new Clazz(123))
//    info2(a)
//
//    "info1"
//  }
//
//  def info2(values: java.util.List[Clazz]): String = values.stream()
//    .map(_.value.toString)
//    .collect(Collectors.joining(","))
















