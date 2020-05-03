// pages/fabu/fabu.js
var util = require('../../utils/util.js')
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 首页的轮播图
    imgUrls: [
      "http://wechatapp.com:8088/picture/campus/lunbotu7.jpg",
      "http://wechatapp.com:8088/picture/campus/lunbotu6.jpg",
      "http://wechatapp.com:8088/picture/campus/lunbotu3.png",
      "http://wechatapp.com:8088/picture/campus/lunbotu2.png",
    ],
    indicatorDots: true,  //是否显示面板指示点
    autoplay: true,      //是否自动切换
    interval: 3000,       //自动切换时间间隔
    duration: 1000,       //滑动动画时长
    inputShowed: false,
    inputVal: "",
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

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this
    that.searchResult();

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
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

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },


 searchResult() {
    var that = this;
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
      url: 'http://wechatapp.com:8088/goods/selectall',
      method: 'POST',
      data: {
      status:1
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
          time: util.resolvingDate(item.create_time),

        });
      this.setData({
        resultList: resultList,

      });

    })
    //将此处resultList的值放在数据data的resultList中

  },
  toThingDetail(e) {
    console.log("e", e)
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../goods-detail/goods-detail?id=' + id, //跳转到商品详情页
    })
  },
  bindToSearch_aa(e) {
    var that = this;
    wx.navigateTo({
      url: '../sortresult/sortresult?keyWord=' + '闲置课本'
    })
  },
  bindToSearch(e) {
    var that = this;
    wx.navigateTo({
      url: '../sortresult/sortresult?keyWord=' + sort
    })
  },
  bindToSearch_ab(e) {
    var that = this;
    wx.navigateTo({
      url: '../sortresult/sortresult?keyWord=' + '生活用品'
    })
  },
  bindToSearch_ac(e) {
    var that = this;
    wx.navigateTo({
      url: '../sortresult/sortresult?keyWord=' + '体育用品'
    })
  },
  bindToSearch_ad(e) {
    var that = this;
    wx.navigateTo({
      url: '../sortresult/sortresult?keyWord=' + '数码电子'
    })
  },
})
