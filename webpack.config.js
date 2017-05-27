var path = require('path');

module.exports = {
  entry: './resources/public/js/compiled/app.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'resources/public/js')
  }
}
