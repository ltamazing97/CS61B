/**
 * Project 0: NBody Simulation
 * src: https://sp18.datastructur.es/materials/proj/proj0/proj0
 * @author Tao Liu 07/04/2019
 */

public class Planet {

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
				double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/**
	 * Initialize an identical Planet object
	 * @param Planet Object p
	 * @return none
	 */
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/**
	 * calculate the distance between two planets
	 * @param  p [description]
	 * @return   [description]
	 */
	public double calcDistance(Planet p) {
		double squaredist = Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos,2);
		return Math.sqrt(squaredist);
	}

	/**
	 * [calcForceExertedBy description]
	 * @param  p [description]
	 * @return   [description]
	 */
	public double calcForceExertedBy(Planet p) {
		double G = 6.67e-11;
		return G * this.mass * p.mass / Math.pow(calcDistance(p), 2); 
	}

	/**
	 * [calcForceExertedByX description]
	 * @param  p [description]
	 * @return   [description]
	 */
	public double calcForceExertedByX(Planet p) {
		double F = this.calcForceExertedBy(p);
		double r = this.calcDistance(p);
		double dx = p.xxPos - this.xxPos;
		return F * dx / r;
	}

	public double calcForceExertedByY(Planet p) {
		double F = this.calcForceExertedBy(p);
		double r = this.calcDistance(p);
		double dy = p.yyPos - this.yyPos;
		return F * dy / r;
	}

	public double calcNetForceExertedByX(Planet[] Ps) {
		double Fx = 0;
		for (Planet s : Ps) {
			if(!this.equals(s)) {
				Fx += this.calcForceExertedByX(s);
			}
		}
		return Fx;
	}

	public double calcNetForceExertedByY(Planet[] Ps) {
		double Fy = 0;
		for (Planet s : Ps) {
			if(!this.equals(s)) {
				Fy += this.calcForceExertedByY(s);
			}
		}
		return Fy;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		
		this.xxVel = this.xxVel + dt * aX;
		this.yyVel = this.yyVel + dt * aY;

		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
	}

}