package level1;

import java.util.*;

public class GetReportResult {

    //신고 결과 받기
    //https://school.programmers.co.kr/learn/courses/30/lessons/92334
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> report_set = new HashSet<>(Arrays.asList(report));
        //List<String> stopUsers = new ArrayList<String>();
        Map<String, Integer> reportUser = new HashMap<>();
        Map<String, Integer> mailUser = new HashMap<>();
        int i = 0;

        /*for (String id : id_list) {
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
        }*/

        String putUser = "";
        String getUser = "";
        Integer count = 0;
        for (String rep : report_set) { //신고당한 횟수 체크
            String[] users = rep.split(" ");
            getUser = users[1];
            count = reportUser.containsKey(getUser) ? reportUser.get(getUser) : 0;
            reportUser.put(getUser, ++count);
        }

        reportUser.entrySet().removeIf(entry -> entry.getValue() < k); //신고당한 user

        for (String rep : report_set) {
            String[] users = rep.split(" ");
            putUser = users[0];
            getUser = users[1];
            if (reportUser.containsKey(getUser)) {
                count = mailUser.containsKey(putUser) ? mailUser.get(putUser) : 0;
                mailUser.put(putUser, ++count);
            }
        }

        for (String id : id_list) {
            answer[i] = mailUser.containsKey(id) ? mailUser.get(id) : 0;
            i++;
        }

        return answer;
    }
}
