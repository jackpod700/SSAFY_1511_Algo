import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static int N, M;
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        solve();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve() {
        int num = 2, nr = 0, nc = 0;
        map[0][0] = 1;
        visited[0][0] = true;
        while (num <= N * M) {
            for (int d = 0; d < 4; d++) {
                nr += dr[d];
                nc += dc[d];
                while (check(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = num++;
                    nr += dr[d];
                    nc += dc[d];
                }
                nr -= dr[d];
                nc -= dc[d];
            }
        }

    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }


}
