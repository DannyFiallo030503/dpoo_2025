package Visual.Overrides;

import javax.swing.*;
import javax.swing.text.*;

public class AlphabeticTextField extends JTextField {
    public AlphabeticTextField(int columns) {
        super(columns);
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new AlphabeticFilter());
    }

    private class AlphabeticFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
                throws BadLocationException {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c) || Character.isWhitespace(c)) {
                    sb.append(c);
                }
            }
            super.insertString(fb, offset, sb.toString(), attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text == null)
                return;
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c) || Character.isWhitespace(c)) {
                    sb.append(c);
                }
            }
            super.replace(fb, offset, length, sb.toString(), attrs);
        }
    }
}
