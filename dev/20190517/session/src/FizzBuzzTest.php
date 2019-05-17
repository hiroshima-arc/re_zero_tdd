<?php

include "FizzBuzz.php";

use PHPUnit\Framework\TestCase;
class FizzBuzzTest extends TestCase
{
    /**
     * @test
     */
    public function 値を1から100までプリントするただし３で割り切れる場合はFizz5で割り切れる場合はBuzz3と5で割り切れる場合はFizzBuzzをプリントする()
    {
        $list = createList();
        $this->assertEquals(1, $list[0]);
        $this->assertEquals("Fizz", $list[2]);
        $this->assertEquals("Buzz", $list[4]);
        $this->assertEquals("FizzBuzz", $list[14]);
        $this->assertEquals("Buzz", $list[99]);
    }
    /**
     * @test
     */
    public function 値が3で割り切れる場合はFizzをプリントする()
    {
        $this->assertEquals("Fizz", fizzBuzz(3));
    }
    /**
     * @test
     */
    public function 値が5で割り切れる場合はBuzzをプリントする()
    {
        $this->assertEquals("Buzz", fizzBuzz(5));
    }
    /**
     * @test
     */
    public function 値が3または5で割り切れる場合はFizzBuzzをプリントする()
    {
        $this->assertEquals("FizzBuzz", fizzBuzz(15));
    }
}
