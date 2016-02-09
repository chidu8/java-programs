package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Compute area of skyline. Uses concept of Riemann sums (Line sweep approach with decomposition into events)
 */

public class SkylineProblem {

	public class Triplet {
		int xSt,xEnd,h;
		public Triplet (int xSt,int xEnd,int h) {
			this.xSt=xSt;
			this.xEnd=xEnd;
			this.h=h;
		}
	}
	
	public class Event implements Comparable<Event> {
		int x;
		boolean start;
		int h;
		public Event (int x,boolean start,int h) {
			this.x=x;
			this.start=start;
			this.h=h;
		}
		@Override
		public int compareTo(Event o) {
			return Integer.valueOf(this.x).compareTo(Integer.valueOf(o.x));
		}
	}
	
	public static List<Event> getSortedEvents(List<Triplet> list) {
		List<Event> eventList = new ArrayList<Event>();
		SkylineProblem s = new SkylineProblem();
		for(Triplet t:list) {
			eventList.add(s.new Event(t.xSt,true,t.h));
			eventList.add(s.new Event(t.xEnd,false,t.h));
		}
		Collections.sort(eventList);
		return eventList;
	}
	
	public static int findAreaOfSkyline(List<Triplet> list) {
		List<Event> eventList = getSortedEvents(list);
		int area = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		maxHeap.add(0);
		int lastX=0;
		for (Event e : eventList) {
			area = area + (e.x-lastX) * maxHeap.peek();
			lastX=e.x;
			if(e.start) {
				maxHeap.add(e.h);
			}
			else {
				maxHeap.remove(e.h);
			}
		}
		return area;
	}
	
	public static void main(String[] args) {
		List<Triplet> list = new ArrayList<Triplet>();
		SkylineProblem s = new SkylineProblem();
		list.add(s.new Triplet(0,5,5));
		list.add(s.new Triplet(2,5,7));
		list.add(s.new Triplet(7,12,2));
		list.add(s.new Triplet(10,11,15));
		System.out.println(findAreaOfSkyline(list));
	}
}
