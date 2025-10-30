import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        // 1 ~ N 까지의 번호 
        // 카드 동작을 구현해야 하는데 큐의 가장 Last 인덱스 pop -> Last 인덱스 First 인덱스 스왑 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while(q.size() > 1) {
            q.poll();   // 맨 앞의 원소 제거 
            q.offer(q.poll()); // 맨 앞의 원소 제거 및 가장 뒤로 삽입 
        }

        System.out.println(q.poll());
    }
}