//다른 풀이들
class Solution {
    fun solution(s: String): Int {
        val numSet = 
        arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var str = s
        
        for((i, n) in numSet.withIndex()){
            println(i)//0, 1, 2, ...
            println(n)//zero, one, two, ...
            str = str.replace(n, i.toString())//n을 i.toString()으로 바꾼다. 그걸 다시 str에 할당.
            println(str)
        }
        return str.toInt()
    }
}
//내풀이
class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        
        var map: Map<String, Int> = mapOf("zero" to 0, "one" to 1, "two" to 2, 
                                          "three" to 3, "four" to 4, "five" to 5, 
                                          "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
        var i = 0
        while(i < s.length){
            answer *= 10;
            if(s[i].isDigit()){
            	answer += Character.getNumericValue(s[i])
            	i++
            }
            else{
                var size3 : String = ""
                var size4 : String = ""
                var size5 : String = ""
                if(i+2 < s.length){
                	size3 = s.substring(i, i+3)
                    if(map.containsKey(size3)){
                        answer += map[size3]!!
                        i+=3
                        continue;
                    }
                }
                if(i+3 < s.length){
                	size4 = s.substring(i, i+4)
                	if(map.containsKey(size4)){
                        answer += map[size4]!!
                        i+=4
                        continue;
                    }
                }
                if(i+4 < s.length){
                	size5 = s.substring(i, i+5)
                	if(map.containsKey(size5)){
                        answer += map[size5]!!
                        i+=5
                        continue;
                    }
                }
            }
            
        }
        return answer
    }
}
