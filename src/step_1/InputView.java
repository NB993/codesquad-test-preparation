package step_1;

import java.util.Scanner;

public class InputView {
  private final Scanner scanner = new Scanner(System.in);

  public String[] input() {
    String[] input = scanner.nextLine().trim().split(" ");
    try {
      validate(input);
    } catch(IllegalArgumentException e) {
      e.getMessage();
      return input();
    }
    return input;
  }

  private void validate(String[] input) throws IllegalArgumentException {
    validateLength(input);
    validateWord(input[0]);
    validateDirection(input[1]);
    validateCount(input[2]);
  }

  private void validateLength(String[] input) {
    if (input.length > 3) {
      throw new IllegalArgumentException("공백 없는 단어, 방향, 밀어낼 횟수를 각각 한 칸씩만 띄워서 다시 입력해주세요.");
    }
  }

  private void validateWord(String word) {
    if (word.contains(" ")) {
      throw new IllegalArgumentException("공백 없는 단어를 입력해주세요.");
    }
  }

  private void validateDirection(String direction) {
    String upperCaseDirection = direction.toUpperCase();
    if (!upperCaseDirection.equals("L") && !upperCaseDirection.equals("R")) {
      throw new IllegalArgumentException("방향은 l/L 또는 r/R을 입력해주세요.");
    }
  }

  private void validateCount(String countString) {
    int count = 0;
    try {
      count = Integer.parseInt(countString);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("밀어낼 횟수가 제대로 입력되지 않았습니다.");
    }

    if (count < -100 || 100 < count) {
      throw new IllegalArgumentException("밀어낼 횟수는 -100 ~ 100 사이의 값을 입력해주세요.");
    }
  }
}
