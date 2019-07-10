package tv.danmaku.ijk.media.example.application;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.danikula.videocache.HttpProxyCacheServer;

import java.io.File;

import tv.danmaku.ijk.media.example.content.MyFileGenerator;

public class App extends Application {
    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        App app = (App) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        File path = new File(Environment.getExternalStorageDirectory().getPath() + "/ijkplayer/vod/");
        if (!path.exists()) {
            path.mkdirs();
        }
        return new HttpProxyCacheServer.Builder(this)
                .cacheDirectory(path)
                .fileNameGenerator(new MyFileGenerator())
                .build();
    }
}
