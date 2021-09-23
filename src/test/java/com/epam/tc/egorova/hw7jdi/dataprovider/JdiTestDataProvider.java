package com.epam.tc.egorova.hw7jdi.dataprovider;

import com.epam.tc.hw7jdi.entities.MetalsAndColors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;

public class JdiTestDataProvider {

    public static final String JDI_TEST_DATA_SET =
        "src/test/resources/com.epam.tc.egorova.hw7jdi/JDI_ex8_metalsColorsDataSet.json";
    public static final String METALS_AND_COLORS_PAGE_TITLE = "Metal and Colors";
    public static final String METALS_AND_COLORS_HEADER_ITEM = "Metals & Colors";

    @SneakyThrows
    @DataProvider(name = "JDITestDataSet")
    public static Object[][] getJdiTestData() {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader(JDI_TEST_DATA_SET);
        Map<String, MetalsAndColors> testDataValues =
            objectMapper.readValue(reader, new TypeReference<Map<String, MetalsAndColors>>() {});
        return testDataValues.values().stream()
                             .map(testValue -> new MetalsAndColors[]{testValue})
                             .toArray(Object[][]::new);
    }

}
