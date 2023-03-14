package level0;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OverlapLineLength {

    //겹치는 선분의 길이
    //https://school.programmers.co.kr/learn/courses/30/lessons/120876
    public int solution(int[][] lines) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> temp2 = new ArrayList<Integer>();

        for (int i = 0; i < lines.length - 1; i++) {
            //start값 ~ end값까지 배열 생성
            temp = IntStream.rangeClosed(lines[i][0], lines[i][1]).boxed().collect(Collectors.toList());
            //다음 원소들 차례대로 start값 ~ end값까지 배열 생성 하며 중복값 카운팅
            for (int j = 1; j < lines.length - i; j++) {
                temp2 = IntStream.rangeClosed(lines[i + j][0], lines[i + j][1]).boxed().collect(Collectors.toList());
                temp2.retainAll(temp);

                //세 선분 모두 겹치는 부분 구하기
                if (i == 0) list = temp2;
                list.retainAll(temp2);

                answer += temp2.size() == 0 ? 0 : temp2.size() - 1; //중복값 개수 -1이 선분의 길이
            }
        }

        //세 선분 모두 겹치는 부분이 있다면 *2한만큼 빼서 중복제거
        answer = list.size() > 0 ? answer - (list.size() - 1) * 2 : answer;

        return answer;
    }
}
