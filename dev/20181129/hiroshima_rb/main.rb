require 'minitest/autorun'

def execute
  (1..100).each {|number| puts(fizz_buzz(number))}
end

def fizz_buzz(number)
  return 'FizzBuzz' if fizz_buzz?(number) 
  return 'Fizz' if fizz?(number)
  return 'Buzz' if buzz?(number)

  number.to_s
end

def fizz?(number)
  number % 3 == 0
end

def buzz?(number)
  number % 5 == 0
end

def fizz_buzz?(number)
  fizz?(number) and buzz?(number)
end

class MainTest < Minitest::Test
  def test_print_1_to_100
    $stdout = StringIO.new
    execute
    output = $stdout.string.lines.map(&:chomp)
    assert_equal '1', output[0]
    assert_equal 'Buzz', output[99]
  end

  def test_print_fizz_when_3
    assert_equal 'Fizz', fizz_buzz(3)
    assert_equal '2', fizz_buzz(2)
  end
 
  def test_print_buzz_when_5
    assert_equal 'Buzz', fizz_buzz(5)
    assert_equal '2', fizz_buzz(2)
  end

  def test_print_fizz_buzz_when_3_and_5_can_be_divied
    assert_equal 'FizzBuzz', fizz_buzz(15)
  end
end
