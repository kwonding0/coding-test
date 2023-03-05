package level0;

public class NextNumber {

    //다음에 올 숫자
    //https://school.programmers.co.kr/learn/courses/30/lessons/120924
    public int solution(int[] common) {
        int answer = 0;
        int cal = 0;
        int len = common.length;

        if(common[1]-common[0] == common[2]-common[1]){ //등차수열
            cal = common[1]-common[0];
            answer = common[len-1] + cal;
        }else{ //등비수열
            cal = common[1] / common[0];
            answer = common[len-1] * cal;
        }

        return answer;
    }
}
