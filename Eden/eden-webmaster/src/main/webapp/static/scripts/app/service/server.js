(function(win, $) {


    var admin={
        login:function(logData,login_success,login_fail){
            dao.adminLogin(logData).done(function(data){
                Base.processData(data,function(data){
                    Alert.success("登录成功");
                    login_success();
                },null,function(data){
                    login_fail();
                })
            })
        },
        logout:function(){
            dao.adminLogout().done(function(data){
                Alert.success("注销成功");
                setTimeout(function(){
                    //刷新页面
                    window.location.reload();
                },1000);
            })
        }


    };
    var statistics={
        userStatistics:function(callBack){
            dao.getUserStatisticsInfo().done(function(data){
                Base.processData(data,function(data){
                    callBack(data)
                });
            })
        }
    };
    var myfile={
        upload:function(fileData,succCall,failCall){
            dao.upload(fileData).done(function(data){
                Base.processData(data,succCall,failCall);
            });
        }
    };

    //资源操作
    var resource={
        addSong:function(song,callBack,failBack){
            dao.addSong(song).done(function(data){
                Base.processData(data,callBack,failBack);
            })
        },
        addMV:function(song,callBack,failBack){
            dao.addMV(song).done(function(data){
                Base.processData(data,callBack,failBack);
            })
        },
        editSong:function(song,callBack,failBack){
            dao.editSong(song).done(function(data){
                Base.processData(data,callBack,failBack);
            })
        },
        addArtist:function(artist,succBack,failBack){
            dao.addArtist(artist).done(function(data){
                Base.processData(data,succBack,failBack);
            })
        },
        editArtist:function(artist,succBack,failBack){
            dao.editArtist(artist).done(function(data){
                Base.processData(data,succBack,failBack);
            })
        }
    };

    win.server={
        admin:admin,
        statistics:statistics,
        resource:resource,
        myfile:myfile
    }


})(window, jQuery);