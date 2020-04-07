import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baseball {
    private static final int RANGE = 9;
    private static final int SELECT = 3;
    private static final int CONTINUE = 1;
    private static int strike = 0;
    private static int ball = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = selectNumber();
        String input;
        int game = CONTINUE;

        while (game == CONTINUE) {
            System.out.println("숫자를 입력해주세요 : ");
            input = br.readLine();

            if (!check(input)) {
                System.out.println("다시 입력해주세요 (중복/0포함/3자리X)");
                continue;
            }

            calculateScore(answer, input);
            System.out.println(print());

            if (strike == SELECT) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                game = Integer.parseInt(br.readLine());
                answer = selectNumber();
            }
        }
    }

    private static boolean check(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        return (set.size() == SELECT) && !set.contains('0');
    }

    private static String selectNumber() {
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        StringBuilder number = new StringBuilder();

        while (set.size() < SELECT) {
            set.add(random.nextInt(RANGE) + 1);
        }

        for (int i : set) {
            number.append(i);
        }
        return number.toString();
    }

    private static void calculateScore(String answer, String input) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < SELECT; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                strike++;
            } else if (answer.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }
    }

    private static String print() {
        StringBuilder answer = new StringBuilder();

        appendString(answer, strike, "스트라이크 ");
        appendString(answer, ball, "볼 ");

        return (answer.length() != 0) ? answer.toString() : "X";
    }

    private static void appendString(StringBuilder stringBuilder, int value, String string) {
        if (value != 0) {
            stringBuilder.append(value).append(string);
        }
    }

}
