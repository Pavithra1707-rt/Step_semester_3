package Week_9.class_problems;

import java.util.Scanner;

abstract class Plot {
    abstract double calculateArea();
}

class CirclePlot extends Plot {
    double radius;


    CirclePlot(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }


}

class RectanglePlot extends Plot {
    double length, width;


    RectanglePlot(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }


}

class TrianglePlot extends Plot {
    double base, height;


    TrianglePlot(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }


}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String owner = sc.next();

            Plot plot;

            if (type.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plot = new CirclePlot(radius);
            } else if (type.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plot = new RectanglePlot(length, width);
            } else {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plot = new TrianglePlot(base, height);
            }

            double area = plot.calculateArea();
            totalArea += area;

            System.out.printf("%s (%s): %.2f%n", owner, type, area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }


}
