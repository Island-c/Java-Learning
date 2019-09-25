/**
 * 1. 已知两个点的经纬度坐标，求他们的距离 Distance(double lat1,double lon1, double lat2,double
 * lon2) 2. 已知一个点和一个距离，求一个范围 getBoundary(double lat,double lon,double dis)
 * 
 * @author LC
 *
 */

public class Distance {

	static double EARTH_RADIUS = 6371.137;// km 地球半径 平均值，千米

	public static void main(String[] args) {
		
		System.out.println("中心点-->" + "(39.9088230000,116.3974700000)"); // 天安门广场作为中心

		System.out.println(Distance(39.9088230000, 116.3974700000, 39.9180560000, 116.3970270000));// 天安门到故宫的距离

		double[][] BoundaryNodes = getBoundary(39.9088230000, 116.3974700000, 50);// 距离天安门广场50km的边界点
		//4*2数组，第一维分别是： 左上、右上、左下、右下
		System.out.println("左上角-->" + "(" + BoundaryNodes[0][0] + "," + BoundaryNodes[0][1] + ")");
		System.out.println("右上角-->" + "(" + BoundaryNodes[1][0] + "," + BoundaryNodes[1][1] + ")");
		System.out.println("左下角-->" + "(" + BoundaryNodes[2][0] + "," + BoundaryNodes[2][1] + ")");
		System.out.println("右下角-->" + "(" + BoundaryNodes[3][0] + "," + BoundaryNodes[3][1] + ")");
	}

	/// 给定的经度1，纬度1；经度2，纬度2. 计算2个经纬度之间的距离。
	public static double Distance(double lat1, double lon1, double lat2, double lon2) {

		// 用haversine公式计算球面两点间的距离。
		// 经纬度转换成弧度
		lat1 = ConvertDegreesToRadians(lat1);
		lon1 = ConvertDegreesToRadians(lon1);
		lat2 = ConvertDegreesToRadians(lat2);
		lon2 = ConvertDegreesToRadians(lon2);

		// 差值
		double vLon = Math.abs(lon1 - lon2);
		double vLat = Math.abs(lat1 - lat2);

		// h is the great circle distance in radians, great
		// circle就是一个球体上的切面，它的圆心即是球心的一个周长最大的圆。
		// h是一个中间值，是长度一半的平方
		double h = HaverSin(vLat) + Math.cos(lat1) * Math.cos(lat2) * HaverSin(vLon);

		double distance = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(h));

		return distance;
	}

	public static double[][] getBoundary(double lat, double lon, double dis) {
		/*
		 * left-top : (lat + dlat, lng - dlng) right-top : (lat + dlat, lng + dlng)
		 * left-bottom : (lat - dlat, lng - dlng) right-bottom: (lat - dlat, lng + dlng)
		 */

		double[] res = GetRelativeDistance(lat, lon, dis);
		double dlat = res[0];
		double dlon = res[1];
		double[] left_top = { lat + dlat, lon - dlon };
		double[] right_top = { lat + dlat, lon + dlon };
		double[] left_bottom = { lat - dlat, lon - dlon };
		double[] right_bottom = { lat - dlat, lon + dlon };

		double[][] resu = new double[][] { left_top, right_top, left_bottom, right_bottom };

		return resu;

	}

	private static double[] GetRelativeDistance(double lat, double lon, double dis) {
		// 得到距中心点一定距离 ，范围内的， 相对的，经纬度偏移
		double dlng = 2 * Math.asin(Math.sin(dis / (2 * EARTH_RADIUS)) / Math.cos(lat * Math.PI / 180)); // ⊿λ东西两侧的的范围边界
		dlng = ConvertRadiansToDegrees(dlng);// 角度转为弧度
		double dlat = dis / EARTH_RADIUS; // ⊿φ南北两侧的范围边界
		dlat = ConvertRadiansToDegrees(dlat);
		double[] res = new double[] { dlat, dlng };
		return res;

	}

	private static double HaverSin(double theta) {
		// HaverSin球面距离公式
		double v = Math.sin(theta / 2);
		return v * v;
	}

	/// 将角度换算为弧度。
	private static double ConvertDegreesToRadians(double degrees) {
		return degrees * Math.PI / 180;
	}

	private static double ConvertRadiansToDegrees(double radian) {
		return radian * 180.0 / Math.PI;
	}

}
