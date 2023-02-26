import level0.OngAlYee;
import level0.PushString;
import level0.SpecialOrder;

public class Main {
    public static void main(String[] args) {

        String[]a = {"a","b"};
        new OngAlYee().solution(a);

        new PushString().solution("atat","tata");

        int[]numlist = {10000,20,36,47,40,6,10,7000};
        new SpecialOrder().solution(numlist,30);
    }
}
