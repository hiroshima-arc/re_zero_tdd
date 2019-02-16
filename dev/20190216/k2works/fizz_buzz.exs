ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "1から100までの数をプリントする" do
    array = FizzBuzz.generate_array()
    assert hd(array) == 1
    assert List.last(array) == 100
    FizzBuzz.print()
  end

  test "3で割り切れる場合はFizzをプリントする" do
    assert "Fizz" == FizzBuzz.execute(3)
    assert 1 == FizzBuzz.execute(1)
  end

  test "5で割り切れる場合はBuzzをプリントする" do
    assert "Buzz" == FizzBuzz.execute(5)
  end

  test "3と5で割り切れる場合はFizzBuzzをプリントする" do
    assert "FizzBuzz" == FizzBuzz.execute(15)
  end
end

defmodule FizzBuzz do
  def generate_array() do
    range = 1..100
    Enum.to_list(range)
  end

  def print() do
    Enum.map(generate_array(), fn(x) -> IO.puts x end)
  end

  def execute(number) do
    cond do
      rem(number, 3) == 0 and rem(number, 5) == 0 -> "FizzBuzz"
      rem(number, 3) == 0 -> "Fizz"
      rem(number, 5) == 0 -> "Buzz"
      true -> number
    end
  end
end
