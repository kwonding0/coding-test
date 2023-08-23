package level2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNmSort {

    //파일명 정렬
    //https://school.programmers.co.kr/learn/courses/30/lessons/17686
    public String[] solution(String[] files) {
        String[] answer = {};
        Map<String, String> head = new LinkedHashMap<String, String>(); //입력값 순서를 지키기 위한 LinkedHashMap
        Map<String, Integer> number = new HashMap<String, Integer>();

        /********HEAD값 추출********/
        for (String file : files) {
            head.put(file, file.split("[0-9]")[0].toLowerCase());
        }

        /********NUMBER값 추출********/
        // 정규식 패턴 생성
        String regex = "\\d+"; // 연속된 숫자 패턴
        Pattern pattern = Pattern.compile(regex);
        for (String file : files) {
            Matcher matcher = pattern.matcher(file);

            if (matcher.find()) {
                String firstNumberChunk = matcher.group();
                number.put(file, Integer.parseInt(firstNumberChunk));
            }
        }

        answer = head.entrySet().stream()
                .sorted((key1, key2) -> {
                    if (key1.getValue().equals(key2.getValue())) { //head가 같으면 number로 비교
                        return number.get(key1.getKey()).compareTo(number.get(key2.getKey()));
                    } else { //head로 비교
                        return key1.getValue().compareTo(key2.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        return answer;
    }
}
