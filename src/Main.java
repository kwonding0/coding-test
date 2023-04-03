import level0.*;
import level1.GymSuit;
import level1.KnightWeapon;
import level1.LottoBestWorstRank;
import level1.NumberMate;

public class Main {
    public static void main(String[] args) {
        //옹알이
        String[] a = {"a", "b"};
        new OngAlYee().solution(a);

        //문자열 밀기
        new PushString().solution("atat", "tata");

        //특이한 정렬
        int[] numlist = {10000, 20, 36, 47, 40, 6, 10, 7000};
        new SpecialOrder().solution(numlist, 30);

        //저주의 숫자 3
        new FuxxNumberThree().solution(40);

        //다항식 더하기
        new AddPolynomial().solution("x + 1 + 0 + 9");
        new AddPolynomial().solution("7 + 5");
        new AddPolynomial().solution("3x + 7 + x");

        //최빈값 구하기
        int[] numlist2 = {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        //int[] numlist2 = {1,1,2,2};
        int answer2 = new FindMode().solution(numlist2);
        //System.out.println("answer2 = " + answer2);

        //OX퀴즈
        String[] quizList = {"5 + 66 = 71", "19 - 6 = 13", "5 - 15 = 63", "3 - 1 = 2"};
        String[] answer = new OXQuiz().solution(quizList);
        //System.out.println("answer = " + answer);

        //다음에 올 숫자
        int[] common = {1, 2, 3, 4};
        //int common[] = {2, 4, 8};
        new NextNumber().solution(common);

        //분수의 덧셈
        //new AdditionOfFractions().solution(1,2,3,4);
        new AdditionOfFractions().solution(9, 2, 1, 3);

        //연속된 수의 합
        new AddStraightNumbers().solution(1, 2);

        //겹치는 선분의 길이
        int[][] lines = {{-3, -1}, {-2, 1}, {0, 2}};/*{{0, 5}, {3, 9}, {1, 10}};*///{{0, 1}, {2, 3}, {4, 5}};
        new OverlapLineLength().solution(lines);

        //평행
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        new Parallel().solution(dots);

        //안전지대
        int[][] board = {{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
        new SafeZone().solution(board);

        //로또의 최고 순위와 최저 순위
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        new LottoBestWorstRank().solution(lottos, win_nums);

        //기사단원의 무기
        new KnightWeapon().solution(5, 3, 2);

        //체육복
        int[] lost = {1, 2};
        int[] reserve = {3};
        new GymSuit().solution(2, lost, reserve);

        //숫자짝꿍
        String X = "";
        for (int i = 0; i < 300; i++) {
            X += "0";
        }
        new NumberMate().solution("5525", "1255");

    }
}
