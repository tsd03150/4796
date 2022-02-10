import java.util.ArrayList;
import java.util.Scanner;

class Tent {
    int L;
    int P;
    int V;

    Tent(int L, int P, int V) {
        this.L = L;
        this.P = P;
        this.V = V;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Tent> arr = new ArrayList<>();

        while (true) {
            int L = kb.nextInt();
            int P = kb.nextInt();
            int V = kb.nextInt();

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            if (1 < L && L < P && L < V) {
                arr.add(new Tent(L, P, V));
            }

        }

        int cnt = 0;
        for (Tent ob : arr) {
            // Math.min을 하지 않으면 3 8 20 반례가 있다
            // 나머지가 4일 이어도 캠핑장은 연속으로 3일 밖에 하지 않기 때문에
            // 3을 선택해야 한다
            int answer = ((ob.V / ob.P) * ob.L) + Math.min(ob.V % ob.P, ob.L);
            System.out.println("Case " + (++cnt) + ": " + answer);

        }
    }

}
