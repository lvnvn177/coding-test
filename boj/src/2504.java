import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        /*
         * sol
         * () = 2
         * [] = 3
         * ([]) = 2 * 3 = 6
         * ()[] = 2 + 3
         * [()[]] = 3 * (2 + 3) = 15
         * [([])[]] = 3 * ((2 * 3) + 3) = 27
         * 
         * 
         * 가장 나중에 입력된 괄호부터 계산 해야함
         * LIFO 에 따라 스택이 가장 적절하다 판단
         * 또한 겹겹히 중첩되어 있는 각 괄호 안의 값을 저장하기 위한 리스트 생성 
         * 값은 추가/제거 해야함 
         * 
         */

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String input = br.readLine();
         int N = input.length();

         Stack<Character> st = new Stack<>();
         List<Integer> sums = new ArrayList<>();
         int idx = -1;
         int ans = 0;

         for (int i = 0; i < N; i++) {
            char curr = input.charAt(i);

            if (curr == '(' || curr == '[') {
                st.push(curr);
                sums.add(0);
                idx ++;
            } else {
                if(st.isEmpty() || !isPair(st.peek(), curr)) {
                    System.out.println(0);
                    return;
                } else {
                    st.pop();
                    int total = sums.remove(idx);
                    int result = (total == 0 ? 1 : total) * getMul(curr);
                    if (--idx >= 0) {
                        sums.set(idx, sums.get(idx) + result);
                    } else {
                        ans += result;
                    }
                }
            }
         }
         System.out.println(st.isEmpty() ? ans : 0);
    }

    static int getMul(char close) {
        return close == ']' ? 3 : 2;
    }

    static boolean isPair(char open, char close) {
        if ( (open == '(' && close == ')') || (open == '[' && close == ']') )
            return true;
        else    
            return false;
    }
}