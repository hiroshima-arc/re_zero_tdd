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
}
function printValue()
{
    $list = [];
    for ($i = 1; $i <= 100; $i++) {
        $list[] = $i;
    }
    return $list;
}
