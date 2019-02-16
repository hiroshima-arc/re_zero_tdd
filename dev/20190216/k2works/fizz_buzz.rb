# frozen_string_literal: true

require 'test/unit'

class TestFizzBuzz < Test::Unit::TestCase
  test 'greeting' do
    assert_equal 'Hello, world!', FizzBuzz.greeting
  end
end

class FizzBuzz
  def self.greeting
    'Hello, world!'
  end
end
