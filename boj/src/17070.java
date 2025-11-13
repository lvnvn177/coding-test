import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int [][] map;
    static int ans;
    public static void main(String[] args) throws IOException {
        // 코드 작성
        // size NxN
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i =1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        DFS(1, 2, 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int x, int y, int direction) {
        if (x == N && y == N) {
            ans++;
            return;
        }

        switch (direction) {
            case 0: // 파이프 가로방향, 
                if (y + 1 <= N && map[x][y + 1] == 0) {
                    DFS(x, y + 1, 0);
                }
                break;
            case 1: // 세로
                if (x + 1 <= N && map[x + 1][y] == 0) {
                    DFS(x + 1, y, 1);
                }
                break;
            case 2: // 대각선
                if (y + 1 <= N && map[x][y + 1] == 0) {
                    DFS(x, y + 1, 0);
                }

                if (x + 1 <= N && map[x + 1][y] == 0) {
                    DFS(x + 1, y, 1);
                }
            break;
        }

        if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
    }
}