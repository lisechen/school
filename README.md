# school
校园二手

## git 操作

1. git status 
查看本地有哪些改动
2. git add -A
添加所有改动到缓存

3. git commit -m "修改信息备注"
添加commit 信息

4. git pull 
<br/>先更新远端的变化（别人的提交）
<br/>有时候merge的时候需要填入备注信息
<br/>执行 shift+冒号键 在左下角显示冒号的时候再输入 wq 然后enter就可以了

4. git push origin master
推送到远端 

## 修改的地方
1. 修改mysql配置
2. mybatis  
```
<insert id="insertSelective" useGeneratedKeys="true" keyProperty="id" 
parameterType="com.chen.campus_trade.dao.entity.User">

```

## 用户逻辑
1. 在首页获取到用户的微信的相关的信息后，先根据nickname去后端查一下是否存在该用户，
	<br/>1.1. 如果存在在查询接口也会返回用户的信息，并且携带id
	<br/>1.2. 如果不存在就调用创建接口创建一个用户，并返回给前端（包括id）
	<br/>1.3. 前端保存用户的id,后面更新的操作都是基于这个id来操作
2. 进入tab页



