package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SharedTaxiFee {
    // 합승 택시 요금
    // https://school.programmers.co.kr/learn/courses/30/lessons/72413
    static ArrayList<Node>[] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        //그래프 데이터 만들어주기
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < fares.length; i++) {
            int v = fares[i][0];
            int w = fares[i][1];
            int cost = fares[i][2];

            graph[v].add(new Node(w, cost));
            graph[w].add(new Node(v, cost));
        }

        //합승했을 때 출발지부터 모든 정점까지의 최소비용
        int[] together = findMinRoute(n, s);

        for (int i = 1; i <= n; i++) {
            //i지점부터 모든 정점까지 최소 요금 경로
            int[] alone = findMinRoute(n, i);
            int cost = together[i] + alone[a] + alone[b];
            if (cost < answer) {
                answer = cost;
            }
        }

        return answer;
    }

    private int[] findMinRoute(int n, int s) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));

        int nowVertex = 0;

        while (!pq.isEmpty()) { //큐가 비워질때까지 진행
            Node poll = pq.poll();
            nowVertex = poll.index;

            if (!check[nowVertex]) {
                check[nowVertex] = true; //방문 표시

                for (Node next : graph[nowVertex]) {
                    if (dist[next.index] > dist[nowVertex] + next.cost) { //현재 비용보다 적으면 비용 업데이트
                        dist[next.index] = dist[nowVertex] + next.cost;
                        pq.offer(new Node(next.index, dist[next.index])); //현재 정점 정보 큐에 저장
                    }
                }
            }
        }

        return dist;
    }

    class Node implements Comparable<Node> {
        int index;
        int cost;

        //정점번호, 가중치 저장
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        //cost(=가중치)  중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}

