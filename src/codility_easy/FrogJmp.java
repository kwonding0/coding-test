package codility_easy;

public class FrogJmp {
    //https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
    public int solution(int X, int Y, int D) {
        int answer = 0;
        //X : 현재위치
        //Y : 도착점
        //D : 한번에 이동가능한 곳

        int dis = (Y - X);
        if (dis > 0) {
            int mod = dis / D;
            int namuge = dis % D;
            if (namuge > 0) {
                mod++;
            }
            answer = mod;
        }

        return answer;
    }
}
