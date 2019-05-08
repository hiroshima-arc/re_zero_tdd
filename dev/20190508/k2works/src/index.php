<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Re:ゼロから始めるテスト駆動開発</title>
    <link href="https://cdn.rawgit.com/mochajs/mocha/2.2.5/mocha.css" rel="stylesheet"/>


    <style type="text/css">
        body {
            width: 810px;
            margin: 0 auto;
            background-color: ivory;
        }

        header {
            width: 350px;
        }

        .nav-component {
            width: 290px;
            float: left;
            padding: 5px;
            margin-bottom: 5px;
        }

        .fizz-buzz-component {
            width: 500px;
            float: right;
            padding-left: 5px;
            padding-bottom: 10px;
            margin-bottom: 5px;
        }

        .fizz-buzz-component table {
            margin-top: 10px;
            border-collapse: collapse;
        }

        .fizz-buzz-component th {
            border: 1px solid black;
            background-color: aqua;
        }

        .fizz-buzz-component td {
            border: 1px solid black;
        }

        footer {
            clear: both;
            width: auto;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>HTML5+CSS+JavaScript with TDD</h1>
<header>
    <nav class="nav-component">
        <h1>Menu</h1>
        <ul>
            <li><a href="readme.html" target="_blank">README</a></li>
            <li><a href="index">FizzBuzz</a></li>
        </ul>
    </nav>
</header>
<section>
    <section class="fizz-buzz-component">
        <h2>FizzBuzz</h2>
        <div id="app">
            <form action="./index.php" method="GET">
                <select name="type">
                    <option value="one">タイプ1</option>
                    <option value="two">タイプ2</option>
                    <option value="three">タイプ3</option>
                </select><br/>
                <?php

                $type = $_GET['type'];
                if( isset($type) ){
                    print "送信された内容はType:{$type}です。<br/>";
                    print renderTableFactory($type);
                } else {
                    print renderTable(new FizzBuzzType1());
                }

                ?>
                <input type="submit" value="送信"/>
            </form>
        </div>
        <div id="mocha"></div>
    </section>
</section>
<footer>
    <p>Copyright</p>
    <address>hiroshima.arc@gmail.com</address>
</footer>

<script src="https://cdn.rawgit.com/jquery/jquery/2.1.4/dist/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chai/4.2.0/chai.min.js"></script>
<script src="https://cdn.rawgit.com/mochajs/mocha/2.2.5/mocha.js"></script>
<script>mocha.setup("tdd");</script>

<script>
</script>

<script>
  mocha.checkLeaks();
  mocha.globals(["jQuery"]);
  mocha.run();
</script>

</body>
</html>

<?php

use PHPUnit\Framework\TestCase;

class FizzBuzzTest extends TestCase
{
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値を1から100までをプリントするただし3で割り切れる場合はFizz5で割り切れる場合はBuzz3と5で割り切れる場合はFizzBuzz()
    {
        $type = new FizzBuzzType1();
        $data = new FizzBuzz($type);
        $this->assertEquals(1, $data->getList()[0]);
        $this->assertEquals("Fizz", $data->getList()[2]);
        $this->assertEquals("Buzz", $data->getList()[4]);
        $this->assertEquals("FizzBuzz", $data->getList()[14]);
        $this->assertEquals("Buzz", $data->getList()[99]);
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値が3で割り切れる場合はFizzをプリントする()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("Fizz", $fizzBuzz->generate(3));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値が5で割り切れる場合はBuzzをプリントする()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("Buzz", $fizzBuzz->generate(5));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function 値が3または5で割り切れる場合はFizzBuzzをプリントする()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
    public function タイプ1は通常のパターンを返す()
    {
        $type = new FizzBuzzType1();
        $fizzBuzz = new FizzBuzz($type);
        $this->assertEquals("Fizz", $fizzBuzz->generate(3));
        $this->assertEquals("Buzz", $fizzBuzz->generate(5));
        $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
    }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
     public function タイプ2は数字のみを返す()
     {
         $type = new FizzBuzzType2();
         $fizzBuzz = new FizzBuzz($type);
         $this->assertEquals(3, $fizzBuzz->generate(3));
         $this->assertEquals(5, $fizzBuzz->generate(5));
         $this->assertEquals(15, $fizzBuzz->generate(15));
     }
    /** @noinspection NonAsciiCharacters */
    /**
     * @test
     */
     public function タイプ3はFizzBuzzの場合のみ返す()
     {
         $type = new FizzBuzzType3();
         $fizzBuzz = new FizzBuzz($type);
         $this->assertEquals(3, $fizzBuzz->generate(3));
         $this->assertEquals(5, $fizzBuzz->generate(5));
         $this->assertEquals("FizzBuzz", $fizzBuzz->generate(15));
     }
}

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

class FizzBuzzType1 extends FizzBuzzType
{
}

class FizzBuzzType2 extends FizzBuzzType
{
    public function generate($number)
    {
        return $number;
    }
}

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

function renderTable($type)
{
    $fizzBuzz = new FizzBuzz($type);
    $line = "<tr>";
    foreach (range(1, 10) as $i) {
        $item = "<th>{$i}</th>";
        $line .= $item;
    }
    $line .= "</tr>";

    $header = "
                <thead>
                {$line}
                </thead>
                ";

    $line = "<tr>";
    $list = $fizzBuzz->getList();
    foreach ($list as $key => $value) {
        $item = "<td>{$value}</td>";
        $line .= $item;
        if (($key + 1) % 10 == 0) {
            $line .= "</tr>";
        }
    }

    $body = "<tbody>
             {$line}
             </tbody>";

    $table = "<table>
             {$header}
             {$body}
             </table>";

    return $table;
}

function renderTableFactory($type)
{
    switch ($type) {
        case "one":
            return renderTable(new FizzBuzzType1());
        case "two":
            return renderTable(new FizzBuzzType2());
        case "three":
            return renderTable(new FizzBuzzType3());
        default:
            return renderTable(new FizzBuzzType1());
    }
}

