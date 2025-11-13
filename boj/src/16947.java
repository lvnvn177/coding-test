import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] ans;
    static boolean[] v;
    static List<Integer>[] list;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        // 코드 작성
        // 싸이클 발생 구간 체크 
        // 탐색을 통해 모든 노드에서 싸이클이 발생하는 노드 까지 거리 계산 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ans = new int[N+1];
        list = new ArrayList[N+1];

        Arrays.fill(ans, -1);

        for(int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }

        // 사이클 체크
        for(int i = 1; i <= N; i++) {
            v = new boolean[N+1];
            cycleCheck(i, 1, i);
        }

        bfs();

        for(int i = 1; i <= N; i++) 
            sb.append(ans[i]).append(" ");

        System.out.println(sb);
    }

    private static void cycleCheck(int cur, int cnt, int start) {
        // 방문
        v[cur] = true;

        for(int next: list[cur]) {
            // 다음 노드를 방문하지 않음
            if(!v[next]) cycleCheck(next, cnt+1, start);
            // 다음 노드를 방문
            else if(next == start && cnt >=3) {
                // 사이클 
                ans[next] = 0;
                q.offer(next);
                return;
            }
        }
    }

    private static void bfs() {

        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int next: list[cur]) {
                // 사이클이 아닌 노드라면
                if(ans[next] == -1) {
                    ans[next] = ans[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}