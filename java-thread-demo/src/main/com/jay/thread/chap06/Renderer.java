package com.jay.thread.chap06;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * CompletionService实现页面渲染
 * 可以通过CompletionService从两个方面来提高页面渲染器的性能；缩短
 * 总运行时间以及提高响应性，
 * 为每一幅图像的下载都创建一个独立任务，并在线程池中执行它们，
 * 从而将串行的下载过程转换为并行的过程。
 * Created by xiang.wei on 2017/8/24
 */
public abstract class Renderer {
    private final ExecutorService executor;

    protected Renderer(ExecutorService executor) {
        this.executor = executor;
    }


    void renderPage(CharSequence source) {
        List<ImageInfo> infos = scanForImageInfo(source);
        ExecutorCompletionService<ImageData> completionService =
                new ExecutorCompletionService<>(executor);
        for (final ImageInfo imageInfo : infos) {
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }
        renderText(source);
        for (int i = 0; i <infos.size() ; i++) {
            try {
                Future<ImageData> take = completionService.take();
                ImageData imageData = take.get();
                renderImage(imageData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
    }

    interface ImageData {

    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence sequence);

    abstract List<ImageInfo> scanForImageInfo(CharSequence source);

    abstract void renderImage(ImageData i);
}
