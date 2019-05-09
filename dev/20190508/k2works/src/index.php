<?php
include "fizzbuzz/FizzBuzz.php";
include "fizzbuzz/FizzBuzzType.php";
include "fizzbuzz/FizzBuzzType1.php";
include "fizzbuzz/FizzBuzzType2.php";
include "fizzbuzz/FizzBuzzType3.php";

use fizzbuzz\{
    FizzBuzz,
    FizzBuzzType1,
    FizzBuzzType2,
    FizzBuzzType3
};

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

?>

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
                <input type="submit" value="送信"/>
                <?php

                $type = $_GET['type'];
                if( isset($type) ){
                    print "送信された内容はType:{$type}です。<br/>";
                    print renderTableFactory($type);
                } else {
                    print renderTableFactory("one");
                }

                ?>
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

