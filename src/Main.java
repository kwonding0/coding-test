import level0.FuxxNumberThree;
import level0.OngAlYee;
import level0.PushString;
import level0.SpecialOrder;

public class Main {
    public static void main(String[] args) {
        //옹알이
        String[]a = {"a","b"};
        new OngAlYee().solution(a);

        //문자열 밀기
        new PushString().solution("atat","tata");

        //특이한 정렬
        int[]numlist = {10000,20,36,47,40,6,10,7000};
        new SpecialOrder().solution(numlist,30);

        //저주의 숫자 3
        new FuxxNumberThree().solution(40);
    }
}
