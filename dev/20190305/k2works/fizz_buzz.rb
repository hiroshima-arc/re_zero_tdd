# coding: utf-8
# frozen_string_literal: true

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

  test 'Fizzだけを抽出したリストを出力する' do
    list = @fizz_buzz.fizz_list
    assert_equal 'Fizz', list.first
    assert_equal 'Fizz', list.last
    assert_equal 27, list.size
  end

  test 'Buzzだけを抽出したリストを出力する' do
    list = @fizz_buzz.buzz_list
    assert_equal 'Buzz', list.first
    assert_equal 'Buzz', list.last
    assert_equal 14, list.size
  end

  test 'FizzBuzzだけを抽出したリストを出力する' do
    list = @fizz_buzz.fizz_buzz_list
    assert_equal 'FizzBuzz', list.first
    assert_equal 'FizzBuzz', list.last
    assert_equal 6, list.size
  end

  test '数字だけを抽出したリストを出力する' do
    list = @fizz_buzz.number_list
    assert_equal 1, list.first
    assert_equal 98, list.last
    assert_equal 53, list.size
  end

  test '数字だけを抽出したリストの合計を出力する' do
    total = @fizz_buzz.number_list_total
    assert_equal 2632, total
  end
end

class FizzBuzz
  attr_reader :list, :fizz_list, :buzz_list, :fizz_buzz_list, :number_list, :number_list_total
  MAX_RANGE = 100
  FIZZ = 'Fizz'
  BUZZ = 'Buzz'
  FIZZ_BUZZ = 'FizzBuzz'

  def initialize
    @list = generate_list
    @fizz_list = generate_fizz_list
    @buzz_list = generate_buzz_list
    @fizz_buzz_list = generate_fizz_buzz_list
    @number_list = generate_number_list
    @number_list_total = calulate_number_list_total
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

  def generate_fizz_list
    @list.select { |item| item == FIZZ }
  end

  def generate_buzz_list
    @list.select { |item| item == BUZZ }
  end

  def generate_fizz_buzz_list
    @list.select { |item| item == FIZZ_BUZZ }
  end

  def generate_number_list
    @list.reject { |item| item =~ /[a-zA-Z]/ }
  end

  def calulate_number_list_total
    @number_list.reduce { |total, number| total + number }
  end

  def fizz?(number)
    (number % 3).zero?
  end

  def buzz?(number)
    (number % 5).zero?
  end
end
