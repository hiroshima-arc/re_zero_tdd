ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "1から100までの数をプリントする、ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方割り切れる場合はFizzBuzzをプリントする" do
    array = FizzBuzz.generate_array()
    assert hd(array) == 1
    assert List.last(array) == "Buzz"
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
  @fizz_buzz "FizzBuzz"
  @fizz "Fizz"
  @buzz "Buzz"

  def generate_array() do
    1..100 |> Enum.map(&execute/1)
  end

  def print() do
    Enum.map(generate_array(), &(IO.puts(&1)))
  end

  def execute(number) do
    cond do
      _isFizz(number) and _isBuzz(number) -> @fizz_buzz
      _isFizz(number) -> @fizz
      _isBuzz(number) -> @buzz
      true -> number
    end
  end

  defp _isFizz(number), do: rem(number, 3) == 0

  defp _isBuzz(number), do: rem(number, 5) == 0
end
