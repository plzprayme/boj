// package 유기놈배추_1012;
//
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.StringTokenizer;
//
// import org.junit.jupiter.api.Test;
//
// class Main {
//     static boolean[][] map;
//     static boolean[][] visited;
//
//     @Test
//     public static void main(String[] args) throws IOException {
//         BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\유기놈배추_1012\\input.txt"));
//         int C = Integer.parseInt(r.readLine());
//
//         for (int c = 0; c < C; c++) {
//             StringTokenizer st = new StringTokenizer(r.readLine());
//             int X = Integer.parseInt(r.readLine());
//             int Y = Integer.parseInt(r.readLine());
//             int k = Integer.parseInt(r.readLine());
//             map = new boolean[X][Y];
//             visited = new boolean[X][Y];
//
//             for (int i = 0; i < k; i++) {
//                 st = new StringTokenizer(r.readLine());
//                 int x = Integer.parseInt(r.readLine());
//                 int y = Integer.parseInt(r.readLine());
//                 map[x][y] = true;
//             }
//
//             for (int x = 0; x < X; x++) {
//                 for (int y = 0; y < Y; y++) {
//
//                 }
//             }
//
//         }
//
//     }
//
//     int dfs(int x, int y) {
//         if (map[x][y]) {
//             dfs(x + 1, y + 1);
//             dfs(x + 1, y);
//             dfs(x - 1, y);
//         }
//     }
// }
