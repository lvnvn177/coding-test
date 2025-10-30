import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
    Stack<Integer> results = new Stack<>();
    public static void main(String[] args) throws IOException {
        Main test = new Main();
    }

    public Main() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        
        //command 와 data를 분리
        for (int i = 0 ; i < tc ; i++){
            String[] input = br.readLine().split(" ");
            String command = input[0];

            int data = 0;
            
            //push를 제외한 경우, 데이터가 없으므로 막아줘야함
            if(input.length > 1) {
                data = Integer.parseInt(input[1]);
            }
            
            solution(command,data);

        }

    }

    public void solution (String command,int data){
        
        //command별 기능 수행
        if (command.equals("push")){
            results.push(data);
        }else if(command.equals("pop")){
            if(results.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(results.pop());
            }
        }else if(command.equals("top")){
            if(results.isEmpty()){
                System.out.println(-1);
            }else{
                //peek() : top의 data를 보여줌 
                System.out.println(results.peek());
            }
        }else if(command.equals("size")){
            System.out.println(results.size());
        }else if(command.equals("empty")){
            if(results.isEmpty()){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

}