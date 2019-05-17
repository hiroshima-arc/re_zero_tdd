<?php

include "FizzBuzz.php";

use PHPUnit\Framework\TestCase;
class FizzBuzzTest extends TestCase
{
    public function testGreeting()
    {
        $this->assertEquals("Hello World", greeting());
    }
}

function greeting()
{
    return "Hello World";
}
