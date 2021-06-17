const app = require("express")()
const session = require("express-session")
const redisStore = require('connect-redis')(session)
const server = require("http").createServer(app)
// http server를 socket.io server로 upgrade한다
const io = require("socket.io")(server)

const redis = require('redis');

const mysql = require("mysql") // mysql 모듈 로드
const conn = {
  // mysql 접속 설정
  host: "localhost",
  port: "3306",
  user: "ek",
  password: "ek",
  database: "earlykross",
};

fId = ''
uId = ''

app.get("/", function (req, res) {
  fId = req.query['fId'];
  uId = req.query['uId'];
  res.redirect("http://localhost:8180/chat/chat.do?fId=" + fId)
})

app.get('/room', (req, res) => {
  res.sendFile(__dirname + '/room.html')
})

const client = redis.createClient();

app.use(session({
  secret: 'SojuWithBeer',
  // store: new redisStore({
  //   host: 'localhost',
  //   port: 6379,
  //   client: client,
  //   ttl: 260
  // }),
  saveUninitialized: false,
  resave: false
}))

// namespace /chat에 접속한다.
const chat = io.of("/chat").on("connection", function (socket) {
  socket.on("chat message", function (data) {
    console.log("message from client: ", data)

    // const connection = mysql.createConnection(conn) // DB 커넥션 생성
    // connection.connect() // DB 접속
    //
    // const sql =
    //     "INSERT INTO chat(room, name, msg) VALUES(" +
    //     // connection.escape(data.room) +
    //     connection.escape(fId) +
    //     "," +
    //     connection.escape(data.name) +
    //     "," +
    //     connection.escape(data.msg) +
    //     ")";
    //
    // connection.query(sql, function (err, results) {
    //   // testQuery 실행
    //   if (err) {
    //     console.log(err)
    //   }
    //   console.log(results)
    // })

    // testQuery = "SELECT * FROM chat";

    // connection.query(testQuery, function (err, results, fields) {
    //   // testQuery 실행
    //   if (err) {
    //     console.log(err)
    //   }
    //   console.log(results)
    // })

    // connection.end() // DB 접속 종료

    const name = uId;
    const room = fId;

    console.log(room, name, data.msg)

    // room에 join한다
    socket.join(room)
    // room에 join되어 있는 클라이언트에게 메시지를 전송한다
    // fid = req.query["fid"];
    // console.log(fid)
    // chat.to(room).emit(fid)
    chat.to(room).emit("chat message", data.msg)
  })
})

server.listen(3000, function () {
  console.log("채팅서버 시작~!!")
})
