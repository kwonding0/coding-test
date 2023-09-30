package level2;

import java.util.*;

public class SearchRank {
    //순위검색
    //https://school.programmers.co.kr/learn/courses/30/lessons/72412
    static Map<String, List<Integer>> searchMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        /**1.info들 돌며 info가 해당할 수 있는 모든 조건들 생성해놓기 **/
        for (String infoString : info) {
            String[] s = infoString.split(" ");
            makeConditions(s, "", 0);
        }

        /**2.이분탐색을 위해 점수 정렬해놓기**/
        for (String key : searchMap.keySet()) {
            Collections.sort(searchMap.get(key));
        }

        /**3.질문조건에 맞는 지원자 수 이분탐색**/
        for (int i = 0; i < query.length; i++) {
            String queryString = query[i];
            String[] q = queryString.replaceAll(" and ", "").split(" ");

            answer[i] = binarySearch(q);
        }

        return answer;
    }

    private void makeConditions(String[] s, String key, int i) {
        if (i == 4) {
            if (!searchMap.containsKey(key)) {
                List<Integer> list = new ArrayList<>();
                searchMap.put(key, list);
            }
            //map value로 점수 넣기
            searchMap.get(key).add(Integer.parseInt(s[4]));
            return;
        }
        makeConditions(s, key + "-", i + 1);
        makeConditions(s, key + s[i], i + 1);
    }

    private int binarySearch(String[] q) {
        String key = q[0];
        int score = Integer.parseInt(q[1]);
        List<Integer> scores = searchMap.get(key);
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2; //list size의 중간값부터 탐색 시작
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scores.size() - start;
    }

    /*public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        System.out.println("info = " + Arrays.toString(info));

        *//**1.개발팀 질문 list for문 돌리기**//*
        int i = 0;
        for (String question : query) {

            *//**2.질문 리스트 뽑기**//*
            String[] s = question.split(" and | ");

            *//**3.질문 조건에 만족하는 지원자 몇수 구하기**//*
            answer[i] = findApplicant(info, s);
            i++;
        }
        return answer;
    }

    private int findApplicant(String[] info, String[] s) {
        System.out.println("s = " + Arrays.toString(s));
        String q1 = s[0];
        String q2 = s[1];
        String q3 = s[2];
        String q4 = s[3];
        int score = Integer.parseInt(s[4]);
        int count = 0;

        //첫번째 조건
        count = (int) Arrays.stream(info).filter(o -> (q1.equals("-") || o.contains(q1))
                && (q2.equals("-") || o.contains(q2))
                && (q3.equals("-") || o.contains(q3))
                && (q4.equals("-") || o.contains(q4))
                && Integer.parseInt(o.substring(o.lastIndexOf(" ") + 1)) >= score).count();

        System.out.println("count = " + count);

        return count;
    }*/
}
