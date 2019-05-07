function httpGet(url, onSuccess, onErrors) {
  var xhr = new XMLHttpRequest();
  xhr.open('GET', url, true);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        var values= JSON.parse(xhr.responseText);
        onSuccess(values);
        var message = `<h3>Apiサーバーの読み込みに成功しました</h3>`;
        $('#message').html(message);
      } else {
        var message = `<h3>Apiサーバーでエラーが発生しました${xhr.status}</h3>`;
        onErrors();
        $('#message').html(message);
      }
    }
  };
  xhr.send('');
  return xhr;
}

function apiCall(url, method, onSuccess, onErrors) {
  $('#message').html("処理中...");
  $.ajax({
    url: url,
    type: method,
    data: {}
  })
    .done((data) => {
      onSuccess(data);
      var message = `<h3>Apiサーバーの読み込みに成功しました</h3>`;
      $('#message').html(message);
    })
    .fail((data) => {
      onErrors();
      var message = `<h3>Apiサーバーでエラーが発生しました</h3>`;
      $('#message').html(message);
    })
}

