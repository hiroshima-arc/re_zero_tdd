<?php

function fizzBuzz($number) {
    if ($number % 3 === 0 && $number % 5 === 0) return "FizzBuzz";
    if ($number % 3 === 0) return "Fizz";
    if ($number % 5 === 0) return "Buzz";
    return $number;
}

function generateValue() {
    $list = [];
    for($i = 1; $i <= 100; $i++) {
       $list[] = fizzBuzz($i); 
    }
    return $list;
}