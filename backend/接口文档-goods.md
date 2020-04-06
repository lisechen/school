## 2.商品接口文档
### 2.1 查找全部商品
```
GET http://localhost:8088/goods/selectall

返回
{
    "code": 0,
    "msg": "SUCCESS",
    "data": [
        {
            "id": 1,
            "name": "物理课本",
            "desc": "这个商品很好",
            "image": "http://localhost:8088/picture/goodsimg/a.jpg",
            "price": 10,
            "status": 1,
            "create_time": "2020-03-10T13:46:59.000+0000",
            "user_id": 5,
            "update_time": "2020-03-31T02:23:06.000+0000",
            "category": "闲置课本"
        },
        {
            "id": 2,
            "name": "自行车",
            "desc": "这个车子很好",
            "image": "http://localhost:8088/picture/goodsimg/b.jpg",
            "price": 100,
            "status": 1,
            "create_time": "2020-03-19T02:28:01.000+0000",
            "user_id": 6,
            "update_time": "2020-03-31T02:28:12.000+0000",
            "category": "生活用品"
        }
        ]
}
```

### 2.2 按照商品名模糊查找
```
GET http://localhost:8088/goods/select?name=羽毛球

返回
{
    "code": 0,
    "msg": "SUCCESS",
    "data": [
        {
            "id": 6,
            "name": "羽毛球",
            "desc": "现在闲置了 出售",
            "image": "http://localhost:8088/picture/goodsimg/d.jpg",
            "price": 35,
            "status": 1,
            "create_time": "2020-03-31T02:32:59.000+0000",
            "user_id": 4,
            "update_time": "2020-03-31T02:44:52.000+0000",
            "category": "体育用品"
        },
        {
            "id": 17,
            "name": "羽毛球全新",
            "desc": "这个商品很好222222223333",
            "image": "http://localhost:8088/picture/goodsimg/a.jpg",
            "price": 18,
            "status": 1,
            "create_time": "2020-04-06T08:14:18.000+0000",
            "user_id": 0,
            "update_time": "2020-04-06T08:15:42.000+0000",
            "category": ""
        }
    ]
}
```

### 2.3 插入一个商品
```
POST http://localhost:8088/goods/insert
{    
        "name": "羽毛球全新",
        "desc": "这个商品很好222222223333",
        "image": "http://localhost:8088/picture/goodsimg/a.jpg",
        "price": 10,
        "status": 1
    }
    
返回
{
    "code": 0,
    "msg": "SUCCESS",
    "data": {
        "id": 18,
        "name": "羽毛球全新",
        "desc": "这个商品很好222222223333",
        "image": "http://localhost:8088/picture/goodsimg/a.jpg",
        "price": 10,
        "status": 1,
        "create_time": null,
        "user_id": null,
        "update_time": null,
        "category": null
    }
}
```



### 2.4 修改一个商品
```
POST http://localhost:8088/goods/update
{
        "id": 17,
        "name": "羽毛球全新",
        "desc": "这个商品很好222222223333",
        "image": "http://localhost:8088/picture/goodsimg/a.jpg",
        "price": 18,
       
        "create_time": null,
        "user_id": null,
        "update_time": null,
        "category": null
    }
    
返回
{
    "code": 0,
    "msg": "SUCCESS",
    "data": "修改成功"
}
```