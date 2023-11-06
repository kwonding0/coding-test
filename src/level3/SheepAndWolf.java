package level3;

import java.util.Arrays;

public class SheepAndWolf {
    // 양과 늑대
    // https://school.programmers.co.kr/learn/courses/30/lessons/92343
    Node[] node;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        node = new Node[info.length];

        for (int i = 0; i < info.length; i++) {
            node[i] = new Node(i, info[i], null, null);
        }

        //간선 정렬(작은값이 왼쪽)
        Arrays.sort(edges, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        System.out.println("Arrays.deepToString(edges) = " + Arrays.deepToString(edges));

        //트리만들기
        for (int i = 0; i < info.length; i++) {
            final int idx = i;
            int[] childs = Arrays.stream(edges)
                    .filter(edge -> edge[0] == idx)
                    .mapToInt(edge -> edge[1])
                    .toArray();
            if (childs.length > 0) {
                System.out.println("Arrays.toString(childs) = " + Arrays.toString(childs));
                insertNode(node[i], childs);
            }
        }

        //양 찾기


        /*for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            if(){

            }
        }*/

        return answer;
    }

    private void insertNode(Node parent, int[] childs) {
        parent.leftChild = node[childs[0]];
        if (childs.length == 2) {
            parent.rightChild = node[childs[1]];
        }

        System.out.println("parent.num = " + parent.getNum());
        System.out.println("parent.data = " + parent.getData());
        System.out.println("=============================");
    }

    class Node {
        int num;
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int num, int data, Node leftChild, Node rightChild) {
            this.num = num;
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public int getData() {
            return data;
        }

        public int getNum() {
            return num;
        }
    }
}

