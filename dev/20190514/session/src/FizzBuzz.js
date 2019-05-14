    const assert = chai.assert;
    suite("FizzBuzzTest", () => {
        test("1から100までをプリントする", () => {
            let list = generateList(); 
            assert.equal(1, list[0]); 
            assert.equal(100, list[99]); 
        });
        test("3で割り切れる場合はFizzをプリントする", () => {
            assert.equal("Fizz", fizzBuzz(3));
        });
        test("5で割り切れる場合はBuzzをプリントする", () => {
            assert.equal("Buzz", fizzBuzz(5));
        })
        test("15で割り切れる場合はFizzBuzzをプリントする", () => {
            assert.equal("FizzBuzz", fizzBuzz(15))
        })
    });
    
    function generateList(){
        let list = [];
        for(let i = 1; i <= 100; i++) {
            list.push(i);
        }
        return list;
    }
    
    function fizzBuzz(number) {
        if (number % 15 === 0) return 'FizzBuzz';
        if (number % 3 === 0) return 'Fizz';
        if (number % 5 === 0) return 'Buzz';
        return number;
    }
    
