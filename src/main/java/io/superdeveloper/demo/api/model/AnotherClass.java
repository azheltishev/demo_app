package io.superdeveloper.demo.api.model;

public class AnotherClass {

    public Boolean validDivide(double a, double b) {
        if (b == 0.0) {
            return false;
        }

        try {
            divide(a, b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }


    public double divide(double a, double b) throws Exception {
        if (b == 0.0) {
            throw new Exception("b cannot be 0");
        }

        return a / b;
    }
}
