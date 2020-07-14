import request from '@/utils/request'

export default {
  list() {
    return request({
      url: '/admin/user/list',
      method: 'get'
    })
  }
}