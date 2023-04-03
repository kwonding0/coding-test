package level1;

public class KnightWeapon {

    //기사단원의 무기
    //https://school.programmers.co.kr/learn/courses/30/lessons/42862
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int temp = 0;

        for (int i = 1; i <= number; i++) { //약수 개수 구하기
            temp = 0;
            for (int j = 1; j * j <= i; j++) { //숫자의 반만 구해도 모든 약수의 개수를 파악 가능(알고리즘)
                if (j * j == i) temp++; //같은 수를 두번 곱했을 때 숫자가 나오면 약수를 하나 카운팅
                else if (i % j == 0) { //ex : 10의 약수는 1,2,5,10 10의 약수가 2인걸 알았다면 나머지 하나는 10을 2로 나눴을 때 몫인 5가 무조건 약수가 됨. 따라서 두개 합산
                    temp += 2;
                }
            }
            if (temp > limit) answer += power; //limit 보다 약수 개수가 크면 제한공격력으로 합산
            else answer += temp;
        }

        return answer;
    }
}
