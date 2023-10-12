package level2;

public class DeliveryService {
    // 택배 배달과 수거하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/150369
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int cnt = 0;
        long deliveryCnt = 0;
        long pickupCnt = 0;
        //제일 먼 집부터 수거 및 배달 하기
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                cnt = 0;
                while (deliveries[i] > deliveryCnt || pickups[i] > pickupCnt) { //배달 및 픽업이 남아있을때까지 진행
                    deliveryCnt += cap;
                    pickupCnt += cap;

                    cnt++;
                }
                deliveryCnt -= deliveries[i];
                pickupCnt -= pickups[i];
                answer += (long) (i + 1) * cnt * 2;
            }
        }

        return answer;
    }
}

