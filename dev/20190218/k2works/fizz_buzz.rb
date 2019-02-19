# frozen_string_literal: true

require 'test/unit'

class TestFizzBuzz < Test::Unit::TestCase
  test '1から100までの数をプリントする,ただし3で割り切れる場合はFizz,5で割り切れる場合はBuzz,両方で割り切れる場合はFizzBuzzをプリントする' do
    list = FizzBuzz.generate_list
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
    puts generate_list
  end

  def self.generate_list
    (1..100).map(&method(:exec))
  end

  def self.exec(number)
    fizz = fizz?(number)
    buzz = buzz?(number)
    return 'FizzBuzz' if (fizz).zero? && (buzz).zero?
    return 'Fizz' if (fizz).zero?
    return 'Buzz' if (buzz).zero?
    number
  end

  private

  def self.buzz?(number)
    number % 5
  end

  def self.fizz?(number)
    number % 3
  end
end
