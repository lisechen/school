
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

  information: function (e) {
    wx.navigateTo({
      url: '../information/information',
    })
  },

  // 跳转到历史发布二手页面
  collect: function (e) {
    wx.navigateTo({
      url: '../my-collect/my-collect',
    })
  },
  order: function (e) {
    wx.navigateTo({
      url: '../order/order',
    })
  },

  // 跳转到历史发布二手页面
  fabu: function (e) {
    wx.navigateTo({
      url: '../my-fabu/my-fabu',
    })
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
})
