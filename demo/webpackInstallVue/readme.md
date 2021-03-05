通过webpack  安装vue（要严格按照版本进行安装）
安装vue
npm install vue --save

--save 运行时依赖         dependencies
--save-dev 开发时依赖     devDependencies

安装webpack
npm install --save-dev webpack
npm install webpack-cli

安装babel
npm install -D babel-loader @babel/core @babel/preset-env 
npm install --save-dev babel-preset-env@next

打包
npm run build

将打包好的文件引入(直接引入没有打包的文件会不支持)

为了让webpack能够打包vue
npm install --save-dev  vue-loader vue-template-compiler
vue-loader修改成 ^13.0.0  不然webpack上要导入一个plug
然后修改vue的版本号、或者这webpack.config.js中添加一个插件  https://www.jianshu.com/p/ef8f6a70679b
然后在webpack设置使用vue-loader打包的文件

npm install vue-loader@latest --save-dev

为了让webpack打包html，同时自动引入打包好的js文件
安装html-webpack-plugin插件
npm install --save-dev html-webpack-plugin

一个用于压缩js的插件安装
npm install uglifyjs-webpack-plugin --save-dev
在webpack.config.js上配置开启插件

通过一个插件通过node启动项目  
webpack-dev-server插件安装  npm install --save-dev webpack-dev-server@2.9.1
在webpack.config.js 中配置启动参数

发现webpack和 webpack-dev-server 版本不兼容、要严格webpack.config.js上面的版本使用


安装npm isntall webpack-merge --save-dev
用于修改配置文件的分离
webpack --config webpack.config.js
