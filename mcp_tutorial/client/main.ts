import { google } from "npm:@ai-sdk/google";
import { CoreMessage, streamText } from "npm:ai";
import dotenv from "npm:dotenv";
import { experimental_createMCPClient as createMCPClient } from "ai";
import * as readline from "node:readline/promises";

const call = async () => {
  const mcpClient = await createMCPClient({
    transport: {
      type: "sse",
      url: "http://localhost:8931/sse",
    }
  });

  const { messages } = {};

  const tools = await mcpClient.tools();

  // Vercel AI SDK の streamText 関数を使用して LLM とのストリーミング通信を開始
  const result = streamText({
    model: google("gemini-2.5-pro-exp-03-25"), // 注: モデル名は利用可能な最新のものに適宜変更してください
    messages, // ユーザーからのメッセージと過去の会話履歴
    tools,
    onFinish: () => {
      mcpClient.close();
    }
  });

  // ストリーミング応答をクライアントに返す
  return result.toDataStreamResponse();
}

dotenv.config();

const terminal = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const messages: CoreMessage[] = [];

async function main() {
  while (true) {
    const userInput = await terminal.question('You: ');

    messages.push({ role: 'user', content: userInput });

    const result = streamText({
      model: openai('gpt-4o'),
      messages,
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