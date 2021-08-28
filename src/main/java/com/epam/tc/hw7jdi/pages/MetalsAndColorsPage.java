package com.epam.tc.hw7jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7jdi.entities.MetalsAndColors;
import com.epam.tc.hw7jdi.forms.MetalsAndColorsForm;
import java.util.List;

@Url("/metals-colors.html")
public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(css = ".summ-res")
    public Text summaryLogRow;

    @FindBy(css = ".elem-res")
    public Text elementsLogRow;

    @FindBy(css = ".col-res")
    public Text colorsLogRow;

    @FindBy(css = ".met-res")
    public Text metalsLogRow;

    @FindBy(css = ".sal-res")
    public Text vegetablesLogRow;

    public void fillMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fill(metalsAndColors);
    }

    public void resultSectionShouldContainData(MetalsAndColors metalsAndColors) {
        doesSummaryLogRowContain(metalsAndColors.getSummary().get(0),
            metalsAndColors.getSummary().get(1));
        doesElementsLogRowContain(metalsAndColors.getElements());
        doesColorsLogRowContain(metalsAndColors.getColor());
        doesMetalsLogRowContain(metalsAndColors.getMetals());
        doesVegetablesLogRowContain(metalsAndColors.getVegetables());
    }

    private boolean doesSummaryLogRowContain(Integer firstNumber, Integer secondNumber) {
        String summary = String.valueOf(firstNumber + secondNumber);
        return summaryLogRow.getText().contentEquals(String.format("Summary: %s", summary));
    }

    private boolean doesElementsLogRowContain(List<String> checklistElements) {
        String log = checklistElements + "";
        return elementsLogRow.getText().contentEquals(String.format("Elements: %s", log)
                                                            .replace("[", "")
                                                            .replace("]", ""));
    }

    private boolean doesColorsLogRowContain(String color) {
        return colorsLogRow.getText().contentEquals(String.format("Color: %s", color));
    }

    private boolean doesMetalsLogRowContain(String metal) {
        return metalsLogRow.getText().contentEquals(String.format("Metal: %s", metal));
    }

    private boolean doesVegetablesLogRowContain(List<String> vegetables) {
        String log = vegetables + "";
        return vegetablesLogRow.getText().contentEquals(String.format("Vegetables: %s", log)
                                                              .replace("[", "")
                                                              .replace("]", ""));
    }

    public void clickSubmitButton() {
        metalsAndColorsForm.clickSubmitButton();
    }
}
