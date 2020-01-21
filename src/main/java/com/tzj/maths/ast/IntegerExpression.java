package com.tzj.maths.ast;

public class IntegerExpression extends Expression {
  IntegerLiteral I;

  public IntegerLiteral(final IntegerLiteral I) {
    this.I = I;
  }

  @Override
  public String toString() {
    return "IntegerExpression { I = " + I + " }";
  }
}
