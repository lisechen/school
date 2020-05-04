// pages/setting/setting.js
const app = getApp()
const WeValidator = require('we-validator')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: '',
    gender: '',
    mobile: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('information onLoad userInfo: ', app.globalData.userInfo);

    if(app.globalData.userInfo){
      let { gender } = app.globalData.userInfo;
      let genderStr = '';
      if(gender == 1){
        genderStr = '男';
      }else if(gender == 2){
        genderStr = '女';
      }
      this.setData({
        username: app.globalData.userInfo.username,
        gender: genderStr,
        mobile: app.globalData.userInfo.mobile
      });
    }
  },

  onReady: function(e){
    console.log('onReady');
    this.initValidator();
  },

  bindinguser: function (e) {
    console.log('bindinguser ', e.detail.value);
    if (app.globalData.userInfo) {
      let { value} = e.detail;
      if (!this.validatorInstance.checkData(value)) return
      let { gender, username, mobile} = value;
      if(gender === '男'){
        gender = 1;
      }else if(gender === '女'){
        gender = 2;
      }else{
        wx.showToast({
          title: '性别只能为男或女',
          icon: 'none'
        })
        return;
      }
      let { id, wechat_id, wechat_name, avatar_url } = app.globalData.userInfo;
      let info = { id, wechat_id, wechat_name, avatar_url, gender, username, mobile};
      console.log('begin req ', info);
      wx.request({
        url: 'http://wechatapp.com:8088/user/update',
        method: 'POST',
        data: info,
        success: function (res) {
          let code = res.data.code
          if (code == 0) {
            wx.showToast({
              title: '信息修改成功',
              icon: 'success',
              duration: 2000,
              mask: true
            })

            //更新数据
            app.globalData.userInfo.username = username;
            app.globalData.userInfo.gender = gender;
            app.globalData.userInfo.mobile = mobile;

            setTimeout(()=>{
              wx.navigateBack({});
            }, 2000);

          } else {
            wx.showToast({
              title: '信息修改失败',
              icon: 'error',
              duration: 1200,
              mask: true
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
          required: true,
        },
      },
      messages: {
        username: {
          required: '请输入姓名'
        },
        gender: {
          required: '请输入性别',
        },
        mobile: {
          required: '请输入手机号',
        },
      },
    })

  },

})