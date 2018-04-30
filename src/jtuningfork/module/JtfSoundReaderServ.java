/**
 * Project JTuningfork
 * Musical Tuningfork Engine with JAVA
 * copyright PeTrA (c) 2018 All rights reserved.
 */

package jtuningfork.module;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 * jtf sound reader serv class.
 * @author PeTrA
 * jtf sound reader supporter.
 */
class JtfSoundReaderServ implements Runnable{
	private TargetDataLine line;
	private AudioFormat format;
	private int bufferSize;
	/* Sound buffer byte[] 
	*/	private byte[] buffer = null;
	/* Stop key
	*/	private int stopKey;
	private ByteArrayOutputStream out;
	
	private int numBytesRead;
	
	/**
	 * Constructor.
	 * @param _line
	 * @param _format
	 */
	protected JtfSoundReaderServ(AudioFormat _format, TargetDataLine _line) {
		this.line = _line;
		this.format = _format;
		this.bufferSize = (int)format.getSampleRate() * format.getFrameSize();
		this.buffer = new byte[this.bufferSize];
		this.out = new ByteArrayOutputStream();
		this.stopKey = -1;
		this.numBytesRead = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.line.open(this.format);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.buffer = new byte[this.line.getBufferSize() / 5];
		this.stopKey = 1;
		this.line.start();
		
		while(stopKey == 1) {
			this.numBytesRead = line.read(this.buffer, 0, this.buffer.length);
			out.write(this.buffer, 0, this.numBytesRead);
		}
		/* Teat Area.
		int count = line.read(buffer, 0, buffer.length);
		if(count > 0) {
			out.write(buffer, 0, count);
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
	
	protected byte[] getBuffer() {
		return this.buffer;
	}
	
	protected void readConfuse() {
		this.stopKey = 0;
	}
}
