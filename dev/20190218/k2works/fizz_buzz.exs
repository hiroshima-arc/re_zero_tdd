ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "1から100までの数をプリントする,ただし3で割り切れる場合はFizz,5で割り切れる場合はBuzz,両方で割り切れる場合はFizzBuzzをプリントする" do
    list = FizzBuzz.generate_list(100)
    assert List.first(list) == 1
    assert Enum.take(list, 3) |> List.last() == "Fizz"
    assert Enum.take(list, 5) |> List.last() == "Buzz"
    assert Enum.take(list, 15) |> List.last() == "FizzBuzz"
    assert List.last(list) == "Buzz"
    FizzBuzz.print()
  end

  test "3で割り切れる場合はFizzを返す" do
    assert FizzBuzz.exec(3) == "Fizz"
    assert FizzBuzz.exec(1) == 1
  end

  test "5で割り切れる場合はBuzzを返す" do
    assert FizzBuzz.exec(5) == "Buzz"
  end

  test "3と5で割り切れる場合はFizzBuzzを返す" do
    assert FizzBuzz.exec(15) == "FizzBuzz"
  end
end

defmodule FizzBuzz do
  def print do
    Enum.map(generate_list(100), fn (i) -> IO.puts(i) end)
  end

  def generate_list(n) do
    1..n |> Enum.map(fn (n) -> exec(n) end)
  end

  def exec(number) when rem(number, 3) == 0 and rem(number, 5) == 0, do: "FizzBuzz"

  def exec(number) when rem(number, 3) == 0, do: "Fizz"

  def exec(number) when rem(number, 5) == 0, do: "Buzz"

  def exec(number), do: number
end
