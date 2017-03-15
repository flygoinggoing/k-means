package cn.bistu.icdd.gpf;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Point {
	private double midu;
	private double hantang;
	
	public Point(double midu, double hantang){
		this.midu = midu;
		this.hantang = hantang;
	}
	
	/**
	 * 
	 * @param p 目标点
	 * @return 返回该点到目标点的距离
	 */
	public double dist(Point p){
		//DecimalFormat df = new DecimalFormat("#.###")
		BigDecimal bd = BigDecimal.valueOf(Math.sqrt(Math.pow((this.midu-p.midu), 2) + Math.pow((this.hantang-p.hantang), 2)));
		return bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public double getMidu() {
		return midu;
	}
	public void setMidu(double midu) {
		this.midu = midu;
	}
	public double getHantang() {
		return hantang;
	}
	public void setHantang(double hantang) {
		this.hantang = hantang;
	}
	
	@Override
	public int hashCode() {
		return (int) (super.hashCode()+this.midu+this.hantang);
	}
	
	@Override
	public boolean equals(Object obj) {
		Point p = (Point)obj;
		return Math.abs(this.midu-p.midu)<0.001 && Math.abs(this.hantang-p.hantang)<0.001;
	}
	
	@Override
	public String toString() {
		return "("+ midu + ";"+ hantang +")";
	}
	
}
