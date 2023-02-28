/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author wissal
 */
public class RatingStar extends Region {

    private final double starWidth = 24;
    private final double starHeight = 24;
    private final double[] starPoints = new double[] {
            12, 0,
            15, 9,
            24, 9,
            18, 15,
            21, 24,
            12, 18,
            3, 24,
            6, 15,
            0, 9,
            9, 9
    };
    private final Polygon starShape = new Polygon(starPoints);

    public RatingStar() {
        setPrefSize(starWidth, starHeight);
        getChildren().add(starShape);
    }

    public void setFilled(boolean filled) {
        starShape.setFill(filled ? Color.YELLOW : Color.TRANSPARENT);
    }
}
