package com.cxh.gmall.gmallmanageweb;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URL;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        String path = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(path);
        // 链接tracker
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();

        // 获得storage
        StorageClient storageClient = new StorageClient(trackerServer,null);

        // 上传文件
        String[] urls = storageClient.upload_file("C:\\Users\\Han\\Desktop\\mi10Pro111.jpg", "jpg", null);

        // 解析返回的图片的路径url信息
        String urlPath = "http://192.168.118.133/";
        for (String url : urls) {
            urlPath += url;
            System.out.println(url);
        }
        System.out.println(urlPath+"========================================");

    }

}
