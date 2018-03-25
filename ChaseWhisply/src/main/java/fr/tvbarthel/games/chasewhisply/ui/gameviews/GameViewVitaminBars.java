package fr.tvbarthel.games.chasewhisply.ui.gameviews;

import android.content.Context;
import android.graphics.Canvas;

import fr.tvbarthel.games.chasewhisply.mechanics.engine.GameEngineTime;

public class GameViewVitaminBars extends GameViewStandard{
    protected GameEngineTime mGameEngine;
    private static float vitaminALength = 930;
    private static float vitaminBLength = 930;
    private static float vitaminCLength = 930;

    public GameViewVitaminBars(Context c, GameEngineTime gameEngine) {
        super(c, gameEngine);
        mGameEngine = gameEngine;
    }

    @Override
    public void onDrawing(Canvas c) {
        super.onDrawing(c);
        drawVitaminBars(c);
    }

    public static float getVitaminALength() {
        return vitaminALength;
    }

    public static float getVitaminBLength() {
        return vitaminBLength;
    }

    public static float getVitaminCLength() {
        return vitaminCLength;
    }

    public static void increaseVitaminALength() {
        vitaminALength += 60;
    }

    public static void increaseVitaminBLength() {
        vitaminBLength += 60;
    }

    public static void increaseVitaminCLength() {
        vitaminCLength += 60;
    }

    public static void resetVitaminLengths() {
        vitaminALength = 930;
        vitaminBLength = 930;
        vitaminCLength = 930;
    }
    /**
     * draw time, in red if time < 10 sec else in green
     *
     * @param canvas canvas from View.onDraw method
     */
    public void drawVitaminBars(Canvas canvas) {
        final long millis = mGameEngine.getCurrentTime();
        final int seconds = (int) (millis / 1000);
        final String remainingTime = String.valueOf(seconds);
        final int radius = Math.max(mTimerBitmap.getWidth(), mTimerBitmap.getHeight()) + (int) mPadding;
        vitaminALength -= 3;
        vitaminBLength -= 3;
        vitaminCLength -= 3;
        resetPainter();

        //draw bars
        mPaint.getTextBounds(remainingTime, 0, remainingTime.length(), mBounds);
        canvas.drawText("Vitamin A:", radius, mPadding + radius, mPaint);
        canvas.drawText("Vitamin B:", radius, mPadding + radius + 60, mPaint);
        canvas.drawText("Vitamin C:", radius, mPadding + radius + 120, mPaint);

        canvas.drawRect(330, mPadding + radius - 40, vitaminALength, mPadding + radius, mPaint);
        canvas.drawRect(330, mPadding + radius + 20, vitaminBLength, mPadding + radius + 60, mPaint);
        canvas.drawRect(330, mPadding + radius + 80, vitaminCLength, mPadding + radius + 120, mPaint);
    }
}
