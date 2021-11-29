package 트리_1068;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static int N, M;
	static List<Integer>[] tree;
	static int[] table;
	static boolean[] visit;

    private static void solution() {
		cut(M);
		System.out.println(countAnswer());
    }

	private static void cut(int m) {
		cutParent(m);
		cutDfs(m);
	}

	private static void cutParent(int m) {
		int parent = table[m];
		if (parent == -1) return;

		for (int i = 0; i < tree[parent].size(); i++) {
			if (tree[parent].get(i) == m) {
				tree[parent].remove(i);
				return;
			}
		}

	}

	private static int countAnswer() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			if (tree[i].isEmpty()) count++;
		}
		return count;
	}

	private static void cutDfs(int m) {
		visit[m] = true;

		for (int child : tree[m]) {
			if (visit[child]) continue;
			cutDfs(child);
		}
	}

	private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\트리_1068\\input.txt");
		N = r.nextInt();

		tree = new List[N];
		visit = new boolean[N];
		table = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int child = 0; child < N; child++) {
			int parent = r.nextInt();
			table[child] = parent;
			if (parent == -1) continue;
			tree[parent].add(child);
		}

		M = r.nextInt();
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

