package Algorithm2;

import java.util.List;

import Controller.Cube;

public class Algo2 {

//	private TestColor test;
	private TC2 test;
	private FirstFind2 first;
	
	public Algo2(){
	//	test=new TestColor();
		test=new TC2();
		first=new FirstFind2(test);
	}
	
	public void maleUpCorrect(List<Cube> cubes){
		Cube firstCube=first.findFirst(cubes);
		change(firstCube,findOneCubeByXY(cubes,0,0));
		makeUp(cubes);
	}
	
	
	public void makeUp(List<Cube> cubes){
	/*	for(int i=0;i<cubes.size();i++){
			Cube cube,
		}*/
		
		for(int y=0;y<4;y++){
			for(int x=0;x<4;x++){
				for(int i=0;i<cubes.size();i++){
					if(x!=0){
						//left
						if(test.compareImages(cubes.get(i).getImage(),findOneCubeByXY(cubes,x-1,y).getImage())==4){
							change(cubes.get(i),findOneCubeByXY(cubes,x,y));
						}
					}
					if(y!=0){
						//top
						if(test.compareImages(cubes.get(i).getImage(),findOneCubeByXY(cubes,x,y-1).getImage())==1){
							change(cubes.get(i),findOneCubeByXY(cubes,x,y));
						}
						
					}
				}
			}
		}
	}
	
	private Cube findOneCubeByXY(List<Cube> cubes,int x,int y){
		for (int i = 0; i < cubes.size(); i++) {
			if (cubes.get(i).getCurrent_X() == x && cubes.get(i).getCurrent_Y() == y) {
				return cubes.get(i);
			}
		}
		return null;
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
