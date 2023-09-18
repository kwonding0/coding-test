package level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class CandidateKey {
    //후보키
    //https://school.programmers.co.kr/learn/courses/30/lessons/42890

    private static List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generate(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            // 현재 조합을 결과에 추가
            result.add(new ArrayList<>(current));
            return;
        }

        // 현재 숫자를 선택하지 않는 경우
        generate(nums, index + 1, current, result);

        // 현재 숫자를 선택하는 경우
        current.add(nums[index]);
        generate(nums, index + 1, current, result);
        current.remove(current.size() - 1); // 다음 경우를 위해 선택한 숫자를 제거
    }

    private static boolean isMinKey(List<List<Integer>> a, List<Integer> b) {
        for (List<Integer> list : a) {
            if (list.stream().allMatch(b::contains)) { //a List들 중에 모든값이 b에 들어있는지 확인 => 들어있으면 최소성이 접합하지 않음
                return false;
            }
        }
        return true;
    }

    public int solution(String[][] relation) {
        int answer = 0;
        List<List<Integer>> candidateKeys = new ArrayList<>();
        int[] numbers = IntStream.rangeClosed(0, relation[0].length - 1).toArray(); //후보키 조합을 위해 컬럼수에 맞게 index 구해놓기

        /**1.후보키를 1개~n개까지 모든 n개 컬럼(index)조합 구하기 (ex : 1~3 => 1,2,3,(1,2),(1,3),(1,2,3) **/
        List<List<Integer>> combinations = generateCombinations(numbers);
        combinations.sort(Comparator.comparingInt(List::size));

        for (List<Integer> indexs : combinations) {
            /**2.최소성도 만족하기 위해 이미 후보키로 뽑힌 키가 있는 조합인지 확인**/
            if (!isMinKey(candidateKeys, indexs)) {
                continue;
            }
            /**3.모든 튜플값 확인하며 유일성 확인**/
            if (indexs != null && isOnlyKey(indexs, relation)) {
                //유일성, 최소성 모두 만족하면 후보키!
                answer++;
                candidateKeys.add(indexs);
            }
        }
        return answer;
    }

    private boolean isOnlyKey(List<Integer> indexs, String[][] relation) {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < relation.length; i++) {
            String s = "";
            for (int index : indexs) {
                s += relation[i][index]; //후보키값들 다 합쳐서 list에 넣기
            }
            keys.add(s);
        }

        //중복되는 값이 있음 -> 후보키 아님
        return keys.size() == keys.stream().distinct().count();
    }
}
