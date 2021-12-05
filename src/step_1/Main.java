package step_1;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    String[] input = inputView.input();
    String inputWord = input[0];
    String direction = input[1];
    int count = Integer.parseInt(input[2]);

    Word word = new Word(inputWord, direction, count);
    PrintView.printWord(word);
  }
}
