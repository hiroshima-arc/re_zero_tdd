# coding: utf-8
require 'test/unit'

class FizzBuzzTest < Test::Unit::TestCase
  test '1から100までプリントする' do
    list = print
    assert_equal 1, list.first
    assert_equal 100, list.last
  end

  test '3で割り切れる場合はFizzを出力する' do
    assert_equal 'Fizz', fizz_buzz(3)
    assert_equal 1, fizz_buzz(1)
  end

  test '5で割り切れる場合はBuzzを出力する' do
    assert_equal 'Buzz', fizz_buzz(5)
  end
end

def print
  list =[]
  i = 1
  while i <= 100
    list.append(i)
    i += 1
  end
  list
end

def fizz_buzz(number)
  result = number

  if (number % 3).zero?
    result = 'Fizz'
  elsif (number % 5).zero?
    result = 'Buzz'
  end

  result
end
