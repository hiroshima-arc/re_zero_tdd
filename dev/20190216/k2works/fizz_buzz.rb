# frozen_string_literal: true

require 'test/unit'

class TestFizzBuzz < Test::Unit::TestCase
  test '1から100までの数をプリントする' do
    array = FizzBuzz.generate_array
    assert_equal 1, array.first
    assert_equal 100, array.last
    FizzBuzz.print
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
end
