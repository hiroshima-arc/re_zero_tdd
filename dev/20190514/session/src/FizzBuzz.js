    const assert = chai.assert;
    suite("FizzBuzzTest", () => {
        test("1から100までをプリントする", () => {
            let list = print1to100();
            assert.equal(1, list[0]); 
            assert.equal(100, list[99]); 
        });
    })
    
    function print1to100() {
        let list = [];
        for(let i = 1; i <= 100; i++) {
            list.push(i);
        }
        return list;
    }
    
    
