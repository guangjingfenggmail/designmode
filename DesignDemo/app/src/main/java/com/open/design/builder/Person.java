package com.open.design.builder;


/**
 * ****************************************************************************************************************************************************************************
 * 定义一个静态内部类Builder，内部的成员变量和外部类一样
 * Builder类通过一系列的方法用于成员变量的赋值，并返回当前对象本身（this）
 * Builder类提供一个build方法或者create方法用于创建对应的外部类，该方法内部调用了外部类的一个私有构造函数，该构造函数的参数就是内部类Builder
 * 外部类提供一个私有构造函数供内部类调用，在该构造函数中完成成员变量的赋值，取值为Builder对象中对应的值
 * 1.AlertDialog.Builder builder=new AlertDialog.Builder(this);
 * 2.GsonBuilder builder=new GsonBuilder();
 * 3.EventBus中也有一个Builder，只不过这个Builder外部访问不到而已，因为它的构造函数不是public的
 * 4.Request.Builder builder=new Request.Builder();
 * Request request=builder.addHeader("","")
 * .url("")
 * .post(body)
 * .build();
 * 5.Request外，Response也是通过Builder模式创建的。贴一下Response的构造函数
 *
 * @author :guangjing.feng
 * @createTime: 2018/8/31.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Person {
    private String name;
    private int age;
    private double height;
    private double weight;

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        height = builder.height;
        weight = builder.weight;
    }


    public static final class Builder {
        private String name;
        private int age;
        private double height;
        private double weight;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Build模式\n" +
                "\n" +
                "了解了单例模式，接下来介绍另一个常见的模式——Builder模式。\n" +
                "\n" +
                "那么什么是Builder模式呢。你通过搜索，会发现大部分网上的定义都是\n" +
                "\n" +
                "将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示\n" +
                "\n" +
                "但是看完这个定义，并没有什么卵用，你依然不知道什么是Builder设计模式。在此个人的态度是学习设计模式这种东西，不要过度在意其定义，定义往往是比较抽象的，学习它最好的例子就是通过样例代码。\n" +
                "\n" +
                "我们通过一个例子来引出Builder模式。假设有一个Person类，我们通过该Person类来构建一大批人，这个Person类里有很多属性，最常见的比如name，age，weight，height等等，并且我们允许这些值不被设置，也就是允许为null，该类的定义如下。\n" +
                "public class Person {\n" +
                "    private String name;\n" +
                "    private int age;\n" +
                "    private double height;\n" +
                "    private double weight;\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public int getAge() {\n" +
                "        return age;\n" +
                "    }\n" +
                "\n" +
                "    public void setAge(int age) {\n" +
                "        this.age = age;\n" +
                "    }\n" +
                "\n" +
                "    public double getHeight() {\n" +
                "        return height;\n" +
                "    }\n" +
                "\n" +
                "    public void setHeight(double height) {\n" +
                "        this.height = height;\n" +
                "    }\n" +
                "\n" +
                "    public double getWeight() {\n" +
                "        return weight;\n" +
                "    }\n" +
                "\n" +
                "    public void setWeight(double weight) {\n" +
                "        this.weight = weight;\n" +
                "    }\n" +
                "}\n" +
                "然后我们为了方便可能会定义一个构造方法。\n" +
                "public Person(String name, int age, double height, double weight) {\n" +
                "\tthis.name = name;\n" +
                "\tthis.age = age;\n" +
                "\tthis.height = height;\n" +
                "\tthis.weight = weight;\n" +
                "}\n" +
                "或许为了方便new对象，你还会定义一个空的构造方法\n" +
                "\n" +
                "1\n" +
                "2\n" +
                "public Person() {\n" +
                "}\n" +
                "甚至有时候你很懒，只想传部分参数，你还会定义如下类似的构造方法。\n" +
                "public Person(String name) {\n" +
                "\tthis.name = name;\n" +
                "}\n" +
                "\n" +
                "public Person(String name, int age) {\n" +
                "\tthis.name = name;\n" +
                "\tthis.age = age;\n" +
                "}\n" +
                "\n" +
                "public Person(String name, int age, double height) {\n" +
                "\tthis.name = name;\n" +
                "\tthis.age = age;\n" +
                "\tthis.height = height;\n" +
                "}\n" +
                "于是你就可以这样创建各个需要的对象\n" +
                "Person p1=new Person();\n" +
                "Person p2=new Person(\"张三\");\n" +
                "Person p3=new Person(\"李四\",18);\n" +
                "Person p4=new Person(\"王五\",21,180);\n" +
                "Person p5=new Person(\"赵六\",17,170,65.4);\n" +
                "可以想象一下这样创建的坏处，最直观的就是四个参数的构造函数的最后面的两个参数到底是什么意思，可读性不怎么好，如果不点击看源码，鬼知道哪个是weight哪个是height。还有一个问题就是当有很多参数时，编写这个构造函数就会显得异常麻烦，这时候如果换一个角度，试试Builder模式，你会发现代码的可读性一下子就上去了。\n" +
                "\n" +
                "我们给Person增加一个静态内部类Builder类，并修改Person类的构造函数，代码如下。\n" +
                "public class Person {\n" +
                "    private String name;\n" +
                "    private int age;\n" +
                "    private double height;\n" +
                "    private double weight;\n" +
                "\n" +
                "    privatePerson(Builder builder) {\n" +
                "        this.name=builder.name;\n" +
                "        this.age=builder.age;\n" +
                "        this.height=builder.height;\n" +
                "        this.weight=builder.weight;\n" +
                "    }\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public int getAge() {\n" +
                "        return age;\n" +
                "    }\n" +
                "\n" +
                "    public void setAge(int age) {\n" +
                "        this.age = age;\n" +
                "    }\n" +
                "\n" +
                "    public double getHeight() {\n" +
                "        return height;\n" +
                "    }\n" +
                "\n" +
                "    public void setHeight(double height) {\n" +
                "        this.height = height;\n" +
                "    }\n" +
                "\n" +
                "    public double getWeight() {\n" +
                "        return weight;\n" +
                "    }\n" +
                "\n" +
                "    public void setWeight(double weight) {\n" +
                "        this.weight = weight;\n" +
                "    }\n" +
                "\n" +
                "    static class Builder{\n" +
                "        private String name;\n" +
                "        private int age;\n" +
                "        private double height;\n" +
                "        private double weight;\n" +
                "        public Builder name(String name){\n" +
                "            this.name=name;\n" +
                "            return this;\n" +
                "        }\n" +
                "        public Builder age(int age){\n" +
                "            this.age=age;\n" +
                "            return this;\n" +
                "        }\n" +
                "        public Builder height(double height){\n" +
                "            this.height=height;\n" +
                "            return this;\n" +
                "        }\n" +
                "\n" +
                "        public Builder weight(double weight){\n" +
                "            this.weight=weight;\n" +
                "            return this;\n" +
                "        }\n" +
                "\n" +
                "        public Person build(){\n" +
                "            return new Person(this);\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "从上面的代码中我们可以看到，我们在Builder类里定义了一份与Person类一模一样的变量，通过一系列的成员函数进行设置属性值，但是返回值都是this，也就是都是Builder对象，最后提供了一个build函数用于创建Person对象，返回的是Person对象，对应的构造函数在Person类中进行定义，也就是构造函数的入参是Builder对象，然后依次对自己的成员变量进行赋值，对应的值都是Builder对象中的值。此外Builder类中的成员函数返回Builder对象自身的另一个作用就是让它支持链式调用，使代码可读性大大增强。\n" +
                "\n" +
                "于是我们就可以这样创建Person类。\n" +
                "Person.Builder builder=new Person.Builder();\n" +
                "Person person=builder\n" +
                "\t\t.name(\"张三\")\n" +
                "\t\t.age(18)\n" +
                "\t\t.height(178.5)\n" +
                "\t\t.weight(67.4)\n" +
                "\t\t.build();\n" +
                "有没有觉得创建过程一下子就变得那么清晰了。对应的值是什么属性一目了然，可读性大大增强。\n" +
                "\n" +
                "其实在Android中， Builder模式也是被大量的运用。比如常见的对话框的创建\n" +
                "AlertDialog.Builder builder=new AlertDialog.Builder(this);\n" +
                "AlertDialog dialog=builder.setTitle(\"标题\")\n" +
                "\t\t.setIcon(android.R.drawable.ic_dialog_alert)\n" +
                "\t\t.setView(R.layout.myview)\n" +
                "\t\t.setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {\n" +
                "\t\t\t@Override\n" +
                "\t\t\tpublic void onClick(DialogInterface dialog, int which) {\n" +
                "\n" +
                "\t\t\t}\n" +
                "\t\t})\n" +
                "\t\t.setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {\n" +
                "\t\t\t@Override\n" +
                "\t\t\tpublic void onClick(DialogInterface dialog, int which) {\n" +
                "\n" +
                "\t\t\t}\n" +
                "\t\t})\n" +
                "\t\t.create();\n" +
                "dialog.show();\n" +
                "其实在java中有两个常见的类也是Builder模式，那就是StringBuilder和StringBuffer，只不过其实现过程简化了一点罢了。\n" +
                "\n" +
                "我们再找找Builder模式在各个框架中的应用。\n" +
                "\n" +
                "如Gson中的GsonBuilder，代码太长了，就不贴了，有兴趣自己去看源码，这里只贴出其Builder的使用方法。\n" +
                "GsonBuilder builder=new GsonBuilder();\n" +
                "Gson gson=builder.setPrettyPrinting()\n" +
                "\t\t.disableHtmlEscaping()\n" +
                "\t\t.generateNonExecutableJson()\n" +
                "\t\t.serializeNulls()\n" +
                "\t\t.create();\n" +
                "还有EventBus中也有一个Builder，只不过这个Builder外部访问不到而已，因为它的构造函数不是public的，但是你可以在EventBus这个类中看到他的应用。\n" +
                "public static EventBusBuilder builder() {\n" +
                "\treturn new EventBusBuilder();\n" +
                "}\n" +
                "public EventBus() {\n" +
                "\tthis(DEFAULT_BUILDER);\n" +
                "}\n" +
                "EventBus(EventBusBuilder builder) {\n" +
                "\tsubscriptionsByEventType = new HashMap<Class<?>, CopyOnWriteArrayList<Subscription>>();\n" +
                "\ttypesBySubscriber = new HashMap<Object, List<Class<?>>>();\n" +
                "\tstickyEvents = new ConcurrentHashMap<Class<?>, Object>();\n" +
                "\tmainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);\n" +
                "\tbackgroundPoster = new BackgroundPoster(this);\n" +
                "\tasyncPoster = new AsyncPoster(this);\n" +
                "\tsubscriberMethodFinder = new SubscriberMethodFinder(builder.skipMethodVerificationForClasses);\n" +
                "\tlogSubscriberExceptions = builder.logSubscriberExceptions;\n" +
                "\tlogNoSubscriberMessages = builder.logNoSubscriberMessages;\n" +
                "\tsendSubscriberExceptionEvent = builder.sendSubscriberExceptionEvent;\n" +
                "\tsendNoSubscriberEvent = builder.sendNoSubscriberEvent;\n" +
                "\tthrowSubscriberException = builder.throwSubscriberException;\n" +
                "\teventInheritance = builder.eventInheritance;\n" +
                "\texecutorService = builder.executorService;\n" +
                "}\n" +
                "再看看著名的网络请求框架OkHttp\n" +
                "Request.Builder builder=new Request.Builder();\n" +
                "Request request=builder.addHeader(\"\",\"\")\n" +
                "\t.url(\"\")\n" +
                "\t.post(body)\n" +
                "\t.build();\n" +
                "除了Request外，Response也是通过Builder模式创建的。贴一下Response的构造函数\n" +
                "private Response(Builder builder) {\n" +
                "\tthis.request = builder.request;\n" +
                "\tthis.protocol = builder.protocol;\n" +
                "\tthis.code = builder.code;\n" +
                "\tthis.message = builder.message;\n" +
                "\tthis.handshake = builder.handshake;\n" +
                "\tthis.headers = builder.headers.build();\n" +
                "\tthis.body = builder.body;\n" +
                "\tthis.networkResponse = builder.networkResponse;\n" +
                "\tthis.cacheResponse = builder.cacheResponse;\n" +
                "\tthis.priorResponse = builder.priorResponse;\n" +
                "}\n" +
                "可见各大框架中大量的运用了Builder模式。最后总结一下\n" +
                "\n" +
                "定义一个静态内部类Builder，内部的成员变量和外部类一样\n" +
                "Builder类通过一系列的方法用于成员变量的赋值，并返回当前对象本身（this）\n" +
                "Builder类提供一个build方法或者create方法用于创建对应的外部类，该方法内部调用了外部类的一个私有构造函数，该构造函数的参数就是内部类Builder\n" +
                "外部类提供一个私有构造函数供内部类调用，在该构造函数中完成成员变量的赋值，取值为Builder对象中对应的值";
    }
}
