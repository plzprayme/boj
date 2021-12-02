package 트리순회_1991;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static int N;
	static Map<Character, Child> binaryTree;
	static StringBuilder pre = new StringBuilder();
	static StringBuilder in = new StringBuilder();
	static StringBuilder post = new StringBuilder();

	private static void solution() {
		search('A');
		System.out.println(pre.append('\n').append(in).append('\n').append(post));
	}

	private static void search(char key) {
		char leftChild = binaryTree.get(key).left;
		char rightChild = binaryTree.get(key).right;

		pre.append(key);

		if (leftChild != '.') {
			search(leftChild);
		}

		in.append(key);

		if (rightChild != '.') {
			search(rightChild);
		}

		post.append(key);
	}

	private static void input() throws IOException {
		InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\트리순회_1991\\input.txt");
		N = r.nextInt();
		binaryTree = new HashMap<>();

		for (int i = 0; i < N; i++) {
			binaryTree.put(r.nextCharater(), new Child(r.nextCharater(), r.nextCharater()));
		}
	}

	private static class Child {
		char left, right;

		public Child(char left, char right) {
			this.left = left;
			this.right = right;
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
			if (!st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return Integer.parseInt(st.nextToken());
		}

		public char[] nextCharArr() throws IOException {
			return r.readLine().toCharArray();
		}

		public char nextCharater() throws IOException {
			if (!st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken().charAt(0);
		}
	}

}

