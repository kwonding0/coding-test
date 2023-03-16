package level0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SafeZone {

    //안전지대
    //https://school.programmers.co.kr/learn/courses/30/lessons/120866
    public int solution(int[][] board) {
        int answer = board.length * board.length; //board판 전체 칸 개수
        Set<List<Integer>> set = new HashSet<List<Integer>>();

        //위험지역 좌표
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    set.add(Arrays.asList(i + 1, j + 1));
                    set.add(Arrays.asList(i + 1, j));
                    set.add(Arrays.asList(i + 1, j - 1));
                    set.add(Arrays.asList(i, j - 1));
                    set.add(Arrays.asList(i, j));
                    set.add(Arrays.asList(i, j + 1));
                    set.add(Arrays.asList(i - 1, j + 1));
                    set.add(Arrays.asList(i - 1, j));
                    set.add(Arrays.asList(i - 1, j - 1));
                }
            }
        }

        //System.out.println("board = " + Arrays.deepToString(board));
        //System.out.println("삭제 전set = " + set);

        //board판 벗어나는 위험지역 삭제
        set.removeIf(list -> list.stream().filter(o -> o < 0 || o >= board.length).collect(Collectors.toList()).size() > 0);

        //System.out.println("삭제 후set = " + set);

        return answer - set.size();
    }
}
