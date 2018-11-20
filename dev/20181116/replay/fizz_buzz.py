MAX_COUNT = 100
ERROR_MSG = f"回数は{MAX_COUNT}までです"
BUZZ = "Buzz"
FIZZ = "Fizz"
FIZZ_BUZZ = "FizzBuzz"
data = {
    'values': [],
    'count': 0
}


def execute(count=MAX_COUNT):
    if within_max_count(count):
        set_count(count)
        set_values_by_generate()
        print_values()
    else:
        print_error_message()


def within_max_count(count):
    return count <= MAX_COUNT


def set_count(count):
    # レンジは指定された値を範囲に含めないので1プラスする
    data['count'] = count + 1


def set_values_by_generate():
    data['values'] = []

    for number in range(data['count']):
        value = generate(number)
        data['values'].append(value)


def print_values():
    for value in data['values']:
        print(value)


def print_error_message():
    print(ERROR_MSG)


def is_fizz(number):
    return number % 3 == 0


def is_buzz(number):
    return number % 5 == 0


def is_fizz_buzz(number):
    return number % 3 == 0 and number % 5 == 0


def generate(number):
    value = number

    if is_fizz_buzz(number):
        value = FIZZ_BUZZ
    elif is_fizz(number):
        value = FIZZ
    elif is_buzz(number):
        value = BUZZ

    return value
