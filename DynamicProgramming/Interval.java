import java.util.*;
public class Interval{
	public int start;
	public int end;
	Interval(){start=0;end=0;}
	Interval(int s,int e){start=s;end=e;}
	
	public static List<Interval> merge(List<Interval> intervals){
		int first=0;
		int second=0;
		int i=0;
         		for(;i<=intervals.size()-1;){
         		    if(intervals.size()==1)break;
         		    if(i==0){
         		    	first=intervals.get(i).start;
        	            second=intervals.get(i).end;
        	            i++;
         		    }else if(second >= intervals.get(i).start&&i>0){
        	                if(second <=intervals.get(i).end){
        	                    intervals.get(i-1).end=intervals.get(i).end;
        	                }
        	                intervals.remove(i);
        	                i=i-1;
        	                first=intervals.get(i).start;
        	                second=intervals.get(i).end;
        	                //  System.out.println("merging");
        	                // System.out.println("first:"+first+"end:"+second);
        	                // print(intervals);
        	                i++;
        	                if(i==intervals.size()-1)break;
         		    }else{
        	            first=intervals.get(i).start;
        	            second=intervals.get(i).end;
        	            i++;
        	        }
        	  
        		}
    		return intervals;
    } 

    //   public List<Interval> merge(List<Interval> intervals) {
    //             if(intervals == null || intervals.size() <= 1) return intervals;
    //                   Collections.sort(intervals, new Comparator<Interval>() {
    //                       public int compare(Interval a, Interval b) {
    //                           return Integer.compare(a.start, b.start);
    //                       }
    //                     });
    //                 List<Interval> res = new ArrayList<Interval>();
    //             Interval cur = intervals.get(0);
    //             for(int i=1;i<intervals.size();i++){
    //                 if(intervals.get(i).start<=cur.end){
    //                     cur.end=Math.max(cur.end,intervals.get(i).end);
    //                 }else{
    //                     res.add(cur);
    //                     cur=intervals.get(i);
    //                 }
    //             }
    //             res.add(cur);
    //     		return res;
    // }

	
	public String getInside(){
		return start+ " + "+end;
		}
	public static void print(List<Interval> myList){
			for(Interval interval:myList){
				System.out.println(interval.getInside());
			}
		}	

	public static void main(String[] args){
		List<Interval> myList = new ArrayList<Interval>();
		myList.add(new Interval(0,0));
		myList.add(new Interval(4,5));
		myList.add(new Interval(2,4));
		myList.add(new Interval(4,6));
		myList.add(new Interval(3,4));
		myList.add(new Interval(1,1));
		myList.add(new Interval(3,5));
		myList.add(new Interval(2,2));
		myList.sort(Comparator.comparing(e->e.start));
		print(myList);
		merge(myList);
		print(myList);
	}
}
