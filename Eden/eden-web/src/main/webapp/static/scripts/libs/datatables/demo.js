+function ($) { "use strict";

  $(function(){

  // datatable

      $('#example').dataTable( {
          "ajax": 'js/datatables/datatable.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          "columns":[
              {
                  "orderable":      false,
                   "data":null,
                  "render": function ( data, type, full, meta ) {
                      //console.info(meta.settings);
                      return meta.settings._iDisplayStart+meta.row+1;
                  }
              },
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="active"  data-toggle="toggle">' +
                                  '<i class="fa fa-heart-o  text "></i>'+
                                  '<i class="fa fa-heart  text-active  text-danger"></i>'+
                              '</span>'+
                              '<a href="#" class="m-l">' +
                                  '<span class="icon icon-arrow-down"></span>'+
                              '</a>';
                  }
              },
              {
                  "data": "browser",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      if(full.mv){
                          return ogin+
                              '<a href="#" class="m-l">' +
                                  '<span class="fa fa-youtube-play text-danger"></span>'+
                              '</a>';
                      }
                      return ogin;
                  }
              },
              {
                  "data": "platform",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              {
                  "data": "version",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              { "data": "grade" }
          ]

      } );

      //歌单中每一行  音乐的双击事件

      var example=$('#example').DataTable();
      //每一行 点击事件
      $('#example tbody').delegate('tr','dblclick',function(){


          var curRow=example.row($(this));
          //当前行的数据
          console.info('双击事件');
          console.info(curRow.data());
      });







    //我的歌手
      $('#example2').dataTable( {
          "ajax": 'js/datatables/myArtist.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          searching:false,
          paging:false,
          info:false,
          "columns":[
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="thumb-md"  >' +
                          '<img src='+full.cover+'/>'+
                          '</span>'+
                          '<span class="m-l">' +full.name+
                          '</span>';
                  }
              },
              {
                  "data": "albumCount",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      return '专辑: '+data;
                  }
              },
              {
                  "data": "mvCount",
                  "render":function ( data, type, full, meta ){
                      return 'MV: '+data;
                  }
              }

          ]

      } );

      var example2=$('#example2').DataTable();
      //每一行 点击事件
      $('#example2 tbody').delegate('tr','click',function(){


          var curRow=example2.row($(this));
          //当前行的数据
          console.info(curRow.data());
      });








      //MyUpload 我的云盘


      $('#yunFile').dataTable( {
          "ajax": 'js/datatables/datatable.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          "columns":[
              {
                  "orderable":      false,
                  "data":null,
                  "render": function ( data, type, full, meta ) {
                      //console.info(meta.settings);
                      return meta.settings._iDisplayStart+meta.row+1;
                  }
              },
              {
                  "className":'text-center',
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="active"  data-toggle="toggle">' +
                          '<i class="fa fa-heart-o  text "></i>'+
                          '<i class="fa fa-heart  text-active  text-danger"></i>'+
                          '</span>'+
                          '<a href="#" class="m-l">' +
                          '<span class="icon icon-arrow-down"></span>'+
                          '</a>';
                  }
              },
              {
                  "data": "browser",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      if(full.mv){
                          return ogin+
                              '<a href="#" class="m-l">' +
                              '<span class="fa fa-youtube-play text-danger"></span>'+
                              '</a>';
                      }
                      return ogin;
                  }
              },
              {
                  "data": "platform",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              {
                  "data": "version",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              {
                  "data": "grade"
              },
              {
                  "className":'text-center',
                  "data":null,
                  "render":function ( data, type, full, meta ){

                      return '<a href="#" >' +
                          '<span class="icon icon-settings"></span>'+
                          '</a>';
                  }
              }

          ]

      } );
      //
      var yunFile=$('#yunFile').DataTable();








      //search-----------------------------------------------------------------
      //search_single_table
      $('#search_single_table').dataTable( {
          "ajax": 'js/datatables/datatable.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          "searching":false,
          "columns":[
              {
                  "orderable":      false,
                  "data":null,
                  "render": function ( data, type, full, meta ) {
                      //console.info(meta.settings);
                      return meta.settings._iDisplayStart+meta.row+1;
                  }
              },
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="active"  data-toggle="toggle">' +
                          '<i class="fa fa-heart-o  text "></i>'+
                          '<i class="fa fa-heart  text-active  text-danger"></i>'+
                          '</span>'+
                          '<a href="#" class="m-l">' +
                          '<span class="icon icon-arrow-down"></span>'+
                          '</a>';
                  }
              },
              {
                  "data": "browser",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      if(full.mv){
                          return ogin+
                              '<a href="#" class="m-l">' +
                              '<span class="fa fa-youtube-play text-danger"></span>'+
                              '</a>';
                      }
                      return ogin;
                  }
              },
              {
                  "data": "platform",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              {
                  "data": "version",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              { "data": "grade" }
          ]

      } );

      //歌单中每一行  音乐的双击事件

      var search_single_table=$('#search_single_table').DataTable();
      //每一行 点击事件
      $('#search_single_table tbody').delegate('tr','dblclick',function(){


          var curRow=search_single_table.row($(this));
          //当前行的数据
          console.info('双击事件');
          console.info(curRow.data());
      });



      //search_artist_table
      $('#search_artist_table').dataTable( {
          "ajax": 'js/datatables/myArtist.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          searching:false,
          paging:true,
          info:false,
          "columns":[
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="thumb-md"  >' +
                          '<img src='+full.cover+'/>'+
                          '</span>'+
                          '<span class="m-l">' +full.name+
                          '</span>';
                  }
              },
              {
                  "data": "albumCount",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      return '专辑: '+data;
                  }
              },
              {
                  "data": "mvCount",
                  "render":function ( data, type, full, meta ){
                      return 'MV: '+data;
                  }
              }

          ]

      } );

      var search_artist_table=$('#search_artist_table').DataTable();
      //每一行 点击事件
      $('#search_artist_table tbody').delegate('tr','click',function(){


          var curRow=search_artist_table.row($(this));
          //当前行的数据
          console.info(curRow.data());
      });



      //search_album_table
      $('#search_album_table').dataTable( {
          "ajax": 'js/datatables/find_albums.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          searching:false,
          paging:true,
          info:false,
          "columns":[
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="thumb-md"  >' +
                          '<img src='+full.cover+'/>'+
                          '</span>'+
                          '<span class="m-l">' +full.name+
                          '</span>';
                  }
              },
              {
                  "data": "artist",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      return data;
                  }
              }

          ]

      } );

      var search_album_table=$('#search_album_table').DataTable();
      //每一行 点击事件
      $('#search_album_table tbody').delegate('tr','click',function(){


          var curRow=search_album_table.row($(this));
          //当前行的数据
          console.info(curRow.data());
      });


      //search_songlist_table
      $('#search_songlist_table').dataTable( {
          "ajax": 'js/datatables/find_songlists.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          searching:false,
          paging:true,
          info:false,
          "columns":[
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="thumb-md"  >' +
                          '<img src='+full.cover+'/>'+
                          '</span>'+
                          '<span class="m-l">' +full.name+
                          '</span>';
                  }
              },
              {
                  "data": "count",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      return data+"首";
                  }
              },
              {
                  "data": "user",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      return "by "+data;
                  }
              }

          ]

      } );

      var search_songlist_table=$('#search_songlist_table').DataTable();
      //每一行 点击事件
      $('#search_songlist_table tbody').delegate('tr','click',function(){


          var curRow=search_songlist_table.row($(this));
          //当前行的数据
          console.info(curRow.data());
      });



      //search_user_table
      $('#search_user_table').dataTable( {
          "ajax": 'js/datatables/find_users.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          searching:false,
          paging:true,
          info:false,
          "columns":[
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="thumb avatar"  >' +
                          '<img src='+full.cover+'/>'+
                          '</span>'+
                          '<span class="m-l">' +full.name+
                          '</span>';
                  }
              },
              {
                  "className":"text-right",
                  "data": "info",
                  "defaultContent":"",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      return data;
                  }
              }

          ]

      } );

      var search_user_table=$('#search_user_table').DataTable();
      //每一行 点击事件
      $('#search_user_table tbody').delegate('tr','click',function(){


          var curRow=search_user_table.row($(this));
          //当前行的数据
          console.info(curRow.data());
      });



      //album----------------------------------------------------------------------------------------------------


      //album_songs_table

      $('#album_songs_table').dataTable( {
          "ajax": 'js/datatables/datatable.json',
          "autoWidth":false,
          "serverSide": true,
          "ordering":false,
          "searching":false,
          "paging":true,
          "columns":[
              {
                  "orderable":      false,
                  "data":null,
                  "render": function ( data, type, full, meta ) {
                      //console.info(meta.settings);
                      return meta.settings._iDisplayStart+meta.row+1;
                  }
              },
              {
                  "data": null,
                  "render":function ( data, type, full, meta ) {
                      return '<span class="active"  data-toggle="toggle">' +
                          '<i class="fa fa-heart-o  text "></i>'+
                          '<i class="fa fa-heart  text-active  text-danger"></i>'+
                          '</span>'+
                          '<a href="#" class="m-l">' +
                          '<span class="icon icon-arrow-down"></span>'+
                          '</a>';
                  }
              },
              {
                  "data": "browser",
                  "orderable":false,
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      if(full.mv){
                          return ogin+
                              '<a href="#" class="m-l">' +
                              '<span class="fa fa-youtube-play text-danger"></span>'+
                              '</a>';
                      }
                      return ogin;
                  }
              },
              {
                  "data": "platform",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              {
                  "data": "version",
                  "render":function ( data, type, full, meta ){
                      var ogin='<a href="#">'+data+'</a>';
                      return ogin;
                  }
              },
              { "data": "grade" }
          ]

      } );

      //歌单中每一行  音乐的双击事件

      var album_songs_table=$('#album_songs_table').DataTable();
      //每一行 点击事件
      $('#album_songs_table tbody').delegate('tr','dblclick',function(){


          var curRow=album_songs_table.row($(this));
          //当前行的数据
          console.info('双击事件');
          console.info(curRow.data());
      });





  });
}(window.jQuery);