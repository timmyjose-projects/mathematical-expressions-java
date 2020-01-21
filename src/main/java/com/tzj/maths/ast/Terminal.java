package com.tzj.maths.ast;

public abstract class Terminal extends AST {
  String spelling;

  public Terminal(final String spelling) {
    this.spelling = spelling;
  }
}
