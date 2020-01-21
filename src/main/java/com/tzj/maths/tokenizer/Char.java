package com.tzj.maths.tokenizer;

public class Char {
  public char c;
  public int line;
  public int column;

  public Char(final char c, final int line, final int column) {
    this.c = c;
    this.line = line;
    this.column = column;
  }

  @Override
  public String toString() {
    return "(" + c + ", " + line + ", " + column + ")";
  }
}
