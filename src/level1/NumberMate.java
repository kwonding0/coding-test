package level1;

public class NumberMate {

    //숫자짝꿍
    //https://school.programmers.co.kr/learn/courses/30/lessons/131128
    public String solution(String X, String Y) {
        String answer = "";
        int[] XX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] YY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < X.length(); i++) { //아스키코드로 0~9까지 몇인지 구해서 배열에 +1 하는 형식으로 개수 카운팅
            XX[X.charAt(i) - 48] += 1;
        }

        for (int j = 0; j < Y.length(); j++) {
            YY[Y.charAt(j) - 48] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 9; k >= 0; k--) { //XX,YY 배열값의 최소값을 구해서 해당 숫자 StringBuilder에 최소값만큼 붙이기
            for (int z = 0; z < Math.min(XX[k], YY[k]); z++) {
                sb.append(k);
            }
        }

        answer = sb.toString();
        //중복값 없으면 -1, 0만 있으면 0
        answer = answer.isEmpty() ? "-1" : sb.charAt(0) == 48 ? "0" : answer;

        return answer;
    }

    /*public String solution(String X, String Y) {
        String answer = "";
        List<String> collectZ = new ArrayList<String>();

        //한글자씩 List에 넣기
        List<String> collectX = Arrays.stream(X.split("")).collect(Collectors.toList());
        List<String> collectY = Arrays.stream(Y.split("")).collect(Collectors.toList());

        //두 List의 중복값 찾기(개수도 맞춰서)
        collectX.forEach(o -> {
            if (collectY.contains(o)) collectZ.add(o);
            collectY.remove(o);
        });

        //중복값 내림차순으로 정렬
        Collections.sort(collectZ, Collections.reverseOrder());

        //List 모든 원소 String 으로 변환
        StringBuilder sb = new StringBuilder();
        collectZ.forEach(o -> sb.append(o));

        answer = sb.toString();
        //중복값 없으면 -1, 0만 있으면 0
        answer = answer.isEmpty() ? "-1" : collectZ.get(0) == "0" ? "0" : answer;

        return answer;
    }*/
}
