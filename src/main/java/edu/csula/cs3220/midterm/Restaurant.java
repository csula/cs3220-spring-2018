package edu.csula.cs3220.midterm;

import java.util.List;

public class Restaurant {
    public final String name;
    public final String url;
    public final List<Integer> designRatings;
    public final List<Integer> tasteRatings;

    public Restaurant(String name, String url, List<Integer> designRatings,
            List<Integer> tasteRatings) {
        this.name = name;
        this.url = url;
        this.designRatings = designRatings;
        this.tasteRatings = tasteRatings;
    }

    public double getDesignRatingAverage() {
        return getAverage(designRatings);
    }

    public double getTasteRatingsAverage() {
        return getAverage(tasteRatings);
    }

    private double getAverage(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Integer i: list) {
            sum += i;
        }
        return sum / list.size();
    }
}
