//Find the K closest points to the origin(0,0) in a 2D plane, given an array containing N points.
/*
public class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
*/
public List<Point> findKClosest(Point[] p, int k) {
	//initial capacity and comparator
	PriorityQueue<Point> pq = new PriorityQueue<Point>(10, new Comparator<Point>(){
		@Override
		public int compare(Point a, Point b){
			return (b.x*b.x+b.y*b.y)-(a.x*a.x+a.y*a.y);
		}
	});
	//maintain k smallest Point in the PriorityQueue
	for(int i=0;i<p.length;i++){
		if(i<k){
			pq.off(p[i]);
		}else{
			Point temp = pq.peak();
			if((p[i].x*p[i].x+p[i].y*p[i].y)-(temp.x*temp.x+temp.y*temp.y) < 0){
				pq.poll();
				pq.offer(p[i]);
			}
		}
	}
	List<Point> resultLst = new ArrayList<Point>();
	while(!pq.isEmpty()){
		resultLst.add(pq.poll());
	}
	return resultLst;
}
