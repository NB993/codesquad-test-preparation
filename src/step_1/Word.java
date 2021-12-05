package step_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {

  private List<String> alphabets;

  public Word(String[] input) {
    this.alphabets = Arrays.asList(input[0].split(""));
    pushAlphabet(input[1], Integer.parseInt(input[2]));
  }

  public void pushAlphabet(String direction, int count) {
    int wordLength = alphabets.size();
    int pushCount = count % wordLength;
    if (direction.equalsIgnoreCase("R") && count > 0) {
      pushRightPlus(pushCount, wordLength);
    }
    if (direction.equalsIgnoreCase("R") && count < 0) {
      pushRightMinus(pushCount, wordLength);
    }
    if (direction.equalsIgnoreCase("L") && count > 0) {
      pushLeftPlus(pushCount, wordLength);
    }
    if (direction.equalsIgnoreCase("L") && count < 0) {
      pushLeftMinus(pushCount, wordLength);
    }
  }

  private void pushRightPlus(int pushCount, int wordLength) {
    List<String> pushedAlphabets = new ArrayList<>();
    pushedAlphabets.addAll(alphabets.subList(wordLength - pushCount, wordLength));
    pushedAlphabets.addAll(alphabets.subList(0, wordLength - pushCount));
    alphabets = pushedAlphabets;
  }

  private void pushRightMinus(int pushCount, int wordLength) {
    List<String> pushedAlphabets = new ArrayList<>();
    pushedAlphabets.addAll(alphabets.subList(-pushCount, wordLength));
    pushedAlphabets.addAll(alphabets.subList(0, -pushCount));
    alphabets = pushedAlphabets;
  }

  private void pushLeftPlus(int pushCount, int wordLength) {
    List<String> pushedAlphabets = new ArrayList<>();
    pushedAlphabets.addAll(alphabets.subList(pushCount, wordLength));
    pushedAlphabets.addAll(alphabets.subList(0, pushCount));
    alphabets = pushedAlphabets;
  }

  private void pushLeftMinus(int pushCount, int wordLength) {
    List<String> pushedAlphabets = new ArrayList<>();
    pushedAlphabets.addAll(alphabets.subList(wordLength + pushCount, wordLength));
    pushedAlphabets.addAll(alphabets.subList(0, wordLength + pushCount));
    alphabets = pushedAlphabets;
  }

  @Override
  public String toString() {
    return String.join("", alphabets);
  }
}
