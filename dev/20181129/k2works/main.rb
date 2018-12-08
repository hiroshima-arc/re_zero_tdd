# frozen_string_literal: true

module Main
  def self.execute
    (1..100).each { |number| puts fizz_buzz(number) }
  end

  def self.fizz_buzz(number)
    return 'FizzBuzz' if (number % 3).zero? && (number % 5).zero?
    return 'Fizz' if (number % 3).zero?
    return 'Buzz' if (number % 5).zero?

    number
  end
end
