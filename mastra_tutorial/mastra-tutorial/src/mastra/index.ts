import { Mastra } from '@mastra/core';
import { myAgent } from './agents';

export const mastra = new Mastra({
  agents: { myAgent },
});

const response = await myAgent.generate([
  { role: "user", content: "Hello, how can you assist me today?" },
]);

console.log("Agent:", response.text);