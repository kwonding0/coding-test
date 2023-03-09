package level0;

import java.util.Arrays;

public class AdditionOfFractions {

    //분수의 덧셈
    //https://school.programmers.co.kr/learn/courses/30/lessons/120808
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = denom1 * denom2; //분모(분모끼리 곱해서 통일시킴)
        int numer = numer1 * denom2 + numer2 * denom1; //분자(각 분자에 서로다른 분모 곱해서 더함)

        //System.out.println("answer = " + Arrays.toString(asFraction(numer,denom)));

        return asFraction(numer,denom);
    }
    
    public static int gcd(int x, int y){ //최대공약수 구하기
        return y == 0? x : gcd(y, x%y);
    }

    public static int[] asFraction(int x, int y) { //최대공약수를 분모,분자 각각 나누기
        int gcd = gcd(x, y);
        int[] arr = {(x / gcd), (y / gcd)};
        return arr;
    }
}
