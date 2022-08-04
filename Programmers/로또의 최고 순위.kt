내 풀이
class Solution{
    fun solution(lottos: IntArray, win_nums:IntArray):IntArray{
        var answer: IntArray = IntArray(2){0}
        var map: Map<Int, Int> = mapOf(6 to 1, 5 to 2, 4 to 3, 3 to 4, 2 to 5, 1 to 6, 0 to 6)
        var zeroCount: Int = lottos.count{it == 0}
        var wins: MutableSet<Int> = mutableSetOf()
        var correctCount: Int = lottos.intersect(win_nums.toList()).toIntArray().size
        //println(correctCount)
        answer[0] = map[minOf(zeroCount+correctCount, 6)]!!
        answer[1] = map[correctCount]!!
        
        
        return answer
    }
}

다른 풀이
class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        return intArrayOf(
            7 - lottos.filter{ win_nums.contains(it) || it == 0 }.size,
            7 - lottos.filter{ win_nums.contains(it) }.size
        ).map{ if(it > 6) 6 else it }.toIntArray()
    }
}
출처: https://yline.tistory.com/118 [Y_LINE's_Repository:티스토리]
