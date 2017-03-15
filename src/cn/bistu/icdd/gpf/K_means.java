package cn.bistu.icdd.gpf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * @author 关鹏飞
 * k-means算法
 * 
 * @version 1.0
 *
 */
public class K_means {

	private final int k;
	private Point[] D;

	/**
	 * k-means构造函数
	 * @param k 聚类簇数
	 * @param D 样本集
	 */
	public K_means(int k, Point[] D){
		this.k = k;
		this.D = D;
	}
	
	@SuppressWarnings("null")
	public void start(){
		
		// 1.从D中选出k个中心点
		Point[] sample = new Point[k];
		Random r = new Random();
		ArrayList<Integer> a = new ArrayList<Integer>();  //用于检测随机数是否重复
		for(int i=0; i<k ; i++){
			int temp;
			do{
				temp = r.nextInt(D.length);
			}while(a.contains(temp));
			a.add(temp);
			sample[i] = D[temp];
		}
		
		// 测试
		sample[0] = new Point(0.403,0.237);
		sample[1] = new Point(0.343,0.099);
		sample[2] = new Point(0.532,0.472);
		
		
		System.out.print("选取中心点：");
		System.out.println(Arrays.toString(sample));
		
		// 存储簇
		ArrayList<LinkedList<Point>> array;
		
		// 记录循环次数
		int numOfTimes = 1;
		
		boolean flag;  //记录中心点是否更新
		do{
			flag = false;  
			// 2.分别计算D中每个点到不同中心点的距离
			double[][] dist = new double[k][D.length];
			for(int i=0; i<k; i++){
				for(int j=0; j<D.length; j++){
					dist[i][j] = sample[i].dist(D[j]);
				}
			}
			
			// 3.根据距离的大小，把点划入相应的簇中
			
			// 定义集合存储簇
			array = new ArrayList<LinkedList<Point>>();
			for (int z = 0; z < k; z++) {
				array.add(new LinkedList<Point>());
			}
			
			// 选出每列对应的行下标
			for (int j = 0; j < D.length; j++) {
				int index = 0;
				double min = dist[index][j];
				for (int i = 1; i < k; i++) {
					if (min > dist[i][j]) {
						min = dist[i][j];
						index = i;
					}
				}
				array.get(index).add(D[j]);  //将点分配到对应的簇中
			} 
			
			// 4.更新中心点的值
			for (int i = 0; i < k; i++) {
				// 更新计算
				int num = array.get(i).size();
				Iterator<Point> it = array.get(i).iterator();
				double sum_midu = 0.0;
				double sum_hantang = 0.0;
				while(it.hasNext()){
					Point p = it.next();
					sum_midu += p.getMidu();
					sum_hantang += p.getHantang();
				}
				
				// 生成新的中点
				// 保留三位小数
				double midu = BigDecimal.valueOf(sum_midu/num).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
				double hantang = BigDecimal.valueOf(sum_hantang/num).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
				Point p = new Point(midu, hantang);
				// 判断新旧两点是否相等
				if(!sample[i].equals(p)){
					sample[i] = p;
					flag = true;
				}
			}
			
			//打印中心点
			if(flag){
				System.out.print("第" +numOfTimes+ "次更新中心点：");
				System.out.println(Arrays.toString(sample));
				numOfTimes++;
			}
			
		}while(flag);
		
		// 打印最终中心点
		System.out.println("打印最终中心点"+Arrays.toString(sample));
		
		// 打印簇划分
		for (int i = 0; i < k; i++) {
			Iterator<Point> it = array.get(i).iterator();
			while(it.hasNext()){
				Point p = it.next();
				System.out.print(p);
			}
			System.out.println();
		}
	}
	
	
}
