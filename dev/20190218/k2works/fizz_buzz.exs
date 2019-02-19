ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "1から100までの数をプリントする,ただし3で割り切れる場合はFizz,5で割り切れる場合はBuzz,両方で割り切れる場合はFizzBuzzをプリントする" do
    list = FizzBuzz.generate_list(100)
    assert List.first(list) == 1
    assert Enum.take(list, 3)
           |> List.last() == "Fizz"
    assert Enum.take(list, 5)
           |> List.last() == "Buzz"
    assert Enum.take(list, 15)
           |> List.last() == "FizzBuzz"
    assert List.last(list) == "Buzz"
    FizzBuzz.print()
  end

  test "3で割り切れる場合はFizzを返す" do
    assert FizzBuzz.generate(3) == "Fizz"
    assert FizzBuzz.generate(1) == 1
  end

  test "5で割り切れる場合はBuzzを返す" do
    assert FizzBuzz.generate(5) == "Buzz"
  end

  test "3と5で割り切れる場合はFizzBuzzを返す" do
    assert FizzBuzz.generate(15) == "FizzBuzz"
  end

  test "数字以外の場合は例外を発生させる" do
    assert_raise RuntimeError, fn ->
      FizzBuzz.generate('a')
    end
  end
end

defmodule FizzBuzz do
  @max_range 100
  @fizz_buzz "FizzBuzz"
  @fizz "Fizz"
  @buzz "Buzz"

  def print do
    try do
      Enum.map(generate_list(@max_range), &(IO.puts(&1)))
    rescue
      e in RuntimeError -> e
    end
  end

  def generate_list(n),
      do: 1..n
          |> Enum.map(&generate/1)

  def generate(number) do
    unless is_number(number), do: raise RuntimeError, message: "数字以外は処理できません"

    cond do
      _fizz?(number) and _buzz?(number) -> @fizz_buzz
      _fizz?(number) -> @fizz
      _buzz?(number)-> @buzz
      true -> number
    end
  end

  defp _fizz?(number), do: rem(number, 3) == 0

  defp _buzz?(number), do: rem(number, 5) == 0
end
