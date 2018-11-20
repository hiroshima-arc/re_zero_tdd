MAX_COUNT = 100
ERROR_MSG = f"回数は{MAX_COUNT}までです"
BUZZ = "Buzz"
FIZZ = "Fizz"
FIZZ_BUZZ = "FizzBuzz"
fizz_buzz_date = {
    'values': [],
    'count': 0
}


def execute(count=MAX_COUNT):
    if within_max_count(count):
        set_count(count)
        set_values_by_fizz_buzz()
        print_values()
    else:
        print_error_message()


def within_max_count(count):
    return count <= MAX_COUNT


def set_count(count):
    # レンジは指定された値を範囲に含めないので1プラスする
    fizz_buzz_date['count'] = count + 1


def set_values_by_fizz_buzz():
    fizz_buzz_date['values'] = []

    for number in range(fizz_buzz_date['count']):
        value = fizz_buzz(number)
        fizz_buzz_date['values'].append(value)


def print_values():
    for value in fizz_buzz_date['values']:
        print(value)


def print_error_message():
    print(ERROR_MSG)


def is_fizz(number):
    return number % 3 == 0


def is_buzz(number):
    return number % 5 == 0


def is_fizz_buzz(number):
    return number % 3 == 0 and number % 5 == 0


def fizz_buzz(number):
    value = number

    if is_fizz_buzz(number):
        value = FIZZ_BUZZ
    elif is_fizz(number):
        value = FIZZ
    elif is_buzz(number):
        value = BUZZ

    return value
