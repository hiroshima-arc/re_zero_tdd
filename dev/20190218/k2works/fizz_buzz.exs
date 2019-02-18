ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "1から100までの数をプリントする" do
    list = FizzBuzz.print(100)
    assert hd(list) == 1
    assert List.last(list) == 100
  end
end

defmodule FizzBuzz do
  def print(n) when n > 0 do
    _print(1, n , [])
  end

  defp _print(_current, 0, result) do
    Enum.reverse(result)
  end

  defp _print(current, left, result) do
    IO.puts(current)
    _print(current+1, left-1, [ current | result])
  end
end
