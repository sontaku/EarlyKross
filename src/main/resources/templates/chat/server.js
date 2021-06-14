var app = require("express")();
var server = require("http").createServer(app);
// http server를 socket.io server로 upgrade한다
var io = require("socket.io")(server);

const mysql = require("mysql"); // mysql 모듈 로드
const conn = {
  // mysql 접속 설정
  host: "localhost",
  port: "3306",
  user: "ek",
  password: "ek",
  database: "earlykross",
};

fId = "";
// localhost:3000으로 서버에 접속하면 클라이언트로 index.html을 전송한다
app.get("/", function (req, res) {
  res.sendFile(__dirname + "/room.html");
  fId = req.query["fId"];
  console.log(fId);
  res.redirect("http://localhost:8180/chat/chat.do")
});

// namespace /chat에 접속한다.
var chat = io.of("/chat").on("connection", function (socket) {
  socket.on("chat message", function (data) {
    console.log("message from client: ", data);

    var connection = mysql.createConnection(conn); // DB 커넥션 생성
    connection.connect(); // DB 접속

    var sql =
        "INSERT INTO chat(room, name, msg) VALUES(" +
        // connection.escape(data.room) +
        connection.escape(fId) +
        "," +
        connection.escape(data.name) +
        "," +
        connection.escape(data.msg) +
        ")";

    connection.query(sql, function (err, results) {
      // testQuery 실행
      if (err) {
        console.log(err);
      }
      console.log(results);
    });

    // testQuery = "SELECT * FROM chat";

    // connection.query(testQuery, function (err, results, fields) {
    //   // testQuery 실행
    //   if (err) {
    //     console.log(err);
    //   }
    //   console.log(results);
    // });

    connection.end(); // DB 접속 종료

    var name = (socket.name = data.name);
    var room = fId;

    console.log(room);

    // room에 join한다
    socket.join(room);
    // room에 join되어 있는 클라이언트에게 메시지를 전송한다
    // fid = req.query["fid"];
    // console.log(fid);
    // chat.to(room).emit(fid);
    chat.to(room).emit("chat message", data.msg);
  });
});

server.listen(3000, function () {
  console.log("Socket IO server listening on port 3000");
});
