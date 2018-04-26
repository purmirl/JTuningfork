/**
 * Project JTuningfork
 * Musical Tuningfork Engine with JAVA
 * copyright PeTrA (c) 2018 All rights reserved.
 */

package jtuningfork.module;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

/**
 * jtf sound reader class
 * @author PeTrA
 * read sound module
 */
public class JtfSoundReader {
	private AudioFormat audioFormat;
	private TargetDataLine targetDataLine;
	private DataLine.Info info;
	
	/**
	 * Constructor
	 * @param _audioFormat
	 * @param _info
	 */
	public JtfSoundReader(AudioFormat _audioFormat, DataLine.Info _info) {
		this.audioFormat = _audioFormat;
		this.info = _info;
	}
}
