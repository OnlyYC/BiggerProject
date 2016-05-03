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
        },
        //下载
        download:function(song_id){
            dao.download(song_id);
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
        },
        //从歌单中移除歌曲
        removeSongFromSonglist:function(songId,songlistId,succBack,failBack){
            dao.removeSongFromSonglist(songId,songlistId).done(function(data){
                Base.processData(data,succBack,failBack);
            });
        },
        //删除歌单
        dealMySonglist:function(songlistId,succBack,failBack){
            dao.dealMySonglist(songlistId).done(function(data){
                Base.processData(data,succBack,failBack);
            });
        }
    };
    var myfile={
        upload:function(fileData,succCall,failCall){
            dao.upload(fileData).done(function(data){
                Base.processData(data,succCall,failCall);
            });
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
        newSonglist:function(listName,succBack){
            dao.newSonglist(listName).done(function(data){
               Base.processData(data,succBack);
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
        },
        //修改个人信息
        editUserInfo:function(user,succBack,failBack){
            dao.editUserInfo(user).done(function(data){
                Base.processData(data,succBack,failBack);
            });
        },
        //发表动态
        sendDynamic:function(content,succBack,failBack){
            dao.sendDynamic(content).done(function(data){
                Base.processData(data,succBack,failBack);
            })
        },
        //更新歌单信息
        updateSonglist:function(songlist,succBack,failBack){
            dao.updateSonglist(songlist).done(function(data){
                Base.processData(data,succBack,failBack);
            });
        },
        //赞，动态
        praiseDynamic:function(dynamicId,succBack,failBack){
            dao.praiseDynamic(dynamicId).done(function(data){
                Base.processData(data,succBack,failBack);
            });
        },
        //发送消息
        sendMess:function(toUser,content,type,succBack,failBack){
            dao.sendMess(toUser,content,type).done(function(data){
                Base.processData(data,succBack,failBack);
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
        open:open,
        myfile:myfile
    }


})(window, jQuery);