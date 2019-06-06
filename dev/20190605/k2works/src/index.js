import "./contents.css";
import Auth from "@aws-amplify/auth";
import Analytics from "@aws-amplify/analytics";
import awsconfig from "./aws-exports";

let apiUrl = "http://localhost:4000";

if (process.env.NODE_ENV === "production") {
  document.querySelector("#dev").style.display = "none";
  apiUrl = "https://o0ufy01frj.execute-api.us-east-1.amazonaws.com/Prod";
}

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

function renderApp() {
  const success = data => {
    console.log(data);
    document.querySelector("#app").innerHTML = data.Output;
  };
  const errors = data => {
    console.log(data);
  };

  apiCall(`${apiUrl}/api/hello`, "GET", success, errors);
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
