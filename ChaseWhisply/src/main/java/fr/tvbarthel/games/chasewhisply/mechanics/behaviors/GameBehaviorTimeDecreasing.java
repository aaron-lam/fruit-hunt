package fr.tvbarthel.games.chasewhisply.mechanics.behaviors;

import fr.tvbarthel.games.chasewhisply.ui.gameviews.GameViewVitaminBars;

public abstract class GameBehaviorTimeDecreasing extends GameBehaviorTime {

    @Override
    public void tick(long tickingTime) {
        //decrease time at each tick
        final long currentTime = mGameInformation.getCurrentTime();
        final long timeAfterTick = currentTime - tickingTime;
        if (GameViewVitaminBars.getVitaminALength() > 331 &&
                GameViewVitaminBars.getVitaminBLength() > 331 &&
                GameViewVitaminBars.getVitaminCLength() > 331) {
            mGameInformation.setCurrentTime(timeAfterTick);
        } else {
            mGameInformation.setCurrentTime(0);
            mIGameBehavior.stop();
        }
    }

}
