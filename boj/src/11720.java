import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int sum = 0;

        for(byte value : br.readLine().getBytes()) {
            sum += (value - '0');
        }

        System.out.println(sum);
    }
}

/**
 * 1. 숫자들을 입력 받는다 (N는 쓸모 x)
 * 2. 
 * 
 * 
 * https://st-lab.tistory.com/41?category=830901
 * 
 * 
 */