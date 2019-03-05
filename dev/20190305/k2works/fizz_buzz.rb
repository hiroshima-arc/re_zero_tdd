# coding: utf-8
require 'test/unit'

class FizzBuzzTest < Test::Unit::TestCase
  test '1から100までプリントする' do
    list = print
    assert_equal 1, list.first
    assert_equal 100, list.last
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
