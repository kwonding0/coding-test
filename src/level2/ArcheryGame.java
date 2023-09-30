package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArcheryGame {
    //양궁게임
    //https://school.programmers.co.kr/learn/courses/30/lessons/92342
    static List<int[]> lionList = new ArrayList<>();
    static int[] lion = new int[11];
    static int maxDiff = -1;

    public int[] solution(int n, int[] info) {
        makeCase(info, n, 0, 0);

        if (lionList.size() == 0) {
            return new int[]{-1};
        }

        //정답 list 정렬
        Collections.sort(lionList, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        return lionList.get(0);
    }

    private void makeCase(int[] info, int n, int cnt, int start) {
        if (cnt == n) { //lion 배열 완성 시
            //라이언이 이겼고, 지금까지 점수차이 중 가장 큰 차이이면 list에 넣기
            isWin(info);
            return;
        }

        for (int i = start; i < 11; i++) {
            if (info[i] < lion[i]) continue; //라이언이 이미 어피치보다 많이 쐇다면 더이상 그 칸을 맞추지 않게 처리
            lion[i]++; //라이언이 맞춘 개수 늘리기
            makeCase(info, n, cnt + 1, i); //해당 점수칸은 계산 끝났기 때문에 cnt + 1 한채로 재귀 다시 돌리기
            lion[i]--; //이건왜..?
        }
    }

    private void isWin(int[] info) {
        int aSum = 0;
        int rSum = 0;

        /**1.양궁 점수계산**/
        for (int i = 0; i < 11; i++) {
            if (lion[i] > 0 || info[i] > 0) { //라이온, 어피치 둘다 한발 이상 쐈으면 점수 체크
                if (lion[i] > info[i]) { //라이온이 같은점수에 더 많이 쐈으면
                    rSum += 10 - i;
                } else {
                    aSum += 10 - i;
                }
            }
        }

        /**2.점수차이 확인 해서 기존보다 점수차이가 클경우는 정답 list에 하나만 넣기.
         * 같을 경우는 나중에 적은 점수를 더 많이 맞춘 경우를 비교하기 위헤 정답 list에 추가하기**/
        if (rSum > aSum) { //라이언 점수가 어피치보다 크면
            int diff = rSum - aSum;
            if (maxDiff < diff) { //점수차이가 기존 경우보다 더 크면 list 초기화
                lionList.clear();
                maxDiff = diff;
                lionList.add(lion.clone());
            } else if (maxDiff == diff) {
                lionList.add(lion.clone());
            }
        }
    }
}
