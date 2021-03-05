define(function(require, exports, module) {
        //如果引入test1后则可以通过test1.say() 调用此方法
        exports.say = function () {
            console.log('test1 say.............');
        };
        console.log('test1');
    }
);