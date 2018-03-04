const path = require('path');

module.exports = {
	entry: './src/app.js',
	output: {
		filename: 'app.bundle.js',
		path: path.join(__dirname, '..', 'dest')
	},
	devtool: 'source-map',
	module: {
		rules: [
			{ test: /\.js$/, loader: 'babel-loader', exclude: /node_modules/ },
		]
	}
};
