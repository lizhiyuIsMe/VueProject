//path是node中的模块
const path = require('path');
//用于使用webpack上的一些插件
const webpack = require('webpack');
//vue的加载插件 低版本不用使用此插件
// const vueLoaderPlugin = require('vue-loader/lib/plugin')
//打包html的插件
const HtmlWebpackPlugin = require('html-webpack-plugin');
//一个用于压缩js的插件
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');

module.exports = {
    /*要打包的文件*/
    entry: './main.js',
    output: {
        /*文件数据的地方是文件名加dist文件夹*/
        path: path.resolve(__dirname, 'dist'),
        /*输出的文件名*/
        filename: 'bundle.js',
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
            },
            {
                test: /\.m?js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['es2015']
                    }
                }
            },
            {
                test: /\.(png|jpg|gif)$/i,
                use: [
                    {
                        loader: 'url-loader',
                        options: {
                            limit: 8192,
                        },
                    },
                ]
            },
            {
                test: /\.vue$/,
                use: 'vue-loader'
            }
        ]
    },
    plugins: [
        /*用于加载vue的插件*/
        /*new vueLoaderPlugin(),*/
        /*用于说明一下版权的插件*/
        new webpack.BannerPlugin({
            banner: 'The copyright belongs to Li Zhiyu',
        }),
        //将会生成一个index.html文件，文件会自动引入打包好的js文件在dist中
        new HtmlWebpackPlugin({ template: './index.html' }),
        //对js文件进行压缩的插件
        new UglifyJsPlugin()
    ],
    resolve: {
        alias: {
            /*vue别名，在导入vue的时候直接导入如下文件*/
            //vue有两种形式的代码compiler（模板）模式，和runtime模式（运行时），vue模板的package.json中的main字段默认为runtime模式，指向的是'dist/vue.runtime.common.js'位置
            //修改为vue/dist/vue.esm.js 则改为模板模式
            //否则会报如下错误
            //You are using the runtime-only build of Vue where the template compiler is not available. Either pre-compile the templates into render functions, or use the compiler-included build.
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    devServer: {
        /*通过安装webpack-dev-server插件,配置如下信息，来实现node启动*/
        //启动的文件位置
        //contentBase: path.join(__dirname, 'dist'),
        contentBase: './dist',
        //是否时时更新
        inline: true,
        //启动端口
        port: 9000,
    }
};