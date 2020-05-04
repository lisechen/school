//index.js
//获取应用实例
const app = getApp();

Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    isHide: true
  },
  //事件处理函数
  bindGetUserInfo: function (e) {
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      var that = this;
      // 获取到用户的信息了，打印到控制台上看下
      console.log("用户的信息如下：");
      console.log(e.detail.userInfo);
      //授权成功后,通过改变 isHide 的值，让实现页面显示出来，把授权页面隐藏起来
      that.setData({
        isHide: false
      });
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function (res) {
          // 用户没有授权成功，不需要改变 isHide 的值
          if (res.confirm) {
            console.log('用户点击了“返回授权”');
          }
        }
      });
    }
  },
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
        console.log('onLoad userInfoReadyCallback res.userInfo', res.userInfo);
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
          app.globalData.userInfo = res.userInfo;
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

      let that = this;
      let {userInfo} = e.detail;
      //入库
      wx.request({
        url: 'http://wechatapp.com:8088/user/insert',
        method: 'POST',
        data: {
          wechat_name: userInfo.nickName,
          avatar_url: userInfo.avatarUrl,
          username: userInfo.nickName,
          gender: userInfo.gender
        },
        success(res) {
          console.log('insert用户 res', res);
          if (res.data && res.data.code === 0 && res.data.data){
            that.globalData.userInfo = res.data.data;
            console.log('app.js 入库 ', res.data.data);
            app.globalData.userInfo = res.data.data;
            this.setData({userInfo: res.data.data, hasUserInfo: true});
          }else {
            wx.showToast({
              title: '用户创建失败',
              icon:'none'
            })
          }
        },
        fail(res) {
          console.log('insert用户 res fail', res);
          wx.showToast({
            title: '用户创建失败',
            icon:'none'
          })
        }
      })
    }
    else{
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
});
