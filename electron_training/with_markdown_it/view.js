let $ = require('jquery')  // jQuery now loaded and assigned to $// enable everything
var md = require('markdown-it')({
  html: true,
  linkify: true,
  typographer: true
});

$('#js-markdown-input').on('change', function() {
  var input_markdown = $('#js-markdown-input').val();
  var result_html = md.render(input_markdown);
  $('#js-markdown-reuslt').html(result_html);
});

