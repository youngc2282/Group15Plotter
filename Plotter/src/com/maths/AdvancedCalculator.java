package com.maths;

public class AdvancedCalculator {

	public AdvancedCalculator() {
	};

	static double num = 1000;

	public static double df(double x, Calculator calc) {

		double total = 0;

		double dx = 0.001;
		double i_2dx = 500;

		// total=(calc.f(x+dx)-calc.f(x-dx))/(2*dx);
		total = (calc.f(x + dx) - calc.f(x - dx)) * i_2dx;
		return total;

	}

	/*
	 * This code was recreated below by MBF on 2017-12-03
	 * 
	 * public static double simpsonIntegral(Calculator calc){
	 * 
	 * double total=0;
	 * 
	 * double x1=calc.a; double x2=calc.b;
	 * 
	 * double s = calc.f(x1) - calc.f(x2);
	 * 
	 * int num=1000; // Number of intervals
	 * 
	 * double dx=(x2-x1)/num; // Width double dx_6=dx/6.0;
	 * 
	 * for(double x=x1;x<x2;x=x+dx){
	 * 
	 * //total+=dx*(calc.f(x)+calc.f(x+dx)+4*calc.f((x*2+dx)/2.0))/6.0;
	 * total+=calc.f(x)+calc.f(x+dx)+4*calc.f((x*2+dx)*0.5); }
	 * 
	 * 
	 * return total*dx_6;
	 * 
	 * }
	 */

	public static double simpsonIntegral(Calculator calc) {
		double a = calc.a; // Starting point
		double b = calc.b; // End point
		double dx = (b - a) / (2 * num); // Interval width;

		double s = calc.f(a) - calc.f(b);

		int i = 1;
		double x;

		while (i <= 2 * num - 1) {
			x = a + dx * i;
			s += 4 * calc.f(x) + 2 * calc.f(x + dx);
			i += 2;
		}
		return s * dx / 3;

	}

	/*
	 * This code was recreated below by MBF on 2017-12-03
	 * 
	 * public static double trapeziumIntegral(Calculator calc){
	 * 
	 * double total=0;
	 * 
	 * double x1=calc.a; double x2=calc.b;
	 * 
	 * int num=1000;
	 * 
	 * double dx=(x2-x1)/num; double dx_2=dx/2;
	 * 
	 * for(double x=x1;x<x2;x=x+dx){
	 * 
	 * //total+=dx*(calc.f(x+dx)-calc.f(x-dx))/2; total+=(calc.f(x+dx)+calc.f(x)); }
	 * 
	 * 
	 * return total*dx_2;
	 * 
	 * }
	 */

	public static double trapeziumIntegral(Calculator calc) {

		double a = calc.a; // Starting point
		double b = calc.b; // End point
		double dx = (b - a) / num; // Interval width

		double sum = 0.5 * (calc.f(a) + calc.f(b)); // Area

		for (int i = 1; i < num; i++) {
			double x = a + dx * i;
			sum = sum + calc.f(x);
		}

		return sum * dx;
	}

	public static double gaussIntegral(Calculator calc) {

		double total = 0;

		double x1 = calc.a;
		double x2 = calc.b;


		double dx = (x2 - x1) / num;
		double dx_2 = dx / 2;

		double[] xrg = { -Math.sqrt((35 + 2 * Math.sqrt(70)) / 63.0), -Math.sqrt((35 - 2 * Math.sqrt(70)) / 63.0), 0,
				Math.sqrt((35 - 2 * Math.sqrt(70)) / 63.0), Math.sqrt((35 + 2 * Math.sqrt(70)) / 63.0) };

		double[] bg = { (-455 + 161 * Math.sqrt(70)) / (450 * Math.sqrt(70)),
				(455 + 161 * Math.sqrt(70)) / (450 * Math.sqrt(70)), 128.0 / 225.0,
				(455 + 161 * Math.sqrt(70)) / (450 * Math.sqrt(70)),
				(-455 + 161 * Math.sqrt(70)) / (450 * Math.sqrt(70))

		};

		for (double x = x1; x < x2; x = x + dx) {

			for (int j = 0; j < xrg.length; j++) {

				double xg = xrg[j] * (dx) * 0.5 + (2 * x + dx) * 0.5;
				total += bg[j] * calc.f(xg);
			}
		}

		return total * dx_2;

	}

}
