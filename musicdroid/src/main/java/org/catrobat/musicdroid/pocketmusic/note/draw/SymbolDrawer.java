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

import android.content.res.Resources;

import org.catrobat.musicdroid.pocketmusic.note.MusicalKey;
import org.catrobat.musicdroid.pocketmusic.note.symbol.BoundNoteSymbol;
import org.catrobat.musicdroid.pocketmusic.note.symbol.BreakSymbol;
import org.catrobat.musicdroid.pocketmusic.note.symbol.NoteSymbol;
import org.catrobat.musicdroid.pocketmusic.note.symbol.Symbol;


public class SymbolDrawer {

	private NoteSheetCanvas noteSheetCanvas;
	private MusicalKey key;
    private Resources resources;
	private NoteDrawer noteDrawer;
	private BreakDrawer breakDrawer;

	public SymbolDrawer(PianoNoteSheetCanvas noteSheetCanvas, Resources resources, MusicalKey key) {
		this.noteSheetCanvas = noteSheetCanvas;
		this.key = key;
		this.resources = resources;
		this.noteDrawer = new NoteDrawer(noteSheetCanvas, key, resources);
		this.breakDrawer = new BreakDrawer(noteSheetCanvas, resources);
	}

	public void drawSymbol(Symbol symbol) {
		if (symbol instanceof BreakSymbol) {
			breakDrawer.drawBreak((BreakSymbol) symbol);
		} else if (symbol instanceof NoteSymbol) {
			noteDrawer.drawNoteSymbol((NoteSymbol) symbol);
		} else if (symbol instanceof BoundNoteSymbol) {
			drawBoundNoteSymbol((BoundNoteSymbol) symbol, noteSheetCanvas, resources);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private void drawBoundNoteSymbol(BoundNoteSymbol symbol, NoteSheetCanvas noteSheetCanvas, Resources resources) {
		// TODO das Dream Team Eli und Flo :D
	}

}