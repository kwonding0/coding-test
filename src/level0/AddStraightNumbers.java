package level0;

import java.util.Arrays;

public class AddStraightNumbers {

    //연속된 수의 합
    //https://school.programmers.co.kr/learn/courses/30/lessons/120923
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int x = (total - sumN(num-1)) / num;  //시작값 구하기

        for(int i = 0; i < num; i++){
            answer[i] = x+i;
        }

        //System.out.println("sumN = " + sumN(num-1));
        //System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }

    public int sumN(int n){ //n번만큼 1씩 증가되는 숫자 더하기 ( 1+2+3+4.... )
        if(n==0) return 0;
        else if(n==1) return 1;  //더이상 쪼개지지 않는 지점에서 값을 반환합니다.
        return sumN(n-1)+n;
    }

    /*public int sumN(int n) {
        int i = 0;
        int sum = 0;
        while (i <= n){
            sum = sum+i;
            i++;
        }
        return sum;
    }*/
}
