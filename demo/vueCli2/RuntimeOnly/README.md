# runtime-only 和 runtimecomplate的区别主要在于main.js上
runtimecomplate： 功能多运行慢体积大
runtime-only ： 功能小 运行块 体积小

两者创建的项目主要区别在于main.js文件不同

//runtimecomplate 是这样的(可以看出是经过渲染组件然后再显示)
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})

//runtime-only 是这样的(没有渲染组件(由vue-template做的)，直接加上去)
new Vue({
  el: '#app',
  render: h => h(App)
})

runtime-only也可以这样使用
new Vue({
  el: '#app',
  // components: { App },
  // template: '<App/>'
  //1.createElement('标签',{标签属性},[''])
  render(createElement){
    // return createElement('h2',
    // {class:'box'},
    // ['hello vue', createElement('button',['按钮'])])
    //2.传入组件 App是导入的组件
    return createElement(App)
  }
})
