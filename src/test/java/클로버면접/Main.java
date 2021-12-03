package 클로버면접;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Main {


	// "a" = 1개의 'a' => "1a"
	// "bb" = 2개의 'b' => "2b"
	// "acaa" = 1개의 'a' 1개의 'c' 2개의 'a' => "1a1c2a"

	// 제한시간 : 45분
	@Test
	void asd() {
		assertEquals("1a", azcxc("a"));
		assertEquals("2b", azcxc("bb"));
		assertEquals("1a1c2a", azcxc("acaa"));
	}

	public String azcxc(String input) {

		// "acaa"

		// 방법 1. 쓰리? 포인터
		// 시작 점을 기억하고 있는 포인터와 끝 점을 기억하고 있는 포인터
		// 두 점 사이의 거리가 개수

		// acaa
		// start = 0, end = 0, next = 1
		// end 와 next가 다르면 압축 가능
		// next가 길이를 초과할 수도 있다..
		// next가 필요 없을 수도 있다..

		int N = input.length();
		int start = 0, end = 0;
		while (end < N) {
			int next = end + 1;
			// 끝과 다음이 같으면 다음으로 전진 가능.

			// 다음 문자열이 없는 경우 (길이의 끝)
			if (next == N) {
				// 끝이 없으니까 압축 가능
				// 아래 로직을 함수화 할 수 있다.
				zip(end - start + 1, input.charAt(start));
			}

			// 다음 문자와 끝 문자열이 같은 경우 (전진할 수 있다.)
			if (end == next) {
				// 전진할 수 있다. end++
			} else { // 전진을 할 수 없다.
				// 지금 까지의 거리를 압축한다.
				// acaa의 경우...
				// 압축 숫자는 end - start + 1
				// 압축 문자는 end 이거나 start 아무거나 가능
				// 압축한 문자를 더한 후 start와 end를 next로 초기화.
			}
		}

		return "";
	}

	private String zip(int i, char charAt) {
		return "i" + charAt;
	}

}
