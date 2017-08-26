package com.jay.thread.chap08;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 在单线程Executor中任务发生死锁
 * Created by xiang.wei on 2017/8/26
 */
public class ThreadDeadlock {
    private final ExecutorService exec = Executors.newSingleThreadScheduledExecutor();

    public class LoadFileTask implements Callable<String> {
        private final String fileName;

        public LoadFileTask(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public String call() throws Exception {
            return "";
        }
    }

    public class RenderPageTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));

            String page = renderPage();
            return header.get() + page + footer.get();
        }

        private String renderPage() {
            return "";
        }
    }

}
