# frozen_string_literal: true

# FizzBuzzClass
class FizzBuzz
  def self.generate(number)
    value = 'Fizz' if number % 3 == 0
    value = value.to_s + 'Buzz' if number % 5 == 0
    value = number if value.nil?

    value
  end

  def self.iterate(count)
    array = []
    (1..count).each do |num|
      array.push(FizzBuzz.generate(num).to_s)
    end

    array
  end
end
