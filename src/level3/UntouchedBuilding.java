package level3;

public class UntouchedBuilding {
    // 파괴되지 않은 건물
    // https://school.programmers.co.kr/learn/courses/30/lessons/92344

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] skillSum = new int[n + 1][m + 1];

        /** 1.범위별 공격, 수비 값 더해주기 **/
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1], c1 = skill[i][2];
            int r2 = skill[i][3], c2 = skill[i][4];
            int degree = skill[i][5];

            if (type == 2) {  //수비
                skillSum[r1][c1] += degree;
                skillSum[r1][c2 + 1] += -degree;
                skillSum[r2 + 1][c1] += -degree;
                skillSum[r2 + 1][c2 + 1] += degree;
            } else { //공격
                skillSum[r1][c1] += -degree;
                skillSum[r1][c2 + 1] += degree;
                skillSum[r2 + 1][c1] += degree;
                skillSum[r2 + 1][c2 + 1] += -degree;
            }
        }

        /** 2.공격, 수비 계산한 누적합 board 만들기 **/
        skillSum = prefixSum(skillSum);

        /** 3.파괴되지 않은 건물 개수 카운팅 **/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (skillSum[i][j] + board[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public int[][] prefixSum(int[][] arr) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                x = i == 0 ? 0 : arr[i - 1][j];
                y = j == 0 ? 0 : arr[i][j - 1];
                z = i == 0 || j == 0 ? 0 : arr[i - 1][j - 1];
                arr[i][j] += x + y - z;
            }
        }

        return arr;
    }
}

