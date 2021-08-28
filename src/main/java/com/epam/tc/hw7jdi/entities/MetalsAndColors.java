package com.epam.tc.hw7jdi.entities;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MetalsAndColors {

    List<Integer> summary;
    List<String> elements;
    String color;
    String metals;
    List<String> vegetables;
}
