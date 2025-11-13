import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        prime = new boolean[N + 1];
        get_prime();

        for (int i = M; i < N; i++) {
            if (deciaml(i)) {
                sum += i;
            }
            
        }
    }

    public static void get_prime() {
        prime[0] = true;
        
    }
}