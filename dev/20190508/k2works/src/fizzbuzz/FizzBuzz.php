<?php
namespace fizzbuzz;

class FizzBuzz
{
    const FIZZ_BUZZ = "FizzBuzz";
    const FIZZ = "Fizz";
    const BUZZ = "Buzz";
    const MAX_NUMBER = 100;

    private $type;
    private $list;

    public function __construct($type)
    {
        $this->type = $type;
        $this->list = $this->generateList();
    }

    public function getList()
    {
        return $this->list;
    }

    public function generate($number)
    {
        return $this->type->generate($number);
    }

    private function generateList()
    {
        return array_map(function ($number) { return $this->generate($number); }, range(1, self::MAX_NUMBER));
    }

}

