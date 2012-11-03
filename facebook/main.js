var http = require("http");
var path = require("path");
var fs = require("fs");

http.createServer( function(request, response) {

  var filePath = "." + request.url;
  if (filePath === "./") filePath = "./index.html";
  console.log("Request received for " + filePath);
  var extname = path.extname(filePath);
  var contentType = 'text/html';
  switch (extname) {
  case '.js':
    contentType = 'text/javascript';
    break;
  case '.css':
    contentType = 'text/css';
    break;
  }

  path.exists(filePath, function(exists) {

    if (exists) {
      fs.readFile(filePath, function(err, data) {
	if (err) {
	  response.writeHead(500);
	  response.end();
	} else {
	  response.writeHead(200, { "Content-Type": contentType });
	  response.write(data);
	  response.end();
	}
      });
    } else {
      response.writeHead(404);
      response.end();
    }
  });

}).listen(8888);

console.log("Server started at http://127.0.0.1:8888/");
