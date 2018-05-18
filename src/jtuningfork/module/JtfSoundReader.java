/**
 * Project JTuningfork
 * Musical Tuningfork Engine with JAVA
 * copyright PeTrA (c) 2018 All rights reserved.
 */

package jtuningfork.module;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 * jtf sound reader class.
 * @author PeTrA
 * read sound module
 */
public class JtfSoundReader {
	private AudioFormat audioFormat;
	private TargetDataLine targetDataLine;
	private DataLine.Info info;
	
	private JtfSoundReaderServ jtfSoundReaderServ;
	private Thread readerThread;
	/**
	 * Constructor.
	 * @param _audioFormat
	 * @param _info
	 * @throws LineUnavailableException 
	 */
	public JtfSoundReader(AudioFormat _audioFormat, DataLine.Info _info) throws LineUnavailableException {
		this.audioFormat = _audioFormat;
		this.info = _info;
		this.targetDataLine = (TargetDataLine)AudioSystem.getLine(this.info);
		this.jtfSoundReaderServ = null;
		this.readerThread = null;
	}
	
	/**
	 * read the microphone sound function.
	 * @throws LineUnavailableException
	 */
	public void read() {
		this.jtfSoundReaderServ = new JtfSoundReaderServ(this.audioFormat, this.targetDataLine);
		this.readerThread = new Thread(this.jtfSoundReaderServ);
		this.readerThread.start();
	}
	
	public byte[] getSound() {
		return jtfSoundReaderServ.getBuffer();
	}
	
	protected JtfSoundReaderServ getJtfSoundReaderServ() {
		return this.jtfSoundReaderServ;
	}
}
