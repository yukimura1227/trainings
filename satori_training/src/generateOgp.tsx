import satori from 'satori';
import fs from 'fs';

const elipsisStringIfSizeOver = ({originalString = '', maxFullSize = 0}) => {
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

const OgpSize = { width: 1200, height: 630 } as const;
const FrameWidth = 24;
const BottomAreaHeight = 80;
const TitleAreaPadding = 24;

const generateOgpSVG = async ({title = '', userName = '', avatarUrl: avatarUrl}) => {
  const fontData = fs.readFileSync(`${__dirname}/ogpFonts/NotoSerifJP-Regular.otf`);
  const svg = await satori(
    <div
      style={{
        background: 'linear-gradient(270deg, #4a40be, #5765db, #5765db, #658af8, #658af8, #658af8)',
        display: 'flex',
        height: '100%',
        paddingLeft: FrameWidth,
        paddingTop: FrameWidth,
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
          height: OgpSize.height - FrameWidth - TitleAreaPadding*2 - BottomAreaHeight,
          padding: 16,
        }}>
          <div style={{ fontSize: 64 }}>
            {elipsisStringIfSizeOver({originalString: title, maxFullSize: 68})}
          </div>
        </div>
        <div style={{
          display: 'flex',
          justifyContent: 'space-between',
          height: BottomAreaHeight,
        }}>
          <div style={{
            fontSize: 48,
            display: 'flex',
            alignItems: 'center',
            height: BottomAreaHeight,
          }}>
            <img
              src={avatarUrl}
              width={80}
              height={BottomAreaHeight}
              style={{ borderRadius: 50, marginRight: 24 }}
            />
            {elipsisStringIfSizeOver({originalString: userName, maxFullSize: 10})}
          </div>
          <div style={{ display: 'flex'}}>
            <img
              src="https://placehold.jp/5765db/fff/500x600.png"
              height={BottomAreaHeight}
              width={353}
            />
          </div>
        </div>
      </div>
    </div>
    ,
    {
      width: OgpSize.width,
      height: OgpSize.height,
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
  const args      = process.argv.slice(2);
  const title     = args[0];
  const userName  = args[1];
  const avatarUrl = args[2];
  const ogpImage = await generateOgpSVG({
    title: title,
    userName: userName,
    avatarUrl: avatarUrl,
  });
  fs.writeFileSync('./ogp.svg', ogpImage);
})();
