<?php
class FizzBuzz
{
    const FIZZ_BUZZ = "FizzBuzz";
    const FIZZ = "Fizz";
    const BUZZ = "Buzz";
    const MAX_NUMBER = 100;

    private $list;

    public function __construct()
    {
        $this->list = $this->createList();
    }

    public function getList()
    {
        return $this->list;
    }

    public static function generate($number)
    {
        $isFizz = $number % 3 === 0;
        $isBuzz = $number % 5 === 0;

        if ($isFizz && $isBuzz) {
            return self::FIZZ_BUZZ;
        }
        if ($isFizz) {
            return self::FIZZ;
        }
        if ($isBuzz) {
            return self::BUZZ;
        }
        return $number;
    }
    private static function createList()
    {
        return array_map(function ($number) {
            return self::generate($number);
        }, range(1, self::MAX_NUMBER));
    }
}
