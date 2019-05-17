<?php

include "FizzBuzz.php";

use PHPUnit\Framework\TestCase;
class FizzBuzzTest extends TestCase
{
    /**
     * @test
     */
    public function 値を1から100までプリントする()
    {
        $list = printValue();
        $this->assertEquals(1, $list[0]);
        $this->assertEquals(100, $list[99]);
    }
    /**
     * @test
     */
    public function 値が3で割り切れる場合はFizzをプリントする()
    {
        $this->assertEquals("Fizz", fizzBuzz(3));
    }
}
function fizzBuzz($number)
{
    $result = $number;
    if ($number % 3 === 0) {
        $result = "Fizz";
    }
    return $result;
}
function printValue()
{
    $list = [];
    for ($i = 1; $i <= 100; $i++) {
        $list[] = $i;
    }
    return $list;
}
