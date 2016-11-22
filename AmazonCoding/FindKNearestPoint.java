import java.util.PriorityQueue;
import java.util.Comparator;


class Point{
  double x;
  double y;
  Point(double x,double y){
    this.x = x;
    this.y = y;
  }
}

public class FindKNearestPoint{
  public Point[] solution(Point[] array, Point origin, int k){
    Point[] result = new Point[k];
    PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>(){
      @Override
      public int compare(Point a, Point b){
        if (getDistance(a,origin) > getDistance(b,origin)){
          return 1;
        }else if(getDistance(a,origin) == getDistance(b,origin)){
          return 0;
        }else{
          return -1;
        }
      }
    });
    for (int i = 0; i < arrays.length; i++){
      pq.offer(array[i]);
      if (pq.size() > k){
        pq.poll();
      }
    }
    int index = 0;
    while (!pq.isEmpty()){
      result[index] = pq.poll();
      index++;
    }

    return result;
  }

  private double getDistance(Point a, Point origin){
    return Math.sqrt((a.x-origin.x)*(a.x-origin.x) + (a.y-origin.y)*(a.y-origin.y));
  }

  public static void main(String[] args){
    // java8 new feature lambda function
    //PriorityQueue<String> pq = new PriorityQueue<String>(5, (a,b)->b.length() - a.length());
    pq.add("Apple");
    pq.add("PineApple");
    pq.add("Custard Apple");
    pq.add("gApple");
    pq.add("adneApple");
    pq.add("adneAppasssssssssle");
    System.out.println(pq.toString());
    while(!pq.isEmpty()){
      System.out.println(pq.poll());
    }

  }
}
