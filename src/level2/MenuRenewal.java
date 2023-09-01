package level2;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MenuRenewal {

    //메뉴 리뉴얼
    //https://school.programmers.co.kr/learn/courses/30/lessons/72411
    public String[] solution(String[] orders, int[] course) {
        TreeSet<String> ts = new TreeSet<String>();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int count = 0;

        //중복되는 메뉴 다 구하기
        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];
            String s = "";
            char[] chars = order.toCharArray();
            Arrays.sort(chars); //코스를 알파벳 숫서대로 하기위함

            for (int j = i + 1; j < orders.length; j++) {
                String compareOrder = orders[j];
                String sameOrder = "";

                System.out.println("order = " + order);
                System.out.println("compareOrder = " + compareOrder);

                for (char c : chars) {
                    if (compareOrder.contains(String.valueOf(c))) {
                        sameOrder += ".*" + c; //중복값
                    }
                }
                System.out.println("sameOrder = " + compareOrder);
                System.out.println("sameOrder = " + compareOrder);
                System.out.println(" =======================");
                if (!sameOrder.isEmpty()) {
                    set.add(sameOrder);
                    list.add(sameOrder);
                }
            }
        }

        System.out.println("set = " + set);
        System.out.println("list = " + list);
        //카운팅
        for (int num : course) {
            List<String> collect = set.stream().filter(o -> o.length() == num * 3).collect(Collectors.toList());
            System.out.println("collect = " + collect);
            Map<String, Integer> courseMenu = new HashMap<>();
            for (String s : collect) {
                String regex1 = s + ".*"; // B와 D가 하나 이상의 문자와 함께 나타나는 패턴
                Pattern pattern1 = Pattern.compile(regex1);
                count = (int) list.stream()
                        .filter(str -> pattern1.matcher(str).matches()).count();
                courseMenu.put(s, count);
            }

            System.out.println("courseMenu = " + courseMenu);

            if (!courseMenu.isEmpty()) {
                //최대 중복 세트메뉴 찾기
                int maxCnt = Collections.max(courseMenu.values());
                for (Map.Entry<String, Integer> entry : courseMenu.entrySet()) {
                    if (entry.getValue() == maxCnt) {
                        ts.add(entry.getKey().replaceAll("\\.\\*", ""));
                    }
                }
            }

            System.out.println("ts = " + ts);
        }

        //제일 큰 숫자 구하기
        /*for (int num : course) {
            Map<String, Integer> numCourse = new HashMap<>();

            //갯수에 맞는것만 찾기
            for (Map.Entry<String, Integer> entry : courseMenu.entrySet()) {
                if (entry.getKey().length() == num) {
                    numCourse.put(entry.getKey(), entry.getValue());
                }
            }
            System.out.println("numCourse = " + numCourse);
            if (!numCourse.isEmpty()) {
                //최대 중복 세트메뉴 찾기
                int maxCnt = Collections.max(numCourse.values());
                for (Map.Entry<String, Integer> entry : numCourse.entrySet()) {
                    if (entry.getValue() == maxCnt) {
                        ts.add(entry.getKey());
                    }
                }
            }
        }*/

        return ts.toArray(new String[ts.size()]);
    }
}
