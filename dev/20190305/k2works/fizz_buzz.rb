require 'test/unit'

class FizzBuzzTest < Test::Unit::TestCase
  test 'greeting' do
    assert_equal 'Hello, world!', greeting
  end
end

def greeting
  'Hello, world'
end
