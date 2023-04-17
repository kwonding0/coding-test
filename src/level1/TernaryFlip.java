package level1;

public class TernaryFlip {

    //3진법 뒤집기
    //https://school.programmers.co.kr/learn/courses/30/lessons/68935
    public int solution(int n) {
        int answer = 0;
        String ternary = Integer.toString(n, 3);

        // 문자열 reverse
        //StringBuffer = 쓰레드 safe (멀티쓰레드 지원)
        StringBuilder sb = new StringBuilder(ternary);
        answer = Integer.parseInt(sb.reverse().toString(), 3);

        return answer;

        //stringbuffer = new()

        // thread(2){
        // sb +="20"
        //}
        // println(sb) <- 2020
        // 2020 이 나올수도있고, 20이 나올수도있어


        // sb = ""
        // for(int i=0; i<2;i++){
        // sb+="20"
        //}
        //"2020" <-
    }
}
