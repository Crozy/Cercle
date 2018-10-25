package algorithms;

import java.awt.Point;
import java.util.ArrayList;

/***************************************************************
 * TME 1: calcul de diamètre et de cercle couvrant minimum.    *
 *   - Trouver deux points les plus éloignés d'un ensemble de  *
 *     points donné en entrée.                                 *
 *   - Couvrir l'ensemble de poitns donné en entrée par un     *
 *     cercle de rayon minimum.                                *
 *                                                             *
 * class Circle:                                               *
 *   - Circle(Point c, int r) constructs a new circle          *
 *     centered at c with radius r.                            *
 *   - Point getCenter() returns the center point.             *
 *   - int getRadius() returns the circle radius.              *
 *                                                             *
 * class Line:                                                 *
 *   - Line(Point p, Point q) constructs a new line            *
 *     starting at p ending at q.                              *
 *   - Point getP() returns one of the two end points.         *
 *   - Point getQ() returns the other end point.               *
 ***************************************************************/
import supportGUI.Circle;
import supportGUI.Line;

public class DefaultTeam {

	// calculDiametre: ArrayList<Point> --> Line
	// renvoie une paire de points de la liste, de distance maximum.
	public Line calculDiametre(ArrayList<Point> points) {
		if (points.size() < 3) {
			return null;
		}

		Point p = points.get(0);
		Point q = points.get(1);

		/*******************
		 * PARTIE A ECRIRE *
		 *******************/

		return new Line(p, q);
	}

	// calculCercleMin: ArrayList<Point> --> Circle
	// renvoie un cercle couvrant tout point de la liste, de rayon minimum.
	public Circle calculCercleMin(ArrayList<Point> points) {
		if (points.isEmpty()) {
			return null;
		}

		double distancePlusLong = 0;
		Point pointDummy = points.get(0);
		Point pointP = new Point();
		Point pointQ = new Point();

		// Cherche le point P qui sera le point le plus loin du point Dummy
		for (int a = 0; a < points.size(); a++) {
			double distanceActuel = pointDummy.distance(points.get(a));
			if (distanceActuel > distancePlusLong) {
				distancePlusLong = distanceActuel;
				pointP = points.get(a);
			}
		}

		distancePlusLong = 0;

		// Cherche le point Q qui sera le point le plus loin du point P
		for (int a = 0; a < points.size(); a++) {
			double distanceActuel = pointP.distance(points.get(a));
			if (distanceActuel > distancePlusLong) {
				distancePlusLong = distanceActuel;
				pointQ = points.get(a);
			}
		}

		Point pointC = new Point();

		double myX = (pointP.getX() + pointQ.getX()) / (double) 2;
		double myY = (pointP.getY() + pointQ.getY()) / (double) 2;

		pointC.setLocation(myX, myY);

		double rayonCP = pointC.distance(pointP);

		Point center = pointC;
		int radius = (int) rayonCP;

		/*******************
		 * PARTIE A ECRIRE *
		 *******************/

		return new Circle(center, radius);
	}
}
