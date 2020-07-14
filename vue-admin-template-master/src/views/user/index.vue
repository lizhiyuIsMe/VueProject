<template>
  <div class="app-container">
     用户管理
  

  </div>
</template>

<script>

import {userApi} from '@/api/user/index';
export default {
  data() {
    return {
     list: [] // 讲师列表
    }
  },
  watch: {

  },
  // 页面渲染成功后获取数据
  created() {
    alert()
    this.fetchData()
  },
  // 定义方法
  methods: {
    fetchData() {
      // 调用api
      userApi.list().then(response => {
        alert(response)
        this.list = response.data.msg
      })
    }
  }
}
</script>

