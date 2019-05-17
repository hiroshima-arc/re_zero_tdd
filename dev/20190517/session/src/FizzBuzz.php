<?php
class FizzBuzz
{
    public static function generate($number)
    {
        $isFizz = $number % 3 === 0;
        $isBuzz = $number % 5 === 0;

        if ($isFizz && $isBuzz) {
            return "FizzBuzz";
        }
        if ($isFizz) {
            return "Fizz";
        }
        if ($isBuzz) {
            return "Buzz";
        }
        return $number;
    }
    public static function createList()
    {
        return array_map(function ($number) {
            return self::generate($number);
        }, range(1, 100));
    }
}
