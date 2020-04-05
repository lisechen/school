Component({
  data: {
    selected: 0,
    color: "#7A7E83",
    selectedColor: "#3cc51f",
    list: [{
      "pagePath": "pages/index/index",
      "text": "5口",
      "iconPath": "pages/img/icon_API.png",
      "selectedIconPath": "pages/img/icon_API_HL.png"

    },
      {
        "pagePath": "pages/fabu/fabu",
        "iconPath": "pages/img/icon_API.png",
        "selectedIconPath": "pages/img/icon_API_HL.png",
        "text": "接口"
      },
      {
        "pagePath": "pages/logs/logs",
        "iconPath": "pages/img/icon_component.png",
        "selectedIconPath": "pages/img/icon_component_HL.png",
        "text": "组件"
      }]
  },
  attached() {
  },
  methods: {
    switchTab(e) {
      const data = e.currentTarget.dataset
      const url = data.path
      wx.switchTab({url})
      this.setData({
        selected: data.index
      })
    }
  }
})