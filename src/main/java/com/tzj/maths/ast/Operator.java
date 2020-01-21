package com.tzj.maths.ast;

public class Operator extends Terminal {
  public Operator(final String spelling) {
    super(spelling);
  }

  @Override
  public String toString() {
    return "Operator { spelling = " + spelling + " }";
  }
}
