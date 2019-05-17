<?php
class FizzBuzz
{
    const FIZZ_BUZZ = "FizzBuzz";
    const FIZZ = "Fizz";
    const BUZZ = "Buzz";
    const MAX_NUMBER = 100;

    private $list;
    private $type;

    public function __construct($type)
    {
        $this->type = $type;
        $this->list = $this->createList();
    }

    public function getList()
    {
        return $this->list;
    }

    public function generate($number)
    {
        switch ($this->type) {
            case 1:
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
            case 2:
                return $number;
        }
    }
    private function createList()
    {
        return array_map(function ($number) {
            return $this->generate($number);
        }, range(1, self::MAX_NUMBER));
    }
}
