package com.lenovo.test.fragment;

public class fragment02_list_Bean implements Comparable<fragment02_list_Bean> {

    String lukou;
    int red;
    int green;
    int yellow;
    int paixvStyle;

    public int getPaixvStyle() {
        return paixvStyle;
    }

    public void setPaixvStyle(int paixvStyle) {
        this.paixvStyle = paixvStyle;
    }

    public String getLukou() {
        return lukou;
    }

    public void setLukou(String lukou) {
        this.lukou = lukou;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getYellow() {
        return yellow;
    }

    public void setYellow(int yellow) {
        this.yellow = yellow;
    }


    //排序方法
    @Override
    public int compareTo(fragment02_list_Bean o) {
        switch (paixvStyle){
            case 0:
                if(red<o.red){
                    return -1;
                }
                else{
                    return 1;
                }
            case 1:
                if(red>o.red){
                    return -1;
                }
                else{
                    return 1;
                }
            case 2:
                if(green<o.green){
                    return -1;
                }else if (green==o.green){
                    if(Integer.parseInt(String.valueOf(lukou.charAt(0)))<Integer.parseInt(String.valueOf(o.lukou.charAt(0)))){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                else{
                    return 1;
                }
            case 3:
                if(green>o.green){
                    return -1;
                }else if(green==o.green){
                    if(Integer.parseInt(String.valueOf(lukou.charAt(0)))>Integer.parseInt(String.valueOf(o.lukou.charAt(0)))){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                else{
                    return 1;
                }

        }
        return 0;
    }
}
