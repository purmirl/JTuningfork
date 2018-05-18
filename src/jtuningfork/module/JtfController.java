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
public class JtfController {
	/* Jtf Class Object
	*/	private JtfSoundReader jtfSoundReader;
		private JtfSoundCalculator jtfSoundCalculator;
	
	public JtfController(JtfSoundReader _jtfSoundReader, JtfSoundCalculator _jtfSoundCalculator) {
		this.jtfSoundReader = _jtfSoundReader;
		this.jtfSoundCalculator = _jtfSoundCalculator;
	}
	
	public void programStart() {
		_programStart();
	}
	
	private void _programStart() {
		
	}
	
	protected JtfSoundReader getJtfSoundReader() {
		return this.jtfSoundReader;
	}
}
