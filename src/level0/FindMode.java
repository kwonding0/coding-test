package level0;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMode {

    //최빈값 구하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/120812
    public int solution(int[] array) {
        //배열원소마다 개수 카운팅
        String[] count = Arrays.stream(array)
                        .mapToObj(i -> Collections.frequency(Arrays.stream(array)
                        .boxed()
                        .collect(Collectors.toList()), i) + "x" + i).toArray(String[]::new);

        //중복제거
        count = Arrays.stream(count).distinct().toArray(String[]::new);

        //최대값 기준으로 정렬
        Arrays.sort(count, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2.replaceAll("x[0-9]*$",""))
                        - Integer.parseInt(o1.replaceAll("x[0-9]*$","")); //내림차순
            }
        });

        return returnMode(count);
    }
    static int returnMode (String[] arr) {
        String mode = "";
        if(arr.length > 1){ //배열 길이가 2 이상이면 0번째, 1번쨰 원소 비교
            String zero = arr[0].replaceAll("x[0-9]*$",""); //x뒤 문자 제거
            String one = arr[1].replaceAll("x[0-9]*$","");

            if(zero.equals(one)) { //같으면 -1
                mode = "-1";
            }else{ //다르면 0번쨰원소가 최빈값
                mode = arr[0].replaceAll("(^[0-9]*x)",""); //x앞 문자 제거
            }
        }else{ //배열 길이가 1이면 0번쨰원소가 최빈값
            mode = arr[0].replaceAll("(^[0-9]*x)","");
        }

        return Integer.parseInt(mode);
    }
}
