import level3.LockAndKey;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Integer v1 = 3;
        Integer v2 = null;
        //System.out.println("Math.min(v1,v2) = " + Math.min(v1, v2));
        /*******************************************************************************************************/
        /****************************************************Level0*********************************************/
        /*******************************************************************************************************/
        //옹알이
        /*String[] a = {"a", "b"};
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
        int[][] lines = {{-3, -1}, {-2, 1}, {0, 2}};*//*{{0, 5}, {3, 9}, {1, 10}};*//*//{{0, 1}, {2, 3}, {4, 5}};
        new OverlapLineLength().solution(lines);

        //평행
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        new Parallel().solution(dots);

        //안전지대
        int[][] board = {{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
        new SafeZone().solution(board);*/

        /*******************************************************************************************************/
        /****************************************************Level1*********************************************/
        /*******************************************************************************************************/
        //로또의 최고 순위와 최저 순위
        /*int[] lottos = {44, 1, 0, 0, 31, 25};
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
        new GetReportResult().solution(id_list, report, 2);*/

        /*******************************************************************************************************/
        /****************************************************Level2*********************************************/
        /*******************************************************************************************************/
        //[1차]캐시
        /*String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        new Cash().solution(3, cities);

        //[1차]뉴스 클러스터링
        new NewsClustering().solution("FRANCE", "french");

        //k진수에서 소수 개수 구하기
        new BinaryDecimalCount().solution(437674, 3);

        //[3차]압축
        new Compression().solution("TOBEORNOTTOBEORTOBEORNOT");

        //[3차]n진수 게임
        new NBinaryGame().solution(16, 16, 2, 1);

        //오픈채팅방
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        new OpenChatting().solution(record);

        //주차요금
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        new ParkingFee().solution(fees, records);

        //주차요금
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        new FileNmSort().solution(files);

        //[1차] 프렌즈4블록
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        new Friends4Block().solution(6, 6, board);

        //두 큐 합 같게 만들기
        int[] queue1 = {1, 1};
        int[] queue2 = {3, 2};
        new SameTwoQueueSum().solution(queue1, queue2);

        //메뉴 리뉴얼
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        new MenuRenewal().solution(orders, course);

        //[3차]방금그곡
        String[] musicinfos = {"0:00,03:00,ISA,D#CC", "03:00,03:30,FOO,D#C#C", "04:00,04:30,BAR,C#CD#"};
        String m = "C#C";
        new SearchSong().solution(m, musicinfos);

        //괄호변환
        String p = ")))()()(((";
        new ParenthesesConversion().solution(p);

        //행렬 테두리 회전
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        new MatrixBorderRotation().solution(6, 6, queries);

        //문자열 압축
        new StringPressure().solution("aabbacc");

        //후보키
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        new CandidateKey().solution(relation);

        //이모티콘 할인행사
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        new EmojiDiscount().solution(users, emoticons);

        //양궁게임
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        new ArcheryGame().solution(n, info);


        //순위검색
        String[] info2 = {"java backend junior pizza 150"
                , "python frontend senior chicken 210"
                , "python frontend senior chicken 150"
                , "cpp backend senior pizza 260"
                , "java backend junior chicken 80"
                , "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        new SearchRank().solution(info2, query);

        //입국심사
        int n3 = 6;
        int[] times = {7, 10};
        new Immigration().solution(n3, times);

        //택배 배달과 수거하기
        int cap = 4;
        int n4 = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        new DeliveryService().solution(cap, n4, deliveries, pickups);

        //합승 택시 요금
        int n5 = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        new SharedTaxiFee().solution(n5, s, a, b, fares);

        //셔틀버스
        String[] timetable = {"09:00", "09:10", "09:20", "09:30", "09:40", "09:50",
                "10:00", "10:10", "10:20", "10:30", "10:40", "10:50"};
        new ShuttleBus().solution(10, 25, 1, timetable);*/

        //자물쇠와 열쇠
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 0, 1}};
        new LockAndKey().solution(key, lock);
    }
}
