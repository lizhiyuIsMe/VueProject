define(function(require, exports, module) {
    //被导入时候执行
    console.log('test3');
    return function say(){
            console.log('test say ..............')
        }
    }
);