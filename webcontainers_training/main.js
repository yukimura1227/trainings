import './style.css';
import { WebContainer } from '@webcontainer/api';
import { files } from './files';

/** @type {import('@webcontainer/api').WebContainer}  */
let webcontainerInstance;

document.querySelector('#app').innerHTML = `
  <div class="container">
    <div class="editor">
      <textarea>I am a textarea</textarea>
    </div>
    <div class="preview">
      <iframe src="loading.html"></iframe>
    </div>
  </div>
`
/** @type {HTMLIFrameElement | null} */
const iframeEl = document.querySelector('iframe');

/** @type {HTMLTextAreaElement | null} */
const textareaEl = document.querySelector('textarea');

window.addEventListener('load', async () => {
 // Call only once
  webcontainerInstance = await WebContainer.boot();
  await webcontainerInstance.mount(files);

  const exitCode = await installDependencies();
  if (exitCode !== 0) {
    throw new Error('Installation failed');
  };

  startDevServer();
});

const installDependencies = async () => {
  // Install dependencies
  const installProcess = await webcontainerInstance.spawn('npm', ['install']);
  // Wait for install command to exit
  installProcess.output.pipeTo(new WritableStream({
    write(data) {
      console.log(data);
    }
  }));
  return installProcess.exit;
}

// sample for command output for stream instead of exit code
// const installDependencies = async () => {
//   const installProcess = await webcontainerInstance.spawn('npm', ['install']);
//   const output = "";
//   installProcess.output.pipeTo(new WritableStream({
//     write(data) {
//       output.concat(data);
//       console.log(data);
//     }
//   }));
// 
//   return { exitCode: installProcess.exit, output: output }
// }

const startDevServer = async () => {
  // Run `npm run start` to start the Express app
  await webcontainerInstance.spawn('npm', ['run', 'start']);

  // Wait for `server-ready` event
  webcontainerInstance.on('server-ready', (port, url) => {
    iframeEl.src = url;
  });
}