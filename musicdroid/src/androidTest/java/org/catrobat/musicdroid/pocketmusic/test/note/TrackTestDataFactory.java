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
package org.catrobat.musicdroid.pocketmusic.test.note;

import org.catrobat.musicdroid.pocketmusic.note.MusicalInstrument;
import org.catrobat.musicdroid.pocketmusic.note.MusicalKey;
import org.catrobat.musicdroid.pocketmusic.note.NoteEvent;
import org.catrobat.musicdroid.pocketmusic.note.NoteLength;
import org.catrobat.musicdroid.pocketmusic.note.NoteName;
import org.catrobat.musicdroid.pocketmusic.note.Track;

public final class TrackTestDataFactory {

	private TrackTestDataFactory() {
	}

	public static Track createTrack() {
		return createTrack(MusicalInstrument.ACOUSTIC_GRAND_PIANO);
	}

	public static Track createTrack(MusicalInstrument instrument) {
		return new Track(MusicalKey.VIOLIN, instrument);
	}

	public static Track createSimpleTrack() {
		Track track = createTrack();

		long tick = 0;

		track.addNoteEvent(tick, new NoteEvent(NoteName.C4, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C4, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.E4, true));

		tick += NoteLength.QUARTER_DOT.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.E4, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.F4, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.F4, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.C4, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C4, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.C5, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C5, false));

		return track;
	}

	public static Track createTrackWithBreak() {
		Track track = createTrack();

		long tick = 0;

		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, true));
		track.addNoteEvent(tick, new NoteEvent(NoteName.D1, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.D1, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.E1, true));

		tick += NoteLength.QUARTER_DOT.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.E1, false));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, false));

		return track;
	}

	public static Track createSemiComplexTrack(MusicalInstrument instrument) {
		Track track = new Track(MusicalKey.VIOLIN, instrument);

		long tick = 0;

		track.addNoteEvent(tick, new NoteEvent(NoteName.C2, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C2, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, true));
		track.addNoteEvent(tick, new NoteEvent(NoteName.D1, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.D1, false));

		tick += NoteLength.QUARTER_DOT.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.E1, true));
		track.addNoteEvent(tick, new NoteEvent(NoteName.F1, true));

		tick += NoteLength.QUARTER.getTickDuration() + NoteLength.SIXTEENTH.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.E1, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.F1, false));

		return track;
	}

	public static Track createComplexTrack() {
		Track track = createTrack();

		long tick = 0;

		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, true));
		track.addNoteEvent(tick, new NoteEvent(NoteName.D1, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C1, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.E1, true));
		track.addNoteEvent(tick, new NoteEvent(NoteName.F1, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.D1, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.E1, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.F1, false));

		tick += NoteLength.QUARTER_DOT.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C2, true));
		track.addNoteEvent(tick, new NoteEvent(NoteName.D2, true));

		tick += NoteLength.QUARTER_DOT.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.C2, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.D2, false));
		track.addNoteEvent(tick, new NoteEvent(NoteName.B3, true));

		tick += NoteLength.QUARTER.getTickDuration();

		track.addNoteEvent(tick, new NoteEvent(NoteName.B3, false));

		return track;
	}
}
