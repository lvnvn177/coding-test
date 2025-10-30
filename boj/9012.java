import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        // 괄호 문자열 짝꿍이 맞는지 안 맞는지 판단 
        // input length 2 ~ 50
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(solve(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String solve(String s) {
        
        int count = 0;

        for (char c : s.toCharArray()) {
            
            // 여는 괄호 -> 카운트 증가 
            if (c == '(') {
                count++;
            }

            // 닫는 괄호일 경우 
            
            else if (count == 0) {
                return "NO";
            }

            else {
                count--;
            }
        }

        /**
         * 모든 검사를 마치고 잔여 요소가 있으면 (count > 0) 여는 괄호가 많은 경우는 "NO"
         * 요소가 비어있으면(count=0) 온전한 수식이므로 "YES" 이다.
         */

         if (count == 0) {
            return "YES";
         }
         else {
            return "NO";
         }
    }
}