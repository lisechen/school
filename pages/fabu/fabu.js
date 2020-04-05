
var app = getApp();
Page({
  formSubmit:function(e){
    wx.request({ 
      method:'post',
      url: 'localhost:8088/goods/insert',
      data:e.detail.value,
      success:function(res){
        console.log(res)
      }
    })},
    onLoad:function(){
      var that=this
      vx.request({
        url:'localhost:8088/goods/select',
        success:function(res){
          that.setData(res.data)
        }

      })
    },
  /**
   * 页面的初始数据
   */
  data: {
   /* title*/  goodsname: "",
    /*info*/   textdesc: "",
    goodsPrice: "",
    goodsState: [{
      name: "下架",
      id: 0
    }, {
      name: "上架",
      id: 1
    }],
    goodssort: [{
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
     goodssortInd: 1, //类别
    goodsStateInd: 1, //状态
    detail: [], //详情图片
    /* detailNew: [],
  detailAll: [],*/
    checkUp: true, //判断从编辑页面进来是否需要上传图片
    chooseViewShowDetail: true,
    chooseViewShowBanner: true,
    params: {
      productID: 0,
      contentFile: "",
      bannerFile: "",
      check: false,
    },
    dis: false,
  },
  
  
  
  })