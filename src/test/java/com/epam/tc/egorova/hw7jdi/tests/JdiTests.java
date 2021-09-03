package com.epam.tc.egorova.hw7jdi.tests;

import static com.epam.tc.hw7jdi.JdiSite.headerMenu;

import com.epam.tc.egorova.hw7jdi.dataprovider.JdiTestDataProvider;
import com.epam.tc.hw7jdi.JdiSite;
import com.epam.tc.hw7jdi.entities.MetalsAndColors;
import com.epam.tc.hw7jdi.entities.User;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class JdiTests extends TestInit {

    SoftAssertions soft = new SoftAssertions();

    @Test(dataProvider = "JDITestDataSet",
          dataProviderClass = JdiTestDataProvider.class)
    public void testMetalsAndColorsPageInteractions(MetalsAndColors metalsAndColors) {
        soft.assertThat(JdiSite.getUserName())
            .as("Incorrect loggined username")
            .isEqualTo(User.ROMAN.getFullName());
        headerMenu.select(JdiTestDataProvider.METALS_AND_COLORS_HEADER_ITEM);
        soft.assertThat(JdiSite.metalsAndColorsPage.title)
            .as("Incorrect page title")
            .isEqualTo(JdiTestDataProvider.METALS_AND_COLORS_PAGE_TITLE);
        JdiSite.metalsAndColorsPage.fillMetalsAndColorsForm(metalsAndColors);
        JdiSite.metalsAndColorsPage.clickSubmitButton();
        soft.assertThat(JdiSite.metalsAndColorsPage.getActualResultsText())
            .as("Incorrect results text")
            .isEqualTo(metalsAndColors.getExpectedResultsText());
    }
}
