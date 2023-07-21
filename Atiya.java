public class Atiya {
    public static void main(String[] args) {
        int[][] list = {{1, 1}, {2, 3}, {3, 4}, {4, 5}, {5, 5},{6,3},{7,3},{8,1},{9,1},{10,4}};
        int bankAmount = 0;

        for (int i = 0; i < list.length; i++) {
            bankAmount += 1;
        }
        int maxGifts = 0;

        for (int i = 0; i < list.length; i++) {
            int giftPrice = list[i][1];

            if (bankAmount >= giftPrice) {
                int affordableGifts = bankAmount / giftPrice;

                if (affordableGifts > maxGifts) {
                    maxGifts = affordableGifts;
                }
            }
        }
        System.out.println("Maximum number of gifts uncle can buy: " + maxGifts);
    }
}