<?php

use PHPUnit\Framework\TestCase;
class FizzBuzzTest extends TestCase {
  /** @noinspection NonAsciiCharacters */
  /**
  * @test
  */
  public function 値を1から100までプリントする() {
      $this->assertEquals(1, printValue());
  }
}

function printValue() {
    return 1;
}