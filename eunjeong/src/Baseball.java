import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baseball {
    private static final int RANGE = 9;
    private static final int SELECT = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = selectNumber();
        String input;
        int[] result;
        int game = 1;

        while (game == 1) {
            System.out.println("숫자를 입력해주세요 : ");
            input = br.readLine();

            if (!check(input)) {
                System.out.println("다시 입력해주세요 (중복/0포함)");
                continue;
            }

            result = calculateScore(answer, input);
            System.out.println(print(result[0], result[1]));

            if (result[0] == SELECT) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

                game = Integer.parseInt(br.readLine());
                answer = selectNumber();
            }
        }
    }

    private static boolean check(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < SELECT; i++) {
            set.add(input.charAt(i));
        }

        if (set.size() != 3) {
            return false;
        } else {
            return !set.contains('0');
        }
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

    private static int[] calculateScore(String answer, String input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < SELECT; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                strike++;
            } else if (answer.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }

    private static String print(int strike, int ball) {
        StringBuilder answer = new StringBuilder();

        if (strike != 0) {
            answer.append(strike).append(" 스트라이크 ");
        }

        if (ball != 0) {
            answer.append(ball).append(" 볼 ");
        }

        return answer.toString();
    }
}
