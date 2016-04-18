
var myPlaylist;
//歌曲详细中点击播放
//播放音乐
function play_inplayinfo(){
  var songinfo=eval(songinfo_json);
  //播放列表,并播放
  //  myPlaylist.add(songinfo,[true]);


  //播放单首音乐
  $("#jplayer_N").jPlayer("setMedia",songinfo);
  $("#jplayer_N").jPlayer("play");

}


$(document).ready(function() {
  var pllist = [];
  if (typeof(mystrplaylist) == "undefined") {

    //pllist = [{
    //    song_id: 1,
    //    title: "Otherworld",
    //    artist: "ADG3 Studios",
    //    mp3: "/sources/music/Otherworld-WVLF.mp3",
    //    poster: "/sources/image/a0.png"
    //},
    //    {
    //        song_id: 2,
    //        title: "Sunburst",
    //        artist: "Studios",
    //        mp3: "/sources/music/Tobu-Itro-Sunburst.mp3",
    //        poster: "/sources/image/a1.png"
    //    }];


  } else {
    pllist = eval(mystrplaylist);
  }
  myPlaylist = new jPlayerPlaylist({
    jPlayer: "#jplayer_N",
    cssSelectorAncestor: "#jp_container_N"
  }, pllist, {
    playlistOptions: {
      enableRemoveControls: true,
      autoPlay: false,
      shuffleOnLoop: true
    },
    swfPath: "js/jPlayer",
    supplied: "webmv, ogv, m4v, oga, mp3",
    smoothPlayBar: true,
    keyEnabled: true,
    audioFullScreen: false,
    loop:true
  });






  $(document).delegate($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer, function () {
    $('.musicbar').removeClass('animate');
    $('.jp-play-me').removeClass('active');
    $('.jp-play-me').parent('li').removeClass('active');
  });

  $(document).delegate($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer, function () {
    $('.musicbar').addClass('animate');
  });



//测试，可以这样获取当前播放时间
  $("#jplayer_N").bind($.jPlayer.event.timeupdate, function (event) {
    //console.info("总时长:"+event.jPlayer.status.duration+"秒");
    //console.log("Play began at time = " + event.jPlayer.status.currentTime);
  });

//播放事件，可以在这里向服务器，发起请求，更新歌曲的播放量


  //每次播放都会触发，当点击暂停然后播放时也会触发
  $("#jplayer_N").bind($.jPlayer.event.play, function (event) {
    //可以拿到播放音乐的url
    //console.log("我被播放了:" + event.jPlayer.status.src);

    console.info(event.jPlayer.status);
    var play_song_id=event.jPlayer.status.media.song_id;
    $.each(myPlaylist.playlist, function (i, n) {
      if (n.song_id == play_song_id) {
        console.info("播放歌曲id:" + play_song_id);



        //discover
        //如果当前播放的歌曲不是被激活的discover,取消激活
        if($('.jp-play-discover').length>0){
          var actDiscover=$('.jp-play-discover.active');
          if(actDiscover.data("song_id")!= n.song_id){
            //取消激活
            actDiscover.removeClass("active");
            actDiscover.parent('div').parent('div').removeClass('active');
          }
        }


        //如果小于1秒表示刚播放，更新播放量，表示我播放了
        if(event.jPlayer.status.currentTime<1){
          //歌曲播放
          dao.playSong(play_song_id);
        }




      }
    });


  });

  //当多媒体被暂停的时候
  $("#jplayer_N").bind($.jPlayer.event.pause, function (event) {

    console.info("我被暂停了");
  });

  //当多媒体结束的时候
  $("#jplayer_N").bind($.jPlayer.event.ended, function (event) {
    console.info("我播放完了");
  });



  //这是我自定义的事件，index是要移除的播放列表myPlaylist中的下标，可以获取到要移除歌曲的url，然后向服务器发请求，移除播放列表中的歌曲
  $("#jplayer_N").bind("myevent", function (event, index) {
    //playlist是歌曲的Json对象
    var playlistitem = myPlaylist.playlist[index];
    console.log("被移除播放列表的歌曲的songid为:" + playlistitem.song_id);

  });




//discover，只有首页有
  $(document).delegate('.jp-play-discover', 'click', function (e) {
    console.info("我被点击了");
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    var state = $this.hasClass("active");

    //

    $('.jp-play-discover').removeClass('active');
    $('.jp-play-discover').parent('div').parent('div').removeClass('active');

    var song_id = $this.data("song_id");

    //discover的歌曲数据
    var discovers = $("#mydiscover").jtemplatePag("getData");
    if(state) {
      $(this).addClass('active');
      $(this).parent('div').parent('div').addClass("active");
      $.each(discovers, function (n, value) {
        if (value.song_id == song_id) {
          console.log("下标：" + n);
          var discover_item = discovers[n];

          //添加到播放列表
          addToPlayList(discover_item);


        }
      });
    }else {

      //false，暂停音乐
      $("#jplayer_N").jPlayer("pause");
    }
  });


  //New Songs
  //$(document).delegate('.jp-play-newsongs', 'click', function (e) {
  //    e && e.preventDefault();
  //    var $this = $(e.target);
  //    if (!$this.is('a')) $this = $this.closest('a');
  //
  //
  //    //取消所有discover中所有激活状态
  //    $('.jp-play-discover').removeClass('active');
  //    $('.jp-play-discover').parent('div').parent('div').removeClass('active');
  //
  //
  //    var song_id = $this.data("song_id");
  //
  //
  //    var newsongs = eval(newsonglist);
  //
  //
  //        $.each(newsongs, function (n, value) {
  //            if (value.song_id == song_id) {
  //                console.log("下标：" + n);
  //                var newsong_item = newsongs[n];
  //
  //                addToPlayList(newsong_item);
  //            }
  //        });
  //
  //
  //
  //});


//music sort
  $(document).delegate('.jp-music-sort', 'click', function (e) {
    console.info("我被点击了");
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    var state = $this.hasClass("active");

    //

    $('.jp-music-sort').removeClass('active');
    $('.jp-music-sort').parent('div').parent('div').removeClass('active');

    var song_id = $this.data("song_id");


    var music_sorts = eval(music_sortlist);
    if(state) {
      $(this).addClass('active');
      $(this).parent('div').parent('div').addClass("active");
      $.each(music_sorts, function (n, value) {
        if (value.song_id == song_id) {
          console.log("下标：" + n);
          var music_sort_item = music_sorts[n];

          //添加到播放列表
          addToPlayList(music_sort_item);


        }
      });
    }else {

      //false，暂停音乐
      $("#jplayer_N").jPlayer("pause");
    }
  });


  //allsong和album
  $(document).delegate('.song_item', 'click', function (e) {
    console.info("播放。我被点击了");
    //e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    //var state = $this.hasClass("active");

    var song_id = $this.data("song_id");

    console.info("data_song"+data_song);
    var data_songx = eval(data_song);
    console.info(data_songx);
    //if(state) {
    //    $(this).addClass('active');
    //    $(this).parent('div').parent('div').addClass("active");
    $.each(data_songx, function (n, value) {
      if (value.song_id == song_id) {
        console.info("下标：" + n);
        var music_sort_item = data_songx[n];

        //添加到播放列表
        addToPlayList(music_sort_item);


      }
    });
    //}else {
    //
    //    //false，暂停音乐
    //    $("#jplayer_N").jPlayer("pause");
    //}

  });


  //Top songs
  $(document).on('.jp-play-topsongs', 'click', function (e) {
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');


    var song_id = $this.data("song_id");
    //取消所有discover中所有激活状态
    $('.jp-play-discover').removeClass('active');
    $('.jp-play-discover').parent('div').parent('div').removeClass('active');

    //与toplist中匹配
    var topsongs = eval(topsonglist);
    $.each(topsongs, function (n, value) {
      console.log("当前：" + n);
      if (value.song_id == song_id) {
        console.log("下标：" + n);
        var topsong_item = value;
        addToPlayList(value);
        return;
      }
    });


  });






  $("#refresh").click(function () {

    //发送ajax请求
    console.log("我要刷新");
    $.ajax({
      url: baseurl + "/music/discover",
      type: 'post',
      //data:'data_id='+del_data_id,
      async: true, //默认为true 异步
      error: function () {
        alert('error');

      },
      success: function (data) {
        //返回json数据
        var data = eval(data);
        //  alert(JSON.stringify(data));

        $("#mydiscover").setTemplateURL(CONTEXTPATH + "/static/template/template_sort.html?date=" + (+new Date()), null, {filter_data: true});
        $("#mydiscover").processTemplate(data);





      }
    });


  });


  // video

  //视频海报点击
  $("#jplayer_1").bind($.jPlayer.event.click, function (event) {
    console.info("视频海报被点击了");
  });




});

