package com.tzj.maths.parser;

import com.tzj.maths.scanner.Scanner;
import com.tzj.maths.tokenizer.Token;
import com.tzj.maths.ast.*;
import com.tzj.maths.error.ParserException;

public class Parser {
  private Scanner scanner;
  private Token currentToken;  

  public Parser(final String input) {
    scanner = new Scanner(input);
  }

  // parsing starts here
  public AST parse() {
    return null;
  }

  private void acceptIt() {
    currentToken = scanner.nextToken();
  }

  private void accept(final Token.Kind expectedTokenKind) {
    if (currentToken.kind != expectedTokenKind) {
      throw new ParserException(String.format("[Line: %d, Column: %d] expected token of kind %s, found kind %",
            currentToken.line,
            currentToken.column,
            expectedTokenKind,
            currentToken.kind));
    }

    currentToken = scanner.nextToken();
  }
}