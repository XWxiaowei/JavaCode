package com.jay.thread.chap06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 模拟在线旅游订票
 * 从一个公司获得报价的过程与从其他公司获得报价的过程无关，
 * 因此可以将获取报价的过程当成一个任务，从而使获得报价的过程能
 * 并发执行。创建n个任务，将其提交到一个线程池，保留n个Future,
 * 并使用限时的get方法通过Future串行地获取每一个结果。
 * <p>
 * 将多个任务提交 到一个ExecutorService并获得结果。InvokeAll
 * 方法的参数为一组任务，并返回一组Future.这两个集合有着相同的结构。
 * <p>
 * Created by xiang.wei on 2017/8/24
 */
public class TimeBudget {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public List<TravelQuote> getRankedTravelQuotes(TravelInfo travelInfo,
                                                   Set<TravelCompany> companies,
                                                   Comparator<TravelQuote> ranking,
                                                   long time,
                                                   TimeUnit unit) throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<>();
        for (TravelCompany company : companies) {
            //有多少个公司就添加多少个任务
            tasks.add(new QuoteTask(company, travelInfo));
        }
//        将多个任务提交到一个ExecutorService并获得结果
        List<Future<TravelQuote>> futures = exec.invokeAll(tasks, time, unit);

        List<TravelQuote> quotes = new ArrayList<>(tasks.size());
        Iterator<QuoteTask> taskIter = tasks.iterator();
        for (Future<TravelQuote> future : futures) {
            QuoteTask task = taskIter.next();
            try {
                quotes.add(future.get());
            } catch (ExecutionException e) {
                quotes.add(task.getFailureQuote(e.getCause()));
            }
        }
        Collections.sort(quotes,ranking);
        return quotes;
    }

    class QuoteTask implements Callable<TravelQuote> {
        private final TravelCompany company;
        private final TravelInfo travelInfo;

        public QuoteTask(TravelCompany company, TravelInfo travelInfo) {
            this.company = company;
            this.travelInfo = travelInfo;
        }

        TravelQuote getFailureQuote(Throwable throwable) {
            return null;
        }

        TravelQuote getTimeoutQuote(CancellationException e) {
            return null;
        }

        @Override
        public TravelQuote call() throws Exception {
            return company.solicitQuote(travelInfo);
        }
    }

    interface TravelCompany {
        TravelQuote solicitQuote(TravelInfo travelInfo);
    }

    interface TravelQuote {
    }

    interface TravelInfo {

    }

}
