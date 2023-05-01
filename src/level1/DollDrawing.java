package level1;

public class DollDrawing {

    //크레딧 인형뽑기
    //https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] bascket = new int[moves.length];
        int top = -1;

        for (int i : moves) {
            for (int j = 0; j < board.length; j++) { //인형 바구니에 담기
                if (board[j][i - 1] > 0) {
                    top++; //바구니 top 재정리
                    bascket[top] = board[j][i - 1];
                    board[j][i - 1] = 0;
                    break;
                }
            }

            if (top > 0 && bascket[top] != 0 && bascket[top - 1] != 0 && bascket[top] == bascket[top - 1]) { //인형 터트리기
                bascket[top] = 0;
                bascket[top - 1] = 0; //인형 터짐
                top -= 2; //바구니 top 재정리
                answer += 2; //인형 개수 카운팅
            }
        }

        return answer;
    }
}
