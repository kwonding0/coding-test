package level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddNoneNumber {

    //없는 숫자 더하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/86051
    public int solution(int[] numbers) {
        List<Integer> A = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        List<Integer> B = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());
        for (int i = 0; i < A.size(); i++) {
            B.remove(A.get(i));
        }

        return B.stream().mapToInt(Integer::intValue).sum();
    }
}
