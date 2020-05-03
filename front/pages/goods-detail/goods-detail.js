
var app = getApp();
var util = require('../../utils/util.js');
const WeValidator = require('we-validator');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    detailData: {
      avatar_url:'',
      price: '', //价格
      name:'',
      username:'',
      time:'',
      image:'',
      desc:'',
     
    },
    mobile: '',
    hadAddCart: false,  //已经加入购物车
    user_id: '',
    id: '',
    theCover: false,
    thePay: false,
    seller_id:'',
    hiddenmodalput: true,
    hiddenmodalputa: true,
    wantID: 0,
    userID: 0, //userID
    replyUserID: 0, //回复哪个人的userID 默认等于楼主id
    replyName: "",
    content: "",
    userName: "",
    userImg: "",
    limit: 5,
    contentInp: "",
    replyInp: "",
    focus: false,
    check: true, //默认显示我来评论input
    resultList: [],
    bookLastIda: '',// 每组数据的最后一个书本的id
    isBookSearchShowa: false,
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.showToast({
      title: '加载中',
      icon: 'loading',
      duration: 2500
    });
    console.log("options", options); //接收上一个页面传过来的数据，是个对象。
     this.setData({
       id: options.id,          
        })

    this.getWantDetail();

    var that = this;
    var detailData = that.data.detailData;
    var image = 'detailData.image';
    var name = 'detailData.name';
    var username = 'detailData.username';
    var desc = 'detailData.desc';
    var avatar_url = 'detailData.avatar_url';
    var time = 'detailData.time';
    var price = 'detailData.price';
    //console.log(user_id);//此处是获取不到值的
    wx.request({
      url: 'http://wechatapp.com:8088/goods/selectByPrimaryKey',
      method: 'POST',
      // header: {'content-type' : 'json'},
      header: { 'content-type': 'application/x-www-form-urlencoded ' },
      data: {
        id: that.data.id,
      
      },
      success: function (res) {
  console.log("goodsres",res)
        var data = res.data.data;
        that.setData({
          [image]: data.image,
          [name]: data.name,
         // [isTextbook]: data.reference,
         // [remark]: data.bnote || '无描述',
          [price]: data.price,
          [desc]: data.desc,
          [avatar_url]: data.avatar_url,
          [username]: data.username,
          [time]: util.resolvingDate(data.create_time),
          seller_id: data.user_id,
         
        })
      } //此处的res就是data对象
    })  
     if (app.globalData.userInfo) {
     
      this.setData({
        user_id: app.globalData.userInfo.id,

      });
     
    }


  },
  mobile(e) {
    this.setData({
      mobile: e.detail.value
    })
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
    wx.setNavigationBarTitle({
      title: '商品详情'
    });
    wx.showNavigationBarLoading(); //在标题栏中显示加载图标
    setTimeout(function () {
      wx.stopPullDownRefresh(); //停止加载
      wx.hideNavigationBarLoading(); //隐藏加载icon
    }, 2000)
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },
  modalinput: function () {
    this.setData({
      hiddenmodalput: !this.data.hiddenmodalput
    })
  },
  modalinputa: function () {
    this.setData({
      hiddenmodalputa: !this.data.hiddenmodalputa
    })
  },
  cancela: function () {
    this.setData({
      hiddenmodalputa: true
    });
  },
  //取消按钮
  cancel: function () {
    this.setData({
      hiddenmodalput: true
    });
  },

  getWantDetail() {
    var that = this;
    var bookLastId = that.data.bookLastId;
    var resultList = that.data.resultList;
    var isBookSearchShow = that.data.isBookSearchShowa;
    //微信请求方式的写法
    wx.showToast({
      title: '加载中',
      icon: 'loading',
      duration: 1000,
    })
    wx.request({
      url: 'http://wechatapp.com:8088/comment/selectbygoods',
      method: 'POST',
      data: {
        goods_id: that.data.id,
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
            isBookSearchShow: true,
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
    var bookLastId = this.data.bookLastId;
    var bookSearchLength = this.data.bookSearchLength;
    bookSearchLength = data.length;
    var resultList = this.data.resultList;

    this.setData({
      bookLastId: data[bookSearchLength - 1].id,
      userID: this.data.user_id,
      replyUserID: this.data.user_id,
    })
    console.log("userID", this.data.user_id, 'replyUserID', 'this.data.user_id')
    data.forEach(item => {
      //注意： push可以是具体的对象
      resultList.push({
        id: item.id,
        time: util.resolvingDate(item.create_time),
        userName: item.username,
        userImg: item.avatar_url,
        status: item.status,
        replyName: item.reply_Username,
        reply_Avatar_url: item.reply_Avatar_url,
        content: item.content,
        userID: item.user_id,
        replyuserid: item.reply_id
      })

      this.setData({
        resultList: resultList,

      });

    })
  },

  onReachBottom: function () {
    // this.getWantDetail();
    wx.showToast({
      title: '已显示所有结果',
      icon: 'loading',
      duration: 1000,
    })
  },
  //触摸事件切换到回复楼主
  touchstar: function () {
    this.setData({
      check: true,
      focus: false,
      contentInp: "",
      replyInp: "",
    })
  },
  /**评论输入框 */
  contentInp(e) {
    this.setData({
      contentInp: e.detail.value
    })
  },
  /**答复输入框 */
  replyInp(e) {
    this.setData({
      replyInp: e.detail.value
    })
  },

  /**消息图片点击 */
  addWantImg() {
    this.setData({
      focus: true,
    })
  },
  addWant() {
    this.setData({
      hiddenmodalput: true,
      hiddenmodalputa: true
    })
    if (this.data.contentInp.length > 100) {

      wx.showToast({
        title: '请将字数控制在100字以内哦',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else {
      if (this.data.replyUserID === this.data.userID && this.data.check === true) {
        this.addComment();
      } else {
        this.addReply();
      }
    }
  },

  /**发表评论 */
  addComment() {
    var that = this
    let newList = [];
    let resultList = that.data.resultList;
    console.log("addComment", that.data.id)
    // 提交评论
    wx.request({
      url: 'http://wechatapp.com:8088/comment/insert',
      method: "POST",
      data: {
        goods_id: that.data.id,
        user_id: app.globalData.userInfo.id,
        content: that.data.contentInp,
        status: 1
      },
      header: {
        "content-type": "application/x-www-form-urlencoded;charset=utf-8",
        //token: app.globalData.token
      },
      success: res => {
        console.log(res.statusCode, "res")
        console.log(res, "resssssssss")
        that.onShow()
        if (res.statusCode = 200) {
          this.setData({
            contentInp: ""
          })
          wx.showToast({
            title: '评论成功',
            icon: "none",
            duration: 2000,
            mask: true,
          })
          // push改变原数组

          this.setData({
            resultList: newList
          })
          this.getWantDetail();
        } else {
          wx.showToast({
            title: '回复失败，请检查您的网络',
          })
        }
      }
    })

  },
  /**点击评论获取要回复的人的id */
  getReplyUserID(e) {
    this.setData({
      hiddenmodalput: !this.data.hiddenmodalput
    })
    console.log("eee", e)
    let replyID = e.currentTarget.dataset.replyuserid;
    if (replyID === app.globalData.userInfo.id) {
      wx.showToast({
        title: '请不要回复自己哦',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else {
      this.setData({
        replyUserID: replyID,
        replyName: e.currentTarget.dataset.replyname,
        focus: true,
        check: false
      })
    }
  },
  /**回复 */
  addReply() {
    var that = this
    let newLista = [];
    let resultList = that.data.resultList;
    wx.request({
      url: 'http://wechatapp.com:8088/comment/insert',
      method: "POST",
      data: {
        goods_id: that.data.id,
        reply_id: this.data.replyUserID,
        user_id: app.globalData.userInfo.id,
        content: this.data.replyInp,
        status: 0
      },
      header: {
        "content-type": "application/x-www-form-urlencoded;charset=utf-8",
        //token: app.globalData.token
      },
      success: res => {
        console.log(res.statusCode, "res")
        if (res.statusCode = 200) {
          this.setData({
            replyInp: "",
            check: true
          })
          wx.showToast({
            title: '评论成功',
            icon: "none",
            duration: 1000,
            mask: true,
          })
          this.setData({
            resultList: newLista
          })
          this.getWantDetail();

        } else {
          wx.showToast({
            title: '回复失败，请检查您的网络',
          })
        }
      }
    })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  addMyCart() {
    var that = this;
    var hadAddCart = that.data.hadAddCart;
    var user_id = that.data.user_id;
    var id = that.data.id;
    if (user_id) {
      if (!hadAddCart) {
        wx.showModal({
          title: '提示',
          content: '是否收藏商品',
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
              wx.request({
                url: 'http://wechatapp.com:8088/collect/insert',
                method: 'POST',
                data: {
                  user_id:user_id,
                  goods_id:id,
                  name: that.data.detailData.name,
                  state:1
                },
                header: {
                  'content-type': 'application/x-www-form-urlencoded' // 默认值
                },
                success: function (res) {
                  that.setData({
                    hadAddCart: true
                  })
                  wx.showToast({
                    title: '收藏成功',
                    icon: 'success',
                    duration: 1000
                  })
                }
              })

            } else if (res.cancel) {
              console.log('用户点击取消')
            }
          }
        })

      } else {
        wx.showModal({
          title: '提示',
          content: '已经收藏过了'

        })
      }
    } 

  },
  nowBuy() {
    var that = this;
    var id = that.data.id;
    var theCover = that.data.theCover;
    var thePay = that.data.thePay;
    if (that.data.user_id != that.data.seller_id) {

    that.setData({
      theCover: true,
      thePay: true,
    })
    } else {
      wx.showModal({
        title: '提示',
        content: '这是自己的商品，不能购买'

      })
    }
  },
  deletePay() {
    var that = this;
    var theCover = that.data.theCover;
    var thePay = that.data.thePay;
    that.setData({
      theCover: false,
      thePay: false,
    })
  },
  
  buy(e) {
    if (e.detail.value.mobile === "") {
      wx.showToast({
        title: '请输入联系方式',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    }else{
    console.log(e,"eeeeee")
    var that = this;
    var id = that.data.id;
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
        console.log("res.data",res.data);
        if (res.data === "删除成功") {
          that.ReservationPayment(e);//预约付款
        } else {
          wx.showModal({
            title: '提示',
            content: '该商品已下架',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              } else if (res.cancel) {
                console.log('用户点击取消')
              }
            }
          })
        }
      }
    }) 

  }},

  ReservationPayment(e) {    
    var that = this;
    console.log("mobile", e.detail.value.mobile)
    var buyer_id= that.data.user_id;
    var seller_id = that.data.seller_id;
    var goods_id= that.data.id;
    var mobile = e.detail.value.mobile

    wx.request({
      url: 'http://wechatapp.com:8088/order/insert',
      method: 'POST',
      header: {
        "Content-Type": "application/json"
      },
      data: {
        goods_id: that.data.id ,
        buyer_id: buyer_id,
        seller_id: seller_id,
        status: 1,
        mobile: e.detail.value.mobile
      },
      success: function (res) {
        console.log(res);
        wx.showToast({
          title: '预购成功',
          icon: 'success',
          duration: 1500
        })
        setTimeout(function () {
          wx.navigateTo({
            url: '../order/order'
          })
        }, 1500)

      }
    })
  },
  
})