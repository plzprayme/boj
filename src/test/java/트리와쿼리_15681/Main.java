package 트리와쿼리_15681;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static int N, R, Q;
	static List<Integer>[] tree;
	static int[] childTable;

	static InputReader r;

	private static void solution() throws IOException {
		dfs(0, R);

		// 정답 만들기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			sb.append(childTable[r.nextInt()]).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int pre, int cur) {
		childTable[cur] = 1; // 리프 노드는 1 저장 후 끝난다.
		for (int next : tree[cur]) {
			if (next == pre) continue;
			dfs(cur, next); // 리프 노드까지 들어가기
			childTable[cur] += childTable[next]; // next의 자식 노드 숫자 더하기
		}
	}

	private static void input() throws IOException {
		r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\트리와쿼리_15681\\input.txt");
		N = r.nextInt();
		R = r.nextInt();
		Q = r.nextInt();

		// 트리 초기화
		tree = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			int left = r.nextInt();
			int right = r.nextInt();
			tree[left].add(right);
			tree[right].add(left);
		}

		childTable = new int[N + 1];
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
			if (!st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return Integer.parseInt(st.nextToken());
		}

		public char[] nextCharArr() throws IOException {
			return r.readLine().toCharArray();
		}
	}

}

