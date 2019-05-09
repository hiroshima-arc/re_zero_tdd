<?php
include "src/index.php";
use PHPUnit\Framework\TestCase;

class FizzBuzzTest extends TestCase
{
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値を1から100までをプリントするただし3で割り切れる場合はFizz5で割り切れる場合はBuzz3と5で割り切れる場合はFizzBuzz()
    {
        $type = new FizzBuzzType1();
        $data = new FizzBuzz($type);
        $this->assertEquals(1, $data->getList()[0]);
        $this->assertEquals("Fizz", $data->getList()[2]);
        $this->assertEquals("Buzz", $data->getList()[4]);
        $this->assertEquals("FizzBuzz", $data->getList()[14]);
        $this->assertEquals("Buzz", $data->getList()[99]);
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値が3で割り切れる場合はFizzをプリントする()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("Fizz", $fizzBuzz->generate(3));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値が5で割り切れる場合はBuzzをプリントする()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("Buzz", $fizzBuzz->generate(5));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値が3または5で割り切れる場合はFizzBuzzをプリントする()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function タイプ1は通常のパターンを返す()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("Fizz", $fizzBuzz->generate(3));
        $this->assertEquals("Buzz", $fizzBuzz->generate(5));
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function タイプ2は数字のみを返す()
    {
        $type = new FizzBuzzType2();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals(3, $fizzBuzz->generate(3));
        $this->assertEquals(5, $fizzBuzz->generate(5));
        $this->assertEquals(15, $fizzBuzz->generate(15));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function タイプ3はFizzBuzzの場合のみ返す()
    {
        $type = new FizzBuzzType3();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals(3, $fizzBuzz->generate(3));
        $this->assertEquals(5, $fizzBuzz->generate(5));
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
}

