// pages/productReleased/productReleased.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    mobile:"",
    image: "",
    title: "",
    info: "",
   // point: "",
    price: "",
    type: [{
      name: "闲置课本",
      id: 0
    }, {
      name: "生活用品",
      id: 1
    }, {
      name: "体育用品",
      id: 2
    }, {
      name: "数码电子",
      id: 3
    }],
    imageurl: " ",
    productID: 0,
    //category: [],
    //categoryInd: -1, //类别
    typeInd: 0, //类型
    stateInd: 1, //状态
 
  
    params: {
      productID: 0,
      contentFile: "",
      check: false,
    },
    dis: false,
  },
  /**
   * 生命周期函数--监听页面加载
   */
  /**
   * 获取标题
   */
  titleBlur(e) {
    this.setData({
      title: e.detail.value
    })
  },
  /**
   * 获取商品价格
   */
  priceBlur(e) {
    this.setData({
      price: e.detail.value
    })
  },
  /**
   * 获取商品信息
   */
  infoBlur(e) {
    this.setData({
      info: e.detail.value
    })
  },
  /**
   * 获取商品卖点
   */
  pointBlur(e) {
    this.setData({
      point: e.detail.value
    })
  },
  /** 
   * 商品价格
   */
  price(e) {
    this.setData({
      price: e.detail.value
    })
  },
  /**
   * 商品类型
   */
  type(e) {
    this.setData({
      typeInd: e.detail.value
    })
  },
  /**
   * 商品状态
   */
  state(e) {
    this.setData({
      stateInd: e.detail.value
    })
  },
  
  mobile(e) {
    this.setData({
      mobile: e.detail.value
    })
  },

  bindThingImageInput: function () { //商品图片选择
  console.log("拿到照片")
    var that = this;
    wx.chooseImage({
      count: 1,
      sourceType: ['album', 'camera'],
      success: function (res) {
        that.setData({
          image: res.tempFilePaths[0]
    
        })
      },
    })
  },

onlode:function(){
  let that = this
  wx.uploadFile({
    url: 'http://wechatapp.com:8088/goods/upload',
    filePath: that.data.image,
    name: 'file',
    formData: {
      'parameters': ""
    },
    success: function (res) {
      that.setData({
        imageurl: res.data
      })
    }, fail: function (res) {
      console.log(JSON.stringify(res));
      wx.showToast({
        title: '发布失败',
        icon: 'loading',
        duration: 2000
      })
      that.setData({
        buttonLoading: false
      })
    },
  })},
  /**发布提交 */
  formSubmit(e) {
    let that = this
    that.onlode();
    var priceTF = /^\d+(\.\d{1,2})?$/
    if (e.detail.value.title === "") {
      wx.showToast({
        title: '请输入商品名称',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else if (e.detail.value.title.length > 60) {
      wx.showToast({
        title: '商品名称不得大于60字',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else if (e.detail.value.title.length === "") {
      wx.showToast({
        title: '请输入商品价格',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else if (!priceTF.test(e.detail.value.price)) {
      wx.showToast({
        title: '商品价格精确到两位',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else if (e.detail.value.info === "") {
      wx.showToast({
        title: '请输入商品信息',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else if (e.detail.value.mobile === "") {
      wx.showToast({
        title: '请输入联系方式',
        icon: "none",
        duration: 1000,
        mask: true,
      })
    } else if (that.data.typeInd === -1) {
      wx.showToast({
        title: '请选择商品类型',
        icon: "none",
        duration: 1000,
        mask: true,
      })
      
    } else if (that.data.image==="") {
      wx.showToast({
        title: '请选择图片',
        icon: "none",
        duration: 1000,
        mask: true,
      })

    }else {
      wx.showModal({
        title: '提示',
        content: '确定发布商品',
        success(res) {
          console.log("改过",res)
     
          console.log("改过1", res)
          if (res.confirm) {
            
             var imageurll= 'http://localhost:8088/picture/goodsimg/' + that.data.imageurl

              let sort = '';
              if (that.data.type[that.data.typeInd].id== 0) {
                sort = '闲置课本';
              } else if (that.data.type[that.data.typeInd].id == 1) {
                sort = '生活用品';
              } else if (that.data.type[that.data.typeInd].id == 2) {
                sort = '体育用品';
              } else if (that.data.type[that.data.typeInd].id == 3) {
                sort = '数码电子';
              }
          
              wx.request({
                url: 'http://wechatapp.com:8088/goods/insert',
                method: 'POST',
                header: {
                  "Content-Type": "application/json"
                },
                data: {
                  user_id: app.globalData.userInfo.id,
                  id: that.data.productID,
                  name: e.detail.value.title,
                  price: e.detail.value.price,
                  desc: e.detail.value.info,
                  category: sort,
                  status: 1,
                  image: imageurll,
                  mobile: e.detail.value.mobile
                },
                success: function (res) {
                  console.log('res ', res.data);
                  wx.showToast({
                    title: '发布成功',
                    icon: 'loading',
                    duration: 2000
                  })
                  wx.reLaunch({
                    url: "../shouye/shouye",                   
                    })
                  that.setData({
                    title: "",
                    info: "",
                    price: "",
                    image: "",
                    mobile:"",
                  })
                },
                fail: function (res) {
                  console.log(res);
                  wx.showToast({
                    title: '发布失败',
                    icon: 'loading',
                    duration: 2000
                  })
                  that.setData({
                    buttonLoading: false
                  })
                },
              }); //发布
            that.setData({
              dis: true,
            })
            
          }
        }
      })
    }
  },
  sureEdit(params) {
    let that = this
    app.addProduct(params).then(res => {
      that.data.params.productID = res.data.productID;
      //判断编辑页面下是否只改变了文字数据，选择图片后checkUp为false
      if (that.data.checkUp && res.state === 1) {
        wx.showToast({
          title: '商品修改成功',
          icon: "none",
          duration: 2000,
          mask: true,
          success() {
            setTimeout(function () {
              wx.navigateBack({
                delta: 0,
              })
            }, 1000);
          }
        })
      }
    })
  },


})