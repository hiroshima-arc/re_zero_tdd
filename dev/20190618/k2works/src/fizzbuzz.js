// eslint-disable-next-line no-unused-vars
const FizzBuzzTypeEnum = {
  type01() {
    return FizzBuzzType01.create();
  },
  type02() {
    return FizzBuzzType02.create();
  },
  type03() {
    return FizzBuzzType03.create();
  }
};

const FizzBuzzType = {
  create() {
    let self = Object.create(FizzBuzzType.prototype);
    self.FIZZ = "Fizz";
    self.BUZZ = "Buzz";
    self.FIZZ_BUZZ = "FizzBuzz";
    return self;
  },
  prototype: {
    isFizz(number) {
      return number % 3 === 0;
    },
    isBuzz(number) {
      return number % 5 === 0;
    }
  }
};

const FizzBuzzType01 = {
  create() {
    let self = Object.create(FizzBuzzType01.prototype);
    Object.assign(self, FizzBuzzType.create());
    return self;
  },
  prototype: {
    generate(number) {
      const isFizz = FizzBuzzType.prototype.isFizz(number);
      const isBuzz = FizzBuzzType.prototype.isBuzz(number);

      if (isFizz && isBuzz) return FizzBuzzValue.create(number, this.FIZZ_BUZZ);
      if (isFizz) return FizzBuzzValue.create(number, this.FIZZ);
      if (isBuzz) return FizzBuzzValue.create(number, this.BUZZ);

      return FizzBuzzValue.create(number, number);
    }
  }
};

const FizzBuzzType02 = {
  create() {
    let self = Object.create(FizzBuzzType02.prototype);
    Object.assign(self, FizzBuzzType.create());
    return self;
  },
  prototype: {
    generate(number) {
      return FizzBuzzValue.create(number, number);
    }
  }
};

const FizzBuzzType03 = {
  create() {
    let self = Object.create(FizzBuzzType03.prototype);
    Object.assign(self, FizzBuzzType.create());
    return self;
  },
  prototype: {
    generate(number) {
      const isFizz = FizzBuzzType.prototype.isFizz(number);
      const isBuzz = FizzBuzzType.prototype.isBuzz(number);

      if (isFizz && isBuzz) return FizzBuzzValue.create(number, this.FIZZ_BUZZ);
      return FizzBuzzValue.create(number, number);
    }
  }
};

const FizzBuzzValue = {
  create(number, value) {
    if (number < 0)
      throw new Error(`FizzBuzzValue can't generate by minus number`);
    let self = Object.create(FizzBuzzValue.prototype);
    self.number = number;
    self.value = value;
    return self;
  },
  prototype: {}
};

const FizzBuzzList = {
  create(list) {
    if (list.length > 100)
      throw new Error(`FizzBuzzList can't generate over 100`);
    let self = Object.create(FizzBuzzList.prototype);
    self.list = list;
    return self;
  },
  prototype: {
    add(value) {
      let result = this.list;
      result.push(value);
      return FizzBuzzList.create(result);
    }
  }
};

const FizzBuzzCommand = {
  create() {
    return Object.create(FizzBuzzCommand.prototype);
  },
  prototype: {
    exec() {}
  }
};

const FizzBuzzValueCommand = {
  create(type) {
    let self = Object.create(FizzBuzzValueCommand.prototype);
    Object.assign(self, FizzBuzzCommand.create());
    self.type = type;
    return self;
  },
  prototype: {
    exec(number) {
      return this.type.generate(number);
    }
  }
};

const FizzBuzzListCommand = {
  create(type) {
    let self = Object.create(FizzBuzzListCommand.prototype);
    Object.assign(self, FizzBuzzCommand.create());
    self.type = type;
    self.fizzBuzzList = FizzBuzzList.create([]);
    return self;
  },
  prototype: {
    exec(number) {
      // 配列は0から始まるので1を足す
      [...Array(number + 1).keys()]
        .slice(1)
        .forEach(
          number =>
            (this.fizzBuzzList = this.fizzBuzzList.add(
              this.type.generate(number)
            ))
        );
      return this.fizzBuzzList;
    }
  }
};

const FizzBuzzService = {
  create(type) {
    let self = Object.create(FizzBuzzService.prototype);
    self.valueCommand = FizzBuzzValueCommand.create(type);
    self.listCommand = FizzBuzzListCommand.create(type);
    return self;
  },
  prototype: {
    generate(number) {
      return this.valueCommand.exec(number).value;
    },
    generateList(number) {
      return this.listCommand.exec(number).list;
    }
  }
};

const FizzBuzzApp = {
  create(type) {
    let self = Object.create(FizzBuzzApp.prototype);
    self.MAX_NUMBER = 100;
    self.service = FizzBuzzService.create(type);
    return self;
  },

  prototype: {
    changeEvent(e) {
      switch (e.target.value) {
        case "one":
          FizzBuzzApp.create(FizzBuzzType01.create()).renderTable();
          break;
        case "two":
          FizzBuzzApp.create(FizzBuzzType02.create()).renderTable();
          break;
        case "three":
          FizzBuzzApp.create(FizzBuzzType03.create()).renderTable();
          break;
        default:
          FizzBuzzApp.create(FizzBuzzType01.create()).renderTable();
      }
    },
    renderSelect() {
      document.querySelector("#app__select").innerHTML = `
              <select name="type" id="app__select--type">
               <option value="one">タイプ1</option>
               <option value="two">タイプ2</option>
               <option value="three">タイプ3</option>
              </select>
                `;
    },
    renderTable() {
      const header = (() => {
        let items = "<tr>";
        [...Array(10).keys()].forEach(i => {
          items += `<th>${i + 1}</th>`;
        });
        items += "</tr>";

        return `
                <thead>
                  ${items}
                </thead>
              `;
      })();

      const body = (() => {
        let items = "<tr>";
        this.service.generateList(this.MAX_NUMBER).forEach((v, k) => {
          items += `<td>${v.value}</td>`;
          if ((k + 1) % 10 === 0) items += "</tr><tr>";
        });

        return `
                <tbody>
                  ${items}
                </tbody>
             `;
      })();

      document.querySelector("#app__table").innerHTML = `
              <table class="table table-bordered">
                ${header}
                ${body}
              </table>
          `;
    },
    renderApp() {
      this.renderSelect();
      this.renderTable();
      document
        .querySelector("#app__select--type")
        .addEventListener("change", this.changeEvent);
    }
  }
};
