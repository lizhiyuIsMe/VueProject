//path是node中的模块
const path = require('path');
//这个模块主要用于复制一个html，会自动引入打包好的css和js
const HtmlWebpackPlugin = require('html-webpack-plugin'); // 通过 npm 安装
const webpack = require('webpack'); // 访问内置的插件

module.exports = {
    /*要打包的文件*/
    entry: './test1.js',
    output: {
        /*文件数据的地方是文件名加dist文件夹*/
        path: path.resolve(__dirname, 'dist'),
        /*输出的文件名*/
        filename: 'my-first-webpack.bundle.js',
    },
    module: {
        /*配置加载css的模块*/
        rules: [
            {
                test: /\.css$/,
                use: [
                    {loader: 'style-loader'},
                    {
                        loader: 'css-loader',
                        options: {
                            modules: true
                        }
                    }
                ]
            }
        ]
    },
    plugins: [
        new webpack.ProgressPlugin(),
        /*创建html的插件、会自动引入打包好的css和js*/
        new HtmlWebpackPlugin({ template: './src/index.html' }),
    ],
};