package com.open.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/9/4.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class WeatherObserver implements Observer {
    private int id;
    private StringBuffer changed = new StringBuffer();
    private Weather weather;

    public WeatherObserver(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public StringBuffer getChanged() {
        return changed;
    }

    public void setChanged(StringBuffer changed) {
        this.changed = changed;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者---->" + id + "得到更新");
        this.weather = (Weather) o;
        System.out.println(((Weather)o).toString());
        changed.append(((Weather)o).toString()+"\n");
    }

    @Override
    public String toString() {
        return "Android设计模式学习之观察者模式\n" +
                "2017年02月17日 00:25:00 阅读数：16213\n" +
                "版权声明：本文为博主原创文章，未经博主允许不得转载。\thttps://blog.csdn.net/u012124438/article/details/55294914\n" +
                "观察者模式在实际项目中使用的也是非常频繁的，它最常用的地方是GUI系统、订阅——发布系统等。因为这个模式的一个重要作用就是解耦，使得它们之间的依赖性更小，甚至做到毫无依赖。以GUI系统来说，应用的UI具有易变性，尤其是前期随着业务的改变或者产品的需求修改，应用界面也经常性变化，但是业务逻辑基本变化不大，此时，GUI系统需要一套机制来应对这种情况，使得UI层与具体的业务逻辑解耦，观察者模式此时就派上用场了。\n" +
                "\n" +
                "概述\n" +
                "\n" +
                "观察者模式又被称作发布/订阅模式，观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。\n" +
                "\n" +
                "模式中的角色\n" +
                "\n" +
                "这里写图片描述\n" +
                "\n" +
                "抽象主题（Subject）：它把所有观察者对象的引用保存到一个聚集里，每个主题都可以有任何数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象。\n" +
                "\n" +
                "具体主题（ConcreteSubject）：将有关状态存入具体观察者对象；在具体主题内部状态改变时，给所有登记过的观察者发出通知。\n" +
                "\n" +
                "抽象观察者（Observer）：为所有的具体观察者定义一个接口，在得到主题通知时更新自己。\n" +
                "\n" +
                "具体观察者（ConcreteObserver）：实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题状态协调。\n" +
                "\n" +
                "1.Subject 和 Observer 是一个一对多的关系，也就是说观察者只要实现 Observer 接口并把自己注册到 Subject 中就能够接收到消息事件； \n" +
                "2.Java API有内置的观察者模式类：java.util.Observable 类和 java.util.Observer 接口，这分别对应着 Subject 和 Observer 的角色； \n" +
                "3.使用 Java API 的观察者模式类，需要注意的是被观察者在调用 notifyObservers() 函数通知观察者之前一定要调用 setChanged() 函数，要不然观察者无法接到通知； \n" +
                "4.使用 Java API 的缺点也很明显，由于 Observable 是一个类，java 只允许单继承的缺点就导致你如果同时想要获取另一个父类的属性时，你只能选择适配器模式或者是内部类的方式，而且由于 setChanged() 函数为 protected 属性，所以你除非继承 Observable 类，否则你根本无法使用该类的属性，这也违背了设计模式的原则：多用组合，少用继承。\n" +
                "\n" +
                "观察者模式示例\n" +
                "\n" +
                "例如：MyPerson是被观察者\n" +
                "\n" +
                "public class MyPerson extends Observable {\n" +
                "\n" +
                "    private String name;\n" +
                "    private int age;\n" +
                "    private String sex;\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "        setChanged();\n" +
                "        notifyObservers();\n" +
                "    }\n" +
                "\n" +
                "    public int getAge() {\n" +
                "        return age;\n" +
                "    }\n" +
                "\n" +
                "    public void setAge(int age) {\n" +
                "        this.age = age;\n" +
                "        setChanged();\n" +
                "        notifyObservers();\n" +
                "    }\n" +
                "\n" +
                "    public String getSex() {\n" +
                "        return sex;\n" +
                "    }\n" +
                "\n" +
                "    public void setSex(String sex) {\n" +
                "        this.sex = sex;\n" +
                "        setChanged();\n" +
                "        notifyObservers();\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public String toString() {\n" +
                "        return \"MyPerson [name=\" + name + \", age=\" + age + \", sex=\" + sex + \"]\";\n" +
                "    }\n" +
                "}\n" +
                "setChanged();告知数据改变，通过notifyObservers();发送信号通知观察者。\n" +
                "\n" +
                "MyObserver是观察者\n" +
                "\n" +
                "public class MyObserver implements Observer {\n" +
                "\n" +
                "    private int id;\n" +
                "    private MyPerson myPerson;\n" +
                "\n" +
                "    public MyObserver(int id) {\n" +
                "        System.out.println(\"我是观察者---->\" + id);\n" +
                "        this.id = id;\n" +
                "    }\n" +
                "\n" +
                "    public int getId() {\n" +
                "        return id;\n" +
                "    }\n" +
                "\n" +
                "    public void setId(int id) {\n" +
                "        this.id = id;\n" +
                "    }\n" +
                "\n" +
                "    public MyPerson getMyPerson() {\n" +
                "        return myPerson;\n" +
                "    }\n" +
                "\n" +
                "    public void setMyPerson(MyPerson myPerson) {\n" +
                "        this.myPerson = myPerson;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void update(Observable observable, Object data) {\n" +
                "        System.out.println(\"观察者---->\" + id + \"得到更新\");\n" +
                "        this.myPerson = (MyPerson) observable;\n" +
                "        System.out.println(((MyPerson) observable).toString());\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "观察者接受到通知后，调用update方法进行更新操作。\n" +
                "\n" +
                "public class MainActivity extends Activity {\n" +
                "\n" +
                "    private Button btnAddObserver;\n" +
                "    private Button btnChangeData;\n" +
                "    private MyPerson observable;\n" +
                "    private MyObserver myObserver;\n" +
                "    private List<MyObserver> myObservers;\n" +
                "    private ListView listview;\n" +
                "\n" +
                "    private int i;\n" +
                "\n" +
                "    private Handler handler = new Handler() {\n" +
                "        public void handleMessage(android.os.Message msg) {\n" +
                "            MyListAdapter myListAdapter = new MyListAdapter(MainActivity.this,\n" +
                "                    myObservers);\n" +
                "            listview.setAdapter(myListAdapter);\n" +
                "\n" +
                "        };\n" +
                "    };\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        btnAddObserver = (Button) findViewById(R.id.btn_add_observer);\n" +
                "        btnChangeData = (Button) findViewById(R.id.btn_change_data);\n" +
                "        listview = getListView();\n" +
                "\n" +
                "        observable = new MyPerson();\n" +
                "        myObservers = new ArrayList<MyObserver>();\n" +
                "\n" +
                "        btnAddObserver.setOnClickListener(new OnClickListener() {\n" +
                "\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                myObserver = new MyObserver(i);\n" +
                "                i++;\n" +
                "                observable.addObserver(myObserver);\n" +
                "                myObservers.add(myObserver);\n" +
                "                handler.sendEmptyMessage(0);\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        btnChangeData.setOnClickListener(new OnClickListener() {\n" +
                "\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                observable.setName(\"a\" + i);\n" +
                "                observable.setAge(10 + i);\n" +
                "                observable.setSex(\"男\" + i);\n" +
                "                handler.sendEmptyMessage(0);\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onDestroy() {\n" +
                "        // TODO Auto-generated method stub\n" +
                "        super.onDestroy();\n" +
                "        observable.deleteObserver(myObserver);\n" +
                "    }\n" +
                "}\n" +
                "Android源码中的模式实现\n" +
                "\n" +
                "在以前，我们最常用到的控件就是ListView了，而ListView最重要的一个点就是Adapter，在我们往ListView添加数据后，我们都会调用一个方法: notifyDataSetChanged(), 这个方法就是用到了我们所说的观察者模式。\n" +
                "\n" +
                "跟进这个方法notifyDataSetChanged方法，这个方法定义在BaseAdapter中，代码如下:\n" +
                "\n" +
                "public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {\n" +
                "    // 数据集观察者\n" +
                "    private final DataSetObservable mDataSetObservable = new DataSetObservable();\n" +
                "\n" +
                "    // 代码省略\n" +
                "\n" +
                "    public void registerDataSetObserver(DataSetObserver observer) {\n" +
                "        mDataSetObservable.registerObserver(observer);\n" +
                "    }\n" +
                "\n" +
                "    public void unregisterDataSetObserver(DataSetObserver observer) {\n" +
                "        mDataSetObservable.unregisterObserver(observer);\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * Notifies the attached observers that the underlying data has been changed\n" +
                "     * and any View reflecting the data set should refresh itself.\n" +
                "     * 当数据集用变化时通知所有观察者\n" +
                "     */\n" +
                "    public void notifyDataSetChanged() {\n" +
                "        mDataSetObservable.notifyChanged();\n" +
                "    }\n" +
                "可以发现，当数据发生变化时候，notifyDataSetChanged中会调用mDataSetObservable.notifyChanged()方法\n" +
                "\n" +
                "public class DataSetObservable extends Observable<DataSetObserver> {\n" +
                "    /**\n" +
                "     * Invokes onChanged on each observer. Called when the data set being observed has\n" +
                "     * changed, and which when read contains the new state of the data.\n" +
                "     */\n" +
                "    public void notifyChanged() {\n" +
                "        synchronized(mObservers) {\n" +
                "            // 调用所有观察者的onChanged方式\n" +
                "            for (int i = mObservers.size() - 1; i >= 0; i--) {\n" +
                "                mObservers.get(i).onChanged();\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "mDataSetObservable.notifyChanged()中遍历所有观察者，并且调用它们的onChanged方法。\n" +
                "\n" +
                "那么这些观察者是从哪里来的呢？首先ListView通过setAdapter方法来设置Adapter\n" +
                "\n" +
                " @Override\n" +
                "    public void setAdapter(ListAdapter adapter) {\n" +
                "        // 如果已经有了一个adapter,那么先注销该Adapter对应的观察者\n" +
                "        if (mAdapter != null && mDataSetObserver != null) {\n" +
                "            mAdapter.unregisterDataSetObserver(mDataSetObserver);\n" +
                "        }\n" +
                "\n" +
                "        // 代码省略\n" +
                "\n" +
                "        super.setAdapter(adapter);\n" +
                "\n" +
                "        if (mAdapter != null) {\n" +
                "            mAreAllItemsSelectable = mAdapter.areAllItemsEnabled();\n" +
                "            mOldItemCount = mItemCount;\n" +
                "            // 获取数据的数量\n" +
                "            mItemCount = mAdapter.getCount();\n" +
                "            checkFocus();\n" +
                "            // 注意这里 : 创建一个一个数据集观察者\n" +
                "            mDataSetObserver = new AdapterDataSetObserver();\n" +
                "            // 将这个观察者注册到Adapter中，实际上是注册到DataSetObservable中\n" +
                "            mAdapter.registerDataSetObserver(mDataSetObserver);\n" +
                "\n" +
                "            // 代码省略\n" +
                "        } else {\n" +
                "            // 代码省略\n" +
                "        }\n" +
                "\n" +
                "        requestLayout();\n" +
                "    }\n" +
                "在设置Adapter时会构建一个AdapterDataSetObserver，最后将这个观察者注册到adapter中，这样我们的被观察者、观察者都有了。\n" +
                "\n" +
                "AdapterDataSetObserver定义在ListView的父类AbsListView中，代码如下 :\n" +
                "\n" +
                " class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {\n" +
                "        @Override\n" +
                "        public void onChanged() {\n" +
                "            super.onChanged();\n" +
                "            if (mFastScroll != null) {\n" +
                "                mFastScroll.onSectionsChanged();\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onInvalidated() {\n" +
                "            super.onInvalidated();\n" +
                "            if (mFastScroll != null) {\n" +
                "                mFastScroll.onSectionsChanged();\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "它由继承自AbsListView的父类AdapterView的AdapterDataSetObserver, 代码如下 :\n" +
                "\n" +
                "class AdapterDataSetObserver extends DataSetObserver {\n" +
                "\n" +
                "        private Parcelable mInstanceState = null;\n" +
                "        // 调用Adapter的notifyDataSetChanged的时候会调用所有观察者的onChanged方法,核心实现就在这里\n" +
                "        @Override\n" +
                "        public void onChanged() {\n" +
                "            mDataChanged = true;\n" +
                "            mOldItemCount = mItemCount;\n" +
                "            // 获取Adapter中数据的数量\n" +
                "            mItemCount = getAdapter().getCount();\n" +
                "\n" +
                "            // Detect the case where a cursor that was previously invalidated has\n" +
                "            // been repopulated with new data.\n" +
                "            if (AdapterView.this.getAdapter().hasStableIds() && mInstanceState != null\n" +
                "                    && mOldItemCount == 0 && mItemCount > 0) {\n" +
                "                AdapterView.this.onRestoreInstanceState(mInstanceState);\n" +
                "                mInstanceState = null;\n" +
                "            } else {\n" +
                "                rememberSyncState();\n" +
                "            }\n" +
                "            checkFocus();\n" +
                "            // 重新布局ListView、GridView等AdapterView组件\n" +
                "            requestLayout();\n" +
                "        }\n" +
                "\n" +
                "        // 代码省略\n" +
                "\n" +
                "        public void clearSavedState() {\n" +
                "            mInstanceState = null;\n" +
                "        }\n" +
                "    }\n" +
                "当ListView的数据发生变化时，调用Adapter的notifyDataSetChanged函数，这个函数又会调用DataSetObservable的notifyChanged函数，这个函数会调用所有观察者 (AdapterDataSetObserver) 的onChanged方法。这就是一个观察者模式！\n" +
                "\n" +
                "总结：AdapterView中有一个内部类AdapterDataSetObserver,在ListView设置Adapter时会构建一个AdapterDataSetObserver，并且注册到Adapter中，这个就是一个观察者。而Adapter中包含一个数据集可观察者DataSetObservable，在数据数量发生变更时开发者手动调用AdapternotifyDataSetChanged，而notifyDataSetChanged实际上会调用DataSetObservable的notifyChanged函数，该函数会遍历所有观察者的onChanged函数。在AdapterDataSetObserver的onChanged函数中会获取Adapter中数据集的新数量，然后调用ListView的requestLayout()方法重新进行布局，更新用户界面。\n" +
                "\n" +
                "比较知名的使用观察者模式的开源框架有 \n" +
                "EventBus \n" +
                "AndroidEventBus \n" +
                "otto\n" +
                "\n" +
                "模式总结\n" +
                "\n" +
                "优点\n" +
                "\n" +
                "观察者模式解除了主题和具体观察者的耦合，让耦合的双方都依赖于抽象，而不是依赖具体。从而使得各自的变化都不会影响另一边的变化。\n" +
                "\n" +
                "缺点\n" +
                "\n" +
                "依赖关系并未完全解除，抽象通知者依旧依赖抽象的观察者。\n" +
                "\n" +
                "适用场景\n" +
                "\n" +
                "当一个对象的改变需要给变其它对象时，而且它不知道具体有多少个对象有待改变时。\n" +
                "\n" +
                "一个抽象某型有两个方面，当其中一个方面依赖于另一个方面，这时用观察者模式可以将这两者封装在独立的对象中使它们各自独立地改变和复用。";
    }
}
