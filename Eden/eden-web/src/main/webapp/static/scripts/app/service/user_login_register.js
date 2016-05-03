/**
 * Created by admin on 2016/4/2.
 */
$(function(){

    $("#login").click(function(){
        openLoginModal();
    });
    $("#register").click(function(){

        openRegisterModal();
    });
    $("#btn_logout").click(function(){
       server.user.logout();
    });

    //注册
    $("#register_submit_btn").click(function(){

        var that=$(this);
        if(typeof(that.attr("disabled"))!="undefined"){
            return;
        }



        $('.error').removeClass('alert alert-danger').html('');

        //获取数据
        var reg_data=$("#register_form").serializeJson();
        console.info(reg_data);
        var emailReg = /\w+[@]{1}\w+[.]\w+/;
        var passReg=/^[0-9a-zA-Z_]{3,15}$/;

        if($.trim(reg_data.email)==''){
            shakeModal('邮箱不能为空');
            return;
        }
        //校验
        if(!emailReg.test(reg_data.email)){
            //
            shakeModal("邮箱格式有误");
            return;
        }
        if($.trim(reg_data.password)==''){
            shakeModal('密码不能为空');
            return;
        }
        if(reg_data.password!=reg_data.password_confirmation){
            shakeModal("两次密码不一致");
            return;
        }
        if(!passReg.test(reg_data.password)){
            shakeModal('密码要求为字母（大小写不限）、数字、下划线组成的6-15位字符');
            return;
        }

        if($.trim(reg_data.code)==''){
            shakeModal('验证码不能为空');
            return;
        }



        $.ajax({
            url: baseUrl+'/api/user/register',
            data: reg_data,
            type: 'post',
            beforeSend: function () {//3.让提交按钮失效，以实现防止按钮重复点击
                that.attr('disabled', 'disabled');

                //4.给用户提供友好状态提示
                that.text('注册中...');
            },
            complete: function () {

            },
            success: function (data) {

                Base.processData(data,function(data){
                    Alert.success("注册成功，请先激活邮箱再登陆");
                    //关闭模态框
                    closeModal();
                    setTimeout(function(){
                        window.location.reload();//刷新当前页面.
                    },2000);

                },function(data){
                    Alert.warning(data.message);
                    //让注册按钮重新有效
                    that.text('注册');
                    that.removeAttr('disabled');
                },function(){
                    //重新刷新验证码
                    refreshCode();
                    //验证码置为空
                    $("#register input[name='code']").text('');
                })

            }
        });



    });

    //登录
    $("#login_btn").click(function(){

        var that=$(this);
        if(typeof(that.attr("disabled"))!="undefined"){
            return;
        }

        $('.error').removeClass('alert alert-danger').html('');
        //获取数据
        var login_data=$("#login_form").serializeJson();
        var emailReg = /\w+[@]{1}\w+[.]\w+/;
        if($.trim(login_data.email)==''||$.trim(login_data.password)==''){
            shakeModal("用户或密码不能为空");
            return;
        }
        if(!emailReg.test(login_data.email)){
            //
            shakeModal("邮箱格式有误");
            return;
        }



        $.ajax({
            url: baseUrl+'/api/user/login',
            data: login_data,
            type: 'post',
            beforeSend: function () {//3.让提交按钮失效，以实现防止按钮重复点击
                that.attr('disabled', 'disabled');

                //4.给用户提供友好状态提示
                that.text('登录中...');
            },
            complete: function () {

            },
            success: function (data) {

                Base.processData(data,function(data){
                    Alert.success("登录成功");
                    window.location.reload();//刷新当前页面.
                },function(){
                    //5.让登陆按钮重新有效
                    that.text('登录');
                    that.removeAttr('disabled');
                },function(){
                    shakeModal("登录失败，请重新登陆");
                    //$('#login_form')[0].reset();
                    //密码置为空
                    $("#login_form input[name='password']").text('');
                })

            }
        });
    });

});

function refreshCode(){
//重新刷新验证码
    $("#code_img").attr('src',baseUrl+'/CodeController/code?t'+new Date().getTime());
}

function showRegisterForm(){

    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('Register with');
    });
    $('.error').removeClass('alert alert-danger').html('');

}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');
        });

        $('.modal-title').html('Login with');
    });
    $('.error').removeClass('alert alert-danger').html('');
}

//关闭模态框

function closeModal(){
    $('#loginModal').modal('hide');
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');
    }, 230);

}
function openRegisterModal(){
    //移除disable
    $("#register_submit_btn").removeAttr('disabled');
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');
    }, 230);

}


//登录
function loginAjax(){
    $('.error').removeClass('alert alert-danger').html('');
    //获取数据
    var login_data=$("#login_form").serializeJson();
    var emailReg = /\w+[@]{1}\w+[.]\w+/;
    if($.trim(login_data.email)==''||$.trim(login_data.password)==''){
        shakeModal("用户或密码不能为空");
        return;
    }
    if(!emailReg.test(login_data.email)){
        //
        shakeModal("邮箱格式有误");
        return;
    }
    console.info(login_data);

    server.user.login(login_data,function(){
        Alert.success("登录成功");
        //刷新页面
        window.location.reload();//刷新当前页面.
    },function(){
        shakeModal("登录失败，请重新登陆");
        //$('#login_form')[0].reset();
        //密码置为空
        $("#login_form input[name='password']").text('');
    })

}

//注册
function registerAjax(){
    $('.error').removeClass('alert alert-danger').html('');

    //获取数据
    var reg_data=$("#register_form").serializeJson();
    console.info(reg_data);
    var emailReg = /\w+[@]{1}\w+[.]\w+/;
    var passReg=/^[0-9a-zA-Z_]{3,15}$/;

    if($.trim(reg_data.email)==''){
        shakeModal('邮箱不能为空');
        return;
    }
    //校验
    if(!emailReg.test(reg_data.email)){
        //
        shakeModal("邮箱格式有误");
        return;
    }
    if($.trim(reg_data.password)==''){
        shakeModal('密码不能为空');
        return;
    }
    if(reg_data.password!=reg_data.password_confirmation){
        shakeModal("两次密码不一致");
        return;
    }
    if(!passReg.test(reg_data.password)){
        shakeModal('密码要求为字母（大小写不限）、数字、下划线组成的6-15位字符');
        return;
    }

    if($.trim(reg_data.code)==''){
        shakeModal('验证码不能为空');
        return;
    }

    server.user.register(reg_data,function(){
        console.info("注册成功，请先激活");
        //关闭模态框
        closeModal();

    },function(){
    //重新刷新验证码
        refreshCode();
        //验证码置为空
        $("#register input[name='code']").text('');
    });


}

function shakeModal(errorMessage){
    $('#loginModal .modal-dialog').addClass('shake');
    $('.error').addClass('alert alert-danger').html(errorMessage);
    $('input[type="password"]').val('');
    setTimeout( function(){
        $('#loginModal .modal-dialog').removeClass('shake');
    }, 1000 );
}