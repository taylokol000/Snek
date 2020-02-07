public class GameStates {

    public static boolean MENU=true;
    public static boolean PAUSE=false;
    public static boolean PLAY=false;
    public static boolean DEATH=false;

    public static boolean isMENU() {
        return MENU;
    }

    public static void setMENU(boolean MENU) {
        GameStates.MENU = MENU;
    }

    public static boolean isPAUSE() {
        return PAUSE;
    }

    public static void setPAUSE(boolean PAUSE) {
        GameStates.PAUSE = PAUSE;
    }

    public static boolean isPLAY() {
        return PLAY;
    }

    public static void setPLAY(boolean PLAY) {
        GameStates.PLAY = PLAY;
    }

    public static boolean isDEATH() {
        return DEATH;
    }

    public static void setDEATH(boolean DEATH) {
        GameStates.DEATH = DEATH;
    }
}
