// 以下のように事前に、mcp サーバーを起動しておく必要があります。
// npx @playwright/mcp@latest --port 8931 --headless  

import { google } from "@ai-sdk/google";
import { type CoreMessage, streamText } from "ai";
import dotenv from "dotenv";
import { experimental_createMCPClient as createMCPClient } from "ai";
import * as readline from "node:readline/promises";

dotenv.config();

const terminal = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const messages: CoreMessage[] = [];

async function main() {
  while (true) {
    const mcpClient = await createMCPClient({
      transport: {
        type: "sse",
        url: "http://localhost:8931/sse",
      },
    });

    const userInput = await terminal.question('You: ');

    messages.push({ role: 'user', content: userInput });

    const tools = await mcpClient.tools();

    const result = streamText({
      model: google("gemini-2.5-pro-exp-03-25"),
      messages,
      tools,
      onFinish: () => {
        mcpClient.close();
      },
    });

    let fullResponse = '';
    process.stdout.write('\nAssistant: ');
    for await (const delta of result.textStream) {
      fullResponse += delta;
      process.stdout.write(delta);
    }
    process.stdout.write('\n\n');

    messages.push({ role: 'assistant', content: fullResponse });
  }
}

main().catch(console.error);