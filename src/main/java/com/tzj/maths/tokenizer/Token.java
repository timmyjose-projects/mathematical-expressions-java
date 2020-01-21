package com.tzj.maths.tokenizer;

import java.util.Map;
import java.util.HashMap;

public class Token {
  public enum Kind {
    INTEGERLITERAL("<integer-literal>"),
    OPERATOR("<operator>"),
    LPAREN("("),
    RPAREN(")"),
    EOT("<eot>");

    private String description;

    private Kind(final String description) {
      this.description = description;
    }

    public String getDescription() {
      return this.description;
    }
  }

  public Kind kind;
  public String spelling;
  public int line;
  public int column;

  public Token(final Kind kind, final String spelling, int line, int column) {
    if (Token.isKeyword(spelling)) {
      this.kind = Token.getKeywordKind(spelling);
    } else {
      this.kind = kind;
    }

    this.spelling = spelling;
    this.line = line;
    this.column = column;
  }

  public static boolean isKeyword(final String spelling) {
    return keywordMap.containsKey(spelling);
  }

  public static Kind getKeywordKind(final String spelling) {
    return keywordMap.get(spelling);
  }

  @Override
  public String toString() {
    return "<" + kind + ", " + spelling + ">";
  }

  private static final Map<String, Kind> keywordMap;

  static {
    keywordMap = new HashMap<>();

    keywordMap.put("(", Kind.LPAREN);
    keywordMap.put(")", Kind.RPAREN);
    keywordMap.put("\000", Kind.EOT);
  }
}
