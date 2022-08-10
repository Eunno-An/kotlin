//이상하게
/*
val lDist = abs(map[left]!!.first - map[num]!!.first) + abs(map[left]!!.second - map[num]!!.second)
                val rDist = abs(map[right]!!.first - map[num]!!.first) + abs(map[right]!!.second - map[num]!!.second)
이게 왜 에러가 날까
*/
import kotlin.math.abs
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val map: Map<Int, Pair<Int, Int>> = mapOf(1 to (0 to 0), 2 to (0 to 1), 3 to (0 to 2), 
                                       4 to (1 to 0), 5 to (1 to 1), 6 to (1 to 2),
                                       7 to (2 to 0), 8 to (2 to 1), 9 to(2 to 2),
                                       0 to (3 to 1))
        var left: Pair<Int, Int> = (3 to 0)
        var right: Pair<Int, Int> = (3 to 2)
        for(num in numbers){
            if(num == 1 || num == 4 || num == 7){
                answer += 'L'
                left = map[num]!!
            }else if(num == 3 || num == 6 || num == 9){
                answer += 'R'
                right = map[num]!!
            }else{
                val lDist = map[num]!!.distance(left)
                val rDist = map[num]!!.distance(right)
                if(lDist < rDist){
                    answer += 'L'
                    left = map[num]!!
                }else if(lDist > rDist){
                    answer += 'R'
                    right = map[num]!!
                }else{
                    if(hand == "left"){
                        answer += 'L'
                        left = map[num]!!
                    }else{
                        answer += 'R'
                        right = map[num]!!
                    }
                }
            }
        }
        return answer
    }
    private fun Pair<Int, Int>.distance(a: Pair<Int ,Int>) : Int{
        return abs(this.first - a.first) + abs(this.second - a.second)
    }
}
