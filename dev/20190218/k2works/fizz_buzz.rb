# frozen_string_literal: true

require 'test/unit'

class TestFizzBuzz < Test::Unit::TestCase
  test '1から100までの数をプリントする' do
    list = FizzBuzz.print
    assert_equal 1, list.first
    assert_equal 100, list.last
  end

  test '3で割り切れる場合はFizzを返す' do
    assert_equal 'Fizz', FizzBuzz.exec(3)
    assert_equal 1, FizzBuzz.exec(1)
  end
end

class FizzBuzz
  def self.print
    list = []
    i = 1
    while i <= 100
      list.push(i)
      i += 1
    end
    puts list
    list
  end

  def self.exec(number)
    result = number

    if (number % 3).zero?
      result = 'Fizz'
    end

    result
  end
end
