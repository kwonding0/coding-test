package level2;

import javafx.util.Pair;

import java.util.*;

public class EmojiDiscount {
    //이모티콘 할인행사
    //https://school.programmers.co.kr/learn/courses/30/lessons/150368

    static Set<Pair<Integer, Integer>> plusCntPrice = new HashSet<>(); //이모티콘 플러스 수, 총 가격 넣어놓을 set
    static List<int[]> prices = new ArrayList<>(); //할인율 조합 넣어놓을 list

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        /**1.4^이모티콘 개수 나올 수 있는 모든 할인조합 구하기**/
        findOptimalCombination(emoticons, 0, emoticons.length, new int[emoticons.length]);

        /**3.만들어진 조합대로 이모티콘 플러스 및 가격 구하기**/
        for (int i = 0; i < prices.size(); i++) {
            int[] price = prices.get(i);
            calPlusCntPrice(users, emoticons, price);
        }

        /**4.목표 우선순위대로 (1.이모티콘 플러스 구독자 늘리기, 2.이모티콘 매출액을 최대한 늘리기) 목적을 최대한으로 달성했을 때의 값 구하기**/
        Optional<Pair<Integer, Integer>> maxPair = plusCntPrice.stream()
                .max(Comparator.comparing((Pair<Integer, Integer> p) -> p.getKey())
                        .thenComparing((Pair<Integer, Integer> p) -> p.getValue()));

        if (maxPair.isPresent()) {
            Pair<Integer, Integer> result = maxPair.get();
            answer[0] = result.getKey();
            answer[1] = result.getValue();
        }

        return answer;
    }

    private void findOptimalCombination(int[] emoticons, int idx, int size, int[] price) {
        if (size == idx) {
            /**2.만들어진 조합 list에 넣기**/
            int[] temp = new int[price.length];
            System.arraycopy(price, 0, temp, 0, price.length);
            prices.add(temp);
            return;
        }

        for (int i = 10; i <= 40; i += 10) {
            price[idx] = i;
            findOptimalCombination(emoticons, idx + 1, size, price);
        }
    }

    public void calPlusCntPrice(int[][] users, int[] emoticons, int[] price) {
        int emoziPlus = 0;
        int allPrice = 0;
        for (int[] user : users) {
            int totalPrice = 0;
            int rate = user[0]; //할인비율
            int maxPrice = user[1]; //최대금액

            for (int j = 0; j < price.length; j++) {
                if (rate <= price[j]) { //내가 사기로한 비율보다 할인을 많이 하면 구매
                    totalPrice += (emoticons[j] * ((100 - price[j]) * 0.01));
                }
                if (totalPrice >= maxPrice) { //이모티콘 구입 합산가격이 내 기준 최대가격 이상이면 이모티콘 플러스로 전환
                    emoziPlus++; //이모티콘 플러스 유저 수 추가
                    totalPrice = 0; //지금까지 구입한 이모티콘 구입 취소
                    break;
                }
            }

            allPrice += totalPrice; //모든 유저 전체 금액에 합산
        }
        plusCntPrice.add(new Pair<>(emoziPlus, allPrice));
    }
}
