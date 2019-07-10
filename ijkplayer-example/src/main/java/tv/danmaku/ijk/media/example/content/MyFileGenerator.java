package tv.danmaku.ijk.media.example.content;

import android.net.Uri;

import com.danikula.videocache.file.FileNameGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFileGenerator implements FileNameGenerator {

    // Urls contain mutable parts (parameter 'sessionToken') and stable video's id (parameter 'videoId').
    // e. g. http://example.com?videoId=abcqaz&sessionToken=xyz987
    @Override
    public String generate(String url) {
        String videoId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return videoId + ".mp4";
    }
}

