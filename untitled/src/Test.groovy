/**
 * @auther: kai2.wang* @date: 2019/9/23 10:37
 * @description:
 * @version: 1.0
 */


//def aa='test'
//println aa.class
//
//for (int i = 0; i < 10; i++) {
//    println('this is frist Data ->'+i)
//}

//for (i in 1..10){
//    println i
//}
//
//1.upto(3){
//    println it
//}
//
//3.downto(1){
//    println it
//}

//String s="123"
//switch (s){
//    case "123":
//        println "字符串"
//        break
//    case "1234":
//        println "数字"
//        break
//    default:
//        println "error"
//}


// 闭包
//def clouser={
//    println "hello0"
//    return "Test"
//}


//
//println clouser.call()
//
//def colusere2={ name -> println "hellow ${name}"}
//colusere2("aa")


//字符串
String str = "the 2 and 5 is 7"
//str.each { def temp->println temp}

//println str.find{
//    def temp->temp.isNumber()
//}

//def list=str.findAll{
//    String s->s.isNumber()
//}
//println list.toListString()

//def anyResult=str.any{
//    String temp -> temp.isNumber()
//}
//println anyResult

//
//def everyOne=str.every{
//    def temp -> temp.isNumber()
//}
//print everyOne

def collect=str.collect{
    def temp -> temp.toUpperCase()
}
println(collect.toListString())




