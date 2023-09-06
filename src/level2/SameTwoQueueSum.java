package level2;

import java.util.LinkedList;
import java.util.Queue;

public class SameTwoQueueSum {

    //두 큐 합 같게 만들기
    //https://school.programmers.co.kr/learn/courses/30/lessons/118667
    public int solution(int[] queue1, int[] queue2) {
        long total = 0;
        long sum = 0;
        int answer = 0;
        int num = 0;

        Queue<Integer> queueOne = new LinkedList<>();
        Queue<Integer> queueTwo = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i];
            total += queue2[i];
            sum += queue1[i];
            queueOne.add(queue1[i]);
            queueTwo.add(queue2[i]);
        }
        total /= 2;

        while (answer <= queue1.length * 2 + 2) {
            if (total > sum) {
                num = queueTwo.poll();
                queueOne.offer(num);
                sum += num;
                answer++;
            } else if (total < sum) {
                num = queueOne.poll();
                queueTwo.offer(num);
                sum -= num;
                answer++;
            } else {
                return answer;
            }
        }
        return -1;
    }

    /*public static boolean canMakeSum(int[] numbers, float target) {
        return backtrack(numbers, target, 0, 0);
    }

    private static boolean backtrack(int[] numbers, float target, int currentIndex, int currentSum) {
        if (currentSum == target) {
            return true;
        }

        if (currentIndex >= numbers.length || currentSum > target) {
            return false;
        }

        // 현재 숫자를 선택하지 않는 경우
        if (backtrack(numbers, target, currentIndex + 1, currentSum)) {
            return true;
        }

        // 현재 숫자를 선택하는 경우
        return backtrack(numbers, target, currentIndex + 1, currentSum + numbers[currentIndex]);
    }
    public int solution(int[] queue1, int[] queue2) {
        IntStream stream1 = Arrays.stream(queue1);
        IntStream stream2 = Arrays.stream(queue2);
        int[] allNumbers = IntStream.concat(stream1, stream2).toArray();

        int answer = -2;
        long sum = Arrays.stream(queue1).sum() + Arrays.stream(queue2).sum();
        float targetNum = sum / 2;

        System.out.println("targetNum = " + targetNum);
        System.out.println("count = " + Arrays.stream(allNumbers).filter(o -> o > targetNum).count());
        System.out.println("canMakeSum = " + canMakeSum(allNumbers, targetNum));

        *//*target이 정수가 아니거나 target보다 큰 숫자가 존재하거나, 어떠한 조합으로도 target을 만들 수 없을 때는 -2 반환*//*
        if (sum % 2 != 0) {
            if (Arrays.stream(allNumbers).filter(o -> o > targetNum).count() > 0
                    || canMakeSum(allNumbers, targetNum)) {
                return answer;
            }
        }

        //최소 무빙 수 구하기
        Queue<Integer> queueOne = new LinkedList<>();
        Queue<Integer> queueTwo = new LinkedList<>();

        queueOne.addAll(Arrays.stream(queue1)
                .boxed()  // int -> Integer로 변환
                .collect(Collectors.toList())); // 리스트로 수집 후 추가

        queueTwo.addAll(Arrays.stream(queue2)
                .boxed()  // int -> Integer로 변환
                .collect(Collectors.toList())); // 리스트로 수집 후 추가

        float sum1 = 0;
        float sum2 = 1;
        while (sum1 != sum2) {


        }

        return answer;
    }*/
}
