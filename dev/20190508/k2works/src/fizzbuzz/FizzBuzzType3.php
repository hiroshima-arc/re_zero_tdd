<?php


class FizzBuzzType3 extends FizzBuzzType
{
    public function generate($number)
    {
        $fizz = $this->isFizz($number);
        $buzz = $this->isBuzz($number);

        if ($fizz && $buzz) return self::FIZZ_BUZZ;

        return $number;
    }
}
