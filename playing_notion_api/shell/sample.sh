#!/bin/sh

curl "https://api.notion.com/v1/blocks/${SAMPLE_PAGE_ID}/children?page_size=100" \
  -H 'Authorization: Bearer '"${NOTION_API_TOKEN}"'' \
  -H "Notion-Version: 2021-08-16" | jq
