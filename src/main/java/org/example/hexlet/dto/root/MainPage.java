package org.example.hexlet.dto.root;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MainPage {
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }
}
