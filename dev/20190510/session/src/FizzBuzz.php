<?php

function fizzBuzz($number) {
    if ($number % 3 === 0 && $number % 5 === 0) return "FizzBuzz";
    if ($number % 3 === 0) return "Fizz";
    if ($number % 5 === 0) return "Buzz";
    return $number;
}

function generateValue() {
    return array_map(
        function($number) { 
            return fizzBuzz($number);
        }, 
        range(1,100)
    );
}