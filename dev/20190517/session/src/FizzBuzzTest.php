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
        $data = new FizzBuzz(new FizzBuzzType1());
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
        $fizzBuzz = new FizzBuzz(new FizzBuzzType1());
        $this->assertEquals("Fizz", $fizzBuzz->generate(3));
    }
    /**
     * @test
     */
    public function 値が5で割り切れる場合はBuzzをプリントする()
    {
        $fizzBuzz = new FizzBuzz(new FizzBuzzType1());
        $this->assertEquals("Buzz", $fizzBuzz->generate(5));
    }
    /**
     * @test
     */
    public function 値が3または5で割り切れる場合はFizzBuzzをプリントする()
    {
        $fizzBuzz = new FizzBuzz(new FizzBuzzType1());
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
    /**
     * @test
     */
    public function タイプ1は通常のパターンを返す()
    {
        $fizzBuzz = new FizzBuzz(new FizzBuzzType1());
        $this->assertEquals("Fizz", $fizzBuzz->generate(3));
        $this->assertEquals("Buzz", $fizzBuzz->generate(5));
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
    /**
     * @test
     */
    public function タイプ2は数字のみを返す()
    {
        $fizzBuzz = new FizzBuzz(new FizzBuzzType2());
        $this->assertEquals(3, $fizzBuzz->generate(3));
        $this->assertEquals(5, $fizzBuzz->generate(5));
        $this->assertEquals(15, $fizzBuzz->generate(15));
    }
    /**
     * @test
     */
    public function タイプ3は数字かFizzBuzzを返す()
    {
        $fizzBuzz = new FizzBuzz(new FizzBuzzType3());
        $this->assertEquals(3, $fizzBuzz->generate(3));
        $this->assertEquals(5, $fizzBuzz->generate(5));
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
}
