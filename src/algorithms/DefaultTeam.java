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

		double xMin = 99999;
		double yMin = 99999;
		double xMax = 0;
		double yMax = 0;

		for (Point thePoint : points) {
			if (thePoint.x < xMin) {
				xMin = thePoint.x;
			}
			if (thePoint.x > xMax) {
				xMax = thePoint.x;
			}
			if (thePoint.y < yMin) {
				yMin = thePoint.y;
			}
			if (thePoint.y > yMax) {
				yMax = thePoint.y;
			}
		}

		System.out.println("xMin : " + xMin + " xMax : " + xMax + " Ymin : " + yMin + " Ymax : " + yMax);

		Point pointA = new Point();
		pointA.setLocation(xMin, yMin);

		Point pointB = new Point();
		pointB.setLocation(xMax, yMax);
		
		Point pointMaxA = null;
		Point pointMaxI = null;
		
		double distancePlusLong = 0;

		for (int a = 0; a < points.size(); a++) {
			for (int i = 0; i < points.size(); i++) {
				double distanceActuel = points.get(a).distance(points.get(i));
				if (distanceActuel > distancePlusLong) {
					distancePlusLong = distanceActuel;
					pointMaxA = points.get(a);
					pointMaxI = points.get(i);
				}
			}
		}

		double DistanceAB = pointMaxA.distance(pointMaxI);
		DistanceAB = DistanceAB / 2;

		double theX = (xMin + xMax) / 2;
		double theY = (yMin + yMax) / 2;

		Point pointCentre = new Point();
		pointCentre.setLocation(theX, theY);

//		double distancePlusLong = 0;
//
//		Point pointMaxA = null;
//		Point pointMaxI = null;
//
//		for (int a = 0; a < points.size(); a++) {
//			for (int i = 0; i < points.size(); i++) {
//				double distanceActuel = points.get(a).distance(points.get(i));
//				if (distanceActuel > distancePlusLong) {
//					distancePlusLong = distanceActuel;
//					pointMaxA = points.get(a);
//					pointMaxI = points.get(i);
//				}
//			}
//		}
//
//		Point pointMilieu;
//		double resultY = 0, resultX = 0, miniX = 0, miniY = 0;
//
//		if (pointMaxA.getY() < pointMaxI.getY()) {
//			resultY = pointMaxI.getY() - pointMaxA.getY();
//			miniY = pointMaxI.getY();
//		} else {
//			resultY = pointMaxA.getY() - pointMaxI.getY();
//			miniY = pointMaxA.getY();
//		}
//
//		if (pointMaxA.getX() < pointMaxI.getX()) {
//			resultY = pointMaxI.getX() - pointMaxA.getX();
//			miniX = pointMaxI.getY();
//		} else {
//			resultY = pointMaxA.getX() - pointMaxI.getX();
//			miniX = pointMaxA.getY();
//		}
//
////		resultY = resultY / 2;
////		resultX = resultX / 2;
//
//		Point pointGeneric = new Point();
//		pointGeneric.setLocation(resultX / 2 + miniX, resultY / 2 - miniY);
//
////		for (Point thePoint : points) {
////			double theDistance = thePoint.getX() - resultX;
////		}
//
//		Point thePoint = null;
//
//		double distanceMinPointGenerric = 999999999;
//		for (int b = 0; b < points.size(); b++) {
//			double theDistance = pointGeneric.distance(points.get(b));
//			if (theDistance < distanceMinPointGenerric) {
//				distanceMinPointGenerric = theDistance;
//				thePoint = points.get(b);
//			}
//		}

//		Point center = thePoint;
//		int radius = (int) distancePlusLong / 2;

		Point center = pointCentre;
		int radius = (int) DistanceAB;

		/*******************
		 * PARTIE A ECRIRE *
		 *******************/

		return new Circle(center, radius);
	}
}
