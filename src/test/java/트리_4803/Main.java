package 트리_4803;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static int vCount, eCount;
	static boolean[] visit;
	static List<Integer>[] tree;

	private static void solution() throws IOException {
		InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\트리_4803\\input.txt");

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
				count += dfs(e, 0);
			}

			if (count == 0) {
				System.out.printf("Case %d: No trees.\n", test);
			} else if (count == 1) {
				System.out.printf("Case %d: There is one tree.\n", test);
			} else {
				System.out.printf("Case %d: A forest of %d trees.\n", test, count);
			}
		}

	}

	// 트리의 정의 : 간선 / 2 == 정점 - 1 이어야한다.
	// 트리의 정의 : 정점 = 간선 - 1
	private static int dfs(int cur, int pre) {
		if (visit[cur])
			return 0;

		int result = 1;
		visit[cur] = true;

		for (int next : tree[cur]) {
			if (next == pre)
				continue;
			result = Math.min(dfs(next, cur), result);
		}

		return result;
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

