package level3;

public class ColumnsAndBo {
    // 기둥과 보
    // https://school.programmers.co.kr/learn/courses/30/lessons/60061
    final static int COLUMN = 0;
    final static int DELETE = 0;
    boolean[][] columnArr;
    boolean[][] boArr;

    public int[][] solution(int n, int[][] build_frame) {
        int size = build_frame.length;
        columnArr = new boolean[n + 1][n + 1];
        boArr = new boolean[n + 1][n + 1];
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int cb = build_frame[i][2]; //기둥 : 0, 보 : 1
            int ad = build_frame[i][3]; //삭제 : 0, 설치 : 1

            if (ad == DELETE) { //삭제
                if (cb == COLUMN) { //기둥 삭제조건 체크
                    columnArr[x][y] = false;
                    if (canDelete(n)) cnt--;
                    else columnArr[x][y] = true;
                } else { //보 삭제조건 체크
                    boArr[x][y] = false;
                    if (canDelete(n)) cnt--;
                    else boArr[x][y] = true;
                }
            } else { //설치
                if (cb == COLUMN) { //기둥 설치조건 체크
                    if (addColumn(x, y)) {
                        columnArr[x][y] = true;
                        cnt++;
                    }
                } else { //보 설치조건 체크
                    if (addBo(x, y)) {
                        boArr[x][y] = true;
                        cnt++;
                    }
                }
            }
        }

        int[][] answer = new int[cnt][3];
        if (cnt > 0) {
            cnt = 0;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (columnArr[i][j]) {
                        answer[cnt][0] = i;
                        answer[cnt][1] = j;
                        answer[cnt++][2] = 0;
                    }
                    if (boArr[i][j]) {
                        answer[cnt][0] = i;
                        answer[cnt][1] = j;
                        answer[cnt++][2] = 1;
                    }
                }
            }
        }

        return answer;
    }

    private boolean addColumn(int x, int y) {
        if (y == 0) return true; //바닥일때
        else if (y > 0 && columnArr[x][y - 1]) return true; //기둥 위일때
        else return x > 0 && boArr[x - 1][y] || boArr[x][y]; //보 위일때
    }

    private boolean addBo(int x, int y) {
        if (y > 0 && (columnArr[x][y - 1] || columnArr[x + 1][y - 1])) return true; //기둥 위일때
        else return x > 0 && boArr[x - 1][y] && boArr[x + 1][y]; //보 사이일때
    }

    private boolean canDelete(int n) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (columnArr[x][y] && !addColumn(x, y)) return false; //이미 설치되어있는 기둥이 설치 불가능하다고 할때
                else if (boArr[x][y] && !addBo(x, y)) return false; //이미 설치되어있는 보가 설치 불가능하다고 할때
            }
        }
        return true;
    }
}

