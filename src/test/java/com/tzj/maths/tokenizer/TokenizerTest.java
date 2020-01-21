package com.tzj.maths.tokenizer;

import org.junit.Test;

public class TokenizerTest {
  @Test
  public void basicTokenizerTest() {
    final Tokenizer tokenizer = new Tokenizer("(1 + 2) *3\n");

    while (tokenizer.hasMoreChars()) {
      System.out.print(tokenizer.nextChar() + " ");
    }
  }
}
