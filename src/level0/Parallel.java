package level0;

import java.util.ArrayList;
import java.util.Arrays;

public class Parallel {

    //평행
    //https://school.programmers.co.kr/learn/courses/30/lessons/120875
    public int solution(int[][] dots) {
        //직선 A가 (x1,y1),(x2,y2) 직선 B가 (x3,y3),(x4,y4)
        //(x1-x2)(y3-y4) - (x3-x4)(y1-y2) = 0 을 만족하면 두 직선은 평행 또는 일치합니다.
        for (int j = 1; j < dots.length; j++) {
            ArrayList<Integer> indexList = new ArrayList<>(Arrays.asList(1, 2, 3));
            indexList.remove(Integer.valueOf(j));
            //System.out.println("indexList = " + indexList);
            if (isParallel(dots[0], dots[j], dots[indexList.get(0)], dots[indexList.get(1)]) == 1) return 1;
        }
        return 0;
    }

    public int isParallel(int[] A, int[] B, int[] C, int[] D) { //평행여부
        return (A[0] - B[0]) * (C[1] - D[1]) - (C[0] - D[0]) * (A[1] - B[1]) == 0 ? 1 : 0;
    }

    /*int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int x4 = 0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        int y4 = 0;
        int z = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[][] arr = new int[6][4];

        //6개의 직선 생성
        for (int i = 0; i < dots.length - 1; i++) {
            for (int j = 1; j < dots.length - i; j++) {
                arr[z][0] = dots[i][0];
                arr[z][1] = dots[i][1];
                arr[z][2] = dots[i + j][0];
                arr[z][3] = dots[i + j][1];
                System.out.println("Arrays.toString(arr) = " + Arrays.deepToString(arr));
                z++;
            }
        }

        //6개의 직선중 두개씩 평행여부 판단
        for (int i = 0; i < arr.length - 1; i++) {
            x1 = arr[i][0];
            y1 = arr[i][1];
            x2 = arr[i][2];
            y2 = arr[i][3];
            System.out.println("첫번째 = " + Arrays.toString(arr[i]));
            for (int j = 1; j < arr.length - i; j++) {
                x3 = arr[i + j][0];
                y3 = arr[i + j][1];
                x4 = arr[i + j][2];
                y4 = arr[i + j][3];
                System.out.println("두번쨰 = " + Arrays.toString(arr[i + j]));
                if ((x1 - x2) * (y3 - y4) - (x3 - x4) * (y1 - y2) == 0) {
                    return 1;
                }
            }
        }

        return 0;*/
}
