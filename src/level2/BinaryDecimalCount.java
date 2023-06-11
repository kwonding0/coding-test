package level2;

public class BinaryDecimalCount {

    //k진수에서 소수 개수 구하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/92335
    public int solution(int n, int k) {
        int answer = 0;
        boolean isPrime = true;
        long num = 0;
        String[] split = Integer.toString(n, k).split("0");

        for (String s : split) {
            if (!s.isEmpty() && !s.equals("1")) {
                num = Long.parseLong(s);

                // i : num에 나눌 값, for문을 한 바퀴 돌 때마다 1씩 증가한다.
                // 변수 i를 num/2만큼만 반복하게 해서 반복횟수를 줄인다.
                for (int i = 2; i <= (int) Math.sqrt(num); i++) {
                    isPrime = true;
                    // 순차적으로 i를 num에 나누어본다.
                    if (num % i == 0) {
                        // num이 i로 나눠져 나머지가 0이 되면 isPrime에 false(소수가 아님)을 입력한다.
                        isPrime = false;
                        // 이미 1과 자기자신 외에 다른 수로도 나눠져 합성수임을 알았으므로 더 이상 반복하지 않고 빠져나온다.
                        break;
                    }
                }

                if (isPrime) answer++;
            }
        }

        return answer;
    }
}
