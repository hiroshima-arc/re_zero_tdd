ExUnit.start()

defmodule FizzBuzzTest do
  use ExUnit.Case, async: true

  test "Hello world" do
    assert FizzBuzz.hello() == "Hello world"
  end
end

defmodule FizzBuzz do
  def hello do
    "Hello world"
  end
end



