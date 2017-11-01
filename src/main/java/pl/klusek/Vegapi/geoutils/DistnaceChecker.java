package pl.klusek.Vegapi.geoutils;

import pl.klusek.Vegapi.models.Local;

public class DistnaceChecker {

	public static boolean checkIfLocWithinRange(Local myLoc, Local otherLoc, double distnace) {
		
		double przelicznikNS = 0.009;
		double przelicznikEW = 0.015;
		double distanceX = 0;
		double distanceY = 0;
		
		if (otherLoc.getxGPS() < myLoc.getxGPS()) {
			distanceX = Math.abs(otherLoc.getxGPS() - myLoc.getxGPS());
		} else {
			distanceX = Math.abs(myLoc.getxGPS() - otherLoc.getxGPS());
		}
		
		if (otherLoc.getyGPS() < myLoc.getyGPS()) {
			distanceY = Math.abs(otherLoc.getyGPS() - myLoc.getyGPS());
		} else {
			distanceY = Math.abs(myLoc.getyGPS() - otherLoc.getyGPS());
		}
		
		double realDistanceX = distanceX / przelicznikNS;
		double realDistanceY = distanceY / przelicznikEW;
		
		double realDistance = Math.sqrt(Math.pow(realDistanceX, 2) + Math.pow(realDistanceY, 2));
		System.out.println("realDistX: " + realDistanceX);
		System.out.println("realDistY: " + realDistanceY);
		System.out.println("realDist:  " + realDistance);
		return realDistance <= distnace;
		
	}
	
}
