/**
 * Project JTuningfork
 * Musical Tuningfork Engine with JAVA
 * copyright PeTrA (c) 2018 All rights reserved.
 */

package jtuningfork.module;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
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
	
	private ByteArrayOutputStream out;
	
	/**
	 * Constructor.
	 * @param _line
	 * @param _format
	 */
	protected JtfSoundReaderServ(TargetDataLine _line, AudioFormat _format) {
		this.line = _line;
		this.format = _format;
		this.bufferSize = (int)format.getSampleRate() * format.getFrameSize();
		this.buffer = new byte[this.bufferSize];
		this.out = new ByteArrayOutputStream();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = line.read(buffer, 0, buffer.length);
		if(count > 0) {
			out.write(buffer, 0, count);
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
