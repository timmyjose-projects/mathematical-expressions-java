package com.tzj.maths.tokenizer;

import java.util.List;
import java.util.ArrayList;

public class Tokenizer {
  private List<Char> characters;
  private int index = 0;

  public Tokenizer(final String input) {
    characters = new ArrayList<>();

    int linum = 0, column = 0;
    for (String line : input.split("\n")) {
      linum++;

      for (char c : line.toCharArray()) {
        column++;
        characters.add(new Char(c, linum, column));
      }
      column = 0;
    }

    // for EOT
    characters.add(new Char('\000', -1, -1));
    // hack - find better way to force eot to be scanned
    characters.add(new Char('\000', -1, -1));
  }

  public boolean hasMoreChars() {
    return index < characters.size();
  }

  public Char nextChar() {
    final Char val = characters.get(index);
    index++;

    return val;
  }
}
