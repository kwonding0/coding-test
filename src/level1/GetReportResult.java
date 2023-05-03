package level1;

import java.util.*;

public class GetReportResult {

    //신고 결과 받기
    //https://school.programmers.co.kr/learn/courses/30/lessons/92334
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> report_set = new HashSet<>(Arrays.asList(report));
        List<String> stopUsers = new ArrayList<String>();
        int i = 0;

        for (String id : id_list) {
            if (report_set.stream().filter(o -> (o + "|").contains(" " + id + "|")).count() >= k) { //정지당한 유저
                stopUsers.add(id);
            }
        }

        for (String id : id_list) { //메일발송 카운팅
            for (String stopUser : stopUsers) {
                if (!id.equals(stopUser)) {
                    answer[i] += report_set.stream().filter(o -> o.equals(id + " " + stopUser)).count() > 0 ? 1 : 0;
                }
            }
            i++;
        }

        return answer;
    }
}
