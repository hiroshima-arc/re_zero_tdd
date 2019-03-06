# coding: utf-8
require 'test/unit'

class FizzBuzzTest < Test::Unit::TestCase
  def setup
    @fizz_buzz = FizzBuzz.new
  end

  test '1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz3と5で割り切れる場合はFizzBuzzをプリントする' do
    list = @fizz_buzz.list
    assert_equal 1, list.first
    assert_equal 'Fizz', list[2]
    assert_equal 'Buzz', list[4]
    assert_equal 'FizzBuzz', list[14]
    assert_equal 'Buzz', list.last
    @fizz_buzz.print
  end

  test '3で割り切れる場合はFizzを出力する' do
    assert_equal 'Fizz', @fizz_buzz.fizz_buzz(3)
    assert_equal 1, @fizz_buzz.fizz_buzz(1)
  end

  test '5で割り切れる場合はBuzzを出力する' do
    assert_equal 'Buzz', @fizz_buzz.fizz_buzz(5)
  end

  test '3と5で割り切れる場合はFizzBuzzを出力する' do
    assert_equal 'FizzBuzz', @fizz_buzz.fizz_buzz(15)
  end
end

class FizzBuzz
  attr_reader :list
  MAX_RANGE = 100
  FIZZ = 'Fizz'
  BUZZ = 'Buzz'
  FIZZ_BUZZ = 'FizzBuzz'

  def initialize
    @list = generate_list
  end

  def print
    list.each { |value| puts value }
  end

  def fizz_buzz(number)
    return FIZZ_BUZZ if fizz?(number) && buzz?(number)
    return FIZZ if fizz?(number)
    return BUZZ if buzz?(number)
    number
  end

  private

  def generate_list
    (1..FizzBuzz::MAX_RANGE).map { |number| fizz_buzz(number) }
  end

  def fizz?(number)
    (number % 3).zero?
  end

  def buzz?(number)
    (number % 5).zero?
  end

end
