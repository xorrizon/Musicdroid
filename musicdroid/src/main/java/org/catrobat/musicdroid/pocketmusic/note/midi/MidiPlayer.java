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

package org.catrobat.musicdroid.pocketmusic.note.midi;

import android.app.Activity;
import android.media.MediaPlayer;

import org.catrobat.musicdroid.pocketmusic.note.NoteEvent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Daniel on 30.10.2014.
 */
public class MidiPlayer {

    private static final String R_RAW = "raw";

    private MediaPlayer player;
    private Queue<NoteEvent> playList;

    public MidiPlayer() {
        playList = new LinkedList<NoteEvent>();
    }

    public void play(NoteEvent noteEvent, Activity activity) {
        if ((null == player) || (false == player.isPlaying())) {
            createPlayer(activity, noteEvent);
        } else {
            playList.add(noteEvent);
        }
    }

    private void createPlayer(final Activity activity, final NoteEvent noteEvent) {
        int id = activity.getResources().getIdentifier(noteEvent.getNoteName().toString().toLowerCase(), R_RAW, activity.getPackageName());

        player = MediaPlayer.create(activity, id);

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (false == playList.isEmpty()) {
                    createPlayer(activity, playList.poll());
                }
            }
        });

        player.start();
    }
}
