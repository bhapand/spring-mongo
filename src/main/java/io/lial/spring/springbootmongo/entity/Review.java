package io.lial.spring.springbootmongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

public class Review {

    private String userName;
    private int rating;
    private boolean approved;

    public Review() {
    }

    public Review(String userName, int rating, boolean approved) {
        this.userName = userName;
        this.rating = rating;
        this.approved = approved;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public boolean isApproved() {
        return approved;
    }

    @Override
    public String toString() {
        return "Review{" +
                "userName='" + userName + '\'' +
                ", rating='" + rating + '\'' +
                ", approved=" + approved +
                '}';
    }
}
