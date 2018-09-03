package com.open.design.builder.director;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/9/3.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class BuilderClient {
//    public static void main(String[] args) {
//        // 构建对象
//        TraxexBuilder builder = new TraxexBuilder();
//        Director director = new Director(builder);
//        director.construct("Naga007", "Level_19");
//        Traxex traxex = builder.build();
//        System.out.println(traxex);
//    }

    @Override
    public String toString() {
        return "之前写Android程序的时候，经常会用到Dialog（对话框）这个控件。我们在使用Dialog，比如AlertDialog的时候就用到了这里要说明的Builder模式。现在我们来看一下这样的一段代码：\n" +
                "\n" +
                "public void showDialog() {\n" +
                "    \tBuilder builder = new AlertDialog.Builder(this);\n" +
                "    \tAlertDialog dialog = builder.setIcon(R.drawable.ic_launcher)\n" +
                "    \t\t\t.setMessage(\"Hello Boy.\")\n" +
                "        \t\t.create();\n" +
                "    \tdialog.show();\n" +
                "    }\n" +
                "  我们可以通过这种方式来显示一个系统自带的对话框。不知道大家有没有想过为什么Dialog要通过这种方式来构建呢？直接new出来不是更直接么？下面就通过Builder模式来详细说明一下这个问题。\n" +
                "\n" +
                "\n" +
                "版权说明\n" +
                "\n" +
                "著作权归作者所有。\n" +
                "商业转载请联系作者获得授权，非商业转载请注明出处。\n" +
                "作者：Coding-Naga\n" +
                "发表日期： 2015年12月11日\n" +
                "链接：http://blog.csdn.net/lemon_tree12138/article/details/50246499\n" +
                "来源：CSDN\n" +
                "更多内容：分类 >> 设计模式\n" +
                "\n" +
                " \n" +
                "\n" +
                "定义\n" +
                "\n" +
                "  builder模式的使用目的是为了将构建复杂对象的过程和它的部件解耦。将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。\n" +
                "\n" +
                "\n" +
                "\n" +
                "说明\n" +
                "\n" +
                "  要怎么理解上面概述的这句话呢？在上一篇《Java设计模式——工厂模式》博客中，我们知道了，如果一个类比较复杂，我们在new这个对象的时候就要多个心眼了。为什么？因为我们要考虑程序部件之间的耦合度。当然，我们也可以使用上篇的工厂模式来解决，不过这不属于我们本篇博客的范围。\n" +
                "\n" +
                "  既然说到了对象的构建过程和部件需要解耦，那么势必会有两个不同的类，分别是构建过程类和部件类。我们可以从下面的图-2中看到这一点，分别是两个接口：HeroBuilder和Hero。下面就来列举一个实例加以说明。\n" +
                "\n" +
                "\n" +
                "\n" +
                "图-1 简单Builder模式\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "图-2 Builder模式类图\n" +
                "\n" +
                "\n" +
                "\n" +
                "实例及过程说明\n" +
                "\n" +
                "背景\n" +
                "\n" +
                "  因为博主是一个DotAer，所以这里我就列举创建一个DotA英雄的过程吧。（真实游戏中英雄的创建并不是这样的，你可以理解这是一个外挂程序-_-!）。\n" +
                "\n" +
                "  每一个英雄在被创建之前，他们都有一个抽象的统称——Hero。这里定义成一个接口。\n" +
                "\n" +
                "  每一个英雄都有以下属性：玩家id、当前等级、当前学习技能点、当前装备。\n" +
                "\n" +
                "创建过程\n" +
                "\n" +
                "  这里我定义一个HeroBuilder的来抽象创建英雄，让具体的创建者TraxexBuilder去实现抽象创建者。所以，真实创建的时候，是通过具体创建者来实现的。我们把具体英雄的创建交给了一个创建者，这一点是不是跟工厂模式中的使用工厂来生产产品很类似？\n" +
                "\n" +
                "创建者接口\n" +
                "\n" +
                "  首先，我们定义一个接口来告诉具体的创建者要如何创建复杂对象的组件。\n" +
                "\n" +
                "\n" +
                "public interface HeroBuilder {\n" +
                " \n" +
                "    public HeroBuilder userName(String _name);\n" +
                "    \n" +
                "    public HeroBuilder level(Level _level);\n" +
                "    \n" +
                "    public HeroBuilder skills(List<Skill> _skills);\n" +
                "    \n" +
                "    public HeroBuilder equipments(List<Equipment> _equipments);\n" +
                "}\n" +
                "具体创建者\n" +
                "\n" +
                "  具体的创建者要实现创建者接口，然后提供一个能够返回对象的接口。\n" +
                "\n" +
                "public class TraxexBuilder implements HeroBuilder {\n" +
                " \n" +
                "    private Traxex traxex;\n" +
                "    \n" +
                "    public String userName; // 玩家id\n" +
                "    public Level level; // 玩家等级\n" +
                "    public List<Skill> skills; // 学习技能点\n" +
                "    public List<Equipment> equipments; // 当前装备\n" +
                "    \n" +
                "    @Override\n" +
                "    public HeroBuilder userName(String _name) {\n" +
                "        userName = _name;\n" +
                "        return this;\n" +
                "    }\n" +
                "    \n" +
                "    ... ...\n" +
                " \n" +
                "    public Traxex build() {\n" +
                "        if (traxex == null) {\n" +
                "            traxex = new Traxex(this);\n" +
                "        }\n" +
                "        \n" +
                "        return traxex;\n" +
                "    }\n" +
                "}\n" +
                "对象的接口\n" +
                "\n" +
                "  这里我们为英雄统一定义一个接口，用于规定好英雄需要做哪些事情。这些事情到时候就交给创建者来完成。\n" +
                "\n" +
                "public interface Hero {\n" +
                " \n" +
                "    public void setUserName(String name);\n" +
                " \n" +
                "    public void setLevel(Level level);\n" +
                "    \n" +
                "    public void setSkill(List<Skill> skills);\n" +
                "    \n" +
                "    public void setEquipment(List<Equipment> equipments);\n" +
                "    \n" +
                "}\n" +
                "具体的对象实例\n" +
                "\n" +
                "  这里为了方便说明更理解，下面的具体对象中省略了很多内容。完整的代码可以在下面的GitHub链接中下载。\n" +
                "public class Traxex implements Hero {\n" +
                " \n" +
                "    private String userName; // 玩家id\n" +
                "    private Level level; // 玩家等级\n" +
                "    private List<Skill> skills; // 学习技能点\n" +
                "    private List<Equipment> equipments; // 当前装备\n" +
                "    \n" +
                "    // 省略从Hero接口中重写的方法\n" +
                "    \n" +
                "    // 省略自定义方法\n" +
                "    \n" +
                "    public Traxex(TraxexBuilder _builder) {\n" +
                "        // 省略完成从创建者那里获得的属性信息\n" +
                "    }\n" +
                " \n" +
                "    @Override\n" +
                "    public String toString() {\n" +
                "        ... ...\n" +
                "        \n" +
                "        return something;\n" +
                "    }\n" +
                "}\n" +
                "组装\n" +
                "\n" +
                "  有了以上的这几个部分，事情大体完成了。说是大体完成的原因是因为还有最一步了，那就是组装（Director）。\n" +
                "  你是不是要问我，为什么之前有了一个Builder是具体创建者了，这里还要有一个Director，这是什么鬼？先别急，让我们来了解一下Builder和Director的区别，之后你就好理解了。\n" +
                "  从上面的代码和分析中，我知道了Builder是一个创建者，它负责的是创建复杂对象中的各个组件。比如例子中的英雄等级、学习技能、合成的装备等。那么我们创建好了这些单个组件之后，是不是应该把这些组件组装到具体的对象上呢？答案是肯定的。那么这里的Director就是干这个事情的啦。请看下面的代码：\n" +
                "\n" +
                "\n" +
                "public class Director {\n" +
                " \n" +
                "    private HeroBuilder builder = null;\n" +
                "    \n" +
                "    public Director(HeroBuilder _builder) {\n" +
                "        builder = _builder;\n" +
                "    }\n" +
                "    \n" +
                "    public void construct(String _playerName, Level _level, List<Skill> _skills, List<Equipment> _equipments) {\n" +
                "        builder\n" +
                "            .userName(_playerName)\n" +
                "            .level(_level)\n" +
                "            .skills(_skills)\n" +
                "            .equipments(_equipments);\n" +
                "    }\n" +
                "}\n" +
                "客户端测试\n" +
                "\n" +
                "public class BuilderClient {\n" +
                " \n" +
                "    public static void main(String[] args) {\n" +
                "        // 技能定义\n" +
                "        List<Skill> skills = getSkills();\n" +
                "        \n" +
                "        // 装备定义\n" +
                "        List<Equipment> equipments = getEquipments();\n" +
                "        \n" +
                "        // 构建对象\n" +
                "        TraxexBuilder builder = new TraxexBuilder();\n" +
                "        Director director = new Director(builder);\n" +
                "        director.construct(\"Naga007\", Level.Level_19, skills, equipments);\n" +
                "        Traxex traxex = builder.build();\n" +
                "        \n" +
                "        System.out.println(traxex);\n" +
                "    }\n" +
                "\t\n" +
                "\t... ...\n" +
                "}\n" +
                "测试结果\n" +
                "\n" +
                "\n" +
                "\n" +
                "图-3 程序运行结果\n" +
                "\n" +
                "GitHub源码链接\n" +
                "\n" +
                "https://github.com/William-Hai/DesignPattern-Builder";
    }
}
