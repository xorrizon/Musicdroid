/**
 *  Catroid: An on-device visual programming system for Android devices
 *  Copyright (C) 2010-2013 The Catrobat Team
 *  (<http://developer.catrobat.org/credits>)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  An additional term exception under section 7 of the GNU Affero
 *  General Public License, version 3, is available at
 *  http://developer.catrobat.org/license_additional_term
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.musicdroid.pocketmusic.note.draw;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

public final class PictureTools {
	private PictureTools() {
	}

	public static Rect calculateProportionalPictureContourRect(Bitmap originalPicture, int height, int startXPosition,
			int yCenterPosition) {
		int keyPictureWidth = originalPicture.getWidth() * height / originalPicture.getHeight();

		Point leftUpperOfRect = new Point(startXPosition, yCenterPosition - height / 2);
		Point rightBottomOfRect = new Point(startXPosition + keyPictureWidth, yCenterPosition + height / 2);

		return new Rect(leftUpperOfRect.x, leftUpperOfRect.y, rightBottomOfRect.x, rightBottomOfRect.y);
	}
}
