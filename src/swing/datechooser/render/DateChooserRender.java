package swing.datechooser.render;

import swing.datechooser.DateBetween;
import swing.datechooser.DateChooser;

import java.util.Date;

public interface DateChooserRender {
    public String renderLabelCurrentDate(DateChooser dateChooser, Date date);

    public String renderTextFieldDate(DateChooser dateChooser, Date date);

    public String renderTextFieldDateBetween(DateChooser dateChooser, DateBetween dateBetween);

    public String renderDateCell(DateChooser dateChooser, Date date);
}
