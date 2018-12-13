# frozen_string_literal: true

require 'simplecov'
SimpleCov.start
require 'minitest/autorun'
require_relative 'FizzBuzz'

# FizzBuzzSpecClass
class FizzBuzzSpec < Minitest::Spec
  describe FizzBuzz do
    it '3ならFizzを返す' do
      expect(FizzBuzz.generate(3)).must_equal 'Fizz'
    end
    it '5ならばBuzzを返す' do
      expect(FizzBuzz.generate(5)).must_equal 'Buzz'
    end
    it '15ならばFizzBuzzを返す' do
      expect(FizzBuzz.generate(15)).must_equal 'FizzBuzz'
    end
    it '30ならばFizzBuzzを返す' do
      expect(FizzBuzz.generate(30)).must_equal 'FizzBuzz'
    end

    it '5回実行されたならば配列を返す' do
      expect(FizzBuzz.iterate(5)).must_equal %w[1 2 Fizz 4 Buzz]
    end
    it '10回実行されたならば配列を返す' do
      expect(FizzBuzz.iterate(10)).must_equal %w[1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz]
    end
    it '15回実行されたならば配列を返す' do
      expect(FizzBuzz.iterate(15)).must_equal %w[1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz]
    end
  end
end
