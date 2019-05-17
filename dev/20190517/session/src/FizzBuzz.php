<?php

function fizzBuzz($number)
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
function createList()
{
    $list = [];
    for ($i = 1; $i <= 100; $i++) {
        $list[] = fizzBuzz($i);
    }
    return $list;
}
