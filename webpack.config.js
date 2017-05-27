const path = require('path');

const DEV = process.env.NODE_ENV !== 'production';

module.exports = {
  entry: DEV ? './entry_dev.js' : './resources/public/js/compiled/app.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'resources/public/js')
  }
}
