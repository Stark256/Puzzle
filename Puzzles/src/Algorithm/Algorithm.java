package Algorithm;

import java.awt.image.BufferedImage;
import java.util.List;

import Controller.Cube;

public class Algorithm {

	private int colorDef = 10;

	private double pixelKoef = 0.23;

	private ColorTest colorTest;

	private FindFirst findFirst;

	public Algorithm() {
		colorTest = new ColorTest();
		findFirst = new FindFirst(colorTest);
	}

	public void getThrough(List<Cube> cubes) {
		// System.out.println(colorTest.compareImages(findOneByCurrentXY(cubes,
		// 1, 1).getImage(),findOneByCurrentXY(cubes, 2, 2).getImage()));
		// System.out.println("-------------------------------------");
		// findAndReplaceFirst(cubes);
		Cube cube = findFirst.findFirst(cubes);
		if (cube != null)
			change(cubes, cube, 0, 0);
		// System.out.println(testFirst(cubes, findOneByCurrentXY(cubes, 2, 1),
		// 1, 1));
	}

	private boolean test(List<Cube> cubes, Cube cube, int x, int y) {
		return testOne(cubes, cube, x, y);
	}

	private boolean findAndReplaceFirst(List<Cube> cubes) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (testOneFirstWithAll(cubes, findOneByCurrentXY(cubes, i, j))) {
					change(cubes, findOneByCurrentXY(cubes, i, j), 0, 0);
					return true;
				}
			}
		}
		return false;
	}

	private boolean testOneFirstWithAll(List<Cube> cubes, Cube cube) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i != 0 && j != 0) {
					if (!testFirst(cubes, cube, i, j)) {
						System.out.println("x=" + i + "y=" + j);
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean testOne(List<Cube> cubes, Cube cube, int x, int y) {
		return topSide(cubes, cube, x, y) && leftSide(cubes, cube, x, y);
	}

	private boolean testFull(List<Cube> cubes, Cube cube, int x, int y) {
		return topSide(cubes, cube, x, y) && leftSide(cubes, cube, x, y) && rightSide(cubes, cube, x, y)
				&& boottomSide(cubes, cube, x, y);
	}

	private boolean testFirst(List<Cube> cubes, Cube cube, int x, int y) {

		Cube rCube = findOneByCurrentXY(cubes, x, y);

		BufferedImage image = cube.getImage();
		BufferedImage rImage = rCube.getImage();

		boolean top = colorTest.compareColors(colorTest.getTopColors(image), colorTest.getBottomColors(rImage));
		// boolean right = compareColors(getColorsByX(image, image.getWidth() -
		// 1), getColorsByX(rImage, 0));
		// boolean bottom = compareColors(getColorsByY(image, image.getWidth() -
		// 1), getColorsByY(rImage, 0));
		boolean left = colorTest.compareColors(colorTest.getLeftColors(image), colorTest.getRightColors(rImage));

		return top || left;
	}

	private boolean rightSide(List<Cube> cubes, Cube cube, int x, int y) {
		////////////////////////
		System.out.print("right ");
		if (x != 3) {
			Cube rCube = findOneByCurrentXY(cubes, x + 1, y);
			BufferedImage image = cube.getImage();
			BufferedImage rImage = rCube.getImage();
			return colorTest.compareColors(colorTest.getRightColors(image), colorTest.getLeftColors(rImage));

		}
		return true;
	}

	private boolean topSide(List<Cube> cubes, Cube cube, int x, int y) {
		////////////////////////
		System.out.print("top ");
		if (y != 0) {
			Cube rCube = findOneByCurrentXY(cubes, x, y - 1);
			BufferedImage image = cube.getImage();
			BufferedImage rImage = rCube.getImage();
			return colorTest.compareColors(colorTest.getTopColors(image), colorTest.getBottomColors(rImage));
		}
		return true;
	}

	private boolean leftSide(List<Cube> cubes, Cube cube, int x, int y) {
		////////////////////////
		System.out.print("left ");
		if (x != 0) {
			Cube rCube = findOneByCurrentXY(cubes, x - 1, y);
			BufferedImage image = cube.getImage();
			BufferedImage rImage = rCube.getImage();
			return colorTest.compareColors(colorTest.getLeftColors(image), colorTest.getRightColors(rImage));
		}
		return true;
	}

	private boolean boottomSide(List<Cube> cubes, Cube cube, int x, int y) {
		////////////////////////
		System.out.print("bot ");
		if (y != 3) {
			Cube rCube = findOneByCurrentXY(cubes, x, y + 1);
			BufferedImage image = cube.getImage();
			BufferedImage rImage = rCube.getImage();
			return colorTest.compareColors(colorTest.getBottomColors(image), colorTest.getTopColors(rImage));
		}
		return true;
	}

	private Cube findOneByCurrentXY(List<Cube> cubes, int x, int y) {
		for (int i = 0; i < cubes.size(); i++) {
			if (cubes.get(i).getCurrent_X() == x && cubes.get(i).getCurrent_Y() == y) {
				return cubes.get(i);
			}
		}
		return null;
	}

	private void change(List<Cube> cubes, Cube cube, int x, int y) {
		Cube cube1 = findOneByCurrentXY(cubes, x, y);

		int xx = cube.getCurrent_X();
		int yy = cube.getCurrent_Y();

		cube.setCurrent_X(cube1.getCurrent_X());
		cube.setCurrent_Y(cube1.getCurrent_Y());
		cube.setCurrent_orient(1);
		
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
