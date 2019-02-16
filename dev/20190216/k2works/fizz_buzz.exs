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
    if rem(number, 3) == 0, do: "Fizz", else: number
  end
end
