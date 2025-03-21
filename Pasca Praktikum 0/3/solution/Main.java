import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += scanner.nextInt();
        }
        int mul = scanner.nextInt();
        ans *= mul;
        int bos = scanner.nextInt();
        if (bos == 1)
            ans *= 2;
        if (bos == 2)
            ans *= 3;
        System.out.println(ans);
        scanner.close();
    }
}
