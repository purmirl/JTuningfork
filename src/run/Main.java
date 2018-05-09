/**
 * Project JTuningfork
 * Musical Tuningfork Engine with JAVA
 * copyright PeTrA (c) 2018 All rights reserved.
 */

package run;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 * Main Class
 * @author PeTrA
 * 
 * AudioFormat Format
 * AudioFormat(float sampleRate, int sampleSizeInBits, int channels, boolean signed, boolean bigEndian)
 * floate sampleRate : 1 sec, sample count.
 * int sampleSizeInBits : sample's bit number.
 * int channels : audio channel's count.
 * 
 * example of AudioFormat
 *  : AudioFormat audioFormat = new AudioFormat(8000, 8, 1, true, true);
 *  
 * example of DataLine.Info
 *  : DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat)
 * 
 * 7 Basic Sound Elements : 
 * -Loudness
 * -Pitch
 * -Contour
 * -Rhythm
 * -Tempo
 * -Spatial Location
 * -Reverberation
 */

import jtuningfork.module.*;

public class Main {
	public static void main(String[] args) {
		new Main();
	}
	
	/**
	 * experiment in here
	 */
	public Main() {
		AudioFormat audioFormat = new AudioFormat(8000, 8, 1, true, true);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
		try {
			JtfSoundReader jtfSoundReader = new JtfSoundReader(audioFormat, info);
			jtfSoundReader.read();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}