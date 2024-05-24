package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class AnimationManager {

    private static AnimationManager instance;


    private AnimationManager() {
    }

    public static AnimationManager getInstance() {
        if (instance == null) {
            instance = new AnimationManager();
        }
        return instance;
    }

    public void applyFloatingAnimation(Node node) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(node);
        transition.setDuration(Duration.seconds(2));
        transition.setByY(-10);
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();
    }

    /**
     TranslateTransition: Esta clase se utiliza para crear una animación de transición de traslación.

     setNode: Establece el nodo que se va a animar, en este caso, imgLogo.

     setDuration: Establece la duración de una repetición completa de la animación (2 segundos en este ejemplo).

     setByY: Establece la cantidad de traslación en el eje Y (en este caso, se moverá 20 píxeles hacia arriba).

     setAutoReverse: Hace que la animación se revierta automáticamente una vez que haya alcanzado el final de su duración.

     setCycleCount: Establece el número de veces que se repetirá la animación (INDEFINITE hace que la animación se repita indefinidamente).

     play: Inicia la animación.
     */


    public void applyFadeAnimation(Node node) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(node);
        fadeTransition.setDuration(Duration.seconds(1.0));
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.6);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
        fadeTransition.play();
    }

    public void setCustomCursor(Node node, String imagePath) {
        try {

            double width = 3;
            double height = 3;
            Image cursorImage = new Image(getClass().getResourceAsStream(imagePath));
            if (cursorImage.isError()) {
                throw new IllegalArgumentException("Error loading image for cursor: " + imagePath);
            }

            ImageCursor customCursor = new ImageCursor(cursorImage, width, height);
            node.setCursor(customCursor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

