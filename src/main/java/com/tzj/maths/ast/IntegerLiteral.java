package com.tzj.maths.ast;

public class IntegerLiteral extends Terminal {
  public IntegerLiteral(final String spelling) {
    super(spelling);
  }

  @Override
  public String toString() {
    return "IntegerLiteral { spelling = " + spelling + " }";
  }
}
