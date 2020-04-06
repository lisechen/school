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
    let that = this;
    wx.getSetting({
      success: res => {
        console.log('onLoad  wx.getSetting res', res);
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              let {userInfo} = res || {};
              console.log('app.js getUserInfo ', userInfo);
              //看这个用户库中是否存在
              wx.request({
                url: 'http://wechatapp.com:8088/user/find',
                method: 'GET',
                data: {wechat_name: userInfo.nickName},
                success(res) {
                  console.log('find用户 res', res);
                  //库里已经存在
                  if (res.data && res.data.code === 0 && res.data.data){
                    that.globalData.userInfo = res.data.data;
                    console.log('app.js 读库 ', res.data.data);
                    // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                    // 所以此处加入 callback 以防止这种情况
                    if (that.userInfoReadyCallback) {
                      //这个调用，page/index/index的app.userInfoReadyCallback收到
                      that.userInfoReadyCallback({userInfo: res.data.data});
                    }
                  }else {
                    //库里没有，入库
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
                          // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                          // 所以此处加入 callback 以防止这种情况
                          if (that.userInfoReadyCallback) {
                            that.userInfoReadyCallback({userInfo: res.data.data})
                          }
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
                },
                fail(res) {
                  console.log('find用户 res fail', res);
                  wx.showToast({
                    title: '用户信息获取失败',
                    icon:'none'
                  })
                }
              })
            }
          })
        }
      }
    })
  },

  globalData: {
    userInfo: null
  },

});
