/**
 * Project JTuningfork
 * Musical Tuningfork Engine with JAVA
 * copyright PeTrA (c) 2018 All rights reserved.
 */

package jtuningfork.module;

/**
 * Main controller.
 * @author PeTrA
 */
public class JtfController implements Runnable{
	/* Jtf Class Object
	*/	private JtfSoundReader jtfSoundReader;
		private JtfSoundCalculator jtfSoundCalculator;
	
	/* Sound buffer byte[] 
	*/	private byte[] buffer;
	
	public JtfController(JtfSoundReader _jtfSoundReader, JtfSoundCalculator _jtfSoundCalculator) {
		this.jtfSoundReader = _jtfSoundReader;
		this.jtfSoundCalculator = _jtfSoundCalculator;
	}
	
	private void programStart() {
		
	}
	
	protected JtfSoundReader getJtfSoundReader() {
		return this.jtfSoundReader;
	}
	
	private void uploadSound() {
		this.buffer = this.jtfSoundReader.getJtfSoundReaderServ().getBuffer();
	}
	
	public void run() {
		programStart();
	}
}
