public class Polynomial {
    private double[] coefficients;
    public Polynomial() {
        this.coefficients = new double[]{0};
    }
    public Polynomial(double[] coefficients) {
        if (coefficients == null || coefficients.length == 0) {
            this.coefficients = new double[]{0};
        } else {
            this.coefficients = coefficients.clone();
        }
    }
    public Polynomial add(Polynomial p) {
        if (p == null) {
            return new Polynomial(this.coefficients.clone());
        }
        int max_len = Math.max(this.coefficients.length, p.coefficients.length);
        double[] result = new double[max_len];
        for (int i = 0; i < max_len; i++) {
            double x, y;
            if (i < this.coefficients.length) {
                x = this.coefficients[i];
            } else {
                x = 0;
            }
            if (i < p.coefficients.length) {
                y = p.coefficients[i];
            } else {
                y = 0;
            }
            result[i] = x + y;
        }
        return new Polynomial(result);
    }
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i]*Math.pow(x, i);
        }
        return result;
    }
    public boolean hasRoot(double x) {
        double result = evaluate(x);
        if (result == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

