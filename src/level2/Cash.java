package level2;

import java.util.Arrays;

public class Cash {

    //1차[캐시]
    //https://school.programmers.co.kr/learn/courses/30/lessons/17680
    String[] cacheList = new String[30];

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        final int cacheHit = 1;
        final int cacheMiss = 5;
        String[] cities2 = Arrays.stream(cities).map(o -> o.toLowerCase()).toArray(String[]::new);

        if (cacheSize > 0) {
            for (String city : cities2) {
                int index = Arrays.asList(cacheList).indexOf(city);
                if (index != -1) { //cache hit
                    answer++;
                    hit(index, city);
                } else { //cache miss
                    answer += 5;
                    add(cacheSize - 1, city);
                }
            }
        } else {
            answer = cities.length * cacheMiss;
        }


        return answer;
    }

    public void add(int cacheSize, String city) {
        for (int i = cacheSize; i > 0; i--) {
            cacheList[i] = cacheList[i - 1];
        }

        cacheList[0] = city;
    }

    public void hit(int index, String city) {
        for (int i = index; i > 0; i--) {
            cacheList[i] = cacheList[i - 1];
        }

        cacheList[0] = city;
    }

}
