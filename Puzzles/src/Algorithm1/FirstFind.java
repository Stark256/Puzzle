package Algorithm1;

import java.util.List;

import Controller.Cube;

public class FirstFind {
	
	//private TestColor test;
	private TC test;
	/*public FirstFind(TestColor test){
		this.test=test;
	}*/
	public FirstFind(TC test){
		this.test=test;
	}
	public Cube findFirst(List<Cube> cubes) {
		Cube cube=null;
		for (int i = 0; i < cubes.size(); i++) {
			if (compareWithAll(cubes, cubes.get(i))) {
				cube=cubes.get(i);
			}
		}
		return cube;
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
