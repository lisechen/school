## 1. 用户相关接口
### 1.1. 查找所有用户列表
```
GET  http://localhost:8088/user/selectall

返回
{
    "code": 0,
    "msg": "SUCCESS",
    "data": [
        {
            "id": 1,
            "wechat_id": "\"\"",
            "wechat_name": "蘭",
            "avatar_url": "http://localhost:8088/picture/atatar/b.jpg",
            "username": "陈兰兰",
            "mobile": "17014986522",
            "gender": 2,
            "state": 1,
            "create_time": "2020-03-26T07:42:14.000+0000",
            "update_time": "2020-04-06T06:39:00.000+0000"
        },
        {
            "id": 21,
            "wechat_id": "AAAA",
            "wechat_name": "wechat-name-is",
            "avatar_url": "http://localhost:8088/picture/atatar/b.jpg",
            "username": "test_user",
            "mobile": "17043781234",
            "gender": 2,
            "state": 1,
            "create_time": "2020-04-06T04:00:47.000+0000",
            "update_time": "2020-04-06T04:00:47.000+0000"
        }
        ]
}
```

### 1.2. 根据用户的微信nickname 查看当前用户是否在系统中
```
GET http://localhost:8088/user/find?wechat_name=赵璐

返回
{
    "code": 0,
    "msg": "SUCCESS",
    "data": {
        "id": 24,
        "wechat_id": "",
        "wechat_name": "赵璐",
        "avatar_url": "https://wx.qlogo.cn/mmopen/vi_32/cQZF8pcShTJZwVj4GrmictSqaRib6aEuW9lRlQE0wbZZa76nHIwZkz84RB3Hxt5q0ibpCoQU2uXctMeyEPIduOtPA/132",
        "username": "赵璐",
        "mobile": "",
        "gender": 2,
        "state": 1,
        "create_time": "2020-04-06T07:13:06.000+0000",
        "update_time": "2020-04-06T07:13:06.000+0000"
    }
}

```

### 1.3. 添加绑定微信用户到当前系统当中
这里的wechat_name不能和系统中已有重复，否则会导致无法创建
```
POST  http://localhost:8088/user/insert
{
        "wechat_id": "AAAABBccffff",
        "wechat_name": "wechat-name-is",
        "avatar_url": "http://localhost:8088/picture/atatar/b.jpg",
        "username": "test_user",
        "mobile": "17043781234",
        "gender": 2
    }
```
返回
```
{
    "code": 0,
    "msg": "SUCCESS",
    "data": {
        "id": 30,
        "wechat_id": "AAAABBccffff",
        "wechat_name": "wechat-name-is",
        "avatar_url": "http://localhost:8088/picture/atatar/b.jpg",
        "username": "wechat-name-is",
        "mobile": "17043781234",
        "gender": "2",
        "state": null,
        "create_time": null,
        "update_time": null
    }
}
```
### 1.4 修改用户
修改的时候必须带上用户的id，这样才知道修改的是哪个用户
```
POST http://localhost:8088/user/update
{
        "id":23,
        "wechat_id": "AAAABBccffff",
        "wechat_name": "wechat-name-is",
        "avatar_url": "http://localhost:8088/picture/atatar/b.jpg",
        "username": "test_user",
        "mobile": "17043781234",
        "gender": 2
}

返回
{
    "code": 0,
    "msg": "SUCCESS",
    "data": "修改成功"
}

```