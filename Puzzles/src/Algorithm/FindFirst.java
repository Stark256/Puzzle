package Algorithm;

import java.util.ArrayList;
import java.util.List;

import Controller.Cube;

public class FindFirst {

	private ColorTest colorTest;
	
	private boolean find = true;
	
	private List<Cube> cc;
	
	private int index = -1;

	public FindFirst(ColorTest colorTest) {
		this.colorTest = colorTest;
		cc=new ArrayList<>();
	}

	public Cube findFirst(List<Cube> cubes) {
		if(find){
		for (int i = 0; i < cubes.size(); i++) {
			if (compareWithAll(cubes, cubes.get(i))) {
				cc.add(cubes.get(i));
				index++;
			}
		}
		find= false;
		}
		Cube cube = null;
		if(index!=-1){
			cube = cc.get(index);}
		//cc.remove(index);
		if(index>0)
			index--;
		return cube;
	}

	private boolean compareWithAll(List<Cube> cubes, Cube cube) {
		boolean a = true;
		cube.setCurrent_orient(1);
		for (int i = 0; i < cubes.size(); i++) {
			int b = colorTest.compareImages(cube.getImage(), cubes.get(i).getImage());
			if (b == 1 || b == 4)
				a = false;
		}
		//System.out.println(a + "(" + cube.getCurrent_X() + "|" + cube.getCurrent_Y() + ")");

		return a;
	}

}
