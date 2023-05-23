package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewsClustering {

    //[1차] 뉴스 클러스터링
    //https://school.programmers.co.kr/learn/courses/30/lessons/17677
    public int solution(String str1, String str2) {
        final int jacard = 65536;
        int count = 0;
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        //두글자씩 나누고 영어만 남기고 대문자로 치환
        List<String> str1AList = Arrays.stream(str1.split("(?<=\\G..)")).collect(Collectors.toList());
        List<String> str1BList = Arrays.stream(str1.substring(1).split("(?<=\\G..)")).collect(Collectors.toList());
        str1AList.addAll(str1BList);
        List<String> str2AList = Arrays.stream(str2.split("(?<=\\G..)")).collect(Collectors.toList());
        List<String> str2BList = Arrays.stream(str2.substring(1).split("(?<=\\G..)")).collect(Collectors.toList());
        str2AList.addAll(str2BList);

        for (String s : str1AList) {
            if (s.replaceAll("[^A-Z]", "").length() == 2) {
                count = map1.containsKey(s) ? map1.get(s) : 0;
                map1.put(s, ++count);
            }
        }

        for (String s : str2AList) {
            if (s.replaceAll("[^A-Z]", "").length() == 2) {
                count = map2.containsKey(s) ? map2.get(s) : 0;
                map2.put(s, ++count);
            }
        }

        //합집합 구하기
        float union = unionCount(map1, map2);
        //교집합 구하기
        float interSec = intersecCount(map1, map2);

        answer = union == 0.0 ? jacard : (int) ((interSec / union) * jacard);
        return answer;
    }

    public long unionCount(Map<String, Integer> mapOne, Map<String, Integer> mapTwo) {
        Map<String, Integer> map1 = new HashMap<>(mapOne);
        Map<String, Integer> map2 = new HashMap<>(mapTwo);
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> Math.max(v1, v2)));
        return map1.values().stream().reduce(0, Integer::sum);
    }

    public long intersecCount(Map<String, Integer> mapOne, Map<String, Integer> mapTwo) {
        Map<String, Integer> map1 = new HashMap<>(mapOne);
        Map<String, Integer> map2 = new HashMap<>(mapTwo);
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> Math.min(v1, v2)));
        map1.entrySet().removeIf(entry ->
                !mapOne.containsKey(entry.getKey()) || !mapTwo.containsKey(entry.getKey()));
        return map1.values().stream().reduce(0, Integer::sum);
    }

}
