let $ = require('jquery')
let fs = require('fs')
let filename = 'contacts'

const clipboard = require('electron').clipboard

$('#js-btn-paste').on('click', () => {
  availableFormats = clipboard.availableFormats()
  image_file_name = new Date().getTime() + '.png'
  fs.writeFile(image_file_name, clipboard.readImage().toPng(), function (err) {})
  // すぐにappendするとファイルが読み込めないので、waitしてからappend
  setTimeout( function () {
    $('#js-paste-target').append("<img  src = '" + image_file_name + "'></img>")
    }
    , 1000)
})

