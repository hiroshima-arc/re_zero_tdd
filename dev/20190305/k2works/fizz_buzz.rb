# coding: utf-8
require 'test/unit'

class FizzBuzzTest < Test::Unit::TestCase
  def setup
    @fizz_buzz = FizzBuzz.new
  end
  
  test '1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz3と5で割り切れる場合はFizzBuzzをプリントする' do
    list = @fizz_buzz.generate_list
    assert_equal 1, list.first
    assert_equal 'Fizz', list[2]
    assert_equal 'Buzz', list[4]
    assert_equal 'FizzBuzz', list[14]
    assert_equal 'Buzz', list.last
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

  def initialize
    @list = generate_list
  end
  
  def print
    generate_list.each { |value| puts value }
  end

  def generate_list
    (1..100).map { |number| fizz_buzz(number) }
  end

  def fizz_buzz(number)
    return 'FizzBuzz' if fizz?(number) && buzz?(number)
    return 'Fizz' if fizz?(number)
    return 'Buzz' if buzz?(number)
    number
  end

  private

  def fizz?(number)
    (number % 3).zero?
  end

  def buzz?(number)
    (number % 5).zero?
  end

end
