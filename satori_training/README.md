# USAGE

## PREPARE

copy ogpFonts/NotoSerifJP-Regular.otf on your generateOgp.js script directory.

## EXECUTE
```bash
npm run build
node dist/generateOgp.js inputYourTitle inputUserName inputAvatarUrl
imgcat ogp.svg
```

```bash
npm run build
node dist/generateOgpPng.js inputYourTitle inputUserName inputAvatarUrl
imgcat ogp.png
```
