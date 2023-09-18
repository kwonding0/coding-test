package level2;

import java.util.ArrayList;
import java.util.List;

public class EmojiDiscount {
    //이모티콘 할인행사
    //https://school.programmers.co.kr/learn/courses/30/lessons/150368

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

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
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
