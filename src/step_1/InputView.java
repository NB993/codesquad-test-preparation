package step_1;

import java.util.Scanner;

public class InputView {
  private final Scanner scanner = new Scanner(System.in);

  public String[] input() {
    return scanner.nextLine().trim().split(" ");
  }
}
