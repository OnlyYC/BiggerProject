(function(win, $) {


    //用户登录
    var adminLogin=function(logData){
        return utils.post(baseUrl+'/api/admin/adminLogin',logData,function(data){
            return data;
        });
    };
    //用户注销
    var adminLogout=function(){
        return utils.post(baseUrl+'/api/admin/adminLogout',{},function(data){
            return data;
        });
    };


    /**
     * 拿到用户统计信息
     */
    var getUserStatisticsInfo=function(){
        return utils.post(baseUrl+'/api/statist/userStatisticsInfo',{},function(data){
            return data;
        });
    };

    /**
     * 添加音乐
     * @param song
     * @returns {*}
     */
    var addSong=function(song){
        return utils.post(baseUrl+'/api/resource/addSong',song,function(data){
            return data;
        });
    };
    var addMV=function(song){
        return utils.post(baseUrl+'/api/resource/addMV',song,function(data){
            return data;
        });
    };
    var editSong=function(song){
        return utils.post(baseUrl+'/api/resource/editSong',song,function(data){
            return data;
        });
    };
    var addArtist=function(artist){
        return utils.post(baseUrl+'/api/resource/addArtist',artist,function(data){
            return data;
        });
    };
    var editArtist=function(artist){
        return utils.post(baseUrl+'/api/resource/editArtist',artist,function(data){
            return data;
        });
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






    win.dao={
        adminLogin:adminLogin,
        adminLogout:adminLogout,
        getUserStatisticsInfo:getUserStatisticsInfo,
        addSong:addSong,
        addMV:addMV,
        upload:upload,
        editSong:editSong,
        addArtist:addArtist,
        editArtist:editArtist
    }



})(window, jQuery);