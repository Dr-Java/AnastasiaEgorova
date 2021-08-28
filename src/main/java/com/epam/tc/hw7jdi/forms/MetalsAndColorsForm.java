package com.epam.tc.hw7jdi.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7jdi.entities.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @FindBy(css = "#odds-selector input")
    public RadioButtons summaryOddNumbers;

    @FindBy(css = "#even-selector input")
    public RadioButtons summaryEvenNumbers;

    @FindBy(id = "calculate-button")
    public Button calculateButton;

    @FindBy(css = "#elements-checklist [type=checkbox]")
    public Checklist elements;

    @JDropdown(root = "div#colors",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "div#metals",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "div#vegetables",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown vegetables;

    @FindBy(css = "#submit-button")
    public Button submitButton;

    @Override
    public void fill(MetalsAndColors metalsAndColors) {
        summaryOddNumbers.select(metalsAndColors.getSummary().get(0).toString());
        summaryEvenNumbers.select(metalsAndColors.getSummary().get(1).toString());
        calculateButton.click();

        for (String checklistElement : metalsAndColors.getElements()) {
            elements.select(checklistElement);
        }

        colors.select(metalsAndColors.getColor());

        metals.select(metalsAndColors.getMetals());

        deselectVegetables();
        for (String vegetable : metalsAndColors.getVegetables()) {
            vegetables.select(vegetable);
        }
    }

    private void deselectVegetables() {
        var vegetablesFromDropdown = "vegetables";
        vegetables.select(vegetablesFromDropdown);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
