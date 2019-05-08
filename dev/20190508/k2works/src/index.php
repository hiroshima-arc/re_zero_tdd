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
            <table>
                <thead>
                <tr>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                    <th>6</th>
                    <th>7</th>
                    <th>8</th>
                    <th>9</th>
                    <th>10</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                    <td>10</td>
                </tr>
                <tr>
                    <td>11</td>
                    <td>12</td>
                    <td>13</td>
                    <td>14</td>
                    <td>15</td>
                    <td>16</td>
                    <td>17</td>
                    <td>18</td>
                    <td>19</td>
                    <td>20</td>
                </tr>
                </tbody>
            </table>
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
    public function 値を1から100までをプリントする()
    {
        $list = printValue();
        $this->assertEquals(1, $list[0]);
        $this->assertEquals(100, $list[99]);
    }
}

function printValue()
{
    $list = [];
    for($i = 1; $i <= 100; $i = $i + 1)
    {
        $list[] = $i;
    }
    return $list;
}