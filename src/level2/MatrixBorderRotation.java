package level2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixBorderRotation {
    //행렬 테두리 회전
    //https://school.programmers.co.kr/learn/courses/30/lessons/77485

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        /**1.rows columns에 맞는 이중배열(board) 만들기**/
        int[][] board = new int[rows][columns];
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = ++num;
            }
        }

        /**2.좌표 for문 돌리며 확인**/
        for (int i = 0; i < queries.length; i++) {
            List<Pair<Integer, Integer>> border = new ArrayList<Pair<Integer, Integer>>();
            List<Integer> borderNum = new ArrayList<>();

            /**3.회전시킬 테두리 시계방향 순서대로 구하기**/
            findBorder(queries[i], board, border, borderNum);

            /**4.회전시킬 테두리 시계방향으로 돌리기**/
            board = borderRotation(board, border, borderNum);

            /**5.가장 작은 수 구하기**/
            answer[i] = Collections.min(borderNum);
        }

        return answer;
    }

    private void findBorder(int[] query, int[][] board, List<Pair<Integer, Integer>> border, List<Integer> borderNum) {
        //index는 0부터 시작하기 때문에 1부터시작하는 queries값에서 1씩 뺌
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;


        for (int column = y1; column <= y2; column++) { //border top
            border.add(new Pair<>(x1, column));
            borderNum.add(board[x1][column]);
        }
        for (int row = x1 + 1; row <= x2; row++) { //border right
            border.add(new Pair<>(row, y2));
            borderNum.add(board[row][y2]);
        }
        for (int column = y2 - 1; column >= y1; column--) { //border bottom
            border.add(new Pair<>(x2, column));
            borderNum.add(board[x2][column]);
        }
        for (int row = x2 - 1; row > x1; row--) { //border left
            border.add(new Pair<>(row, y1));
            borderNum.add(board[row][y1]);
        }
    }

    private int[][] borderRotation(int[][] board, List<Pair<Integer, Integer>> border, List<Integer> borderNum) {
        for (int j = 0; j < border.toArray().length; j++) {
            Pair<Integer, Integer> xy = border.get(j);
            if (j == border.size() - 1) { //다음값이 없으면 첫번째 pair 좌표에 값 넣어주기
                Pair<Integer, Integer> nextXy = border.get(0);
                board[nextXy.getKey()][nextXy.getValue()] = borderNum.get(j);
            } else {
                Pair<Integer, Integer> nextXy = border.get(j + 1);
                board[nextXy.getKey()][nextXy.getValue()] = borderNum.get(j);
            }
        }

        return board;
    }
}
