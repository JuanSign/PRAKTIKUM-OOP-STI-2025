
/**
 * Main.java
 * 
 * @author [NIM] [Nama]
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /**
     * Mengecek apabila kartu memiliki nilai 10, J, Q, K, A
     * 
     * @param cards
     * @return true apabila kartu memiliki 10 sampai As, false sebaliknya
     */
    public static boolean isRoyal(String[] cards) {
        for (String card : cards) {
            char value = card.charAt(1);
            if (value != 'T' && value != 'J' && value != 'Q' && value != 'K' && value != 'A') {
                return false;
            }
        }
        return true;
    }

    /**
     * Mengecek apabila kartu dapat membentuk Full House
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Full House, false sebaliknya
     */
    public static boolean isFullHouse(String[] cards) {
        Map<Character, Integer> rankCount = new HashMap<>();
        for (String card : cards) {
            char rank = card.charAt(1);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        boolean hasThree = false;
        boolean hasTwo = false;
        for (int count : rankCount.values()) {
            if (count == 3)
                hasThree = true;
            if (count == 2)
                hasTwo = true;
        }
        return hasThree && hasTwo;
    }

    /**
     * Mengecek apabila kartu dapat membentuk Flush
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Flush, false sebaliknya
     */
    public static boolean isFlush(String[] cards) {
        char suit = cards[0].charAt(0);
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].charAt(0) != suit) {
                return false;
            }
        }
        return true;
    }

    /**
     * Mengembalikan rangking dari set yang dimiliki dengan rangking berikut:
     * - Royal Flush: 3
     * - Full House: 2
     * - Flush: 1
     * - High Card: 0
     * 
     * @param cards
     * @return rangking
     */
    public static int getSetRanking(String[] cards) {
        boolean flush = isFlush(cards);
        boolean royal = isRoyal(cards);
        boolean fullHouse = isFullHouse(cards);

        if (flush && royal)
            return 3;
        if (fullHouse)
            return 2;
        if (flush)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        String[] cardsTuanBil = new String[5];
        String[] cardsTuanMask = new String[5];

        /* YOUR CODE HERE */
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            cardsTuanBil[i] = scanner.nextLine().toUpperCase();
        }
        for (int i = 0; i < 5; i++) {
            cardsTuanMask[i] = scanner.nextLine().toUpperCase();
        }
        scanner.close();

        int skorTuanBil = getSetRanking(cardsTuanBil);
        int skorTuanMask = getSetRanking(cardsTuanMask);

        if (skorTuanBil > skorTuanMask) {
            System.out.println("Tuan Bil");
            System.out.println(skorTuanBil);
        } else if (skorTuanBil < skorTuanMask) {
            System.out.println("Tuan Mask");
            System.out.println(skorTuanMask);
        } else {
            System.out.println("Seri");
            System.out.println(skorTuanBil);
        }
    }
}