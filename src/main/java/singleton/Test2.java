package singleton;

/**
 * 解法2： 在创建实例的时候去加锁
 * 解法3：仅当instance 为空时加锁 双重检索
 * 解法4：静态内部类
 * 一个类会被初始化的场景：
 * 1.new 关键字，读取或者设置static 修饰的字段（final static 除外）,调用类的静态方法
 * 2，反射调用时会初始化未被初始化的类
 * 3，初始化一个类时会先初始化其父类
 * 4，虚拟机启动时会先初始化包含main 方法的类
 * 5，一个java.lang.invoke.MethodHandle实例最后的解析结果 包含static 字段或者方法会被初始化
 * 线程安全：
 * 虚拟机会保证一个类的<clinit>()类构造器方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，
 * 其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕
 * 故 INSTANCE在创建过程中是线程安全的
 *
 * 初始化：
 * getInstance()方法并没有多次去new对象，故不管多少个线程去调用getInstance()方法，取的都是同一个INSTANCE对象
 *
 */
public class Test2 {

    static class Single2{
        private static Single2 single2;

        private Single2() {}

        /**
         * 对方法进行加锁，保证同一时刻只有一个线程可以使用该方法
         * @return
         */
        public static synchronized Single2 getSingle2(){
            if(single2==null){
                single2=new Single2();
            }

           return single2;
            }


        }

        static class Single3{

            /**
             * 使用volatile
             * volatile 禁止指令重拍 ，使用这个可以防止出现当线程一创建实例未完成时被二线程使用
             */
        private  static volatile Single3 single3;
        private Single3(){}
        public static Single3 getSingle3() throws InterruptedException {
            /**
             * 缩小同步锁使用范围
             */
            if(single3==null){

                Thread.sleep(10000);
                synchronized (Single3.class){
                    /**
                     * 防止出现由于cpu 中断时，1，2线程同时获得 synchronized 锁后创建实例
                     * 0:singleton.Test2$Single3@493615b9
                     * 1:singleton.Test2$Single3@2d74268a
                     */
                   /* if(single3==null) {
                        single3=new Single3();
                    }*/
                    single3=new Single3();
                }
            }
            return single3;
        }

        }

        static class Single4{
         private Single4(){

         }
        public static Single4 getInstance(){
             return Single4Instance.single4;
        }

        static class Single4Instance{
             private static Single4 single4=new Single4();
        }

            public static void main(String[] args) {
                System.out.println(getInstance());
                System.out.println(getInstance());
                System.out.println(getInstance());
                System.out.println(getInstance());
            }
        }

}
