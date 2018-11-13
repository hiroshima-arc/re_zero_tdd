defmodule FizzBuzz do
  @type t :: pos_integer | Fizz | Buzz | FizzBuzz
  @spec generate(pos_integer) :: t()
  def generate(n) when rem(n, 3) == 0 and rem(n, 5) == 0, do: FizzBuzz
  def generate(n) when rem(n, 3) == 0, do: Fizz
  def generate(n) when rem(n, 5) == 0, do: Buzz
  def generate(n), do: n

  @spec iterate(pos_integer) :: [t()]
  def iterate(n) do
    for i <- 1..n, do: generate(i)
  end
end

ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "3ならFizzを返す" do
    assert FizzBuzz.generate(3) == Fizz
  end

  test "5ならばBuzzを返す" do
    assert FizzBuzz.generate(5) == Buzz
  end

  test "15ならばFizzBuzzを返す" do
    assert FizzBuzz.generate(15) == FizzBuzz
  end

  test "30ならばFizzBuzzを返す" do
    assert FizzBuzz.generate(30) == FizzBuzz
  end

  test "5回実行されたならば配列を返す" do
    assert FizzBuzz.iterate(5) == [1, 2, Fizz, 4, Buzz]
  end

  test "10回実行されたならば配列を返す" do
    assert FizzBuzz.iterate(10) == [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz]
  end

  test "15回実行されたならば配列を返す" do
    assert FizzBuzz.iterate(15) == [
             1,
             2,
             Fizz,
             4,
             Buzz,
             Fizz,
             7,
             8,
             Fizz,
             Buzz,
             11,
             Fizz,
             13,
             14,
             FizzBuzz
           ]
  end
end
