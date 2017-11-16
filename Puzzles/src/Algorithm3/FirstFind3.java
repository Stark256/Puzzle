package Algorithm3;

import java.util.List;

import Algorithm1.TestColor;
import Controller.Cube;

public class FirstFind3 {
	
	private TestColor test;
	//private TC2 test;
	
	/*public FirstFind3(TC2 test){
		this.test=test;
	}*/
	public Cube findFirst(List<Cube> cubes) {
		Cube cube=null;
		for (int i = 0; i < cubes.size(); i++) {
			if (compareWithAll(cubes, cubes.get(i))) {
				cube=cubes.get(i);
			}
		}
		return cube;
	}

	public FirstFind3(TestColor test) {
		super();
		this.test = test;
	}

	private boolean compareWithAll(List<Cube> cubes, Cube cube) {
		boolean a=true;
		cube.setCurrent_orient(1);
		for (int i = 0; i < cubes.size(); i++) {
			int b = test.compareImages(cube.getImage(), cubes.get(i).getImage());
			if (b==1 || b==4){
				a = false;
				break;
			}
		}
		return a;
	}
}
