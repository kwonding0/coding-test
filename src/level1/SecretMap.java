package level1;

public class SecretMap {

    //비밀지도
    //https://school.programmers.co.kr/learn/courses/30/lessons/17681
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String a1 = "";
        String a2 = "";
        String a3 = "";

        for (int i = 0; i < n; i++) {
            a1 = String.format("%1$" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            a2 = String.format("%1$" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            a3 = "";
            for (int j = 0; j < n; j++) {
                a3 += !(Character.toString(a1.charAt(j)) + a2.charAt(j)).equals("00")
                        ? "#" : " ";
            }
            answer[i] = a3;
        }

        return answer;
    }
}
