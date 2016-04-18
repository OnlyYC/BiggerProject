
package com.liaoyb.base;

/**
 * 系统参数
 * 
 * @author ybliao2
 */
public class SysCode {



	/**
	 * 区域
	 * 歌曲、歌手
	 */
	public static interface AREA {
		/**
		 * 内地
		 */
		public static final Long HINTERLAND=1L;
		/**
		 * 港台
		 */
		public static final Long HONGKONG_TAIWAN=2L;
		/**
		 * 欧美
		 */
		public static final Long EUROPE_AMERICA=3L;
		/**
		 * 日本
		 */
		public static final Long JAPANESE=4L;
		/**
		 * 韩国
		 */
		public static final Long KOREA=5L;
		/**
		 * 其他
		 */
		public static final Long OUTHER=6L;
	}


	/**
	 * 收藏类型
	 */
	public static interface COLLECT_TYPE{
		public static final Long SONGLIST=1L;
		public static final Long ALBUM=2L;
		public static final Long Artist=3L;
		public static final Long MV=4L;
		public static final Long USER=5L;
	}


	/**
	 * 用户权限
	 */
	public static interface USER_ROLE{
		/**
		 * 普通用户
		 */
		public static final Long USER_ROLE_ID=1L;
		/**
		 * 管理员
		 */
		public static final Long ADMIN_ROLE_ID=2L;
	}


    /**
	 * 用户、艺术家、专辑、歌单默认封面
	 */
	public static interface DEFAUT_URL{
		/**
		 * 默认用户头像
		 */
		public static final String USER_AVATAR="/sources/image/default_user_avatar.jpg";
		/**
		 * 默认艺术家头像
		 */
		public static final String ARTIST_POSTER="/sources/image/default_artist_poster.jpg";
		/**
		 * 默认专辑封面
		 */
		public static final String ALBUM_COVER="/sources/image/default_artist_cover.jpg";
		/**
		 * 默认歌单封面
		 */
		public static final String SONGLIST_COVER="/sources/image/default_songlist_cover.jpg";
	}


	/**
	 * 歌曲类型，mv或者音乐
	 */
	public static interface SONG_TYPE{
		public static final Long SONG=1L;
		public static final Long MV=2L;
	}

	/**
	 * 歌单类型,普通歌单还是官方榜单、全球榜单
	 */
	public static interface SONGLIST_TYPE{

		public static final Long COMMON_LIST=1L;
		public static final Long OFFICIAL_LIST=2L;
		public static final Long GLOBAL_LIST=3L;
	}


	/**
	 * 评论类型
	 */
	public static interface COMMENT_TYPE{
		public static final Long SONG_COMMENT=1L;
		public static final Long SONGLIST_COMMENT=2L;
		public static final Long DYNAMIC_COMMENT=3L;
		public static final Long ALBUM_COMMENT=4L;
	}

	/**
	 * 有效标识
	 */
	public static interface FLAG{
		/**
		 * 有效
		 */
		public static final Long VALID=1L;
		/**
		 * 无效
		 */
		public static final Long INVALID=0L;

	}

	/**
	 * 播放历史
	 */
	public static interface USER_LISTEN{
		/**
		 * 存在播放列表中
		 */
		public static final Long EXIT_PLAYLIST=1L;

		/**
		 * 不存在在播放列表中
		 */
		public static final Long NOT_IN_PLAYLIST=0L;
	}


    /**
	 * 歌单
	 */
	public static interface MUSIC_LIST{
		/**
		 * 用户默认歌单，我喜欢
		 */
		public static final String DEFAULT_LOVE="我喜欢";
	}





	/**
	 * 文件的类型
	 */
	public static interface FILE_TYPE{
		/**
		 * 图片 对应的code为 3
		 */
		public static final String IMAGE = "3";
		/**
		 * 歌词 对应的code为 4
		 */
		public static final String IYRIC = "4";
	}

	/**
	 * 排序
	 */
	public static interface SORT{
		/**
		 * 升序
		 */
		public static final String ASC = "asc";
		/**
		 * 降序
		 */
		public static final String DESC = "desc";
	}





	/**
	 *
	 * Webcontent Type
	 *
	 * @author yfcheng2@iflytek.com
	 * @created 2015年1月13日 上午10:25:56
	 * @lastModified
	 * @history
	 */
	public interface ContentType {
		/*
		 * jpeg 类型的mime
		 */
		public String JPEG_MIME = "image/jpeg";
		/*
		 * 设置请求文件类型html
		 */
		public static final String HTML_MIME = "text/html; charset=UTF-8";
	}



}
