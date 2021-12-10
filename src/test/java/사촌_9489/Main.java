package 사촌_9489;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static List<Integer> nodeCountOfDepth = new ArrayList<>();
    static Map<Integer, Set<Integer>> nodeMap = new HashMap<>();

	static InputReader r;

    private static void solution() throws IOException {
        while (true) {
            int N = r.nextInt();
            int M = r.nextInt();
            if (N == 0 && M == 0) break;

            // 노드 입력 받기
            int[] nodes = new int[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = r.nextInt();
            }

            // 증가하는 수열 찾기

            // 루트 노드 추가하기
            nodeCountOfDepth.add(1);
            Set<Integer> root = new HashSet<>();
            root.add(nodes[0]);
            nodeMap.put(0, root);


            int depth = 0;
            int parentCount = nodeMap.get(depth++).size();
            int pointer = 1; // 검사 해야 하는 노드의 위치를 가리킨다.
            int count = 0; // 해당 depth의 노드 개수를 세기
            int pre = 0;   // 이전 노드 기억하고 있기
            Set<Integer> nodeHashSet = new HashSet<>();
            while (pointer < N) {
                // 첫 시작일 때
                if (pre == 0) {
                    // pre를 등록해준다.
                    pre = nodes[pointer++];
                    // 카운트 1증가
                    count++;
                    nodeHashSet.add(pre);
                } else {
                    int cur = nodes[pointer++];
                    if (pre + 1 != cur) {
                        // 이전 노드가 지금 노드와 같지 않을 때
                        // 현재 깊이의 노드 숫자를 추가하고
                        // 카운트를 초기화해준다.

                        if (parentCount == 1) {
                            nodeCountOfDepth.add(count);
                            nodeMap.put(depth, nodeHashSet);
                            nodeHashSet = new HashSet<>();
                            count = 0;
                            parentCount = nodeMap.get(depth).size();
                            depth++;
                        } else {
                            nodeHashSet.add(pre);
                            count++;
                            parentCount--;
                        }


                    } else {
                        nodeHashSet.add(pre);
                        // 카운트 증가한다.
                        count++;
                    }
                    // 지금 노드를 이전 노드로 교체해준다.
                    pre = cur;
                    if (pointer == N) {
                        nodeHashSet.add(pre);
                        count++;
                    }
                }
            }
            nodeCountOfDepth.add(count);
            nodeMap.put(nodeCountOfDepth.size() - 1, nodeHashSet);

            System.out.println("");

            // for (int i = 1; i < N; i++) {
            //     // 첫 시작일 때
            //     if (pre == 0) {
            //         pre = nodes[pointer++];
            //         count++;
            //     } else {
            //         int cur = nodes[pointer++];
            //         if (pre != cur) {
            //             nodeCountOfDepth.add(count);
            //             count = 0;
            //         } else {
            //             count++;
            //         }
            //         pre = cur;
            //     }
            // }

        }
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\사촌_9489\\input.txt");
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader r;

        public InputReader(String filePath) throws FileNotFoundException {
            this(new FileReader(filePath));
        }

        public InputReader() {
            this(new InputStreamReader(System.in));
        }

        private InputReader(InputStreamReader reader) {
            r = new BufferedReader(reader);
            st = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }

}

