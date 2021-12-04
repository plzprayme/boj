package 트리_4803;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static boolean[] visit;
	static List<Integer>[] tree;
	static int vCount, eCount;

	private static void solution() throws IOException {
		InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\트리_4803\\input.txt");

		StringBuilder sb = new StringBuilder();

		for (int test = 1; ; test++) {
			int E = r.nextInt();
			int V = r.nextInt();
			if (E == 0 && V == 0) break;

			tree = new List[E + 1];
			for (int i = 1; i <= E; i++) {
				tree[i] = new ArrayList<>();
			}

			for (int i = 0; i < V; i++) {
				int left = r.nextInt();
				int right = r.nextInt();
				tree[left].add(right);
				tree[right].add(left);
			}

			visit = new boolean[E + 1];

			int count = 0;
			for (int e = 1; e <= E; e++) {
				if (visit[e]) continue;
				// 정점 개수, 간선 개수 초기화
				vCount = 0;
				eCount = 0;

				// 정점 개수, 간선 개수 세기
				dfs(e);

				// 양방향이니까 간선은 반으로 나눈다.
				// 트리의 정질 V = E - 1 이용
				if (vCount / 2 == eCount - 1) {
					count++;
				}
			}

			// 정답 빌드
			sb.append("Case ").append(test).append(": ");

			if (count > 1) {
				sb.append("A forest of ").append(count).append(" trees.");
			} else if (count == 1) {
				sb.append("There is one tree.");
			} else {
				sb.append("No trees.");
			}

			sb.append('\n');

		}
		System.out.println(sb);

	}

	// 트리의 정의 : 간선 / 2 == 정점 - 1 이어야한다.
	// 트리의 정의 : 정점 = 간선 - 1
	// 정점 세기, 간선 세기
	private static void dfs(int cur) {
		eCount++;
		vCount += tree[cur].size();
		visit[cur] = true;

		for (int next : tree[cur]) {
			if (visit[next]) continue;
			dfs(next);
		}
	}

	@Test
	public static void main(String[] args) throws IOException {
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
			if (!st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return Integer.parseInt(st.nextToken());
		}

		public char[] nextCharArr() throws IOException {
			return r.readLine().toCharArray();
		}
	}

}

