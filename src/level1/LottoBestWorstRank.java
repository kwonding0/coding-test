package level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBestWorstRank {

    //로또의 최고 순위와 최저 순위
    //https://school.programmers.co.kr/learn/courses/30/lessons/77484
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int correctCnt = (int) Arrays.stream(lottos).filter(o -> list.contains(o)).count(); //정답과 맞는 숫자 개수

        answer[0] = findRank(correctCnt + (int) Arrays.stream(lottos).filter(o -> o == 0).count()); //최고 순위
        answer[1] = findRank(correctCnt); //최저 순위
        //System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));

        return answer;
    }

    //순위 구하기
    public int findRank(int correctCnt) {
        //System.out.println("correctCnt = " + correctCnt);
        switch (correctCnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
