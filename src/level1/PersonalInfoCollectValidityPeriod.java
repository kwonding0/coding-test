package level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PersonalInfoCollectValidityPeriod {

    //개인정보 수집 유효기간
    //https://school.programmers.co.kr/learn/courses/30/lessons/150370
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        List<Integer> answer = new ArrayList<Integer>();
        Map<String, Integer> termMap = new HashMap<String, Integer>();
        //수집 기간 map 생성
        for (String term : terms) {
            termMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        //유효기간 체크
        for (int i = 0; i < privacies.length; i++) {
            String[] dp = privacies[i].split(" ");

            if (deletePrivacy(today.replaceAll("\\.", ""), dp[0].replaceAll("\\.", ""), termMap.get(dp[1]))) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean deletePrivacy(String today, String lastDay, int addMonth) throws ParseException { //유효기간 지났는지 체크
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();

        //string => date + addMonth
        Date lDay = format.parse(lastDay);
        cal.setTime(lDay);
        cal.add(Calendar.MONTH, addMonth);

        //string => date
        Date tDay = format.parse(today);

        return !cal.getTime().after(tDay);
    }
}
