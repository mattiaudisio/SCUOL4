package utili;

import java.awt.event.FocusEvent;
import java.text.DecimalFormat;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class JFormattedNumber extends JFormattedTextField {

	public JFormattedNumber() {
		this(0);
	}
	
	public JFormattedNumber(int pDecimal) {
		// Eseguo costruttore classi "padri"
		super();
		// ** richiamare getFormat
		//** imposta come deve essere formattato il campo
		setFormatterFactory(getFormat(pDecimal));
		setValue(0);
	}

	public DefaultFormatterFactory getFormat(int pDecimal) {
		String s = "#,##0";
		// ** loop aggiunge zero per cifre decimali
		if (pDecimal > 0) {
			s = s + ".";
			for (int i = 0; i < pDecimal; i++) {
				s = s + "0";
			}
		}
		DecimalFormat df = new DecimalFormat(s);
		NumberFormatter nf = new NumberFormatter(df);
		DefaultFormatterFactory dff = new DefaultFormatterFactory(nf);
		return dff;
	}
	
	@Override
	protected void processFocusEvent(final FocusEvent e) {
		if(e.isTemporary()) {
			
		}
		if(e.getID() == FocusEvent.FOCUS_LOST) {
			if(getText() == null || getText().equals("")) {
				
			}
		}
		super.processFocusEvent(e);
		if(e.getID() == FocusEvent.FOCUS_GAINED) {
			select(0,getText().length());
		}
	}
}
