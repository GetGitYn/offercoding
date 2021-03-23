package singleton;


public class CreateMultiThreadDemo2 extends Thread{
    public CreateMultiThreadDemo2(String name) {
        // 设置当前线程的名字
        this.setName(name);
    }

    @Override
    public void run() {
        // 每隔1s中输出一次当前线程的名字
        while (true) {
            // 输出线程的名字，与主线程名称相区分
            try {
                printThreadInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                // 线程休眠一秒
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void printThreadInfo() throws Exception {
        System.out.println(Thread.currentThread().getName()+":"+Test2.Single3.getSingle3());
        if (Thread.currentThread().getName()=="1"){
            sleep(10000);
        }


    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <7 ; i++) {
            new CreateMultiThreadDemo2(String.valueOf(i)).start();
        }

       /* while (true) {
            printThreadInfo();
            Thread.sleep(1000);
        }*/

    }
}
