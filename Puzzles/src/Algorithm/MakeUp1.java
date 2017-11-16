package Algorithm;

import java.util.List;

import Controller.Cube;

public class MakeUp1 {
	private ColorTest colorTest;

	private boolean find = true;

	private List<Cube> cubes;

	private int index = 1;

	public MakeUp1(ColorTest colorTest, List<Cube> cubes) {
		this.colorTest = colorTest;
		this.cubes = cubes;
	}
	
	public void findAll() {
		for(int y = 0; y<4;y++){
			for(int x = 1; x<4;x++){
				findOne(x,y);
			}
		}
		
	}
	
	public void findOne(int x, int y){
		
	}
}
