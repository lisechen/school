// pages/order/order.js
var util = require('../../utils/util.js')
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currtab: 0,
    swipertab: [{ sname: '我的购买', index: 0 }, { sname: '我的售卖', index: 1 }],
    resultLista:[],
    resultList: [],
    bookLastId: '',// 每组数据的最后一个书本的id
    bookLastIda:"",
    bookSearchLength: 5,
    bookSearchLengtha:5,
    isBookSearchShow: false,
    isBookSearchShowa: false,
    time: '',
    user_id: '',

  },

  onPullDownRefresh: function () {
    wx.showNavigationBarLoading(); //在标题栏中显示加载图标
    setTimeout(function () {
      wx.stopPullDownRefresh(); //停止加载
      wx.hideNavigationBarLoading(); //隐藏加载icon
    }, 1000)
  },
  onReachBottom: function () {
    // this.searchResult();
    wx.showToast({
      title: '已显示所有结果',
      icon: 'loading',
      duration: 1000,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    if (app.globalData.userInfo) {

      this.setData({
        user_id: app.globalData.userInfo.id,
      });
    }
    that.getDeviceInfo()
    that.orderShow()
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    // 页面渲染完成

  },

  getDeviceInfo: function () {
    let that = this
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          deviceW: res.windowWidth,
          deviceH: res.windowHeight
        })
      }
    })
  },

  /**
  * @Explain：选项卡点击切换
  */
  tabSwitch: function (e) {
    var that = this
    if (this.data.currtab === e.target.dataset.current) {
      return false
    } else {
      that.setData({
        currtab: e.target.dataset.current
      })
    }
  },

  tabChange: function (e) {
    this.setData({ currtab: e.detail.current })
    this.orderShow()
  },

  orderShow: function () {
    let that = this
    switch (this.data.currtab) {
      case 0:
        that.alreadyShow()
        break
      case 1:
        that.lostShow()
        break
    }
  },
  alreadyShow: function () {
    var that = this;
    var user_id = that.data.user_id;
    var bookLastId = [];
    var resultList = that.data.resultList;
    //  var bookSearchLength = that.data.bookSearchLength;
    var isBookSearchShow = that.data.isBookSearchShow;


    //微信请求方式的写法
    wx.showToast({
      title: '加载中',
      icon: 'loading',
      duration: 1000,
    })
    wx.request({
      url: 'http://wechatapp.com:8088/order/selectbybuyer',
      method: 'POST',
      data: {
        buyer_id: user_id,
        id: bookLastId,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded ' },
      success: function (res) {
        console.log('res ', res.data);
        let code = res.data.code
        var data = res.data.data.length;
        if (data == 0) {
          wx.hideToast();
          that.setData({
            isBookSearchShow: true
          })
          return
        }

        that.handleData(res.data.data);

      },
      fail(err) {
        console.log(err);
      }
    })

  },
  handleData(data) {
    //  console.log('111', bookSearchLength, bookLastId);
    var bookLastId = this.data.bookLastId;
    var bookSearchLength = this.data.bookSearchLength;
    // console.log('222',bookSearchLength, bookLastId);
    bookSearchLength = data.length;
    var resultList = this.data.resultList;

    this.setData({
      bookLastId: data[bookSearchLength - 1].id,
      //   bookSearchLength: data.length
    })
    data.forEach(item => {
      //注意： push可以是具体的对象
      resultList.push({
        id: item.id,
        name: item.name,
        price: item.price,
        image: item.image,
        desc: item.desc,
        time: util.resolvingDate(item.create_time),
        username: item.username,
        avatar_url: item.avatar_url,
        mobile: item.mobile


      })

      this.setData({
        resultList: resultList,

      });

    })
    //将此处resultList的值放在数据data的resultList中

  },

  lostShow: function () {
    var that = this;
    var user_id = that.data.user_id;
    var bookLastIda = that.data.bookLastIda;
    var resultLista = that.data.resultLista;
    //  var bookSearchLength = that.data.bookSearchLength;
    var isBookSearchShowa = that.data.isBookSearchShowa;
    

    //微信请求方式的写法
    wx.showToast({
      title: '加载中',
      icon: 'loading',
      duration: 1000,
    })
    wx.request({
      url: 'http://wechatapp.com:8088/order/selectbyseller',
      method: 'POST',
      data: {
        seller_id: user_id,
        id: bookLastIda,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded ' },
      success: function (res) {
        console.log('res ', res.data);
        let code = res.data.code
        var data = res.data.data.length;
        if (data == 0) {
          wx.hideToast();
          that.setData({
            isBookSearchShowa: true
          })
          return
        }

        that.handleDataa(res.data.data);

      },
      fail(err) {
        console.log(err);
      }
    })

  },
  handleDataa(data) {
    //  console.log('111', bookSearchLength, bookLastId);
    var bookLastIda = this.data.bookLastIda;
    var bookSearchLengtha = this.data.bookSearchLengtha;
    // console.log('222',bookSearchLength, bookLastId);
    bookSearchLengtha = data.length;
    var resultLista = this.data.resultLista;

    this.setData({
      bookLastIda: data[bookSearchLengtha - 1].id,
      //   bookSearchLength: data.length
    })
    data.forEach(item => {
      //注意： push可以是具体的对象
      resultLista.push({
        id: item.id,
        name: item.name,
        price: item.price,
        image: item.image,
        desc: item.desc,
        time: util.resolvingDate(item.create_time),
        username: item.username,
        avatar_url: item.avatar_url,
        mobile: item.mobile


      })

      this.setData({
        resultLista: resultLista,

      });

    })
    //将此处resultList的值放在数据data的resultList中

  },
})