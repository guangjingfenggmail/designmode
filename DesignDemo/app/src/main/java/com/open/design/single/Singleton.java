package com.open.design.single;

/**
 * ****************************************************************************************************************************************************************************
 *
 *必须防止外部可以调用构造函数进行实例化，因此构造函数必须私有化。
 必须定义一个静态函数获得该单例
 单例使用volatile修饰
 使用synchronized 进行同步处理，并且双重判断是否为null，我们看到synchronized (Singleton.class)里面又进行了是否为null的判断，这是因为一个线程进入了该代码，如果另一个线程在等待，这时候前一个线程创建了一个实例出来完毕后，另一个线程获得锁进入该同步代码，实例已经存在，没必要再次创建，因此这个判断是否是null还是必须的
 1.Android-Universal-Image-Loader中的单例
 2.EventBus中的单例
 3.InputMethodManager 中的单例
 4.AccessibilityManager 中的单例
 5.ActivityManager
 * @author :guangjing.feng
 * @createTime: 2018/8/31.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class) {
                if (instance==null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Double Check Lock(DCL模式）：双重检查锁定\n" +
                "\n" +
                "\n" +
                "public class SingleTon {\n" +
                "    //声明私有化\n" +
                "    private static SingleTon singleTonInstance;\n" +
                "    //将构造函数私有化\n" +
                "    private SingleTon() {\n" +
                "    }\n" +
                "    //Double Check Lock\n" +
                "    public static SingleTon getInstance(){\n" +
                "        if (singleTonInstance==null){\n" +
                "            synchronized (SingleTon.class){\n" +
                "                if (singleTonInstance==null){\n" +
                "                    singleTonInstance = new SingleTon();\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        return singleTonInstance;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "可以看到getInstance()方法对singleTonInstance进行两次判空，对懒汉式进行了优化，只有在第一次实例化的时候才会走第二个分支，才会同步，避免了每次都同步造成的不必要的资源消耗。\n" +
                "\n" +
                "优点：第一次执行getInstance方法时才会实例化，资源利用率高，效率高。\n" +
                "\n" +
                "缺点：偶尔失效（高并发条件下，由于JDK版本问题，在jdk1.5之前会失败）\n"+
                "代码如下\n" +
                "public class Singleton {\n" +
                "    private static volatile Singleton instance = null;\n" +
                "\n" +
                "    private Singleton(){\n" +
                "    }\n" +
                " \n" +
                "    public static Singleton getInstance() {\n" +
                "        if (instance == null) {\n" +
                "            synchronized (Singleton.class) {\n" +
                "                if (instance == null) {\n" +
                "                    instance = new Singleton();\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        return instance;\n" +
                "    }\n" +
                "}\n" +
                "要保证单例，需要做一下几步\n" +
                "\n" +
                "必须防止外部可以调用构造函数进行实例化，因此构造函数必须私有化。\n" +
                "必须定义一个静态函数获得该单例\n" +
                "单例使用volatile修饰\n" +
                "使用synchronized 进行同步处理，并且双重判断是否为null，我们看到synchronized (Singleton.class)里面又进行了是否为null的判断，这是因为一个线程进入了该代码，如果另一个线程在等待，这时候前一个线程创建了一个实例出来完毕后，另一个线程获得锁进入该同步代码，实例已经存在，没必要再次创建，因此这个判断是否是null还是必须的。\n" +
                "至于单例的并发测试，可以使用CountDownLatch，使用await()等待锁释放，使用countDown()释放锁从而达到并发的效果。可以见下面的代码\n" +
                "public static void main(String[] args) {\n" +
                "\tfinal CountDownLatch latch = new CountDownLatch(1);\n" +
                "\tint threadCount = 1000;\n" +
                "\tfor (int i = 0; i < threadCount; i++) {\n" +
                "\t\tnew Thread() {\n" +
                "\t\t\t@Override\n" +
                "\t\t\tpublic void run() {\n" +
                "\t\t\t\ttry {\n" +
                "\t\t\t\t\tlatch.await();\n" +
                "\t\t\t\t} catch (InterruptedException e) {\n" +
                "\t\t\t\t\te.printStackTrace();\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\tSystem.out.println(Singleton.getInstance().hashCode());\n" +
                "\t\t\t}\n" +
                "\t\t}.start();\n" +
                "\t}\n" +
                "\tlatch.countDown();\n" +
                "}\n" +
                "看看打印出来的hashCode会不会出现不一样即可，理论上是全部都一样的。\n" +
                "\n" +
                "而在Android中，很多地方用到了单例。\n" +
                "\n" +
                "比如Android-Universal-Image-Loader中的单例\n" +
                "private volatile static ImageLoader instance;\n" +
                "/** Returns singleton class instance */\n" +
                "public static ImageLoader getInstance() {\n" +
                "\tif (instance == null) {\n" +
                "\t\tsynchronized (ImageLoader.class) {\n" +
                "\t\t\tif (instance == null) {\n" +
                "\t\t\t\tinstance = new ImageLoader();\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\treturn instance;\n" +
                "}\n" +
                "比如EventBus中的单例\n" +
                "private static volatile EventBus defaultInstance;\n" +
                "public static EventBus getDefault() {\n" +
                "\tif (defaultInstance == null) {\n" +
                "\t\tsynchronized (EventBus.class) {\n" +
                "\t\t\tif (defaultInstance == null) {\n" +
                "\t\t\t\tdefaultInstance = new EventBus();\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\treturn defaultInstance;\n" +
                "}\n" +
                "上面的单例都是比较规规矩矩的，当然实际上有很多单例都是变了一个样子，单本质还是单例。\n" +
                "\n" +
                "如InputMethodManager 中的单例\n" +
                "static InputMethodManager sInstance;\n" +
                "public static InputMethodManager getInstance() {\n" +
                "\tsynchronized (InputMethodManager.class) {\n" +
                "\t\tif (sInstance == null) {\n" +
                "\t\t\tIBinder b = ServiceManager.getService(Context.INPUT_METHOD_SERVICE);\n" +
                "\t\t\tIInputMethodManager service = IInputMethodManager.Stub.asInterface(b);\n" +
                "\t\t\tsInstance = new InputMethodManager(service, Looper.getMainLooper());\n" +
                "\t\t}\n" +
                "\t\treturn sInstance;\n" +
                "\t}\n" +
                "}\n" +
                "AccessibilityManager 中的单例，看代码这么长，其实就是进行了一些判断，还是一个单例\n" +
                "private static AccessibilityManager sInstance;\n" +
                "public static AccessibilityManager getInstance(Context context) {\n" +
                "\tsynchronized (sInstanceSync) {\n" +
                "\t\tif (sInstance == null) {\n" +
                "\t\t\tfinal int userId;\n" +
                "\t\t\tif (Binder.getCallingUid() == Process.SYSTEM_UID\n" +
                "\t\t\t\t\t|| context.checkCallingOrSelfPermission(\n" +
                "\t\t\t\t\t\t\tManifest.permission.INTERACT_ACROSS_USERS)\n" +
                "\t\t\t\t\t\t\t\t\t== PackageManager.PERMISSION_GRANTED\n" +
                "\t\t\t\t\t|| context.checkCallingOrSelfPermission(\n" +
                "\t\t\t\t\t\t\tManifest.permission.INTERACT_ACROSS_USERS_FULL)\n" +
                "\t\t\t\t\t\t\t\t\t== PackageManager.PERMISSION_GRANTED) {\n" +
                "\t\t\t\tuserId = UserHandle.USER_CURRENT;\n" +
                "\t\t\t} else {\n" +
                "\t\t\t\tuserId = UserHandle.myUserId();\n" +
                "\t\t\t}\n" +
                "\t\t\tIBinder iBinder = ServiceManager.getService(Context.ACCESSIBILITY_SERVICE);\n" +
                "\t\t\tIAccessibilityManager service = IAccessibilityManager.Stub.asInterface(iBinder);\n" +
                "\t\t\tsInstance = new AccessibilityManager(context, service, userId);\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\treturn sInstance;\n" +
                "}\n" +
                "当然单例还有很多种写法，比如恶汉式，有兴趣的自己去了解就好了。\n" +
                "\n" +
                "最后，我们应用一下单例模式。典型的一个应用就是管理我们的Activity，下面这个可以作为一个工具类，代码也很简单，也不做什么解释了。\n" +
                "public class ActivityManager {\n" +
                "\n" +
                "\tprivate static volatile ActivityManager instance;\n" +
                "\tprivate Stack<Activity> mActivityStack = new Stack<Activity>();\n" +
                "\t\n" +
                "\tprivate ActivityManager(){\n" +
                "\t\t\n" +
                "\t}\n" +
                "\t\n" +
                "\tpublic static ActivityManager getInstance(){\n" +
                "\t\tif (instance == null) {\n" +
                "\t\tsynchronized (ActivityManager.class) {\n" +
                "\t\t\tif (instance == null) {\n" +
                "\t\t\t\tinstance = new ActivityManager();\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\treturn instance;\n" +
                "\t}\n" +
                "\t\n" +
                "\tpublic void addActicity(Activity act){\n" +
                "\t\tmActivityStack.push(act);\n" +
                "\t}\n" +
                "\t\n" +
                "\tpublic void removeActivity(Activity act){\n" +
                "\t\tmActivityStack.remove(act);\n" +
                "\t}\n" +
                "\t\n" +
                "\tpublic void killMyProcess(){\n" +
                "\t\tint nCount = mActivityStack.size();\n" +
                "\t\tfor (int i = nCount - 1; i >= 0; i--) {\n" +
                "        \tActivity activity = mActivityStack.get(i);\n" +
                "        \tactivity.finish();\n" +
                "        }\n" +
                "\t\t\n" +
                "\t\tmActivityStack.clear();\n" +
                "\t\tandroid.os.Process.killProcess(android.os.Process.myPid());\n" +
                "\t}\n" +
                "}\n" +
                "这个类可以在开源中国的几个客户端中找到类似的源码";
    }
}
