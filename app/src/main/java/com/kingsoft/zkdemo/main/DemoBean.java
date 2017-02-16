package com.kingsoft.zkdemo.main;

/**
 * Created by 周康 on 2017/2/16.
 */

public class DemoBean {
    private String name;

    public DemoBean(String name, Class mclass) {
        this.name = name;
        this.mclass = mclass;
    }

    private Class mclass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getMclass() {
        return mclass;
    }

    public void setMclass(Class mclass) {
        this.mclass = mclass;
    }
}
