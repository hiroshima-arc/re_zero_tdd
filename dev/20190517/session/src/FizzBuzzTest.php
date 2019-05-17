<?php

include "FizzBuzz.php";
include "FizzBuzzData.php";

use PHPUnit\Framework\TestCase;
class FizzBuzzTest extends TestCase
{
    /**
     * @test
     */
    public function 値を1から100までプリントするただし３で割り切れる場合はFizz5で割り切れる場合はBuzz3と5で割り切れる場合はFizzBuzzをプリントする()
    {
        $data = new FizzBuzzData();
        $data->setList(FizzBuzz::createList());
        $this->assertEquals(1, $data->getList()[0]);
        $this->assertEquals("Fizz", $data->getList()[2]);
        $this->assertEquals("Buzz", $data->getList()[4]);
        $this->assertEquals("FizzBuzz", $data->getList()[14]);
        $this->assertEquals("Buzz", $data->getList()[99]);
    }
    /**
     * @test
     */
    public function 値が3で割り切れる場合はFizzをプリントする()
    {
        $this->assertEquals("Fizz", FizzBuzz::generate(3));
    }
    /**
     * @test
     */
    public function 値が5で割り切れる場合はBuzzをプリントする()
    {
        $this->assertEquals("Buzz", FizzBuzz::generate(5));
    }
    /**
     * @test
     */
    public function 値が3または5で割り切れる場合はFizzBuzzをプリントする()
    {
        $this->assertEquals("FizzBuzz", FizzBuzz::generate(15));
    }
}
