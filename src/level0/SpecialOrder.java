package level0;

import java.util.Arrays;
import java.util.Comparator;

public class SpecialOrder {

    //특이한정렬
    //https://school.programmers.co.kr/learn/courses/30/lessons/120880
    public int[] solution(int[] numlist, int n) {
        Integer[] tempList = Arrays.stream(numlist).boxed().toArray(Integer[]::new); //int[] -> Integer[] 변환 (Comparator) 함수를 쓰기 위함
        Arrays.sort(tempList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o2-n) == Math.abs(o1-n)) { //기준값을 뺸값의 절대값이 같으면
                    return o2 - o1; //원래값으로 내림차순
                }
                return Math.abs(o1-n) - Math.abs(o2-n); //절대값으로 오름차순
            }
        });
        System.out.println(Arrays.toString(tempList));

        numlist = Arrays.stream(tempList).mapToInt(i->i).toArray(); //Integer[] -> int[] 변환 (반환 형식 맞추기 위함)

        return numlist;
    }

    /*public Integer[] solution(Integer[] numlist, Integer n) {
        Arrays.sort(numlist, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o2-n) == Math.abs(o1-n)) { //기준값을 뺸값의 절대값이 같으면
                    return o2 - o1; //원래값으로 비교
                }else{
                    return Math.abs(o1-n) - Math.abs(o2-n);
                }
            }
        });

        return numlist;
    }*/
}
