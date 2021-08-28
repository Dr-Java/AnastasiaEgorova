package com.epam.tc.egorova.hw7jdi.tests;

import com.epam.tc.egorova.hw7jdi.dataprovider.JdiTestDataProvider;
import com.epam.tc.hw7jdi.JdiSite;
import com.epam.tc.hw7jdi.entities.MetalsAndColors;
import com.epam.tc.hw7jdi.entities.User;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class JdiTests extends TestInit {

    SoftAssertions soft = new SoftAssertions();

    @Test
    public void testSuccessfulLogin() {
        JdiSite.login(User.ROMAN);
        soft.assertThat(JdiSite.getUserName())
            .as("Incorrect loggined username")
            .isEqualTo(User.ROMAN.getFullName());
    }

    @Test(dataProvider = "JDITestDataSet", dataProviderClass = JdiTestDataProvider.class,
          dependsOnMethods = "testSuccessfulLogin")
    public void testMetalsAndColorsPageInteractions(MetalsAndColors metalsAndColors) {
        JdiSite.openMetalsColorsPage();
        soft.assertThat(JdiSite.metalsAndColorsPage.title)
            .as("Incorrect page title")
            .isEqualTo(JdiTestDataProvider.METALS_AND_COLORS_PAGE_TITLE);
        JdiSite.metalsAndColorsPage.fillMetalsAndColorsForm(metalsAndColors);
        JdiSite.metalsAndColorsPage.clickSubmitButton();
        JdiSite.metalsAndColorsPage.resultSectionShouldContainData(metalsAndColors);
    }
}
