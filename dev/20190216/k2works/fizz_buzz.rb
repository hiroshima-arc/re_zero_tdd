# frozen_string_literal: true

require 'test/unit'

class TestFizzBuzz < Test::Unit::TestCase
  test '1から100までの数をプリントする' do
    array = FizzBuzz.generate_array
    assert_equal 1, array.first
    assert_equal 100, array.last
    FizzBuzz.print
  end

  test '3で割り切れる場合はFizzをプリントする' do
    assert_equal 'Fizz', FizzBuzz.execute(3)
    assert_equal 1, FizzBuzz.execute(1)
  end

  test '5で割り切れる場合はBuzzをプリントする' do
    assert_equal 'Buzz', FizzBuzz.execute(5)
  end

  test '3と5で割り切れる場合はFizzBuzzをプリントする' do
    assert_equal 'FizzBuzz', FizzBuzz.execute(15)
  end
end

class FizzBuzz
  def self.generate_array
    array = []
    (1..100).each do |i|
      array.push(i)
    end
  end

  def self.print
    generate_array.each do |i|
      puts i
    end
  end

  def self.execute(number)
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
