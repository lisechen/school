//my.js
var StudentId = './mySetting/mySetting.js'
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    userInfo: {
      nickName: '',
      avatarUrl: '',
    },

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    console.log('mine onLoad');

    console.log('app.globalData.userInfo', app.globalData.userInfo);
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log('mine onShow');
    //没有进入页面或者返回该页面都刷新一下数据
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo
      })
    }
  },


  onPullDownRefresh() {
    wx.setNavigationBarTitle({
      title: '我的信息'
    });
    wx.showNavigationBarLoading(); //在标题栏中显示加载图标
    setTimeout(function () {
      wx.stopPullDownRefresh(); //停止加载
      wx.hideNavigationBarLoading(); //隐藏加载icon
    }, 2000)
  },
  bindGetUserInfo: function (e) {
    var that = this;
    var nickName = that.data.userInfo.nickName;
    var avatarUrl = that.data.userInfo.avatarUrl;

    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      var userInfo = e.detail.userInfo;
      console.log(userInfo)
      that.setData({
        nickName: userInfo.nickName
      })
      that.setData({
        avatarUrl: userInfo.avatarUrl
      })
      try {//同步设置nickName
        wx.setStorageSync('nickName', userInfo.nickName)
      } catch (e) {
      }

      wx.setStorage({
        key: 'avatarUrl',
        data: userInfo.avatarUrl,
      })
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '提示',
        content: '请授权登录',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
            wx.navigateBack({
              delta: 1
            })
          } else {
            console.log('用户点击取消')
            wx.navigateBack({
              delta: 1
            })
          }
        }
      })
    }
  },
  bindClear: function (e) {
    var that = this;
    var nickName = 'userInfo.nickName';
    var avatarUrl = 'userInfo.avatarUrl';

    try {//同步设置nickName
      wx.setStorageSync('nickName', '')
    } catch (e) {
    }
    wx.setStorage({
      key: 'studentId',
      data: '',
    })
    wx.setStorage({
      key: 'passWord',
      data: '',
    })
    wx.setStorage({
      key: 'avatarUrl',
      data: '',
    })
    that.setData({
      [nickName]: '个人信息',
      [avatarUrl]: ''
    })
    wx.showModal({
      title: '提示',
      content: '退出账号成功',
      success: function () {
        wx.switchTab({
          url: '/pages/shouye/shouye',
        })
      }
    })
  },


})
