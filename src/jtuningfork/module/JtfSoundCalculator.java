/**
 * Project JTuningfork
 * Musical Tuningfork Engine with JAVA
 * copyright PeTrA (c) 2018 All rights reserved.
 */

package jtuningfork.module;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


/**
 * Calculator of read sound.
 * @author PeTrA
 */
public class JtfSoundCalculator {
	
	public JtfSoundCalculator() {}
	
	public void Calculator(byte[] buffer) {
		algorithm(buffer);
	}
	
	private void algorithm(byte[] buffer) {
		
	}
	
	
	
	/**
	 * trans the byte data to double data
	 * @param buffer
	 * @return doubleData
	 * Reference : https://stackoverflow.com/questions/25666623/my-app-find-frequency-of-audio-input-from-microphone-always-crashs-but-why
	 */
	private double[] byteToDouble(byte[] buffer) {
		ByteBuffer buf = ByteBuffer.wrap(buffer);
		buf.order(ByteOrder.BIG_ENDIAN);
		int index = 0;
		double doubleData[] = null;
		doubleData = new double[8192];
		
		while(buf.remaining() > 2) {
			short s = buf.getShort();
			/* audio frame is 8192
			*/	doubleData[index] = (new Short(s)).doubleValue();
			++index;
		}
		
		return doubleData;
	}
	
	
	
}
