package level3;

public class LockAndKey {
    // 자물쇠와 키
    // https://school.programmers.co.kr/learn/courses/30/lessons/60059

    // 90 rotate
    static int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] rotate = new int[m][m];

        for (int i = 0; i < m; i++) { //행값을 열값으로 바꾸기 (i), 열값을 행값으로 바꾸는데 거꾸로 ( m - 1 - j )
            for (int j = 0; j < m; j++) {
                rotate[i][j] = key[m - 1 - j][i];
            }
        }
        return rotate;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length; //키 열 개수
        int n = lock.length; //자물쇠 열 개수
        int[][] rotateArr = key.clone();
        int extend = n + ((m - 1) * 2); //확장 자물쇠 크기
        int[][] check = new int[extend][extend]; //확장 자물쇠
        int cnt = 0; //열쇠홈

        /**1.확장 자물쇠에 자물쇠값 넣기**/
        for (int i = 0; i < extend; i++) {
            for (int j = 0; j < extend; j++) {
                if (i >= (m - 1) && i <= (n + m - 2) && j >= (m - 1) && j <= (n + m - 2)) {
                    check[i][j] = lock[i - (m - 1)][j - (m - 1)];
                    if (lock[i - (m - 1)][j - (m - 1)] == 0) cnt++;
                } else {
                    check[i][j] = 0;
                }
            }
        }

        /**2.자물쇠가 열려있는 상태라면 true 반환**/
        if (cnt == 0) {
            return true;
        }

        /**3.360도 90도씩 회전 시킨 키를 이동시켜보며 자물쇠에 들어가는지 확인**/
        for (int r = 0; r < 4; r++) { //
            rotateArr = rotate(rotateArr); //키 90도 회전
            //키 이동시키기
            for (int i = 0; i <= (n + m - 2); i++) {
                for (int j = 0; j <= (n + m - 2); j++) {
                    int[][] lockCheck = match(rotateArr, check, m, i, j);

                    if (isKey(lockCheck, n, m)) { //자물쇠에 들어가는지 확인
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] match(int[][] rotateArr, int[][] check, int m, int startX, int startY) {
        // 깊은 복사 (for문 + clone 사용)
        int[][] lockCheck = new int[check.length][check.length];
        for (int i = 0; i < check.length; i++) {
            lockCheck[i] = check[i].clone();
        }

        for (int i = startX; i < startX + m; i++) { //키를 맞춰볼 위치에서부터 키값을 자물쇠에 더하기
            for (int j = startY; j < startY + m; j++) {
                lockCheck[i][j] += rotateArr[i - startX][j - startY];
            }
        }
        return lockCheck;
    }

    private boolean isKey(int[][] lockCheck, int n, int m) { //자물쇠위치 값에 모두 1만 있으면 key맞음!
        for (int i = m - 1; i < n + m - 1; i++) {
            for (int j = m - 1; j < n + m - 1; j++) {
                if (lockCheck[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

}

