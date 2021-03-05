安装 npm install webpack -g   不建议全局安装
查看 webpack -v
安装 npm install webpack-cli -g 不建议全局安装
创建打包配置文件 webpack.config.js(配置要打包的文件、以及打包完要输出的地方)
打包 webpack  （然后在dist下就看到了自己打包好的文件）


为了能够加载css
安装style-loader、css-loader
然后在webpack.config.js中配置如何加载css

为了能创建一个html这个html会自动引入导入打包好的js、css
安装 html-webpack-plugin 插件
然后在webpack.config.js中配置html模板位置

为了能够实现热加载配置
安装webpack-dev-server 
然后通过webpack-dev-server 启动