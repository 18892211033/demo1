$(function(){
    var aStr = sessionStorage.getItem("currentNews") ;
    if(aStr == '' || aStr == null) {
        window.close() ;
        return ;
    }
    // var aObj = JSON.parse(aStr) ;
    // sessionStorage.removeItem("currentNews") ;
    // console.log(aObj) ;
    // $(".showtitle").html(aObj.title) ;
    // $(".showdate").text(aObj.date) ;
    // $(".showcontent").html(aObj.content) ;

    //富文本编辑器中上传文件（图片）


    var aObj = JSON.parse(aStr);
    $("#title").val(aObj.title) ;
    $("#newstype").val(aObj.newstype) ;
    $("#editor").val(aObj.content) ;
    $("#comefrom").val(aObj.comefrom) ;

    function sendFile($summernote ,file) {
        var formData = new FormData();
        formData.append("file",file) ;

        $.ajax({
            type : 'post' ,
            url : sysNewsAddPhoto ,
            data : formData ,
            //如果提交data是FormData类型，那么下面三句一定需要加上
            cache : false ,
            processData : false,
            contentType : false ,
            success : function (data) {
                console.log(data) ;
                if(data.errCode == 0) {
                    $('#editor').summernote('insertImage', data.data);  //直接插入路径就行，filename可选
                    // imgs.push(data.data.substr(data.data.lastIndexOf('/') + 1)) ;
                } else {
                    bootbox.alert('图片插入失败！') ;
                }
            } ,
            error : function (data) {
                bootbox.alert('上传失败') ;
            }
        })
    }
    $(function(){
        //ajax请求新闻类别
        $.get(
            sysNewstype,
            function (reqData) {
                if (reqData.errCode == 0){
                    var str = '';
                    // var strthis = "<option value=0>+aObj.typename+</option>";
                    $.each(reqData.data , function (index , item) {
                        str += '<option value="'+item.id+'">';
                        str += item.typename;
                        str += '</option>';
                    });
                    $("#newstype").html(str
                        /*function(){
                            strthis += str;
                        }*/);
                }
            }
        )

        $summernote = $("#editor").summernote({
            lang : 'zh-CN' ,
            height:300,
            toolbar : [
                <!--字体工具-->
                ['fontname', ['fontname']], //字体系列
                ['style', ['bold', 'italic', 'underline', 'clear']], // 字体粗体、字体斜体、字体下划线、字体格式清除
                ['font', ['strikethrough', 'superscript', 'subscript']], //字体划线、字体上标、字体下标
                ['fontsize', ['fontsize']], //字体大小
                ['color', ['color']], //字体颜色

                <!--段落工具-->
                // ['style', ['style']],//样式
                // ['para', ['ul', 'ol', 'paragraph']], //无序列表、有序列表、段落对齐方式
                // ['height', ['height']], //行高

                <!--插入工具-->
                ['table',['table']], //插入表格
                ['hr',['hr']],//插入水平线
                ['link',['link']], //插入链接
                ['picture',['picture']], //插入图片
                // ['video',['video']], //插入视频

                <!--其它-->
                ['fullscreen',['fullscreen']], //全屏
                ['codeview',['codeview']], //查看html代码
                ['undo',['undo']], //撤销
                ['redo',['redo']], //取消撤销
                ['help',['help']], //帮助
            ],
            callbacks: {
                onImageUpload: function (files) {
                    sendFile($summernote ,files[0]);
                },
            }
        }) ;
        // 添加按钮
        $("#btn_addSure").click(function(){
            var content = {
                id : aObj.id,
                typeid : $("#newstype").val(),
                title : $("#addForm input[name=title]").val() ,
                content : $("#editor").summernote('code') ,
                pubdatetime : aObj.pubdatetime,
                comefrom : $("#addForm input[name=comefrom]").val() ,
                // imgs : imgs.join(',')
            };
            // imgs.length = 0;
            $.ajax({
                type : "PUT",
                url : sysNewsUpde ,
                data :JSON.stringify(content) ,
                contentType : 'application/json;charset=UTF-8' ,
                dataType:"json",
                success : function(data) {
                    console.log(data);
                    if(data.errCode == 0) {
                        bootbox.confirm('修改成功，是否继续？',function(data) {
                            if(data) {
                                // reset();
                            } else {
                                var pTable = parentDom.getElementById("newsTable") ;
                                $(pTable).bootstrapTable('refresh') ;
                                window.close() ;
                            }
                        })
                    } else {
                        bootbox.alert(data.errMsg + ",稍后再试！") ;
                    }

                }
            });
        }) ;
        $("#btn_addCancel").click(function(){
            // reset();
            location.href="NewsManager.html";
        })
        $('#addDatetimepicker').datetimepicker({
            format: 'yyyy年mm月dd日',
            autoclose: true,
            minView:'month',
            maxView:'month',
            todayBtn : true ,
            language:'zh-CN'
        });
    });
})
function reset() {
    $("#editor").summernote('code' , '')
    $("#addForm")[0].reset() ;
    // imgs.length = 0;
}
