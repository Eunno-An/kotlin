//문제 아이디어를 잘 생각해보자
//숫자는 단 한번씩만 존재한다.
//그러면 0부터 9까지 더한 값에서 numbers의 합을 빼주면 될 것이다...

class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = -1
        answer = 0
        var arr: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        for(num in numbers)
        	arr[num]++
        	
        
        
        for(i in arr.indices)
        	if(arr[i] == 0)
            	answer += i
       
            
        return answer
    }
}
