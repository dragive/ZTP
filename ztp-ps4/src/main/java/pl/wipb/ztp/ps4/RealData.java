package pl.wipb.ztp.ps4;

import java.util.ArrayList;
import java.util.List;

// prosta implementacja danych - tablica
class RealData implements Data {

	private List<Integer> data = new ArrayList<Integer>();

	public RealData(int size) {
		int n = size;
		while(n-->0){
			data.add(0);
		}

	}

	public int get(int idx){
		return data.get(idx);
	}

	public void set(int idx, int value) {
		data.set(idx,value);
	}

	public int size() {
		return data.size();
	}

}