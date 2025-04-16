package codility_easy;

public class BinaryGap {
    //https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
    public int solution(int N) {
        //10진수 -> 2진수로 변경
        String binary = Integer.toBinaryString(N);
        String[] chars = binary.split("");

        int max = 0;
        int count = 0;
        for (String chr : chars) {
            if (chr.equals("0")) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
            }
        }
        return max;
    }
}
