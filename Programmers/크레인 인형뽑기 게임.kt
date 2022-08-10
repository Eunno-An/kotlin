//Array는 mutable이다. 그러나 remove를 지원하지 않는다.!!!
//List는 unmutable이다.
//하지만 mutableList는 mutable이다!

//java.util을 import하여 Stack을 사용할 수 있다.
class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var temp: MutableList<Int> = mutableListOf();
        for(m in moves){
            for(i in 0..board.size-1){
                val t = board[i][m-1]
                if(t == 0)
                    continue;
                if(t != 0){
                    if(temp.isEmpty() || temp.last() != t)
                        temp += t
                    else{
                        answer += 2
                        temp.removeLast()
                    }
                    board[i][m-1]=0
                    break
                }
                
                    
            }
            // println(temp.toList())
        }
        
        return answer
    }
}
