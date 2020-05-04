/**
 * 用户管理
 */
var pageCurr;
var form;
$(function () {
    layui.use('table', function () {
        var table = layui.table;
        form = layui.form;

        tableIns = table.render({
            elem: '#uesrList',
            url: '/categoryManager/getCategoryList',
            method: 'post', //默认：get请求
            cellMinWidth: 80,
            page: true,
            request: {
                pageName: 'pageNum', //页码的参数名称，默认：pageNum
                limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
            },
            response: {
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'totals', //数据总数的字段名称，默认：count
                dataName: 'list' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type: 'numbers', style: {height: 120}}
                , {field: 'name', title: '分类名称', align: 'center'}
                , {
                    field: 'image',
                    title: '图片',
                    width: 150,
                    height: 120,
                    templet: '<div><img src="{{ d.image }}" style="width:30px; height:30px;"></div>'
                }
                , {field: 'state', title: '是否有效', align: 'center'}
                , {title: '操作', align: 'center', toolbar: '#optBar'}
            ]],
            done: function (res, curr, count) {
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(curr);
                $("[data-field='state']").children().each(function () {
                    if ($(this).text() == '1') {
                        $(this).text("有效")
                    } else if ($(this).text() == '0') {
                        $(this).text("失效")
                    }

                });

                //得到数据总量
                //console.log(count);
                pageCurr = curr;
            }
        });

        //监听工具条
        table.on('tool(userTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                //删除
                delUser(data, data.id, data.name);
            } else if (obj.event === 'edit') {
                //编辑
                openUser(data, "编辑");
            } else if (obj.event === 'recover') {
                //恢复
                recoverUser(data, data.id);
            }
        });

        //监听提交
        form.on('submit(userSubmit)', function (data) {
            // TODO 校验
            formSubmit(data);
            return false;
        });
    });

    //搜索框
    layui.use(['form', 'laydate'], function () {
        var form = layui.form, layer = layui.layer
            , laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function (data) {
            //重新加载table
            load(data);
            return false;
        });
    });
});

//提交表单
function formSubmit(obj) {

    console.log('form=='+JSON.stringify(obj.field))
    $.ajax({
        type: "POST",
        data: obj.field,
        url: "/categoryManager/updateCategory",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg, function () {
                    layer.closeAll();
                    load(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试", function () {
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}

//开通用户
function addUser() {
    openUser(null, "添加分类");
}

function openUser(data, title) {

    if (data == null || data == "") {
        $("#id").val("");
    } else {
        $("#id").val(data.id);
        $("#name").val(data.name);
        $("#mobile").val(data.mobile);
        $("#gender").val(data.gender);
        form.render('select');

    }
    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);
    // $.ajax({
    //     url:'/role/getRoles',
    //     dataType:'json',
    //     async: true,
    //     success:function(data){
    //         $.each(data,function(index,item){
    //             if(!roleId){
    //                 var option = new Option(item.roleName,item.id);
    //             }else {
    //                 var option = new Option(item.roleName,item.id);
    //                 // // 如果是之前的parentId则设置选中
    //                 if(item.id == roleId) {
    //                     option.setAttribute("selected",'true');
    //                 }
    //             }
    //             $('#roleId').append(option);//往下拉菜单里添加元素
    //             form.render('select'); //这个很重要
    //         })
    //     }
    // });

    layer.open({
        type: 1,
        title: title,
        fixed: false,
        resize: false,
        shadeClose: true,
        area: ['550px'],
        content: $('#setUser'),
        end: function () {
            cleanUser();
        }
    });
}

function delUser(obj, id, name) {
    if (null != id) {

        layer.confirm('您确定要删除' + name + '分类吗？', {
            btn: ['确认', '返回'] //按钮
        }, function () {
            $.post("/categoryManager/updateUserStatus", {"id": id, "status": 0}, function (data) {
                if (data.code == 1) {
                    layer.alert(data.msg, function () {
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                }
            });
        }, function () {
            layer.closeAll();
        });

    }
}

//恢复
function recoverUser(obj, id) {
    if (null != id) {
        layer.confirm('您确定要恢复吗？', {
            btn: ['确认', '返回'] //按钮
        }, function () {
            $.post("/categoryManager/updateUserStatus", {"id": id, "status": 1}, function (data) {
                if (data.code == 1) {
                    layer.alert(data.msg, function () {
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                }
            });
        }, function () {
            layer.closeAll();
        });
    }
}

function load(obj) {
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function cleanUser() {
    $("#username").val("");
    $("#mobile").val("");
    $("#password").val("");
    $('#roleId').html("");
}

layui.use('upload', function () {
    var $ = layui.jquery
    var upload = layui.upload;

    var uploadInst = upload.render({
        elem: "#test1",
        url: "http://localhost:8088/goods/uploadWeb",
        before: function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            obj.preview(function(index, file, result){
                $('#image').attr('src', result); //图片链接（base64）
            });
        },
        done: function (res) {

            layui.$("#image").attr('src', 'http://localhost:8088/picture/category/' + res.data.src);
            layui.$("#image").attr('value', 'http://localhost:8088/picture/category/' + res.data.src);

            form.render('#image');
            alert('上传成功');
        },
        error: function () {

        }
    })
})