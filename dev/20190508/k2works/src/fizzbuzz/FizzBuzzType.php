<?php
namespace fizzbuzz;

class FizzBuzzType
{
    const FIZZ_BUZZ = "FizzBuzz";
    const FIZZ = "Fizz";
    const BUZZ = "Buzz";

    public function generate($number)
    {
        $fizz = $this->isFizz($number);
        $buzz = $this->isBuzz($number);

        if ($fizz && $buzz) return self::FIZZ_BUZZ;
        if ($fizz) return self::FIZZ;
        if ($buzz) return self::BUZZ;

        return $number;
    }

    protected function isBuzz($number)
    {
        return $number % 5 == 0;
    }

    protected function isFizz($number)
    {
        return $number % 3 == 0;
    }
}
