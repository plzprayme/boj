package 부동산다툼_20364;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static InputReader r;

	static int N;

	static boolean[] orphanage;

	static Set<Integer> own = new HashSet<>();

	static StringBuilder sb = new StringBuilder();

	private static void solution() throws IOException {

		// 부모를 기억하는 인접 리스트 생성

		int M = r.nextInt();
		for (int i = 0; i < M; i++) {
			int node = r.nextInt();

			if (orphanage[node]) {
				// 입력 노드가 고아 노드면 부모 노드로 이동
				// 부모 노드가 고아가 아니면 부모 노드를 출력 후 종료
				// 부모 노드가 고아면 다시 부모 노드로 이동
				sb.append(searchParent(node));
			} else if (own.contains(node)) {
				// 소유지의 자식 노드는 아니지만 소유지이다.
				sb.append(node);
			} else {
				// 입력 노드가 고아 노드가 아니면(!= -1) 0 리턴
				// 입력 노드의 자식 노드들을 모두 고아 노드로 변경
				sb.append(0); // 0 리턴

				own.add(node);

				cutChild(node * 2);
				cutChild(node * 2 + 1);
			}
			sb.append('\n');
		}

		System.out.println(sb);
    }

	private static int searchParent(int cur) {
		if (orphanage[cur]) return searchParent(cur / 2);
		return cur;
	}

	private static void cutChild(int cur) {
		if (cur > N) return;
		if (orphanage[cur]) return;
		orphanage[cur] = true;
		cutChild(cur * 2);
		cutChild(cur * 2 + 1);
	}

	private static void input() throws IOException {
		r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\부동산다툼_20364\\input.txt");
		N = r.nextInt();
		orphanage = new boolean[N + 1]; // 고아 노드 배열
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

