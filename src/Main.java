import level0.*;

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
    }
}
