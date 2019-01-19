import React from "react";

export class FizzBuzz extends React.Component {
  render() {
    return (
      <div>
        <h1>HTML5+CSS+JavaScript with TDD</h1>
        <header>
          <div className="nav-component">
            <nav>
              <h1>Menu</h1>
              <ul>
                <a href="../index.html">FizzBuzz</a>
                <ul id="nav-component__sub-menu--fizz-buzz">
                  <li id="nav-component__sub-menu--fizz-buzz-call">
                    <a href="#">FizzBuzzCall</a>
                  </li>
                  <li id="nav-component__sub-menu--fizz-buzz-print">
                    <a href="#">FizzBuzzPrint</a>
                  </li>
                  <li id="nav-component__sub-menu--fizz-buzz-up-down">
                    <a href="#">FizzBuzzUpDown</a>
                  </li>
                  <li id="nav-component__sub-menu--fizz-buzz-iterate">
                    <a href="#">FizzBuzzIterate</a>
                  </li>
                </ul>
              </ul>
            </nav>
          </div>
        </header>
        <div className="components">
          <section>
            <div className="fizz-buzz-component">
              <h1>FizzBuzz</h1>
              <article id="fizz-buzz-component__article--call">
                <h2>FizzBuzzCall</h2>
                <input id="fizz-buzz-component__input--call" type="text"/>
                <input
                  id="fizz-buzz-component__button--call"
                  type="button"
                  value="Call"
                />
              </article>

              <article id="fizz-buzz-component__article--print">
                <h2>FizzBuzzPrint</h2>
                <div id="fizz-buzz-component__print--message">Initialized</div>
                <input id="fizz-buzz-component__input--print" type="text"/>
                <input
                  id="fizz-buzz-component__button--print"
                  type="button"
                  value="Print"
                />
              </article>

              <article id="fizz-buzz-component__article--up-down">
                <h2>FizzBuzzUpDown</h2>
                <div id="fizz-buzz-component__up-down--message">Ready</div>
                <input
                  id="fizz-buzz-component__button--down"
                  type="button"
                  value="-"
                />
                <input
                  id="fizz-buzz-component__button--up"
                  type="button"
                  value="+"
                />
              </article>

              <article id="fizz-buzz-component__article--iterate">
                <h2>FizzBuzzIterate</h2>
                <input id="fizz-buzz-component__input--iterate" type="text"/>
                <input
                  id="fizz-buzz-component__button--iterate"
                  type="button"
                  value="execute"
                />
                <div id="fizz-buzz-component__iterate--result"></div>
              </article>
            </div>
          </section>
        </div>
        <footer>
          <p>Copyrights</p>
          <address>hiroshima-arc@gmail.com</address>
        </footer>
      </div>
    );
  }
}