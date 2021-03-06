/*
 * Musicdroid: An on-device music generator for Android
 * Copyright (C) 2010-2014 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.musicdroid.pocketmusic.test.note.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Daniel on 21.10.2014.
 */
public class CanvasMock extends Canvas {

    public static final int HEIGHT = 1000;
    public static final int WIDTH = 1000;

    private Queue<String> drawnElements;

    public CanvasMock() {
        drawnElements = new LinkedList<String>();
    }

    public Queue<String> getDrawnElements() {
        return drawnElements;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() { return WIDTH; }

    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        drawnElements.add(createString((int) startX, (int) startY, (int) stopX, (int) stopY));
    }

    @Override
    public void drawRect(Rect r, Paint paint) {
        drawnElements.add(createString((int) r.left, (int) r.top, (int) r.right, (int) r.bottom));
    }

    @Override
    public void drawOval(RectF oval, Paint paint) {
        drawnElements.add(createString((int) oval.left, (int) oval.top, (int) oval.right, (int) oval.bottom));
    }

    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        drawnElements.add(createString((int) dst.left, (int) dst.top, (int) dst.right, (int) dst.bottom));
    }

    public static String createString(Object... objects) {
        String result = "";

        for (Object object : objects) {
            result = result + object + " ";
        }

        return result;
    }
}
