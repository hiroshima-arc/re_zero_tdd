ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "Hello, world!" do
    assert FizzBuzz.greeting() == "Hello, world!"
  end
end

defmodule FizzBuzz do
  def greeting do
    "Hello, world!"
  end
end
