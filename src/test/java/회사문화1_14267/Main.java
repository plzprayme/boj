package 회사문화1_14267;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static int N, M;
	static List<Integer>[] tree;

	static Map<Integer, Integer> weightCounter = new HashMap<>();

	static int[] answerTable;

	static InputReader r;

    private static void solution() {
		for (Map.Entry<Integer, Integer> set : weightCounter.entrySet()) {
			dfs(set.getKey(), set.getValue());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answerTable[i]).append(' ');
		}
		System.out.println(sb);
    }

	private static void dfs(int cur, int w) {
		answerTable[cur] += w;

		for (int next : tree[cur]) {
			dfs(next, w);
		}
	}

	private static void input() throws IOException {
        r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\회사문화1_14267\\input.txt");
		N = r.nextInt();
		M = r.nextInt();

		tree = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		r.nextInt();
		for (int child = 2; child <= N; child++) {
			int parent = r.nextInt();
			tree[parent].add(child);
		}

		answerTable = new int[N + 1];
		for (int i = 0; i < M; i++) {
			int node = r.nextInt();
			int weight = r.nextInt();
			weightCounter.put(node, weightCounter.getOrDefault(node, 0) + weight);
		}
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

