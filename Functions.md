함수의 기본형. 
기본으로는 Unit형을 반환한다. Unit은 Void와 같다고 생각하면 된다.
default parameter를 지정할 수도 있다.
```
fun printMessage(message: String): Unit{
  println(message)
}

fun printMessageWithPrefix(message: String = "Eunno", prefix: String="Info"){
    println("[$prefix] $message")
}

```

무언가를 반환하고 싶을 때는 parameter 뒤에다가 반환형을 놓으면 된다.
```
fun sum(x: Int, y: Int): Int{
    return x + y
}
```

단일 표현식 함수라고 해서, 이렇게 간단하게 하는 것도 가능하다
함수를 변수처럼 할당해서 사용하는 느낌이다.
```
fun sum(x: Int, y : Int): Int = x * y
```

**Infix Function(중위 함수)**
아까 단일 표현식 함수처럼 사용하지만, 이렇게 infix로 사용이 가능하다.
Int와 String 사이에 있는 함수라서 Infix, 중간에 위치해 있다고 해서 이렇게 부른다.
```
infix fun Int.times(str: String) = str.repeat(this)//여기서 this는 Int
println(2.times("Bye"))
println(2 times("Bye"))
println(2 times "Bye")
```

대표적인 infix function 중 표준 라이브러리에는 Pair와 to가 있다.
```
val pair = "Eunno" to "Noeun"

infix fun String.onto(other: String) = Pair(this, other)
val myPair = "Eunno" onto "Noeun"
println(myPair)
```

map을 이용할 때 자주 사용하는 패턴이기도 하다.
```
//val map: Map<String ,Int> = mapOf(Pair("Eunno", 25), Pair("Noeun", 21)) 
val map: Map<String, Int> = mapOf("Eunno" to 25, "Noeun" to 21) // 위 코드보다 훨씬 간결하다.
```

클래스 내에서 infix 함수를 사용할 때는, dispatcher가 클래스 자신이기 때문에 생략할 수 있다.
```
class Person{
    var name = "Default"
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person){likedPeople.add(other)}
    constructor(name: String) {
    	this.name = name
    }
}

fun main() {
   val kotlin = "🙂"
   println(kotlin)

   val p = Person("Kimse")
   val p1 = Person("Eunno")
   val p2 = Person("Noeun")
   val p3 = Person("Kayoung")
   p likes p1
   p likes p2
   p likes p3
   println(p.likedPeople[0])
   println(p.likedPeople[1])
   println(p.likedPeople[2])
	
}
```

만약 infix를 쓰지 않는다면?
p.likes(p1)
p.likes(p2)
p.likes(p3)
이렇게 해야 될것이다. 

**Operator functions**
특정 함수들은 operator로 변환될 수 있는데, 특정 심볼([0..14], *, 등등)로 대체가 가능하다.
```
operator fun Int.times(str: String) = str.repeat(this)
operator fun String.get(range: IntRange) = substring(range)
fun main() {
    val kotlin = "🙂"
    println(kotlin)
	
	  println(2 * "Bye")  
    val str= "Always forgive your enemies; nothing annoys them so much."
    val range: IntRange = IntRange(0, 14)
    println(str.substring(range))//Always Forgive
    println(str[0..14])//Always Forgive
}
```

**Functions with vararg**
vararg를 통해 parameter를 선언하면, 어떤 개수든 상관없이 파라미터를 넘길 수 있다. 자료형은 아니니까 유의하자
```
fun printAll(vararg messages: String) {                            // 1
    for (m in messages) println(m)
}
printAll("Hello", "Hallo", "Salut", "Hola", "你好") 
```
