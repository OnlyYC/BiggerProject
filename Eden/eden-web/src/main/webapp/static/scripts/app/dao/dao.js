(function(win, $) {


    /**
     * 播放歌曲
     * @param song_id
     */
    var playSong=function(song_id){
        var songData={
            songId:song_id
        };
        utils.post(baseUrl+'/api/song/playSong',songData,function(data){
            return data;
        },"json")
    };

    /**
     * 通过歌曲id拿到歌曲
     */
    var getSong=function(song_id){
        var songData={
            songId:song_id
        };
        return utils.post(baseUrl+'/api/song/getSong',songData,function(data){
            return data;
        },"json")
    };
    /**
     * 通过歌单id找到歌曲
     */
    var getSongInSonglist=function(songlistId){
      var songlistData={
          songlistId:songlistId
      };
      return utils.post(baseUrl+'/api/songlist/findSongCustomInSonglist',songlistData,function(data){
        return data;
      },"json")
    };

    /**
     * 通过专辑id找到专辑中的音乐
     * @param albumId
     * @returns {*}
     */
    var getSongInAlbum=function(albumId){
        var albumData={
            albumId:albumId
        };
        return utils.post(baseUrl+'/api/album/findSongCustomInAlbum',albumData,function(data){
            return data;
        },"json")
    };


    /**
     * 添加歌曲,可以是多首歌曲。到播放列表,都跟用户相关
     * @param songids 歌曲id数组
     */
    var addSongsToUserPlaylist=function(songids){
        var songidsData={
            songids:songids
        };

        return utils.post(baseUrl+'/api/user/addSongToPlaylist',songidsData,function(data){
            return data;
        })
    };



    //用户注册
    var register=function(registerData){
      return utils.post(baseUrl+'/api/user/register',registerData,function(data){
          return data;
      });
    };

    //用户登录
    var login=function(logData){
        return utils.post(baseUrl+'/api/user/login',logData,function(data){
            return data;
        });
    };
    //用户注销
    var logout=function(){
        return utils.post(baseUrl+'/api/user/logout',{},function(data){
            return data;
        });
    };

    //添加歌曲到歌单
    var addSongToSonglist=function(songId,songlistId){
        var data={
            songId:songId,
            songlistId:songlistId
        };
        return utils.post(baseUrl+'/api/user/addSongToSonglist',data,function(data){
            return data;
        })
    };

    //添加到我喜欢
    var toggleSongFromLovelist=function(songId){
        var data={
            songId:songId
        };
        return utils.post(baseUrl+'/api/user/toggleSongFromLovelist',data,function(data){
            return data;
        })
    };

    //新建歌单
    var newSonglist=function(listName){
        var data={
            listName:listName
        };
        return utils.post(baseUrl+'/api/songlist/newSonglist',data,function(data){
            return data;
        });
    };

    //发布评论、回复评论commType 0--发表评论，1--回复评论
    var submitComment=function(type,content,targetId,commType){
        var data={
            type:type,
            content:content,
            targetId:targetId,
            commType:commType
        };

        return utils.post(baseUrl+'/api/comment/submitComment',data,function(data){
            return data;
        });
    };

    //收藏
    var collect=function(targetId,collectType){
        var data={
          targetId:targetId,
          collectType:collectType
        };
        return utils.post(baseUrl+'/api/user/collect',data,function(data){
            return data;
        });
    };
    //赞评论
    var praiseComment=function(commentId){
      var data={
          commentId:commentId
      };
      return utils.post(baseUrl+'/api/comment/praiseComment',data,function(data){
          return data;
      });
    };
    //用户最新信息
    var showMyLastMess=function(paramData){
        return utils.post(baseUrl+'/api/mess/showMyLastMess',paramData,function(data){
            return data;
        });
    };

    //用户之前未读的信息
    var showMyUreadMessPrevious=function(paramData){
        return utils.post(baseUrl+'/api/mess/showMyUreadMessPrevious',paramData,function(data){
            return data;
        });
    };

    //设置消息为已读
    var readMess=function(messIdArray){
        var data={
            messId:messIdArray
        };
        var paramData=JSON.stringify(data);
        return utils.post(baseUrl+'/api/mess/readMess',data,function(data){
            return data;
        })
    };

    //歌曲，mv下载
    var download=function(songId){
        window.open(baseUrl+'/api/song/download/'+songId);
    };


    /**
     * 文件上传
     * @param fileData
     * @returns {*}
     */
    var upload=function(fileData){
        var dtd = $.Deferred(),
            data;
        $.ajax(baseUrl+'/api/file/upload', {
            method: "POST",
            data: fileData,
            processData: false,
            contentType: false
        }).done(function (data) {
            dtd.resolve(data);
        }).fail(function (a, b, c) {
            dtd.reject(data);
        });
        return dtd.promise();
    };

    //修改个人信息
    var editUserInfo=function(user){
        return utils.post(baseUrl+'/api/user/editUserInfo',user,function(data){
            return data;
        });
    };

    //发表动态
    var sendDynamic=function( content){
        var data={
            'content':content
        };
        return utils.post(baseUrl+'/api/dynamic/sendDynamic',data,function(data){
            return data;
        });
    };

    //更新歌单信息
    var updateSonglist=function(songlist){
        return utils.post(baseUrl+'/api/songlist/updateSonglist',songlist,function(data){
            return data;
        });
    };

    //赞，动态
    var praiseDynamic=function(dynamicId){
        var data={
            'dynamicId':dynamicId
        };
        return utils.post(baseUrl+'/api/dynamic/praiseDynamic',data,function(data){
            return data;
        });
    };

    //从歌单中移除歌曲
    var removeSongFromSonglist=function(songId,songlistId){
        var data={
            'songId':songId,
            'songlistId':songlistId
        };
        return utils.post(baseUrl+'/api/songlist/removeSongFromSonglist',data,function(data){
            return data;
        });
    };

    //删除歌单
    var dealMySonglist=function(songlistId){
        var data={
            'songlistId':songlistId
        };
        return utils.post(baseUrl+'/api/songlist/dealMySonglist',data,function(data){
            return data;
        });

    };

    //发送消息
    var sendMess=function(toUser,content,type){
        var data={
            'toUser':toUser,
            'content':content,
            'type':type

        };
        return utils.post(baseUrl+'/api/mess/sendMess',data,function(data){
            return data;
        });
    };




    win.dao={
        playSong:playSong,
        getSong:getSong,
        getSongInSonglist:getSongInSonglist,
        getSongInAlbum:getSongInAlbum,
        addSongsToUserPlaylist:addSongsToUserPlaylist,
        register:register,
        login:login,
        logout:logout,
        addSongToSonglist:addSongToSonglist,
        toggleSongFromLovelist:toggleSongFromLovelist,
        newSonglist:newSonglist,
        submitComment:submitComment,
        collect:collect,
        praiseComment:praiseComment,
        showMyLastMess:showMyLastMess,
        showMyUreadMessPrevious:showMyUreadMessPrevious,
        readMess:readMess,
        download:download,
        upload:upload,
        editUserInfo:editUserInfo,
        sendDynamic:sendDynamic,
        updateSonglist:updateSonglist,
        praiseDynamic:praiseDynamic,
        removeSongFromSonglist:removeSongFromSonglist,
        dealMySonglist:dealMySonglist,
        sendMess:sendMess

    }



})(window, jQuery);