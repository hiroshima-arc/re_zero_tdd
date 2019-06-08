import "./contents.css";
import Amplify from "aws-amplify";
import API from "@aws-amplify/api";
import Auth from "@aws-amplify/auth";
import Analytics from "@aws-amplify/analytics";
import awsconfig from "./aws-exports";
import $ from "jquery";

let apiUrl = "http://localhost:4000";

if (process.env.NODE_ENV === "production") {
  document.querySelector("#dev").style.display = "none";
  apiUrl = "https://o0ufy01frj.execute-api.us-east-1.amazonaws.com/Prod";
}

Amplify.configure({
  API: {
    endpoints: [
      {
        name: "AmplifyTest",
        endpoint: "https://o0ufy01frj.execute-api.us-east-1.amazonaws.com/Prod",
        region: "us-east-1"
      }
    ]
  }
});

function apiCall(url, method, onSuccess, onErrors) {
  $("#app__message").html("処理中...");
  $.ajax({
    url: url,
    type: method,
    data: {}
  })
    .done(data => {
      onSuccess(data);
      const message = `<h3>Apiサーバーの読み込みに成功しました</h3>`;
      $("#app__message").html(message);
    })
    .fail(data => {
      onErrors(data);
      const message = `<h3>Apiサーバーでエラーが発生しました</h3>`;
      $("#app__message").html(message);
    });
}

function apiGet(path, onSuccess, onErrors) {
  let apiName = "AmplifyTest";

  API.get(apiName, path)
    .then(response => {
      onSuccess(response);
      const message = `<h3>Apiサーバーの読み込みに成功しました</h3>`;
      $("#app__message").html(message);
    })
    .catch(err => {
      onErrors(err);
      const message = `<h3>Apiサーバーでエラーが発生しました</h3>`;
      $("#app__message").html(message);
    });
}

function renderApp() {
  const success = data => {
    console.log(data);
    document.querySelector("#app").innerHTML = data.Output;
  };
  const errors = data => {
    console.log(data);
  };

  //apiCall(`${apiUrl}/api/hello`, "GET", success, errors);
  apiGet("/api/hello", success, errors);
}

renderApp();

// retrieve temporary AWS credentials and sign requests
Auth.configure(awsconfig);
// send analytics events to Amazon Pinpoint
Analytics.configure(awsconfig);

const AnalyticsResult = document.getElementById("AnalyticsResult");
const AnalyticsEventButton = document.getElementById("AnalyticsEventButton");
let EventsSent = 0;
AnalyticsEventButton.addEventListener("click", evt => {
  Analytics.record("Amplify Tutorial Event").then(evt => {
    const url =
      "https://" +
      awsconfig.aws_mobile_analytics_app_region +
      ".console.aws.amazon.com/pinpoint/home/?region=" +
      awsconfig.aws_mobile_analytics_app_region +
      "#/apps/" +
      awsconfig.aws_mobile_analytics_app_id +
      "/analytics/events";
    AnalyticsResult.innerHTML = "<p>Event Submitted.</p>";
    AnalyticsResult.innerHTML += "<p>Events sent: " + ++EventsSent + "</p>";
    AnalyticsResult.innerHTML +=
      '<a href="' +
      url +
      '" target="_blank">View Events on the Amazon Pinpoint Console</a>';
  });
});

Amplify.configure({
  Auth: {
    // フェデレーションアイデンティティのID
    identityPoolId: "us-east-1:2f6acc9d-75fc-4d40-8826-7e833b45cc9b",
    // リージョン
    region: "us-east-1",
    // ユーザープールのID
    userPoolId: "us-east-1_yqHANLMEx",
    // ユーザープールのウェブクライアントID
    userPoolWebClientId: "1bi9k5r3elbf8esbnqo2tkq3pb"
  }
});

const SignUpButton = document.getElementById("register-submit");
SignUpButton.addEventListener("click", () => {
  const email = document.querySelector("#email").value;
  const password = document.querySelector("#password").value;
  const confirmPassword = document.querySelector("#confirm-password").value;

  console.log(email);

  Auth.signUp(email, password)
    .then(data => {
      alert("登録メールアドレスに検証コードを送信しました");
    })
    .catch(err => {
      console.log(err);
      alert("エラーが発生しました");
      return;
    });
});

const VeirfyButton = document.getElementById("verify-now");
VeirfyButton.addEventListener("click", () => {
  const email = document.querySelector("#verify-email").value;
  const code = document.querySelector("#verify-code").value;

  console.log(email);
  console.log(code);

  Auth.confirmSignUp(email, code)
    .then(data => {
      alert("ユーザ登録が完了しました。");
    })
    .catch(err => {
      console.log(err);
      alert("検証に失敗しました");
      return;
    });
});

const SignInButton = document.getElementById("signin-submit");
SignInButton.addEventListener("click", () => {
  const email = document.querySelector("#signin-email").value;
  const password = document.querySelector("#signin-password").value;

  console.log(email);
  console.log(password);

  Auth.signIn(email, password)
    .then(data => {
      alert("サインインに成功しました");
      CurrentUser();
    })
    .catch(err => {
      console.log(err);
      alert("サインインに失敗しました");
      return;
    });
});

const SignOutButton = document.getElementById("signout-submit");
SignOutButton.addEventListener("click", () => {
  Auth.signOut()
    .then(data => {
      alert("サインアウトしました");
      CurrentUser(data);
    })
    .catch(err => {
      console.log(err);
      alert("サインアウトに失敗しました");
      return;
    });
});

const CurrentUser = () => {
  const filter = data => {
    console.log(data);
    return data === "not authenticated" ? data : data.attributes.email;
  };

  Auth.currentAuthenticatedUser({
    bypassCache: false
  })
    .then(user => renderCurrentUser(filter(user)))
    .catch(err => renderCurrentUser(filter(err)));
};

const renderCurrentUser = data => {
  document.querySelector("#signin-user").innerHTML = data;
};

CurrentUser();
