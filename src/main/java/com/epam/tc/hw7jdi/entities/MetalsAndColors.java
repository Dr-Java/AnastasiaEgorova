package com.epam.tc.hw7jdi.entities;

import com.epam.jdi.tools.DataClass;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MetalsAndColors extends DataClass<MetalsAndColors> {

    List<Integer> summary;
    List<String> elements;
    String color;
    String metals;
    List<String> vegetables;

    public List<String> getExpectedResultsText() {
        List<String> expectedResultsText = List.of(
            String.format("Summary: %d", summary.get(0) + summary.get(1)),
            "Elements: " + elements.toString().replace("[", "").replace("]", ""),
            "Color: " + color,
            "Metal: " + metals,
            "Vegetables: " + vegetables.toString().replace("[", "").replace("]", "")
        );
        return expectedResultsText;
    }
}


