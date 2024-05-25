package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

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

    public void applySlideInFromBottom(Node node) {
        node.setTranslateY(600);
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(node);
        transition.setDuration(Duration.seconds(4));
        transition.setFromY(600);
        transition.setToY(-10);
        transition.play();
    }
    public void applySlideInFromBottomSlow(Node node) {
        node.setTranslateY(600);
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(node);
        transition.setDuration(Duration.seconds(6));
        transition.setFromY(600);
        transition.setToY(-10);
        transition.play();
    }

    public void playSound(String soundFilePath) {
        try {
            URL resource = getClass().getResource(soundFilePath);
            Media sound = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void applyRotationAnimation(Node node) {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(node);
        rotateTransition.setDuration(Duration.seconds(2));
        rotateTransition.setFromAngle(-10);
        rotateTransition.setToAngle(10);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
    }

}

