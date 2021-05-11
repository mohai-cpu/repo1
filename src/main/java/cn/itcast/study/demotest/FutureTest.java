package cn.itcast.study.demotest;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;


/**
 * 一、使用场景
 * 1.计算密集型（ 数学和科学计算 ）
 * 2.操纵大数据结构（ 大数据 ）
 * 3.远程方法调用（下载文件，HTML 爬取，Web 服务）
 *
 * 二、主要方法
 *  1.get（）方法可以当任务结束后返回一个结果，如果调用时，工作还没有结束，则会阻塞线程，直到任务执行完毕
 *  2.get（long timeout,TimeUnit unit）做多等待timeout的时间就会返回结果
 *  3.cancel（boolean mayInterruptIfRunning）方法可以用来停止一个任务，如果任务可以停止（通过mayInterruptIfRunning来进行判断），
 *  则可以返回true,如果任务已经完成或者已经停止，或者这个任务无法停止，则会返回false.
 *  4.isDone（）方法判断当前方法是否完成
 *  5.isCancel（）方法判断当前方法是否取消
 */
public class FutureTest {


    ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));



    @Test
    public void haha() throws ExecutionException, InterruptedException {

        //ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        Future<String> future = executor.submit(new Runnable() {
            @Override
            public void run() {
                new Random().nextInt(100);
            }
        }, new String("asda"));
     /*   Future<Integer> future = executor.submit((new Runnable()) -> {
            // 故意耗时
            Thread.sleep(5000);
            return new Random().nextInt(100);
        });*/
        System.out.println(future.get());
        System.out.println("如果get是阻塞的，则此消息在数据之后输出");
        executor.shutdown();
    }





    public Future<Integer> ceshi(Integer input){
        return executor.submit(()-> {
            System.out.println("caculating..."+input);
            return input*input;
        });
    }


    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            System.out.println("Calculating..." + input);
            Thread.sleep(1000);
            return input * input;
        });
    }


    /**
     * 计算并取得结果
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void calateResult() throws ExecutionException, InterruptedException {
        Random random = new Random();
        FutureTest futureTest = new FutureTest();
        Future<Integer> calculate = futureTest.ceshi(20);
       // calculate.cancel(true);
        System.out.println(calculate.get());
    }




    @Test
    public void caculateres() throws Exception {
        FutureTest futureTest = new FutureTest();
        Future<Integer> future1 = futureTest.calculate(10);
        Future<Integer> future2 = futureTest.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);
    }

}
