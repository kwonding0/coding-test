package level2;

import java.util.*;

public class OpenChatting {

    //오픈채팅방
    //https://school.programmers.co.kr/learn/courses/30/lessons/42888
    public String[] solution(String[] record) {
        int count = (int) Arrays.stream(record).filter(o -> !o.contains("Change ")).count();
        String[] answer = new String[count];
        Map<String, String> nickName = new HashMap<String, String>();
        List<List<String>> logs = new ArrayList<>();
        for (String rec : record) {
            /*
             * 아이디별 닉네임을 nickName map에 관리
             * split[0] : Enter / Change / Leave
             * split[1] : ID
             * split[2] : nickName
             */
            String[] split = rec.split(" ");
            if (!split[0].equals("Leave")) {
                nickName.put(split[1], split[2]);
            }

            if (!split[0].equals("Change")) {
                logs.add(new ArrayList<>(Arrays.asList(split[0], split[1])));
            }
        }

        int i = 0;
        for (List<String> log : logs) {
            if (log.get(0).equals("Enter")) {
                answer[i] = nickName.get(log.get(1)) + "님이 들어왔습니다.";
            } else {
                answer[i] = nickName.get(log.get(1)) + "님이 나갔습니다.";
            }
            i++;
        }
        return answer;
    }
}
