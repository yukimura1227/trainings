import { WebSocketServer } from 'ws';
import * as nodePty from 'node-pty';

const wss = new WebSocketServer({ port: 8080 });

wss.on('connection', function connection(ws) {
  const pty = nodePty.spawn("bash", ["--login"], {
    name: "xterm-color",
    cols: 80,
    rows: 24,
    cwd: process.env.HOME,
  });
  pty.onData((data) => {
    console.log("send: %s", data);
    ws.send(JSON.stringify({ output: data }));
  });
  ws.on('error', console.error);

  ws.on('message', (message) => {
    console.log('received: %s', message);

    const m = JSON.parse(message.toString());

    if (m.input) {
      pty.write(m.input);
    }
  });
});
