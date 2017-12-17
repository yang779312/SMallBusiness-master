package com.liumeng.smallbusiness.db;

import android.net.Uri;

/**
 * Created by Administrator on 2017/11/22.
 */

public class CourseProviders {
    public static final String AUTHORITIES = "com.small.business";
    public static final String COURSE_PATH = "course";


    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITIES);
    public static final Uri COURSE_URI = Uri.withAppendedPath(BASE_URI, COURSE_PATH);


    public static class CourseColumn {

        public static final String ID = "id";
        public static final String NAME = "NAME";
        public static final String TEACHER_NAME = "teacher_name";
        public static final String WATCH_COUNT = "watch_count";
        public static final String VIDEO_URL = "video_url";
    }

}