//设置视频video
function setVideo(video,isAutoPlay){

  isAutoPlay=isAutoPlay||false;
  $("#jplayer_1").jPlayer({
    ready: function () {
      $(this).jPlayer("setMedia", {
        title: video.title,
        m4v: video.mp3,
        ogv: video.mp3,
        webmv: video.mp3,
        wmv:video.mp3,
        flv:video.mp3,

        poster: video.poster
      });
    },
    swfPath: "js",
    supplied: "webma, webmv, oga, ogv, wav, fla, flv, rtmpa, rtmpv",
    size: {
      width: "100%",
      height: "auto",
      cssClass: "jp-video-360p"
    },
    globalVolume: true,
    smoothPlayBar: true,
    keyEnabled: true
  });
}

//暂停音乐
function pause_songPlay(){
  $("#jplayer_N").jPlayer("pause");
}





//刷新音乐分类结果
/**
 *
 * @param data PageMusicSort jsonarray数据
 */
function refreshMusicSortResult(data){
  $("#mysort").setTemplateURL(CONTEXTPATH + "/static/template/template_sort.html?date=" + (+new Date()), null, {filter_data: true});
  $("#mysort").processTemplate(data);


}



//添加到播放列表
function addToPlayList(song,isPlayagain) {
  isPlayagain=isPlayagain||false;
  var song_id = song.song_id;
  //重复标志
  var state = false;
  $.each(myPlaylist.playlist, function (n, value) {
    if (value.song_id == song_id) {
      console.log("找到相同的了：" + n);
      //歌曲真正播放，是否重新播放,默认是
      if((myPlaylist.current==n)&&!isPlayagain){
        console.info("不重新播放");
      }else{
        myPlaylist.play(n);
      }

      state = true;
    }
  });
  //先要判断是否重复,
  //重复，不添加，返回
  // 不重复，添加，还要更新远程的播放列表
  console.info(myPlaylist);

  if (!state) {
    myPlaylist.add(song, true);

    //发送ajax请求

  }

}


/**
 * 只是把歌曲添加到末尾
 * @param song
 */
function justaddToPlayList(song){
  var song_id = song.song_id;
  //重复标志
  var state = false;
  $.each(myPlaylist.playlist, function (n, value) {
    if (value.song_id == song_id) {
      console.log("找到相同的了：" + n);
      state = true;
    }
  });
  //先要判断是否重复,
  //重复，不添加，返回
  // 不重复，添加，还要更新远程的播放列表


  if (!state) {
    myPlaylist.add(song);
    //

  }
}


//播放单首歌曲
function playSong(song) {
  $("#jplayer_N").jPlayer("setMedia", song);
  $("#jplayer_N").jPlayer("play");
}


//设置默认播放列表
function setPlaylist(playlist) {
  myPlaylist.setPlaylis
}