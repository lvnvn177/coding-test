public class Eratosthenes {

    public boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n+1];

        prime[0] = false;				
        prime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i] == true) {
                continue;
            }

            for(int j = i * i; j < prime.length; j = j+i) {
                prime[j] = true;
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        Eratosthenes e = new Eratosthenes();
        boolean[] primes = e.sieveOfEratosthenes(100);
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) System.out.print(i + " ");
        }
    }
}
