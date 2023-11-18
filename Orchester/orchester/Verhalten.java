package orchester;

import orchester.Orchester;

import java.io.IOException;

public interface Verhalten {
    void spielen (Orchester orchester) throws IOException;
}
