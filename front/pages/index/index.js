//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: '待修改',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    console.log('pages/index onLoad');
    if (app.globalData.userInfo) {
      console.log('onLoad app.globalData.userInfo 有值');
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      console.log('onLoad userInfoReadyCallback');
      app.userInfoReadyCallback = res => {
        console.log('onLoad userInfoReadyCallback res', res);
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      console.log('onLoad  wx.getUserInfo');
      wx.getUserInfo({
        success: res => {
          console.log('onLoad  wx.getUserInfo res', res);
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    //用户不一定给权限
    if (e.detail.userInfo){
      console.log('getUserInfo click userInfo', e.detail.userInfo);

      app.globalData.userInfo = e.detail.userInfo;
      console.log("wechat data:", app.globalData.userInfo);
      this.setData({
        userInfo: e.detail.userInfo,
        hasUserInfo: true
      });
    }else{
      wx.showToast({
        title: '权限获取失败，请重试',
        icon:'none'
      })
    }
  },
  //进入首页
  enterHome: function(e){
    console.log('enterHome click');
    wx.switchTab({
		  url: "../shouye/shouye"

	  });
  },
})
