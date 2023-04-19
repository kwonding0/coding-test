package level1;

import java.util.HashSet;
import java.util.Set;

public class AddTwoPickupNum {

    //두 개 뽑아서 더하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/68644
    public int[] solution(int[] numbers) {
        Set<Integer> sum = new HashSet<Integer>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                sum.add(numbers[i] + numbers[i + j]);
            }
        }

        return sum.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
