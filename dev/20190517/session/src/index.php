<?php
function renderTable()
{
    $header = "<thead>";
    $header .= "<tr>";
    for ($i = 1; $i <= 10; $i++) {
        $header .= "<th>{$i}</th>";
    }
    $header .= "</tr>";

    $body = "<tbody>";
    $body .= "<tr>";
    for ($i = 1; $i <= 100; $i++) {
        $body .= "<td>${i}</td>";
        if ($i % 10 === 0) {
            $body .= "</tr>";
        }
    }
    $body .= "</tbody>";

    $table = "<table>
                ${header}
                ${body}
            </table>";

    return $table;
} ?>

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
            <?php print renderTable(); ?>

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