import satori from 'satori';
import sharp from 'sharp';
import fs from 'fs';

const elipsisStringIfSizeOver = (originalString:string, maxFullSize:number) => {
  let halfSizeStringLength = 0;
  let fullSizeStringLength = 0;
  for (let i = 0; i < originalString.length; i++) {
    if(originalString[i].match(/[-~]/) ) {
      halfSizeStringLength++;
    } else {
      fullSizeStringLength++;
    }

    const totalSize = halfSizeStringLength * 0.5 + fullSizeStringLength;

    if( totalSize > maxFullSize ) {
      return `${originalString.substring(0, i-1)}..`
    }
  }
  return originalString;
}

const generateOgpPng = async (title:string, userName:string) => {
  const svg = await generateOgpSVG(title, userName);
  const png = await sharp(Buffer.from(svg)).png().toBuffer();
  return png;
}

const generateOgpSVG = async (title:string, userName:string) => {
  const fontData = fs.readFileSync("./fonts/NotoSerifJP-Regular.otf");
  const svg = await satori(
    <div
      style={{
        background: 'linear-gradient(270deg, #4a40be, #5765db, #5765db, #658af8, #658af8, #658af8)',
        display: 'flex',
        height: '100%',
        paddingLeft: 24,
        paddingTop: 24,
        width: '100%',
      }}
    >
      <div
        style={{
          backgroundColor: '#FFF',
          display: 'flex',
          flexDirection: 'column',
          justifyContent: 'space-between',
          fontWeight: 600,
          padding: 24,
          width: '100%',
        }}
      >
        <div style={{
          display: 'flex',
          alignItems: 'center',
          height: 600-24-24-80,
          padding: 16,
        }}>
          <div style={{ fontSize: 64 }}>
            {elipsisStringIfSizeOver(title, 68)}
          </div>
        </div>
        <div style={{
          display: 'flex',
          justifyContent: 'space-between',
        }}>
          <div style={{
            fontSize: 48,
            display: 'flex',
            alignItems: 'center'
          }}>
            <img
              src="https://avatars.githubusercontent.com/yukimura1227"
              width={80}
              height={80}
              style={{ borderRadius: 50, marginRight: 24 }}
            />
            {elipsisStringIfSizeOver(userName, 10)}
          </div>
          <div style={{ display: 'flex'}}>
            <img
              src="https://slidevook-public.s3.ap-northeast-1.amazonaws.com/slidevook-title.png"
              height={80}
              width={353}
            />
          </div>
        </div>
      </div>
    </div>
    ,
    {
      width: 1200,
      height: 630,
      fonts: [
        {
          name: "Noto Serif JP",
          data: fontData,
          style: 'normal',
        },
      ],
    },
  )
  return svg;
}

(async () => {
  const ogpImage = await generateOgpPng(
    'No-Title',
    'あああああいいいいいう'
  );
  fs.writeFileSync('./ogp.png', ogpImage);
})();
