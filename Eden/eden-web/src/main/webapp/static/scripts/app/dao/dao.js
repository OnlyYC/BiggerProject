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
        return utils.post(baseUrl+'/api/songlist/findSongCustomInAlbum',albumData,function(data){
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
        readMess:readMess

    }



})(window, jQuery);