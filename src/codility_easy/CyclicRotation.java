package codility_easy;

import java.util.Arrays;

public class CyclicRotation {
    //https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
    public int[] solution(int[] A, int K) {
        int size = A.length;
        int[] answer = new int[size];

        if (K > 0 && size > 0) {
            int namuge = K % size;
            System.out.println("namuge = " + namuge);

            if (namuge == 0) { //K가 A크기의 배수면 그대로 반환
                answer = A;
            } else {
                for (int i = 0; i < size; i++) {
                    if (i + namuge > size - 1) {
                        answer[i + namuge - size] = A[i];
                    } else {
                        answer[i + namuge] = A[i];
                    }
                }
            }
        } else {
            answer = A;
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }

}
