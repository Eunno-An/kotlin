mutableMap 선언 방법

```
var map = mutableMapOf<String, Int>()
```

mutabeMap의 value로 mutableSet을 선언해주는 방법.
이때, value에는 mutableSetOf<String>()이 아닌, MutableSet<String>이 들어간다.
```
var map = mutableMapOf<String, MutableSet<String>>()
```


map에 어떤 요소를 넣어주거나, 값을 수정할 때는 map.getOrDefault(key, 0)을 사용한다.

```
map[key] = map.getOrDefault(key, 0) + 1
```
  
map에 어떤 요소를 넣어줄 때, value가 collection일 경우,

```
var bucket = mutableMapOf<String, MutableSet<String>>()
bucket.computeIfAbsent(str[0]){mutableSetOf<String>()}.add(str[1])
```
  
  
map에서 특정 value들의 조건을 만족하는 key들만 뽑아내는 함수

```
var list = map.filterValues{it >= k}
```
  
  
groupBy
keySelector 함수에서 반환된 키로 그룹화하고, 각 그룹 키가 해당 요소 목록과 연결된 맵을 반환한다.
원래 요소의 순서를 그대로 갖고 있다!
```
val words = listOf("a", "abc", "ab", "def", "abcd")
val byLength = words.groupBy{it.length}
println(byLength.keys) // [1, 3, 2, 4]
println(byLength.values) // [[a], [abc, def], [ab], [abcd]]

val mutableByLength: MutableMap<Int, MutableList<String>> = words.groupByTo(mutableMapOf()){it.length}

```
  
