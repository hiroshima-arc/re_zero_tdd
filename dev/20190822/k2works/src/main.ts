import { greeting } from "./greeting";

export function renderGreeting() {
  document.querySelector("#app").innerHTML = greeting();
}

renderGreeting();
