# frozen_string_literal: true

require 'test/unit'

class TestFizzBuzz < Test::Unit::TestCase
  test '1から100までの数をプリントする,ただし3で割り切れる場合はFizz,5で割り切れる場合はBuzz,両方で割り切れる場合はFizzBuzzをプリントする' do
    list = FizzBuzz.print
    assert_equal 1, list.first
    assert_equal 'Fizz', list[2]
    assert_equal 'Buzz', list[4]
    assert_equal 'FizzBuzz', list[14]
    assert_equal 'Buzz', list.last
  end

  test '3で割り切れる場合はFizzを返す' do
    assert_equal 'Fizz', FizzBuzz.exec(3)
    assert_equal 1, FizzBuzz.exec(1)
  end

  test '5で割り切れる場合はBuzzを返す' do
    assert_equal 'Buzz', FizzBuzz.exec(5)
  end

  test '3と5で割り切れる場合はFizzBuzzを返す' do
    assert_equal 'FizzBuzz', FizzBuzz.exec(15)
  end
end

class FizzBuzz
  def self.print
    list = []
    i = 1
    while i <= 100
      list.push(exec(i))
      i += 1
    end
    puts list
    list
  end

  def self.exec(number)
    result = number

    if (number % 3).zero? && (number % 5).zero?
      result = 'FizzBuzz'
    elsif (number % 3).zero?
      result = 'Fizz'
    elsif (number % 5).zero?
      result = 'Buzz'
    end

    result
  end
end
