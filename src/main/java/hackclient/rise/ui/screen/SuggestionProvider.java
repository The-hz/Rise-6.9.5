package hackclient.rise.ui.screen;

import java.util.List;

interface SuggestionProvider {
    default void a(SuggestionContext var1) {
    }

    List<Suggestion> b(SuggestionContext var1);
}
