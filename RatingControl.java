/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javafx.scene.control.Control;
import javafx.scene.layout.VBox;

/**
 *
 * @author wissal
 */
public class RatingControl extends Control {

    private final VBox stars = new VBox();
    private final int maxRating = 5;
    private int rating = 0;

    public RatingControl() {
        for (int i = 1; i <= maxRating; i++) {
            RatingStar star = new RatingStar();
            star.setOnMousePressed(e -> setRating(stars.getChildren().indexOf(star) + 1));
            star.setOnMouseEntered(e -> highlightStars(stars.getChildren().indexOf(star) + 1));
            star.setOnMouseExited(e -> highlightStars(rating));
            stars.getChildren().add(star);
        }
        getChildren().add(stars);
        setPrefWidth(150);
    }

    public void setRating(int rating) {
        this.rating = rating;
        highlightStars(rating);
    }

    private void highlightStars(int highlightCount) {
        for (int i = 0; i < maxRating; i++) {
            RatingStar star = (RatingStar) stars.getChildren().get(i);
            if (i < highlightCount) {
                star.setFilled(true);
            } else {
                star.setFilled(false);
            }
        }
    }
}

