$(document).ready(function(){
        $("#formRegister").bootstrapValidator({
            message : "注册信息填写不符合规则" ,
            feedbackIcons: {			// 图标设置
                valid: 'glyphicon glyphicon-ok',		// 合格
                invalid: 'glyphicon glyphicon-remove',	// 不合格
                validating: 'glyphicon glyphicon-refresh'	// 校验中，，，
            },
            fields : {
                registerName : {
                    message: '用户名填写错误!' ,
                    validators : {
                        notEmpty : {
                            message : '用户名不能为空!'
                        } ,
                        stringLength : {
                            min : 3 ,
                            message : '用户名至少三个字符'
                        } ,
                        remote : {
                            url : sysNameCheckUrl + "/" + $('#formRegister input[name = "registerName"]').val() + "/",
                            message : '用户名已存在',
                            delay : 2000,
                            type : 'GET'
                        }
                    }
                } ,

                registerPass : {
                    message: '密码填写错误!' ,
                    validators : {
                        notEmpty : {
                            message : '密码不能为空!'
                        } ,
                        stringLength : {
                            min : 6,
                            max : 12,
                            message : '密码长度应该在6-12之间' ,
                        } ,
                        regexp: {
                            regexp: /^[\d\w]{3,15}$/,
                            message: '密码应该是3-15位之间数字和字母相结合'
                        },
                        identical : {
                            field: 'registerPass2',
                            message : '两次密码不一致'
                        }
                    }
                },
                registerPass2 : {
                    message: '确认密码填写错误!',
                    validators: {
                        notEmpty: {
                            message: '确认密码不能为空!'
                        },
                        stringLength: {
                            min: 6,
                            max: 12,
                            message: '确认密码长度应该在6-12之间',
                        },
                        regexp: {
                            regexp: /^[\d\w]{3,15}$/,
                            message: '确认密码应该是3-15位之间数字和字母相结合'
                        },
                        identical: {
                            field: 'registerPass',
                            message: '两次密码不一致'
                        }
                    }
                }
            }

        }).on('success.form.bv', function(e) {//点击提交之后
            // 阻止表单提交
            e.preventDefault();
            // 获取表单引用
            var $form = $(e.target);

            // 得到bootstrapvalidator实例
            var bv = $form.data('bootstrapValidator');

            // 使用Ajax提交表单并进行校验？？？？？？？？？？？？？？？？
            var name = $('#formRegister input[name = "registerName"]').val();
            var password = $('#formRegister input[name = "registerPass"]').val();
            var serverUrl = sysRegisterUrl;
            console.log(serverUrl);
            $.post(
                // testRegisterUrl,
                sysRegisterUrl,
                {name : name , password : password},
                function (reqData) {
                    alert(reqData.msg);
                    if(reqData.errCode == 0){
                        location.href = "login.html";
                    }
                }
            );

        });
        // End 表单校验

    // 表单的重置按钮绑定动作
    $("#btnRegisterReset").click(function() {
        $("#formRegister").data("bootstrapValidator").resetForm();
        $("#formRegister")[0].reset();
    }) ;
});


