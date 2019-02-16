ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "1から100までの数をプリントする" do
    array = FizzBuzz.generate_array()
    assert hd(array) == 1
    assert List.last(array) == 100
    FizzBuzz.print()
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
end
