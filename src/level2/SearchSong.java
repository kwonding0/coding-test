package level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SearchSong {

    //[3차]방금그곡
    //https://school.programmers.co.kr/learn/courses/30/lessons/17683
    public String solution(String m, String[] musicinfos) throws ParseException {
        String answer = "";
        m = m.replaceAll("[A-G]{1}(#)?", "$0|"); //ABC -> ABC#을 일치한다고 보지 않기 위해 음기준으로 잘라놓기
        Map<String, Long> melodies = new LinkedHashMap<String, Long>(); //입력값 순서를 지키기 위한 LinkedHashMap

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");

            /**1.시간구하기**/
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            // 비교할 시간 (문자열)
            String timeStr1 = split[0];
            String timeStr2 = split[1];

            // 문자열 -> Date
            Date date1 = sdf.parse(timeStr1);
            Date date2 = sdf.parse(timeStr2);

            // Date -> 밀리세컨즈
            long timeMil1 = date1.getTime();
            long timeMil2 = date2.getTime();

            // 비교
            long diff = timeMil2 - timeMil1;
            long time = diff / (1000 * 60) + 1;

            /**2.시간동안 재생된 악보구하기**/
            //시간동안 재생된 악보를 구하기 위해 최소 단위로 반복
            String melody = split[3];
            int n = (int) time / melody.replaceAll("#", "").length();
            melody = melody.repeat(n + 1);
            //반복한값을 음기준으로 나눠놓기
            String indexString = melody.replaceAll("[A-G](#)?", "$0|");
            //음기준으로 재생시간만큼 자를 index 구하기
            char targetChar = '|';
            int index = IntStream.range(0, indexString.length())
                    .filter(i -> indexString.charAt(i) == targetChar)
                    .skip(time - 1)
                    .findFirst()
                    .orElse(-1);

            if (index != -1) {
                //음기준으로 자르기
                String totalSong = indexString.substring(0, index);

                /**3.악보보고 일치하는 노래 찾기 **/
                if (totalSong.contains(m)) {
                    melodies.put(split[2], time);
                }
            }
        }

        /**4.일치하는 노래들 중에 우선순위 찾기 (A.더 오래 재생된 곡 -> B.먼저 재생된 곡)**/
        if (melodies.size() > 0) {
            String[] strings = melodies.entrySet().stream()
                    .sorted((key1, key2) -> {
                        return key2.getValue().compareTo(key1.getValue()); //재생 시간이 큰 순서대로 정렬
                    })
                    .map(Map.Entry::getKey)
                    .toArray(String[]::new);

            answer = strings[0]; //첫번째 값이 정답
        } else {
            answer = "(None)"; //없음
        }

        return answer;
    }
}
