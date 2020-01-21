# mathematical-expressions-java

A simple parser for mathematical expressions in Java.

Based on the following EBNF grammar:

```
expr ::= term (+ expr | - expr | epsilon)

term ::= pow (* term | / term | epsilon)

pow ::= factor (^ pow | epsilon)

factor ::= ( expr ) | integer

integer ::= digit digit*

digit ::= [0-9]
```

This grammar (modified) is due to Graham Hutton's book, "Programming in Haskell" (2nd Edition). Check the companion repository, [mathematical-expressions-haskell](https://github.com/timmyjose-projects/mathematical-expressions-haskell) for the comparative implementation in Haskell.
