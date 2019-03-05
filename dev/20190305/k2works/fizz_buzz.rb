# coding: utf-8
require 'test/unit'

class FizzBuzzTest < Test::Unit::TestCase
  test '1から100までプリントする,ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz3と5で割り切れる場合はFizzBuzzをプリントする' do
    list = FizzBuzz.generate_list
    assert_equal 1, list.first
    assert_equal 'Fizz', list[2]
    assert_equal 'Buzz', list[4]
    assert_equal 'FizzBuzz', list[14]
    assert_equal 'Buzz', list.last
  end

  test '3で割り切れる場合はFizzを出力する' do
    assert_equal 'Fizz', FizzBuzz.fizz_buzz(3)
    assert_equal 1, FizzBuzz.fizz_buzz(1)
  end

  test '5で割り切れる場合はBuzzを出力する' do
    assert_equal 'Buzz', FizzBuzz.fizz_buzz(5)
  end

  test '3と5で割り切れる場合はFizzBuzzを出力する' do
    assert_equal 'FizzBuzz', FizzBuzz.fizz_buzz(15)
  end
end

class FizzBuzz
  def self.print
    generate_list.each { |value| puts value }
  end

  def self.generate_list
    (1..100).map { |number| fizz_buzz(number) }
  end

  def self.fizz_buzz(number)
    return 'FizzBuzz' if fizz?(number) && buzz?(number)
    return 'Fizz' if fizz?(number)
    return 'Buzz' if buzz?(number)
    number
  end

  def self.fizz?(number)
    (number % 3).zero?
  end

  def self.buzz?(number)
    (number % 5).zero?
  end

  private_class_method :fizz?, :buzz?
end
