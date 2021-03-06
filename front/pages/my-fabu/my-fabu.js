// pages/search/search.js
var util = require('../../utils/util.js')
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 存放数据
    resultList: [],
    bookLastId: '',// 每组数据的最后一个书本的id
    bookSearchLength: 5,
    isBookSearchShow: false,
    time: '',
    user_id: '',
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
    that.searchResult();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**+
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    wx.showNavigationBarLoading(); //在标题栏中显示加载图标
    setTimeout(function () {
      wx.stopPullDownRefresh(); //停止加载
      wx.hideNavigationBarLoading(); //隐藏加载icon
    }, 1000)
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    // this.searchResult();
    wx.showToast({
      title: '已显示所有结果',
      icon: 'loading',
      duration: 1000,
    })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  //时间戳转换成日期时间





  searchResult() {
    var that = this;
    var keyWord = "课本";
    var bookLastId = that.data.bookLastId;
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
      url: 'http://wechatapp.com:8088/goods/selectbyuser',
      method: 'POST',
      data: {
        user_id: that.data.user_id,
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
        avatar_url: item.avatar_url


      })

      this.setData({
        resultList: resultList,

      });

    })
    //将此处resultList的值放在数据data的resultList中

  },
  toThingDetail(e) {
    console.log("e", e)
    var that = this
    //获取当前点击元素的id(索引值)
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../goods-detail/goods-detail?id=' + id, //跳转到书本详情页



    })
  },


  deletePost: function (event) {
    var that = this;
    var id = event.currentTarget.dataset.id;
    console.log("event", event)
    var index = event.currentTarget.dataset.index;
    let resultList = that.data.resultList
    wx.showModal({
      title: '操作提示',
      content: '确定要删除该发布？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://wechatapp.com:8088/goods/delete',//仅为示例，并非真实的接口地址
            method: 'POST',
            data: {
              id: id
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded' // 默认值
            },
            success: function (res) {
              console.log("res.data", res.data);
              if (res.data === "删除成功"){
                wx.showToast({
                  title: '删除成功',
                  icon: 'success',
                  duration: 1000
                })
                resultList.splice(index, 1)
                that.setData({
                  resultList: resultList
                })

              } else if (res.cancel) {

                console.log('用户点击取消');
                
              }
            }
          }) 
        }
      }
    })
  }

})