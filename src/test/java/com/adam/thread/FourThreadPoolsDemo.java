package com.adam.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class FourThreadPoolsDemo {

    public static void main(String[] args) {

        /**
         * 1.newCachedThreadPool：
         *
         * 底层：返回ThreadPoolExecutor实例，
         * corePoolSize为0；maximumPoolSize为Integer.MAX_VALUE；
         * keepAliveTime为60L；时间单位TimeUnit.SECONDS；
         * workQueue为SynchronousQueue(同步队列)
         * 通俗：当有新任务到来，则插入到SynchronousQueue中，由于SynchronousQueue是同步队列，
         * 因此会在池中寻找可用线程来执行，若有可以线程则执行，若没有可用线程则创建一个线程来执行该任务；
         * 若池中线程空闲时间超过指定时间，则该线程会被销毁。
         * 适用：执行很多短期的异步任务
         *
         * 1.创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程<br>
         * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务<br>
         * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小<br>
         */
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 1; i <= 10; i++) {
//            final int ii = i;
//            try {
//                Thread.sleep(ii * 1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            cachedThreadPool.execute(() -> out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii));
//        }

        /**
         *
         * 2.newFixedThreadPool：
         *
         * 底层：返回ThreadPoolExecutor实例，接收参数为所设定线程数量n，
         * corePoolSize和maximumPoolSize均为n；
         * keepAliveTime为0L；时间单位TimeUnit.MILLISECONDS；
         * WorkQueue为：new LinkedBlockingQueue<Runnable>() 无界阻塞队列
         * 通俗：创建可容纳固定数量线程的池子，每个线程的存活时间是无限的，当池子满了就不再添加线程了；
         * 如果池中的所有线程均在繁忙状态，对于新任务会进入阻塞队列中(无界的阻塞队列)
         * 适用：执行长期任务
         *
         *   1.创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小<br>
         *   2.线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程<br>
         *   3.因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字，和线程名称<br>
         */
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int ii = i;
//            fixedThreadPool.execute(() -> {
//                out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }


        /**
         * 3.newSingleThreadExecutor:
         *
         * 底层：FinalizableDelegatedExecutorService包装的ThreadPoolExecutor实例，
         * corePoolSize为1；maximumPoolSize为1；
         * keepAliveTime为0L；时间单位TimeUnit.MILLISECONDS；
         * workQueue为：new LinkedBlockingQueue<Runnable>() 无解阻塞队列
         * 通俗：创建只有一个线程的线程池，当该线程正繁忙时，对于新任务会进入阻塞队列中(无界的阻塞队列)
         * 适用：按顺序执行任务的场景
         *
         *创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
         */
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            final int ii = i;
//            pool.execute(() -> out.println(Thread.currentThread().getName() + "=>" + ii));
//        }


        /**
         * 4.NewScheduledThreadPool:
         *
         * 底层：创建ScheduledThreadPoolExecutor实例，该对象继承了ThreadPoolExecutor，
         * corePoolSize为传递来的参数，
         * maximumPoolSize为Integer.MAX_VALUE；
         * keepAliveTime为0；时间单位TimeUnit.NANOSECONDS；
         * workQueue为：new DelayedWorkQueue() 一个按超时时间升序排序的队列
         * 通俗：创建一个固定大小的线程池，线程池内线程存活时间无限制，线程池可以支持定时及周期性任务执行，
         * 如果所有线程均处于繁忙状态，对于新任务会进入DelayedWorkQueue队列中，这是一种按照超时时间排序的队列结构
         * 适用：执行周期性任务
         *
         * 创建一个定长线程池，支持定时及周期性任务执行。延迟执行
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Runnable r1 = () -> out.println("线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
        scheduledThreadPool.schedule(r1, 3, TimeUnit.SECONDS);
        Runnable r2 = () -> out.println("线程名称：" + Thread.currentThread().getName() + "，执行:延迟2秒后每3秒执行一次");
        scheduledThreadPool.scheduleAtFixedRate(r2, 2, 3, TimeUnit.SECONDS);
        Runnable r3 = () -> out.println("线程名称：" + Thread.currentThread().getName() + "，执行:普通任务");
        for (int i = 0; i < 5; i++) {
            scheduledThreadPool.execute(r3);
        }

    }
}
