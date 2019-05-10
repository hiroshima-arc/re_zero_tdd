<?php

include "FizzBuzz.php";

use PHPUnit\Framework\TestCase;
class FizzBuzzTest extends TestCase {
  /** @noinspection NonAsciiCharacters */
  /**
  * @test
  */
  public function 値を1から100までプリントする() {
      $list = printValue();
      $this->assertEquals(1, $list[0]);
      $this->assertEquals(100, $list[99]);
  }
  /** @noinspection NonAsciiCharacters */
  /**
  * @test
  */
  public function 値が3で割り切れる場合はFizzをプリントする() {
      $this->assertEquals("Fizz", fizzBuzz(3));
  }
  /** @noinspection NonAsciiCharacters */
  /**
  * @test
  */
  public function 値が5で割り切れる場合はBuzzをプリントする() {
      $this->assertEquals("Buzz", fizzBuzz(5));
  }
  /** @noinspection NonAsciiCharacters */
  /**
  * @test
  */
  public function 値が3と5の両方で割り切れる場合はFizzBuzzをプリントする(){
      $this->assertEquals("FizzBuzz",fizzBuzz(15));
  }
}