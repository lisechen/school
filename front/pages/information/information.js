// pages/setting/setting.js
const app = getApp()
const WeValidator = require('we-validator')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: '',
    gender: '女',//假数据
    mobile: '123',//假数据
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('onLoad userInfo: ', app.globalData.userInfo);

    if(app.globalData.userInfo){
      this.setData({
        username: app.globalData.userInfo.nickName
      });
    }
    
  },

  bindinguser: function (e) {
    console.log('bindinguser ', e);
    console.log('data ', this.data);
    if (app.globalData.userInfo) {
      let val = wx.getStorageSync("openId");
      let { value } = e.detail
     // if (!this.validatorInstance.checkData(value)) return
      let info = e.detail.value
      // console.log(info.name)
      console.log('begin req');
      wx.request({
        url: 'http://wechatapp.com:8088/user/update',
        // data: {
        //   openId: val,
        //   username: e.detail.value.username,
        //   gender: e.detail.value.gender,
        //   mobile: e.detail.value.mobile,
        // },
        data: {
          openId: val,
          username: this.data.username,
          gender: this.data.gender,
          mobile: this.data.mobile,
        },
        success: function (res) {
          console.log('res ',res.data);
          let code = res.data.code
          if (code == 0) {

            wx.showToast({
              title: '注册信息成功',
              icon: 'success',
              duration: 3000,
              mask: true
            })
            wx.navigateTo({
              url: '../mine/mine',
            })

          } else {
            wx.showToast({
              title: '注册信息失败',
              icon: 'error',
              duration: 1200,
              mask: true
            })
            wx.redirectTo({
              url: '../mine/mine'
            })
          }
        },
        fail: function(e){
          console.log('fail ', e);
        }
      })
    } else {
      wx.showToast({
        title: '请先登录',
        image: '../../images/error.png',
        duration: 1000,
        mask: true
      })
    }

  },

  initValidator() {
    this.validatorInstance = new WeValidator({
      rules: {
        username: {
          required: true
        },
        gender: {
          required: true,
        },
        mobile: {
          required: true
        },


      },
      messages: {
        username: {
          required: '请输入姓名'
        },
        gender: {
          required: '请输入性别',
        },
        moblie: {
          required: '请输入语言'
        },
      },
    })

  },
  onReady() {
   // this.initValidator()
    //this.checkBinding()
  },
})