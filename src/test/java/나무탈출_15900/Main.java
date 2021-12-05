package 나무탈출_15900;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static int N;
	static List<Integer>[] tree;

	static boolean[] visit;

	static int moveCount = 0;

    private static void solution() {
		// N 개의 정점이 있는 트리 모양 게임판
		// 몇개의 게임말
		// 루트 노트는 1
		// 리프 노드에 게임말이 하나씩 놓여있다.
		// 게임 말은 부모 노드로 올라간다. 겹칠 수 있다.
		// 루트에 도착하면 게임말 제거 가능하다.

		// 말을 고를 수 없는 사람이 진다.

		// 형석이가 먼저, 그 후에 성원이 성원이가 이길 수 있는지 확인하기


		// 백트래킹?
		// 정점의 개수는 500,000

		// 모든 단말노드까지의 거리가 짝수면 NO
		// 홀수면 YES
		// 즉, 간선의 개수를 세어도 된다.
		// 간선 * 자식 노드로 한다.

		// 단말 노드까지 들어간 후, 돌아오면서 카운트? NO
		// 결론 단말 노드까지의 거리를 더해준다.
		dfs( 1, 0);

		if (moveCount % 2 == 0) System.out.println("No");
		else System.out.println("Yes");
    }

	private static void dfs(int cur, int depth) {
		visit[cur] = true;

		for (int next : tree[cur]) {
			if (visit[next]) continue;
			dfs(next, depth + 1);
		}

		if (cur != 1 && tree[cur].size() == 1) moveCount += depth;
	}

	private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\나무탈출_15900\\input.txt");
		N = r.nextInt();
		tree = new List[N + 1];
		for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

		visit = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			int left = r.nextInt();
			int right = r.nextInt();
			tree[left].add(right);
			tree[right].add(left);
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

