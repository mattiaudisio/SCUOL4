package formatters;

import java.text.NumberFormat;

import javax.swing.text.NumberFormatter;

// 
public class TxtFormatters {

	public static NumberFormatter getIntFormatter() {
		return getIntFormatter(Long.MIN_VALUE,Long.MAX_VALUE);
	}
	
	public static NumberFormatter getIntFormatter(long min, long max) {
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);//Remove comma from number greater than 4 digit
		NumberFormatter newFormatter = new NumberFormatter(format);
		newFormatter.setValueClass(Long.class);
		newFormatter.setMinimum(min);
		newFormatter.setMaximum(max);
		newFormatter.setAllowsInvalid(false);

		newFormatter.setCommitsOnValidEdit(false);// committ value on each keystroke instead of focus lost
		return newFormatter;
	}

	public static NumberFormatter getDoubleFormatter() {
		return getDoubleFormatter(2);
	}
	public static NumberFormatter getDoubleFormatter(int decimalPlaces) {
		return getDoubleFormatter(Integer.MIN_VALUE,Integer.MAX_VALUE,decimalPlaces);
	}
	
	public static NumberFormatter getDoubleFormatter(int min, int max,int decimalPlaces) {
		NumberFormat format = NumberFormat.getInstance();
		format .setMinimumFractionDigits(decimalPlaces);
		format .setMaximumFractionDigits(decimalPlaces);
		format .setGroupingUsed(false);//Remove comma from number greater than 4 digit
		
		NumberFormatter newFormatter = new NumberFormatter(format);
    	newFormatter.setMinimum(Long.MIN_VALUE+0.9999999999);
		newFormatter.setMaximum(Long.MAX_VALUE+0.9999999999);
		newFormatter.setAllowsInvalid(false);

		newFormatter.setCommitsOnValidEdit(false);// committ value on each keystroke instead of focus lost
		return newFormatter;
	}
}
