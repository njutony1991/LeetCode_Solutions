package MaxPointsOnaLine;

public class Solution {
	class Point{
		int x;
		int y;
		Point(){x = 0;y = 0;}
		Point(int a,int b){x = a;y = b;}
	}
	 public int maxPoints(Point[] points) {
		 int ans = 0;
		 int flag = 0;
		 if(points.length == 1)
			 return 1;
	        for(int i=0;i<points.length;i++)
	        	for(int j=i+1;j<points.length;j++){
	        	if(points[i].x==points[j].x&&points[i].y==points[j].y)
	        		continue;
	        	int temp = 0;
	        	flag = 1;
	        	for(int k=0;k<points.length;k++){
	        		int left = (points[j].x-points[i].x)*(points[k].y-points[i].y);
	        		int right = (points[j].y-points[i].y)*(points[k].x-points[i].x);
	        		if(left == right) temp++;
	        	}
	        	if(temp>ans) ans = temp;
	        }
	     if(flag==0)
	    	 return points.length;
	     else
	    	 return ans;
	 }
}
