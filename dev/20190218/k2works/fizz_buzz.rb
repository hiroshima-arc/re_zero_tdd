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
    assert_equal 'Fizz', FizzBuzz.generate(3)
    assert_equal 1, FizzBuzz.generate(1)
  end

  test '5で割り切れる場合はBuzzを返す' do
    assert_equal 'Buzz', FizzBuzz.generate(5)
  end

  test '3と5で割り切れる場合はFizzBuzzを返す' do
    assert_equal 'FizzBuzz', FizzBuzz.generate(15)
  end

  test "数字以外の場合は例外を発生させる" do
    assert_raise(RuntimeError)  {FizzBuzz.generate('a')}
  end
end

class FizzBuzz
  MAX_RANGE = 100
  FIZZ_BUZZ = 'FizzBuzz'
  FIZZ = 'Fizz'
  BUZZ = 'Buzz'

  def self.print
    begin
      puts generate_list
    rescue RuntimeError => error
      p error.backtrace
    end
  end

  def self.generate_list
    (1..MAX_RANGE).map(&method(:generate))
  end

  def self.generate(number)
    raise "数字以外は処理できません:#{number}" unless number.is_a? Numeric

    return FIZZ_BUZZ if (fizz?(number)).zero? && (buzz?(number)).zero?
    return FIZZ if (fizz?(number)).zero?
    return BUZZ if (buzz?(number)).zero?
    number
  end

  def self.fizz?(number)
    number % 3
  end

  def self.buzz?(number)
    number % 5
  end

  private_class_method :buzz?,:fizz?
end
