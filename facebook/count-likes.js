$(function() {
  var ACCESS_TOKEN = "AAACEdEose0cBAHC3ly4ZCZCYgoi02ziJlt49UhlHkuNRQ7CZBKkn6YDKblSci7VYtCkPXTyAhnQxnokZCLIWCAdkeQEGdHaZAqGEyZBMCfSwZDZD"
  var HACK_UID = "276905079008757"
  var MY_UID = "607556004"
  var POST_UID = "607556004_10151270295981005"
  var URL = "https://graph.facebook.com/" + POST_UID +
    "?access_token=" + ACCESS_TOKEN;

  checkLikes = function() {
    $.ajax({
      url: URL,
      dataType: "json",
      success: function(data) {
	var count = data["likes"] ? data["likes"]["count"] : 0;
	$(".number").text(count);
	if (count < 1) {
	  setTimeout(checkLikes, 5000);
	} else {
	  $(".number").text("COMMENCE CHAIN");
	}
      }
    });
  }

  checkLikes();
});

