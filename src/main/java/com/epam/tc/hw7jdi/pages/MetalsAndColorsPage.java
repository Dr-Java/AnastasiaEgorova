package com.epam.tc.hw7jdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7jdi.entities.MetalsAndColors;
import com.epam.tc.hw7jdi.forms.MetalsAndColorsForm;
import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(css = ".results li")
    public WebList results;

    public void fillMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fill(metalsAndColors);
    }

    public List<String> getActualResultsText() {
        return results.stream()
                      .map(UIElement::getText)
                      .collect(Collectors.toList());
    }

    public void clickSubmitButton() {
        metalsAndColorsForm.submit();
    }
}
