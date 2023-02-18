package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OngAlYee {

    //옹알이
    //https://school.programmers.co.kr/learn/courses/30/lessons/120956
    public int solution(String[] babblings){
        int answer = 0;
        List<String> mussg1 = Arrays.asList("aya", "ye", "woo", "ma");
        answer = (int)Arrays.asList(babblings).stream().filter(o -> o.replace(mussg1.get(0),"/")
                .replace(mussg1.get(1),"/")
                .replace(mussg1.get(2),"/")
                .replace(mussg1.get(3),"/")
                .replace("/","").length() == 0).count();

        /*for (String babbling : babblings){
            for(String ong : mussg1){
                babbling = babbling.replace(ong,"/");
            }
            answer = babbling.replace("/","").length() == 0 ? answer+1 : answer;
        }*/

        return answer;
    }
}
