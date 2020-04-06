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

4. git push origin manster
推送到远端 

## 修改的地方
1. 修改mysql配置
2. mybatis   <insert id="insertSelective" useGeneratedKeys="true" keyProperty="id"  parameterType="com.chen.campus_trade.dao.entity.User">
