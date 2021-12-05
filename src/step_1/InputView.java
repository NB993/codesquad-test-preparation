package step_1;

import java.util.Scanner;

public class InputView {

  private final Scanner scanner = new Scanner(System.in);
  private static final int RIGHT_INPUT_LENGTH = 3;

  public String[] input() {
    String[] input = scanner.nextLine().trim().split(" ");
    try {
      validate(input);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return input();
    }
    return input;
  }

  private void validate(String[] input) throws IllegalArgumentException {
    validateLength(input);
    validateDirection(input[1]);
    validateCount(input[2]);
  }

  private void validateLength(String[] input) throws IllegalArgumentException {
    if (input.length != RIGHT_INPUT_LENGTH) {
      throw new IllegalArgumentException("'공백 없는 단어 v 방향 v 밀어낼 횟수' 를 각각 한 칸씩만 띄워서 다시 입력해주세요.");
    }
  }

  private void validateDirection(String direction) throws IllegalArgumentException {
    if (!direction.equalsIgnoreCase("L") && !direction.equalsIgnoreCase("R")) {
      throw new IllegalArgumentException("방향은 l/L 또는 r/R을 입력해주세요.");
    }
  }

  private void validateCount(String countString) throws IllegalArgumentException {
    int count = 0;
    try {
      count = Integer.parseInt(countString);
      if (count < -100 || 100 < count) {
        throw new IllegalArgumentException("밀어낼 횟수는 -100 ~ 100 사이의 값을 입력해주세요.");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("밀어낼 횟수가 제대로 입력되지 않았습니다.");
    }

  }

  public void close() {
    scanner.close();
  }
}
