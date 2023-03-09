package level0;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMode {

    //최빈값 구하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/120812
    public int solution(int[] array) {
        //방법 1: 배열원소마다 개수 카운팅
        /*String[] count = Arrays.stream(array)
                        .mapToObj(i -> Collections.frequency(Arrays.stream(array)
                        .boxed()
                        .collect(Collectors.toList()), i) + "x" + i).toArray(String[]::new);*/

        //System.out.println("중복제거 전 count = " + set);

        //중복제거
        //count = Arrays.stream(count).distinct().toArray(String[]::new);

        //System.out.println("중복제거 후 count = " + set);

        //방법 2: Set 자동 중복제거
        /*Set<String> set = Arrays.stream(array)
                .mapToObj(i -> Collections.frequency(Arrays.stream(array)
                        .boxed()
                        .collect(Collectors.toList()), i) + "x" + i).collect(Collectors.toSet());

        System.out.println("set = " + set);*/

        //최대값 기준으로 정렬
//        Arrays.sort(count, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.parseInt(o2.replaceAll("x[0-9]*$",""))
//                        - Integer.parseInt(o1.replaceAll("x[0-9]*$","")); //내림차순
//            }
//        });
//
//        return returnMode(count);


        //ollectors.groupingBy 사용하여 Map으로 바로 만들기
        /*Map<Integer, Long> map1 = Arrays.stream(Arrays.asList(array).toArray(Integer[]::new))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/


        //방법 2 : Map(value를 list로 만들어 같은 개수의 숫자가 있는지 쉽게 파악
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Arrays.stream(array).distinct()
                .forEach(i -> {
                    Integer key = Collections.frequency(Arrays.stream(array)
                                    .boxed()
                                    .collect(Collectors.toList()),i);
                    List<Integer> value = map.getOrDefault(key,new ArrayList<Integer>());
                    value.add(i);
                    map.put(key,value);
                });


        //System.out.println("map = " + map);

        Integer maxKey = map.keySet().stream().sorted(Collections.reverseOrder()).toList().get(0);
        if(map.get(maxKey).size() != 1)
            return -1;
        else
            return map.get(maxKey).get(0);

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
