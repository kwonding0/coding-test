package level2;

import java.util.*;

public class MenuRenewal {
    //메뉴 리뉴얼
    //https://school.programmers.co.kr/learn/courses/30/lessons/72411
    public String[] solution(String[] orders, int[] course) {
        TreeSet<String> ts = new TreeSet<String>(); //자동정렬을 위한 treeSet사용

        /**1.주문 알파벳순으로 정렬 (코스를 알파벳 숫서대로 하기위함 )**/
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        /**2.코스 개수대로 코스를 구하기 위해 for문 돌림**/
        for (int i = 0; i < course.length; i++) {
            Map<String, Integer> courseMap = new HashMap<>();
            List<String> courseList = new ArrayList<>();

            /**3.order에서 course수의 모든 조합 찾아서 List에 넣기**/
            for (int j = 0; j < orders.length; j++) {
                String order = orders[j];
                generateCombinations(order, "", course[i], courseList);
            }

            /**4.course수의 모든 조합 Map에 넣으면서 카운팅**/
            countingCourse(courseMap, courseList);

            /**5.최대 중복 코스 찾기**/
            courseMap.entrySet().removeIf(entry -> entry.getValue() < 2); //최소 2번이상 중복된 코스만 코스로 선정될 수 있음.
            if (!courseMap.isEmpty()) {
                findMaxCourse(courseMap, ts);
            }
        }

        return ts.toArray(new String[ts.size()]);
    }

    private void generateCombinations(String input, String combination, int length, List<String> courseList) {
        if (length == 0) {
            courseList.add(combination);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            generateCombinations(input.substring(i + 1), combination + input.charAt(i), length - 1, courseList);
        }
    }

    private void countingCourse(Map<String, Integer> courseMap, List<String> courseList) {
        int count = 0;
        for (String s : courseList) {
            count = courseMap.containsKey(s) ? courseMap.get(s) : 0; //코스별 개수 counting해서 map에 넣어주
            courseMap.put(s, ++count);
        }
    }

    private void findMaxCourse(Map<String, Integer> courseMap, TreeSet<String> ts) {
        int maxCnt = Collections.max(courseMap.values()); //map에서 최대 value값 찾기
        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            if (entry.getValue() == maxCnt) { //map에서 최대 value값을 가진 key값을 찾아 treeMap에 넣어주기
                ts.add(entry.getKey());
            }
        }
    }
}
