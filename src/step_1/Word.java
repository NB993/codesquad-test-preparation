package step_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {

  private List<String> alphabets;

  public Word(String word, String direction, int count) throws IllegalArgumentException {
    this.alphabets = Arrays.asList(word.split(""));
    pushAlphabet(direction, count);
  }

  //TODO : 밀어내기 구현
  public void pushAlphabet(String direction, int count) {
    int wordLength = alphabets.size();
    int pushCount = count % wordLength;
    List<String> pushedAlphabets = new ArrayList<>();

    if (direction.equalsIgnoreCase("R") && count > 0) {
      pushedAlphabets.addAll(alphabets.subList(alphabets.size() - pushCount, alphabets.size()));
      pushedAlphabets.addAll(alphabets.subList(0, alphabets.size() - pushCount));
      alphabets = pushedAlphabets;
    }
    if (direction.equalsIgnoreCase("R") && count < 0) {
      pushedAlphabets.addAll(alphabets.subList(-pushCount, alphabets.size()));
      pushedAlphabets.addAll(alphabets.subList(0, -pushCount));
      alphabets = pushedAlphabets;
    }
    if (direction.equalsIgnoreCase("L") && count > 0) {
      pushedAlphabets.addAll(alphabets.subList(pushCount, alphabets.size()));
      pushedAlphabets.addAll(alphabets.subList(0, pushCount));
      alphabets = pushedAlphabets;
    }
    if (direction.equalsIgnoreCase("L") && count < 0) {
      pushedAlphabets.addAll(alphabets.subList(alphabets.size() + pushCount, alphabets.size()));
      pushedAlphabets.addAll(alphabets.subList(0, alphabets.size() + pushCount));
      alphabets = pushedAlphabets;
    }
  }

  @Override
  public String toString() {
    return String.join("", alphabets);
  }
}
