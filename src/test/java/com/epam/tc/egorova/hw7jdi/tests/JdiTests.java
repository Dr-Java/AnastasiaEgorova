package com.epam.tc.egorova.hw7jdi.tests;

import static com.epam.tc.hw7jdi.JdiSite.headerMenu;
import static com.epam.tc.hw7jdi.JdiSite.jdiHomePage;
import static com.epam.tc.hw7jdi.JdiSite.metalsAndColorsPage;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.egorova.hw7jdi.dataprovider.JdiTestDataProvider;
import com.epam.tc.hw7jdi.entities.MetalsAndColors;
import org.testng.annotations.Test;

public class JdiTests extends TestInit {

    @Test(dataProvider = "JDITestDataSet",
          dataProviderClass = JdiTestDataProvider.class)
    public void testMetalsAndColorsPageInteractions(MetalsAndColors metalsAndColors) {
        jdiHomePage.userShouldBeLoggined();
        headerMenu.select(JdiTestDataProvider.METALS_AND_COLORS_HEADER_ITEM);
        metalsAndColorsPage.checkOpened();
        metalsAndColorsPage.fillMetalsAndColorsForm(metalsAndColors);
        metalsAndColorsPage.clickSubmitButton();
        assertThat(metalsAndColorsPage.getActualResultsText())
            .as("Incorrect results text")
            .isEqualTo(metalsAndColors.getExpectedResultsText());
    }
}
