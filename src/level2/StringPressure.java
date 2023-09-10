package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringPressure {
    //문자열압축
    //https://school.programmers.co.kr/learn/courses/30/lessons/60057

    public int solution(String s) {
        /**1.문자열 길이가 1이면 1 반환**/
        if (s.length() == 1) return 1;

        int answer = 0;
        List<String> stringPressureList = new ArrayList<>();

        for (int i = 1; i <= s.length() / 2; i++) {
            /**2.n개씩 문자열을 분할**/
            String[] parts = splitNString(s, i);

            /**3.분할된 문자열로 압축문자열 생성하여 list에 넣기**/
            makeStringPressure(parts, stringPressureList);
        }

        /**4.list에 모인 문자열 중 제일 길이가 짧은 문자열 추출**/
        Optional<String> shortest = stringPressureList.stream()
                .min((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        if (shortest.isPresent()) {
            answer = shortest.get().length();
        }

        return answer;
    }

    private String[] splitNString(String s, int i) {
        String pattern = "(?<=\\G.{" + i + "})";
        return s.split(pattern);
    }

    private void makeStringPressure(String[] parts, List<String> stringPressureList) {
        int cnt = 1;
        String sp = "";
        for (int j = 0; j < parts.length; j++) {
            if (j != parts.length - 1) { //마지막이 아니면 다음문자열과 비교
                if (parts[j].equals(parts[j + 1])) { //같으면 카운팅
                    cnt++;
                } else { //다르면 카운팅값과 단일문자열 합쳐서 압축
                    sp += cnt == 1 ? parts[j] : cnt + parts[j];
                    cnt = 1;
                }
            } else {
                sp += cnt == 1 ? parts[j] : cnt + parts[j];
            }
        }
        stringPressureList.add(sp);
    }
}
