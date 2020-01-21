package com.tzj.maths.scanner;

import org.junit.Test;

public class ScannerTest {
  @Test
  public void basicScannerTest() {
    final Scanner scanner = new Scanner("(1 + 2) *3\n");

    while (scanner.hasMoreTokens()) {
      System.out.println(scanner.nextToken());
    }
  }
}