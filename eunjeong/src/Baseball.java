import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Baseball {
    public static void main(String[] args) {
        int answer = selectNumber(9, 3);

    }

    private static int selectNumber(int range, int select) {
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        int digit = 3;
        int value = 0;

        while (set.size() < select) {
            set.add(random.nextInt(range) + 1);
        }

        for (int i : set) {
            value += Math.pow(10, digit - 1) * i;
            digit--;
        }

        return value;
    }
}
