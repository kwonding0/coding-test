import level0.*;

public class Main {
    public static void main(String[] args) {
        //옹알이
        String[]a = {"a","b"};
        new OngAlYee().solution(a);

        //문자열 밀기
        new PushString().solution("atat","tata");

        //특이한 정렬
        int[] numlist = {10000,20,36,47,40,6,10,7000};
        new SpecialOrder().solution(numlist,30);

        //저주의 숫자 3
        new FuxxNumberThree().solution(40);

        //다항식 더하기
        new AddPolynomial().solution("x + 1 + 0 + 9");
        new AddPolynomial().solution("7 + 5");
        new AddPolynomial().solution("3x + 7 + x");

        //최빈값 구하기
        //int[] numlist2 = {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] numlist2 = {1,1,2,2};
        new FindMode().solution(numlist2);

        //OX퀴즈
        String[] quizList = {"5 + 66 = 71", "19 - 6 = 13", "5 - 15 = 63", "3 - 1 = 2"};
        new OXQuiz().solution(quizList);
    }
}
