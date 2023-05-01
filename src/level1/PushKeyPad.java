package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class PushKeyPad {

    //키패드 누르기
    //https://school.programmers.co.kr/learn/courses/30/lessons/67256
    ArrayList<Integer> left = new ArrayList<>(Arrays.asList(1, 4, 7, 10));
    ArrayList<Integer> both = new ArrayList<>(Arrays.asList(2, 5, 8, 0));
    ArrayList<Integer> right = new ArrayList<>(Arrays.asList(3, 6, 9, 12));
    int[] leftNum = {0, 3};
    int[] rightNum = {2, 3};
    int num = 0;
    StringBuilder answer = new StringBuilder();

    public String solution(int[] numbers, String hand) {

        for (int i = 0; i < numbers.length; i++) {
            num = numbers[i];
            if (left.contains(num)) {
                rememberNum("left", false);
            } else if (right.contains(num)) {
                rememberNum("right", false);
            } else { //중간 부분
                int lDistance = Math.abs(leftNum[0] - 1) + Math.abs(leftNum[1] - both.indexOf(num)); //왼손이랑 거리
                int rDistance = Math.abs(rightNum[0] - 1) + Math.abs(rightNum[1] - both.indexOf(num)); //오른손이랑 거리

                if (rDistance > lDistance) { //왼쪽이랑 가까울때
                    rememberNum("left", true);
                } else if (rDistance < lDistance) { //오른쪽이랑 가까울때
                    rememberNum("right", true);
                } else {
                    if (hand.equals("left")) rememberNum("left", true);
                    else rememberNum("right", true);
                }
            }
        }

        return answer.toString();
    }

    private void rememberNum(String hand, boolean bothYn) {
        if (bothYn) {
            if (hand.equals("left")) {
                answer.append("L");
                leftNum[0] = 1;
                leftNum[1] = both.indexOf(num);
            } else {
                answer.append("R");
                rightNum[0] = 1;
                rightNum[1] = both.indexOf(num);
            }
        } else {
            if (hand.equals("left")) {
                answer.append("L");
                leftNum[0] = 0;
                leftNum[1] = left.indexOf(num);
            } else {
                answer.append("R");
                rightNum[0] = 2;
                rightNum[1] = right.indexOf(num);
            }
        }
    }
}
