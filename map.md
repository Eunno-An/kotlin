mutableMap 선언 방법

'''
var map = mutableMapOf<String, Int>()
'''

mutabeMap의 value로 mutableSet을 선언해주는 방법.
이때, value에는 mutableSetOf<String>()이 아닌, MutableSet<String>이 들어간다.
'''
var map = mutableMapOf<String, MutableSet<String>>()
'''


map에 어떤 요소를 넣어주거나, 값을 수정할 때는 map.getOrDefault(key, 0)을 사용한다.

'''
map[key] = map.getOrDefault(key, 0) + 1
'''

map에서 특정 value들의 조건을 만족하는 key들만 뽑아내는 함수

'''
var list = map.filterValues{it >= k}
'''