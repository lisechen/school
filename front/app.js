//app.js

App({


  onLaunch: function () {

    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || [];
    logs.unshift(Date.now());
    wx.setStorageSync('logs', logs);

    console.log('app.js onLoad');

    console.log('app.js onLoad  wx.getSetting');

    //page/index/index onLoad获取用户信息
    // 获取用户信息


  },

  globalData: {
    userInfo: null
  },



});
