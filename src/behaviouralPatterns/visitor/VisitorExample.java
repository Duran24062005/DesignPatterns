import java.util.ArrayList;
import java.util.List;

public class VisitorExample {

    interface Shape {
        void accept(ShapeVisitor visitor);
    }

    static class Circle implements Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        double getRadius() {
            return radius;
        }

        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class Rectangle implements Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        double getWidth() { return width; }
        double getHeight() { return height; }

        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visit(this);
        }
    }

    interface ShapeVisitor {
        void visit(Circle circle);
        void visit(Rectangle rectangle);
    }

    static class AreaCalculator implements ShapeVisitor {
        private double totalArea;

        @Override
        public void visit(Circle circle) {
            totalArea += Math.PI * circle.getRadius() * circle.getRadius();
        }

        @Override
        public void visit(Rectangle rectangle) {
            totalArea += rectangle.getWidth() * rectangle.getHeight();
        }

        double getTotalArea() {
            return totalArea;
        }
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(3, 4));

        AreaCalculator calculator = new AreaCalculator();
        for (Shape shape : shapes) {
            shape.accept(calculator);
        }

        System.out.println("Total area: " + calculator.getTotalArea());
    }
}
