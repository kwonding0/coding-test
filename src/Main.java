import level0.*;
import level1.*;
import level2.Cash;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        /*******************************************************************************************************/
        /****************************************************Level0*********************************************/
        /*******************************************************************************************************/
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

        /*******************************************************************************************************/
        /****************************************************Level1*********************************************/
        /*******************************************************************************************************/
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
        new NumberMate().solution("5525", "1255");

        //없는 숫자 더하기
        int[] numbers = {1, 2, 3, 4, 5};
        new AddNoneNumber().solution(numbers);

        //음양더하기
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        new AddMinusPlus().solution(absolutes, signs);

        //나머지가 1인 숫자
        new NumberOfOneRemainder().solution(1);

        //내적
        int[] a1 = {1, 2, 3, 4};
        int[] b1 = {-3, -1, 0, 2};
        new DotProduct().solution(a1, b1);

        //약수의 개수와 덧셈
        new DivisorCntSum().solution(13, 17);

        //3진법 뒤집기
        new TernaryFlip().solution(39);

        //비밀지도
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        new SecretMap().solution(5, arr1, arr2);

        //비밀지도
        new NumberEnglishString().solution("2three45sixseven");

        //두 개 뽑아서 더하기
        int[] numbers2 = {100, 1, 2};
        new AddTwoPickupNum().solution(numbers2);

        //실패율
        int[] stages = {5, 5, 5, 2, 3, 4};
        new FailRate().solution(10, stages);

        //다트게임
        new DartGame().solution("10D*10S#10T*");

        //인형뽑기
        int[][] board3 = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        new DollDrawing().solution(board3, moves);

        //키패드 누르기
        int[] numbers3 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        new PushKeyPad().solution(numbers3, "right");

        //신규 아이디 추천
        new NewIdRecommand().solution("...!@BaT#*..y.abc-_.~()defghijklm");

        //성격유형 검사하기
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        new Mbti().solution(survey, choices);

        //개인정보 수집 유효기간
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        new PersonalInfoCollectValidityPeriod().solution("2022.05.19", terms, privacies);

        //신고 결과 받기
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        new GetReportResult().solution(id_list, report, 2);

        /*******************************************************************************************************/
        /****************************************************Level2*********************************************/
        /*******************************************************************************************************/
        //[1차]캐시
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        new Cash().solution(3, cities);
    }
}
