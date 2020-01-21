package com.tzj.maths.scanner;

import java.util.List;
import java.util.ArrayList;

import com.tzj.maths.tokenizer.*;
import com.tzj.maths.error.ScannerException;

public class Scanner {
  private Tokenizer tokenizer;
  private Char currentChar;
  private int currentLine = 0;
  private int currentColumn = 0;
  private StringBuffer currentSpelling;

  private List<Token> tokens;
  private int index = 0;

  public Scanner(final String input) {
    tokenizer = new Tokenizer(input);
    tokens = new ArrayList<>();
    scan();
  }

  // scanning starts here
  private void scan() {
    currentChar = tokenizer.nextChar();

    while (tokenizer.hasMoreChars()) {
      while (currentChar.c == ' ' || currentChar.c == '\n') {
        scanSeparator();
      }

      currentSpelling = new StringBuffer();
      final Token.Kind kind = scanToken();

      tokens.add(new Token(kind, currentSpelling.toString(), currentLine, currentColumn));
    }
  }

  private void scanSeparator() {
    switch (currentChar.c) {
      case ' ':
      case '\n': 
        skipIt();
        break;
    }
  }

  private Token.Kind scanToken() {
    currentLine = currentChar.line;
    currentColumn = currentChar.column;

    switch (currentChar.c) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
        {
          takeIt();

          while (Character.isDigit(currentChar.c)) {
            takeIt();
          }

          return Token.Kind.INTEGERLITERAL;
        }

      case '+':
      case '-':
      case '*':
      case '/':
      case '^':
        {
          takeIt();
          return Token.Kind.OPERATOR;
        }

      case '(':
        {
          takeIt();
          return Token.Kind.LPAREN;
        }

      case ')':
        {
          takeIt();
          return Token.Kind.RPAREN;
        }

      case '\000':
        {
          skipIt();
          return Token.Kind.EOT;
        }

      default:
        {
          throw new ScannerException(String.format("[Line: %d, Column: %d] expected to scan a number, operator, or parenthesis. Found %s",
                currentChar.line,
                currentChar.column,
                currentChar));
        }
    }
  }

  private void skipIt() {
    currentChar = tokenizer.nextChar(); 
  }

 private void takeIt() {
    currentSpelling.append(currentChar.c);
    currentChar = tokenizer.nextChar();
  }

  public boolean hasMoreTokens() {
    return index < tokens.size();
  }

  public Token nextToken() {
    final Token val = tokens.get(index);
    index++;

    return val;
  }
}
