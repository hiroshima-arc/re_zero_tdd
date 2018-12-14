# frozen_string_literal: true

require 'minitest/autorun'
require "minitest/reporters"
require_relative './main.rb'
Minitest::Reporters.use!
require 'simplecov'
SimpleCov.start

class MainTest < Minitest::Test
  def test_print_1_to_100
    $stdout = StringIO.new
    Main.execute
    output = $stdout.string.lines.map(&:chomp)
    assert_equal '1', output[0]
    assert_equal 'Buzz', output[99]
  end

  def test_print_fizz_when_play_3
    assert_equal 'Fizz', Main.fizz_buzz(3)
  end

  def test_print_buzz_when_play_5
    assert_equal 'Buzz', Main.fizz_buzz(5)
  end

  def test_print_fizz_buzz_when_play_15
    assert_equal 'FizzBuzz', Main.fizz_buzz(15)
  end
end
