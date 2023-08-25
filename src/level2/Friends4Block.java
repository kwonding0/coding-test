package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Friends4Block {

    //[1차] 프렌즈4블록
    //https://school.programmers.co.kr/learn/courses/30/lessons/17679
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        /*1.이중배열로 옮김*/
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        System.out.println("map = " + Arrays.deepToString(map));

        /*2.2x2 값 체크해서 지워질값인지 확인*/
        while (true) {
            boolean[][] chk = new boolean[m][n]; // 지워질 블럭 체크용
            for (int i = 0; i < m - 1; i++) { //마지막줄들은 확인 안해도됨 (index 오류남)
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c != '0') { //빈 공간을 0으로 치환할꺼기 때문에 빈 공간인지 체크
                        if (map[i][j + 1] == c && map[i + 1][j + 1] == c && map[i + 1][j] == c) {
                            chk[i][j] = true;
                            chk[i][j + 1] = true;
                            chk[i + 1][j + 1] = true;
                            chk[i + 1][j] = true;
                        }
                    }
                }
            }

            System.out.println("chk = " + Arrays.deepToString(chk));
            //3.지워질 블록 지우고, 블록 하나씩 밑으로 내리기
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                Queue<Character> q = new LinkedList<>();
                for (int i = m - 1; i >= 0; i--) {
                    if (chk[i][j]) {
                        cnt++;
                    } else {
                        q.add(map[i][j]);
                    }
                }

                for (int i = m - 1; i >= 0; i--) {
                    map[i][j] = q.isEmpty() ? '0' : q.poll();
                }
            }

            System.out.println("map = " + Arrays.deepToString(map));

            answer += cnt;
            if (cnt == 0) break;
        }

        return answer;

        /*List<LinkedList<Character>> allBlock = new ArrayList<>();

        //1.세로로 한줄 씩 거꾸로 LinkedList에 넣어주기
        for (int j = 0; j < m; j++) {
            LinkedList<Character> blockLine = new LinkedList<>();
            for (int i = n - 1; i >= 0; i--) {
                blockLine.add(board[i].charAt(j));
            }
            allBlock.add(blockLine);
        }
        System.out.println("allBlock = " + allBlock);

        while (true) { //지워질 블록이 없을 떄까지 반복
            boolean[][] chk = new boolean[m][n]; // 지워질 블럭 체크용
            //2.없어지는 블록인지 확인후 좌표 체크
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = allBlock.get(i).get(j);
                    System.out.println("c = " + c);
                    System.out.println("allBlock.get(i + 1).get(j) = " + allBlock.get(i).get(j + 1));
                    System.out.println("allBlock.get(i + 1).get(j) = " + allBlock.get(i + 1).get(j + 1));
                    System.out.println("allBlock.get(i + 1).get(j) = " + allBlock.get(i + 1).get(j));

                    if (c == allBlock.get(i).get(j + 1) && c == allBlock.get(i + 1).get(j + 1) && c == allBlock.get(i + 1).get(j)) {
                        System.out.println(i + " / " + j);
                        System.out.println(i + " / " + j + 1);
                        System.out.println(i + 1 + " / " + j + 1);
                        System.out.println(i + 1 + " / " + j);
                        chk[i][j] = true;
                        chk[i][j + 1] = true;
                        chk[i + 1][j + 1] = true;
                        chk[i + 1][j] = true;
                    }
                }
            }

            System.out.println("chk = " + Arrays.deepToString(chk));

            //좌표개수 answer에 더해주고 모두 삭제 ( 삭제하면 자연스럽게 블럭이 아래로 밀리는것처럼 데이터 셋팅됨 )
            for (int i = 0; i < m; i++) {
                LinkedList<Character> temp = allBlock.get(i);
                for (int j = 0; j < n; j++) {
                    if (chk[i][j]) {
                        System.out.println(i + " / " + j);
                        temp.removeAll(j);
                    }
                }
                allBlock.set(i, temp);
                System.out.println("allBlock = " + allBlock);
            }
        }*/

    }
}
