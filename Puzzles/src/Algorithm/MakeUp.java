package Algorithm;

import java.util.ArrayList;
import java.util.List;

import Controller.Cube;

public class MakeUp {

	private ColorTest colorTest;

	private boolean find = true;

	private List<Cube> cubes;

	private int index = 1;

	public MakeUp(ColorTest colorTest, List<Cube> cubes) {
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
		int index= -1;
		List<Cube> list = new ArrayList<>();
		Cube cube = findOneByCurrentXY(x, y);
		for (int i = 1; i < cubes.size(); i++) {
			System.out.print(".");
			if (compareTopLeft(cubes.get(i), x, y)){
				list.add(cubes.get(i));
				System.out.println();
				System.out.println(x+"|"+y+"----"+index);
				index++;
			}
		}
		if(index>=0)
		change(list.get(index),x,y);
	}
	
	
	////////////////
	private boolean compareLeft(Cube cube, int x, int y){
		if(x==0)
			return true;
		if(colorTest.compareImages(findOneByCurrentXY(x - 1, y).getImage(), cube.getImage())==4)
			return true;
		return false;

	}
	
private boolean compareTop(Cube cube, int x, int y){
		
	if(y==0)
		return true;
	if(colorTest.compareImages(findOneByCurrentXY(x , y-1).getImage(), cube.getImage())==1)
		return true;
	return false;
	}

private boolean compareTopLeft(Cube cube, int x, int y){
	return compareLeft(cube, x, y)&&compareTop(cube, x, y);
}
	
/////////////////////////
	

	private Cube findOneByCurrentXY(int x, int y) {
		for (int i = 0; i < cubes.size(); i++) {
			if (cubes.get(i).getCurrent_X() == x && cubes.get(i).getCurrent_Y() == y) {
				return cubes.get(i);
			}
		}
		return null;
	}

	private void change(Cube cube, int x, int y) {
		Cube cube1 = findOneByCurrentXY(x, y);

		int xx = cube.getCurrent_X();
		int yy = cube.getCurrent_Y();

		cube.setCurrent_X(cube1.getCurrent_X());
		cube.setCurrent_Y(cube1.getCurrent_Y());

		cube1.setCurrent_X(xx);
		cube1.setCurrent_Y(yy);
	}

	private void change(Cube cube, Cube cube1) {
		int xx = cube.getCurrent_X();
		int yy = cube.getCurrent_Y();

		cube.setCurrent_X(cube1.getCurrent_X());
		cube.setCurrent_Y(cube1.getCurrent_Y());

		cube1.setCurrent_X(xx);
		cube1.setCurrent_Y(yy);
	}
}
