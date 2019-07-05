/**
 * Project 0: NBody Simulation
 * src: https://sp18.datastructur.es/materials/proj/proj0/proj0
 * @author Tao Liu 07/05/2019
 */

public class NBody {

	public static double readRadius(String dir) {
		In in = new In(dir);

		int N = in.readInt();
		double R = in.readDouble();

		return R;
	}

	public static Planet[] readPlanets(String dir) {
		In in = new In(dir);

		int N = in.readInt();
		double R = in.readDouble();
		Planet[] planets = new Planet[N];

		for (int i = 0; i < N; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xP, yP, xV, yV, m, img);
		}

		return planets; 
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = NBody.readPlanets(filename);
		double R  = NBody.readRadius(filename);

		StdDraw.setScale(-R, R);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for (Planet planet : planets) {
			planet.draw();
		}

		StdDraw.enableDoubleBuffering();

		for (double t = 0; t <= T; t += dt) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];

			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "images/stanfield.jpg");

			for (Planet planet : planets) {
				planet.draw();
			}

			StdDraw.Show();
			StdDraw.pause(10);

			StdOut.printf("%d\n", planets.length);
			StdOut.printf("%.2e\n", radius);
			for (int i = 0; i < planets.length; i++) {
				StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                		planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                 		planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
			}
		}

	}

}