package level0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FuxxNumberThree {

    //저주의 숫자 3
    //https://school.programmers.co.kr/learn/courses/30/lessons/120871
    public int solution(int n) {
        int answer = 0;

        int[] arr = IntStream.rangeClosed(1, 200).toArray(); //1~200까지 배열 만들기
        arr = Arrays.stream(arr).filter(o -> o % 3 != 0 && !String.valueOf(o).contains("3")).toArray();
        answer = arr[n-1];

        return answer;


        /*int realNum = 1;
        int threeNum = 0;
        while(realNum <= n){ //실제 숫자(n)만큼 카운팅 될때까지
            threeNum++;
            if (threeNum % 3 != 0 && String.valueOf(threeNum).indexOf("3") == -1) { //3의 배수도 아니고 3도 포함되어 있지 않으면 3x 마을 숫자
                realNum++;
            }
        }
        System.out.println("threeNum = " + threeNum);
        return threeNum;*/
    }
}
