package singleton;

/**
 * 该单例模式只能在单线程的环境下使用 懒汉，线程安全
 * 核心：
 * 1,一个私有的构造方法
 * 2，一个私有的静态类对象，并且只能在不存在时创建
 *
 */
public class SingleThreadSingleton {

    private  final static SingleThreadSingleton singleThreadSingleton =new SingleThreadSingleton();
    private SingleThreadSingleton() {}

    public static SingleThreadSingleton getInstance(){
        return singleThreadSingleton;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }

}
