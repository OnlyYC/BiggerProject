(function(win, $) {

    var song={
        //播放歌曲，通过点击封面上按钮
        playSingleSong:function(song_id){
            dao.getSong(song_id).done(function(data){
                Base.processData(data,function(data){
                    //添加并播放
                    addToPlayList(data.data,true);
                });

            });
        }
    };

    var songlist={
        //播放整个歌单，播放列表要更新
        playSonglist:function(songlistId){
            dao.getSongInSonglist(songlistId).done(function(data){
                Base.processData(data,function(data){
                    myPlaylist.setPlaylist(data.data);
                    myPlaylist.play(0);

                });
            })
        }
    };


    var album={
        /**
         * 播放专辑中的歌曲,播放列表要更新
         * @param albumId
         */
        playAlbum:function(albumId){
            dao.getSongInAlbum(albumId).done(function(data){
                Base.processData(data,function(data){
                    myPlaylist.setPlaylist(data.data);
                    myPlaylist.play(0);
                    //拿到所有歌曲id


                    //添加到播放列表
                    dao.addSongsToUserPlaylist()
                });
            });
        }
    };

    var user={
        register:function(registerData,register_success,register_fail){
            dao.register(registerData).done(function(data){
                Base.processData(data,function(data){
                    Alert.success("注册成功，请先激活邮箱再登陆")
                    register_success();
                },null,function(data){
                    Alert.error(data.message);
                    register_fail();
                });
            });
        },
        login:function(logData,login_success,login_fail){
            dao.login(logData).done(function(data){
                Base.processData(data,function(data){
                    Alert.success("登录成功");
                    login_success();
                },null,function(data){
                    login_fail();
                })
            })
        },
        logout:function(){
            dao.logout().done(function(data){
                Alert.success("注销成功");
                setTimeout(function(){
                    //刷新页面
                    window.location.reload();
                },1000);
            })
        },
        addSongToSonglist:function(songId,songlistId){
            dao.addSongToSonglist(songId,songlistId).done(function(data){
                Base.processData(data);
            });
        },
        toggleSongFromLovelist:function(songId){
            dao.toggleSongFromLovelist(songId).done(function(data){
                Base.processData(data);
            });
        },
        newSonglist:function(listName){
            dao.newSonglist(listName).done(function(data){
               Base.processData(data);
            });
        },

        //发布评论,commType 0--发表评论，1--回复评论
        submitComment:function(type,content,targetId,commType,sucessCallBack){
            //校验
            if($.trim(content)==''){
                Alert.warning("评论不能为空");
                return;
            }
            //替换标签
            content=escapeHTML(content);
            dao.submitComment(type,content,targetId,commType).done(function(data){
                Base.processData(data,function(data){
                    Alert.success(data.message);
                    if(sucessCallBack){
                        sucessCallBack();
                    }
                },null,function(data){
                    Alert.warning(data.message);
                });
            });
        },

        //收藏
        collect:function(targetId,collectType){
            dao.collect(targetId,collectType).done(function(data){
                Base.processData(data);
            })
        },
        //用户最新信息
        showMyLastMess:function(callBack,lastTime,pageSize,pageNumber){
            var data={
                pageSize:pageSize,
                pageNumber:pageNumber,
                lastTime:lastTime
            };
            dao.showMyLastMess(data).done(function(data){
                callBack(data);
            });
        },
        //用户之前的未读信息
        showMyUreadMessPrevious:function(callBack,previousTime,pageSize,pageNumber){
            var data={
                pageSize:pageSize,
                pageNumber:pageNumber,
                previousTime:previousTime
            };
            dao.showMyUreadMessPrevious(data).done(function(data){
                callBack(data);
            });
        },
        //设置消息为已读
        readMess:function(callBack,messIdArray){
            dao.readMess(messIdArray).done(function(data){
                callBack(data);
            });
        }



    };
    var open={
        praiseComment:function(commentId,successCallback){
            dao.praiseComment(commentId).done(function(data){
               Base.processData(data,function(data){
                   Alert.success(data.message);
                   if(successCallback){
                       successCallback();
                   }
               });
            });
        }
    };

    win.server={
        song:song,
        songlist:songlist,
        album:album,
        user:user,
        open:open
    }


})(window, jQuery);