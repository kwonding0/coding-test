package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GymSuit {

    //체육복
    //https://school.programmers.co.kr/learn/courses/30/lessons/42862
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> lostList = Arrays.stream(lost).sorted().boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).sorted().boxed().collect(Collectors.toList());
        List<Integer> jungbok = new ArrayList<Integer>(reserveList);

        //중복 제거
        jungbok.retainAll(lostList);
        lostList.removeAll(jungbok);
        reserveList.removeAll(jungbok);

        for (int lostStudent : lostList) {
            if (reserveList.contains(lostStudent - 1)) {
                reserveList.remove(Integer.valueOf(lostStudent - 1));
                answer++;
            } else if (reserveList.contains(lostStudent + 1)) {
                reserveList.remove(Integer.valueOf(lostStudent + 1));
                answer++;
            }
        }

        return n - (lostList.size() - answer);
    }
}
