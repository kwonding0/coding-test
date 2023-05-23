package level2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cash {

    //1차[캐시]
    //https://school.programmers.co.kr/learn/courses/30/lessons/17680
    //String[] cacheList = new String[30];
    //List<String> cacheList = new ArrayList<String>();
    List<String> cacheList = new LinkedList<String>();

    public int solution(int cacheSize, String[] cities) {
        cacheList.addAll(Collections.nCopies(30, ""));
        int answer = 0;
        final int cacheHit = 1;
        final int cacheMiss = 5;

        if (cacheSize > 0) {
            for (String city : cities) {
                city = city.toLowerCase();
                int index = cacheList.indexOf(city);
                if (index != -1) { //cache hit
                    answer += cacheHit;
                    hit(index, city);
                } else { //cache miss
                    answer += cacheMiss;
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
            cacheList.set(i, cacheList.get(i - 1));
        }

        cacheList.set(0, city);
    }

    public void hit(int index, String city) {
        for (int i = index; i > 0; i--) {
            cacheList.set(i, cacheList.get(i - 1));
        }

        cacheList.set(0, city);
    }

}
