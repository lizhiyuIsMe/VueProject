//第一种导出方式
const param="parm1"
function fun(){

}
export {param,fun}

//第二种导出方式
export function fun(){
    console.log('fun1>>>>>>>');
    return;
}
//默认导出方式、一个文件只能使用default导出一次，引入时候可以用随意名字导入
export default  function fun2(){
    console.log('fun2>>>>>>>')
}
