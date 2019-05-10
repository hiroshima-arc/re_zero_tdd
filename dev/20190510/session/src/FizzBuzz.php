<?php

function fizzBuzz($number) {
    if ($number % 3 === 0 && $number % 5 === 0) return "FizzBuzz";
    if ($number % 3 === 0) return "Fizz";
    if ($number % 5 === 0) return "Buzz";
    return $number;
}

function generateValue() {
    foreach(range(1,100) as $number) {
        $list[] = fizzBuzz($number);
    }
    return $list;
}