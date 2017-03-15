package cn.bistu.icdd.gpf;

public class TestKmeans {

	public static void main(String[] args) {
		int k = 3;
		Point[] D = {
				new Point(0.697,0.460),
				new Point(0.774,0.376),
				new Point(0.634,0.264),
				new Point(0.608,0.318),
				new Point(0.556,0.215),
				new Point(0.403,0.237),
				new Point(0.481,0.149),
				new Point(0.437,0.211),
				new Point(0.666,0.091),
				new Point(0.243,0.267),
				new Point(0.245,0.057),
				new Point(0.343,0.099),
				new Point(0.639,0.161),
				new Point(0.657,0.198),
				new Point(0.360,0.370),
				new Point(0.593,0.042),
				new Point(0.719,0.103),
				new Point(0.359,0.188),
				new Point(0.339,0.241),
				new Point(0.282,0.257),
				new Point(0.748,0.232),
				new Point(0.714,0.346),
				new Point(0.483,0.312),
				new Point(0.478,0.437),
				new Point(0.525,0.369),
				new Point(0.751,0.489),
				new Point(0.532,0.472),
				new Point(0.473,0.376),
				new Point(0.725,0.445),
				new Point(0.446,0.459)
				}; 
		
		K_means km = new K_means(k, D);
		km.start();
	}

}
