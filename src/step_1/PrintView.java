package step_1;

public class PrintView {

  public static void printInputGuide() {
    System.out.println("[공백 없는 단어] V [단어를 밀어낼 방향(l/L r/R)] V [밀어낼 자릿수(-100 ~ 100)]' 를 입력해주세요.");
    System.out.println("ex) apple r 2   ->  leapp");
  }

  public static void printWord(Word word) {
    System.out.println(word);
  }
}
