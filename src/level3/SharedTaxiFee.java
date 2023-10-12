package level3;

import lombok.Data;

import java.util.*;

public class SharedTaxiFee {
    // 합승 택시 요금
    // https://school.programmers.co.kr/learn/courses/30/lessons/72413
    static ArrayList<Node>[] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        // {A : [1,10,2,12], B : [4,10,5,12]} 구간, 금액, 구간...
        Map<String, List<Integer>> minRoute = new HashMap<>();
        int answer = 0;

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < fares.length; i++) {
            int v = fares[i][0];
            int w = fares[i][1];
            int cost = fares[i][2];

            graph[v].add(new Node(w, cost, new ArrayList<>()));
            graph[w].add(new Node(v, cost, new ArrayList<>()));
        }

        //A집까지 최소 요금 경로
        int aFee = findMinRoute(n, s, a, "A", minRoute);

        //B집까지 최소 요금 경로
        int bFee = findMinRoute(n, s, b, "B", minRoute);

        System.out.println("minRoute = " + minRoute);

        // A, B의 최소요금 경로 중 둘이 겹치는 경로가 있는지 확인
        // ( 단, 중간이 겹치면 안되고 처음부터 겹치는 구간만 겹치는 구간이라고 인정)
        List<Integer> aRoute = minRoute.get("A");
        List<Integer> bRoute = minRoute.get("B");

        int sameRouteFee = findSameRouteFee(aRoute, bRoute);
        System.out.println("sameRouteFee = " + sameRouteFee);

        //겹치는 경로가 있으면 (A + B) 금액에서 해당 부분 요금 빼기
        answer = aFee + bFee - sameRouteFee;

        System.out.println("answer = " + answer);
        return answer;
    }

    private int findMinRoute(int n, int s, int a, String goal, Map<String, List<Integer>> minRoute) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        List<Integer>[] route = new ArrayList[n + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0, Arrays.asList(s, 0)));
        for (Node node : pq) {
            System.out.println("node = " + node);
        }
        System.out.println("==================================");

        int nowVertex = 0;

        while (!pq.isEmpty()) { //큐가 비워질때까지 진행
            Node poll = pq.poll();
            nowVertex = poll.index;

            System.out.println("nowVertex = " + nowVertex);

            if (!check[nowVertex]) {
                check[nowVertex] = true; //방문 표시

                for (Node next : graph[nowVertex]) {
                    if (dist[next.index] > dist[nowVertex] + next.cost) {
                        dist[next.index] = dist[nowVertex] + next.cost;
                        List<Integer> course = new ArrayList<>(poll.course);
                        course.add(next.index);
                        course.add(next.cost);
                        route[next.index] = course;

                        pq.offer(new Node(next.index, dist[next.index], course));
                    }
                }
                for (Node node : pq) {
                    System.out.println("node = " + node);
                }
                System.out.println("==================================");
            }
            System.out.println("check = " + Arrays.toString(check));
            System.out.println("dist = " + Arrays.toString(dist));


        }

        minRoute.put(goal, route[a]);

        return dist[a];
    }

    private int findSameRouteFee(List<Integer> aRoute, List<Integer> bRoute) {
        int sameFee = 0;
        int maxLength = Math.max(aRoute.size(), bRoute.size());

        for (int i = 2; i < maxLength; i += 2) { //출발지 다음부터 검사
            if (aRoute.get(i) == bRoute.get(i)) { //경로가 같으면 해당 경로까지의 요금을 더해줌
                sameFee = aRoute.get(i - 1);
            } else {
                break;
            }
        }

        return sameFee;
    }

    @Data
    class Node implements Comparable<Node> {
        int index;
        int cost;
        List<Integer> course;

        //정점번호, 가중치 저장
        public Node(int index, int cost, List<Integer> course) {
            this.index = index;
            this.cost = cost;
            this.course = course;
        }

        //cost(=가중치)  중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}

