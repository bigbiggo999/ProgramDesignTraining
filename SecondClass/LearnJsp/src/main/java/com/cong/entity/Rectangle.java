package com.cong.entity;

/**
 * @author cong
 * @date 2018/4/8
 */
public class Rectangle {
    private double length=0;
    private double width=0;
    private double area;

    public Rectangle(){
        super();
    }

    public Rectangle(double length, double width){
        this.width = width;
        this.length = length;
        this.area = length*width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setArea(){
        this.area = length*width;
    }

    public double getArea(){
        setArea();
        return area;
    }

}
