require 'test/unit'

class TestFizzBuzz < Test::Unit::TestCase
  test 'greeting' do
    assert_equal 'Hello, world!', FizzBuzz.greeting
  end

  test '1から100までの数をプリントする' do
    list = FizzBuzz.print
    assert_equal 1, list.first
    assert_equal 100, list.last
  end
end

class FizzBuzz
  def self.greeting
    'Hello, world!'
  end

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
end