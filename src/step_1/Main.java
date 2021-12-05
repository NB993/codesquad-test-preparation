package step_1;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    String[] input = inputView.input();
    Word word = new Word(input);
    PrintView.printWord(word);
  }
}
